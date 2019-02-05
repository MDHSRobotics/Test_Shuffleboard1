/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.command.Command;

public class AutoCommand1 extends Command {

  private int m_counter = 0;
  private int m_printNum = 0;

  public AutoCommand1() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    System.out.println("Initializing Auto Command 1");
    m_counter = 0;
    m_printNum = 0;
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    ++m_counter;
    if (m_counter > 50) {
      m_counter = 0;
      ++m_printNum;
      System.out.println("Executing AutoCommand1 " + m_printNum);
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    System.out.println("Ending Auto Command 1");
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    System.out.println("Interrupting Auto Command 1");
  }
}
