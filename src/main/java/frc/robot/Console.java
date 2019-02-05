/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.shuffleboard.*;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import java.util.Map;

/**
 * Add your docs here.
 */
public class Console {

    // Tabs
    private ShuffleboardTab mainTab;
    private ShuffleboardTab driveTab;
    private ShuffleboardTab subsystemsTab;
    private ShuffleboardTab debugTab;

    // Updatable entries
    private NetworkTableEntry driver_matchTime;
    private NetworkTableEntry drive_targetDistanceEntry;


    public Console() {
        System.out.println("Console constructor");
    }

    public void initialize() {
        System.out.println("Initializing console...");

        setupSmartdashboard();

        setupMainTab();
        setupDriveTab();
        setupSubsystemTab();
        setupDebugTab();
    }

    public void update() {

        updateMainTab();
        updateDriveTab();
        updateSubsystemTab();
        updateDebugTab();
    }

    private void setupMainTab() {

        mainTab = Shuffleboard.getTab("Main");

        // Match time
        driver_matchTime = mainTab.add("Match Time",0.0)
            .withPosition(2,0)
            .withWidget(BuiltInWidgets.kDial)
            .withProperties(Map.of("min", -1, "max", 135))  // this property setting isn't working
            .getEntry();

        // Autonomous Command
        mainTab.add("Auto Command",Robot.autoCommandChooser)
            .withSize(2,1)
            .withPosition(0,0);

        //  Command Scheduler
        //  Not sure why this isn't working
        mainTab.add("Scheduler",Scheduler.getInstance())
            .withSize(2,1)
            .withPosition(0,1);

    }

    private void setupSubsystemTab() {

        subsystemsTab = Shuffleboard.getTab("Subsystems");

        ShuffleboardLayout climbLayout = subsystemsTab.getLayout("Climb", BuiltInLayouts.kList)
            .withSize(2, 2)
            .withPosition(0,0)
            .withProperties(Map.of("Label position", "HIDDEN")); // hide labels for elements within layout
         climbLayout.add(Robot.climbSubsystem);

         climbLayout.add(new ClimbCommand());
    }

    
    private void setupDriveTab() {

        driveTab = Shuffleboard.getTab("Drive");

        driveTab.add("Drive Subsystem",Robot.driveSubsystem)
            .withSize(2,1)
            .withPosition(0,0);

        // Target Distance for Drive Distance command
        drive_targetDistanceEntry = driveTab.add("Target Distance",2.0)
                .withPosition(0,1)
                .withWidget(BuiltInWidgets.kTextView)
                .getEntry();

        driveTab.add("Drive Distance", new DriveDistanceCmd())
            .withSize(2,1)
            .withPosition(0,2);

        driveTab.add("Mecanum Drive",Robot.driveSubsystem.mecDrive)
            .withSize(4,3)
            .withPosition(3,1);
    }

    private void setupDebugTab() {
        debugTab = Shuffleboard.getTab("Debug");
    }


    // This is for stuff that can't be displayed easily in custom Shuffleboard tabs
    // Will end up on the SmartDashboard tab
    private void setupSmartdashboard() {

        // SmartDashboard.putData("Command Scheduler",Scheduler.getInstance());

    }

    private void updateMainTab() {

        double matchTime = DriverStation.getInstance().getMatchTime();
        driver_matchTime.setDouble(matchTime);

    }

    private void updateDriveTab() {

    }    
    
    private void updateSubsystemTab() {

    }

    private void updateDebugTab() {

    }

    // -------------------
    // Access Methods
    // -------------------
    public double getTargetDriveDistance() {
        return drive_targetDistanceEntry.getDouble(1.0);
    }
}
