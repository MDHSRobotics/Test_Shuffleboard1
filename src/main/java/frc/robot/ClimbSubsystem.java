/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.command.Subsystem;


public class ClimbSubsystem extends Subsystem {

  //TODO  Might want to do something with this in the future
  private int m_controllerID = 1;

  public ClimbSubsystem() {

  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for the subsystem
    setDefaultCommand(new Climb_Idle());
  }
}
