/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

/**
 * Add your docs here.
 */
public class DriveSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

    //Speed Controller singletons
    public static WPI_TalonSRX talonSrxWheelFrontRight = new WPI_TalonSRX(1);
    public static WPI_TalonSRX talonSrxWheelFrontLeft = new WPI_TalonSRX(2);
    public static WPI_TalonSRX talonSrxWheelRearRight = new WPI_TalonSRX(3);
    public static WPI_TalonSRX talonSrxWheelRearLeft = new WPI_TalonSRX(4);

  public static MecanumDrive mecDrive = new MecanumDrive(talonSrxWheelFrontLeft, talonSrxWheelRearLeft, talonSrxWheelFrontRight, talonSrxWheelRearRight);

  public DriveSubsystem() {

  }
  
  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new Drive_Idle());
  }
}
