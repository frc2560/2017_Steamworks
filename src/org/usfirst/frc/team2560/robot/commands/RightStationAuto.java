package org.usfirst.frc.team2560.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RightStationAuto extends CommandGroup {

    public RightStationAuto() 
    {
        addSequential(new GyroAndDrive(), 5.0);
        addSequential(new Turn(270, 0.5));
        addSequential(new GyroAndDrive(), 2.0);
    }
}
