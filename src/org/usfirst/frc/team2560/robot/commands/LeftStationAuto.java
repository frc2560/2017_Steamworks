package org.usfirst.frc.team2560.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LeftStationAuto extends CommandGroup {

    public LeftStationAuto() {
        addSequential(new GyroAndDrive(), 1.3);
        addSequential(new Turn(55, 0.5)); //subtract 5 to make actual 60 degree turn
        addSequential(new GyroAndDrive(), 0.75);
    }
}
