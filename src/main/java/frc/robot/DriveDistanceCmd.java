/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.command.Command;

import edu.wpi.first.wpilibj.Timer;

public class DriveDistanceCmd extends Command {

  private double m_targetDistance;
  private Timer m_timer = new Timer();
  private double m_direction = 1.0;

  public DriveDistanceCmd() {
    requires(Robot.driveSubsystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {

    // Get the target distance from the console
    m_targetDistance = Robot.console.getTargetDriveDistance();

    System.out.println("Initializing Drive Distance command, with target of " + m_targetDistance + " feet");

    if (m_targetDistance < 0.) {
      m_direction = -1.0;
      m_targetDistance = -m_targetDistance;
    } else {
      m_direction = 1.0;
    }

    m_timer.reset();
    m_timer.start();

  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    if (m_timer.get() >= m_targetDistance) return true;
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    double distanceTraveled = m_direction * m_targetDistance;
    System.out.println("Drove " + distanceTraveled + " feet");
    System.out.println("Ending Drive Distance command");
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    System.out.println("Interrupting Drive Distance command");
  }
}
