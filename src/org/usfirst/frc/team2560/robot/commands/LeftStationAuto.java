package org.usfirst.frc.team2560.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LeftStationAuto extends CommandGroup {

    public LeftStationAuto() 
    {
        addSequential(new GyroAndDrive(), 5.0);
        addSequential(new Turn(90, 0.5));
        addSequential(new GyroAndDrive(), 2.0);
    }
}
