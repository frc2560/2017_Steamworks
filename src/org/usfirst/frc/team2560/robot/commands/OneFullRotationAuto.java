package org.usfirst.frc.team2560.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class OneFullRotationAuto extends CommandGroup {

    public OneFullRotationAuto() {
        addSequential(new OneFullRotation(4096));
    }
}
