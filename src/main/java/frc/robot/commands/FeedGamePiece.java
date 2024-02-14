package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj2.command.WaitUntilCommand;
import frc.robot.subsystems.Feeder;
import frc.robot.subsystems.Intake;

public class FeedGamePiece extends SequentialCommandGroup {
  public FeedGamePiece() {
    Feeder feeder = Feeder.getInstance();
    Intake intake = Intake.getInstance();

    addCommands(
      new ParallelCommandGroup(
        new SetFeederVelocity(2_000.0),
        new SetIntakeVelocity(3_000.0)
      ),

      new WaitUntilCommand(feeder::gamePieceDetected),
      new InstantCommand(() -> feeder.setPercentOutput(-0.05), feeder),
      new WaitCommand(0.05),  // Tune note position in feeder.

      new ParallelCommandGroup(
        // new SetFeederVelocity(0.0),
        new InstantCommand(() -> feeder.setPercentOutput(0.0), feeder),
        new SetIntakeVelocity(0.0)
      )
    );

    addRequirements(feeder, intake);
  }
}
