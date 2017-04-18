package org.usfirst.frc.team2560.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CenterStationAuto extends CommandGroup {

    public CenterStationAuto() 
    {
    	addSequential(new GyroAndDrive(), 4.0);
    }
}
