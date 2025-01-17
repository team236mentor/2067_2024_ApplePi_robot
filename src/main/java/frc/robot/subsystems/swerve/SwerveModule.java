package frc.robot.subsystems.swerve;


import java.text.DecimalFormat;

import edu.wpi.first.math.kinematics.SwerveModulePosition;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import frc.robot.Constants;


public class SwerveModule {
    // Reported CANCoder abs encoder position at wheel zero.
    // Back left, back right, front left, front right convention.
    // Calibration procedure: set all offsets to 0.0, redeploy, align all wheels to face forwards,
    // use CANCoder reading as offset, add 180.0 if wheel drives backwards.
    private static final double[] STEER_WHEEL_ZERO_OFFSET_DEGREES = {298.04, 260.33, 161.37, -0.44}; //adjust wheel offsets. 

    private static final DecimalFormat rounder = new DecimalFormat("0.0000");

    private final DriveMotor m_driveMotor;
    private final SteerMotor m_steerMotor;

    private final int location;
    
    public SwerveModule(int location) {
        this.location = location;

        m_driveMotor = new DriveMotor(Constants.canIDs.Drivetrain.DRIVE[location]);
        m_steerMotor = new SteerMotor(
            Constants.canIDs.Drivetrain.STEER[location],
            Constants.canIDs.Drivetrain.CANCoder[location],
            STEER_WHEEL_ZERO_OFFSET_DEGREES[location]
        );
    }

    public void setTargetState(SwerveModuleState targetState) {
        // Do nothing if target state is to not move.
        if (Math.abs(targetState.speedMetersPerSecond) < 0.01) {
            m_driveMotor.setTargetVelocityMetersPerSecond(0.0);
            return;
        }

        // Optimize state, inverting steer and drive rotations for shortest turn.
        targetState = SwerveModuleState.optimize(targetState, m_steerMotor.getPositionRotation2d());

        // Set steer and drive motors to targets.
        m_steerMotor.setTargetPositionRotation2d(targetState.angle);
        m_driveMotor.setTargetVelocityMetersPerSecond(targetState.speedMetersPerSecond);
    }

    public SwerveModuleState getState() {
        SwerveModuleState state = new SwerveModuleState(
            m_driveMotor.getVelocityMetersPerSecond(),
            m_steerMotor.getPositionRotation2d()
        );
        return state;
    }

    public SwerveModulePosition getPosition() {
        SwerveModulePosition position = new SwerveModulePosition(
            m_driveMotor.getPositionMeters(),
            m_steerMotor.getPositionRotation2d()
        );
        return position;
    }

    public String toString() {
        String desc = "Loc " + location + ": ";
        
        SwerveModuleState currState = getState();
        desc += "v (m/s)=" + rounder.format(currState.speedMetersPerSecond) + "   ";
        desc += "angle (deg)=" + rounder.format(currState.angle.getDegrees());
        
        return desc;
    }
}
