/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.Timer;

public class ClimbCommand extends Command {

  private Timer m_timer = new Timer();

  public ClimbCommand() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.climbSubsystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Logging.logTrivial("Initializing climb command");

    m_timer.reset();
    m_timer.start();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

  }

  // Just execute for 5 seconds
  @Override
  protected boolean isFinished() {
    if (m_timer.get() >= 5.) return true;
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Logging.logTrivial("Ending climb command");
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    Logging.logTrivial("Interrupting climb command");
  }
}
