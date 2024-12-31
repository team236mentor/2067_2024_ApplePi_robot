[![build](https://github.com/applepi-2067/2024_Robot/actions/workflows/main.yml/badge.svg)](https://github.com/applepi-2067/2024_Robot/actions)

# 2024_Robot

Code copied from for FRC 2067's 2024 Robot for the game 
[CRESCENDO](https://www.youtube.com/watch?v=9keeDyFxzY4)

![cheat_sheet](img/cheat_sheet.jpg)

## Useful links:

  * [2024 Game manual](https://firstfrc.blob.core.windows.net/frc2024/Manual/2024GameManual.pdf)
  * [wpilib getting started](https://docs.wpilib.org/en/latest/index.html)

    * [Status Light Quick Reference](https://docs.wpilib.org/en/latest/docs/hardware/hardware-basics/status-lights-ref.html) - something is blinking at you... what does it mean?
  * documentation for software libraries and hardware we'll use:

    * [wpilib javadocs](https://github.wpilib.org/allwpilib/docs/release/java/index.html)

    * [Path Planner](https://pathplanner.dev/home.html)

    * [Choreo](https://sleipnirgroup.github.io/Choreo/usage/editing-paths/)

    * [CTRE TalonFX motor controller code examples](https://github.com/CrossTheRoadElec/Phoenix-Examples-Languages/tree/master/Java%20Talon%20FX%20(Falcon%20500)) ([motion magic](https://github.com/CrossTheRoadElec/Phoenix-Examples-Languages/tree/master/Java%20Talon%20FX%20(Falcon%20500)/MotionMagic), [velocity](https://github.com/CrossTheRoadElec/Phoenix-Examples-Languages/tree/master/Java%20Talon%20FX%20(Falcon%20500)/VelocityClosedLoop) control)

      * [Closed loop primer](https://v5.docs.ctr-electronics.com/en/stable/ch16_ClosedLoop.html)
      * [MotionMagic parameters / Pheonix Tuner](https://youtu.be/1b0BAV2jBd8) video
      * [CTRE Documentation](https://v5.docs.ctr-electronics.com/en/stable/index.html)
    * 
    * [Photonlib](https://docs.photonvision.org/en/latest/docs/programming/photonlib/adding-vendordep.html)


## Robot Subsystem Descriptions

![image](https://github.com/applepi-2067/2024_Robot/assets/148881295/53e0c1fd-fda8-4799-86cb-8156cc336157)


### 2067 Drivetrain
The motors that move the robot chassis around the field.

  * Motors
    * 4x - Falcon500 swere modules (2 Falcon500s per module) 
  * Sensors
    * Pigeon IMU for measuring robot heading and pitch

### 2067 Intake
Picks up game pieces off the ground. Hands them off to the hopper
  * Motors
    * 2x Falcon 500
      * Velocity closed loop control
  * Sensors
    * 1x IR Proximity Sensor

### 2067 Shooter
Motors at the front of the shooter assembly that allow game pieces to be fired out of the robot.
  * Motors
    * 2x - Kraken X60 
      * Velocity closed loop control

### 2067 Hopper
Brings in game pieces from the intake. Stores them until the shooter is ready to be fired.
  * Motors
    * 1x - Falcon 500
      * `tbd` - Velocity closed loop control 

### 2067 Linear Lift
Moves the shooter assembly vertically to differnt heights
  * Motors
    * 2x - Falcon 500
      * Motion Magic - position closed loop control

### 2067 Shoulder
Rotates the shooter assembly to change pitch angle

  * Motors
    * 1x - Falcon 500
      * Motion Magic - position closed loop control


## Clone this repo to your desktop
The following steps will authorize vscode to access your github account through OAuth.
This is in place of setting up ssh keys. If you'd rather do that, feel free to do so.     
Similar steps to what we're doing [are covered here](https://adamtheautomator.com/visual-studio-code-github-setup/#Cloning_a_GitHub_Repository) if the below isn't clear enough.

  * Open the `2024 WPILib VS Code` link (on your desktop?)
  * Click the `Source Control` tab on the right ( Ctrl+Shift+G )
  * Click the `Clone Repository` button 
    * This will open the `Command Palette` at the top middle.   
      You will come to know this VS Code feature well...
    * Click the `Clone from GitHub` option
    * Follow the on-screen steps to authorize vscode to access your github account
  * Choose the `applepi-2067/2024_Robot` project

  * Choose a directory to clone the project into that you will remember (e.g. Documents\FRC\)
    a new subdirectory for the project will be created

  * The first time the project opens it should start downloading dependencies and building the code. 
    You should see the status of the build process listed at the bottom `Terminal` panel in vscode
    * If the build fails, you may not have completed the installation of the Phoenix Framework Installer (above).


### Using git
  * https://docs.wpilib.org/en/stable/docs/software/basic-programming/git-getting-started.html

  `TODO`
  
