package org.usfirst.frc.team2560.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class TurnAuto extends CommandGroup {

    public TurnAuto() {
       addSequential(new Turn(90, 0.5));  //Causes stack overflow. Don't have the function call itself unless you are deliberately doing recursion.
    }
}
