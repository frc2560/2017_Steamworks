package org.usfirst.frc.team2560.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class GyroAndDriveAuto extends CommandGroup {

    public GyroAndDriveAuto() {
    	addSequential(new GyroAndDrive(), 1.0);
    }
}
