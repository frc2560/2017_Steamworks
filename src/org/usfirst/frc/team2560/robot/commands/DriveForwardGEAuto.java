package org.usfirst.frc.team2560.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DriveForwardGEAuto extends CommandGroup {

    public DriveForwardGEAuto() 
    {
    	addSequential(new DriveForwardGyroAndEncoders(10, 0.5));
    }
}
