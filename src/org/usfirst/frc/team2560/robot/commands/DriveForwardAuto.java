package org.usfirst.frc.team2560.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DriveForwardAuto extends CommandGroup {

    public DriveForwardAuto() 
    {
    	addSequential(new DriveForward(0.66, 0.66), 1.0);   
    }
}
