/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

// This is a test program to illustrate the features of the Smartdashboard

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;

public class Robot extends TimedRobot {

  public static SendableChooser<Command> autoCommandChooser = new SendableChooser<>();
  private Command m_autoCommand;
  public static ClimbSubsystem climbSubsystem = new ClimbSubsystem();
  private  ClimbCommand m_climbCommand = new ClimbCommand();
  public static DriveSubsystem driveSubsystem = new DriveSubsystem();

  // Set up the console last
  public static Console console = new Console();      

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    autoCommandChooser.setDefaultOption("AutoCommand1", new AutoCommand1());
    autoCommandChooser.addOption("AutoCommand2", new AutoCommand2());

    // Set up the initial configuration of the console
    console.initialize();
  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {

    // Update the Shuffleboard console with any values not automatically updated
    console.update();

    // Avoid motor safety errors by feeding the drive constantly
    driveSubsystem.mecDrive.feed();
  }


  @Override
  public void autonomousInit() {

    m_autoCommand = autoCommandChooser.getSelected();

    if (m_autoCommand != null)  {
      m_autoCommand.start();
      System.out.println("Starting " + m_autoCommand.getName());
    }
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {
      System.out.println("Initializing Teleop...");

      // This makes sure that the autonomous stops running when
      // teleop starts running. If you want the autonomous to
      // continue until interrupted by another command, remove
      // this line or comment it out.
      if (m_autoCommand != null) {
          m_autoCommand.cancel();
      }

      // Start the climb command
     m_climbCommand.start();
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }

      /**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
     * the robot is disabled.
     */
    @Override
    public void disabledInit() {
        System.out.println("Disabling Robot...");
    }

    @Override
    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }
}
