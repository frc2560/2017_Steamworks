package org.usfirst.frc.team2560.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RightStationAuto extends CommandGroup {

    public RightStationAuto() 
    {
        System.out.println("Starting!");
    	addSequential(new GyroAndDrive(), 1.3);
        System.out.println("Just finished moving forward");
        addSequential(new DriveForward(0, 0), 0.5);
        System.out.println("Just finished stopping");
        addSequential(new NegativeTurn(-55, 0.66)); //subtract 5 to actually go 60 degrees
        System.out.println("Just turned");
        addSequential(new GyroAndDrive(), 0.75);
        System.out.println("Made it to the peg");
    }
}
