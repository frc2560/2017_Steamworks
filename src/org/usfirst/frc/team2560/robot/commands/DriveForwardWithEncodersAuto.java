package org.usfirst.frc.team2560.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DriveForwardWithEncodersAuto extends CommandGroup {

    public DriveForwardWithEncodersAuto() {
        addSequential(new ResetEncoders());
    	addSequential(new DriveForwardWithEncoders(1000, 0.5));
    }
}
