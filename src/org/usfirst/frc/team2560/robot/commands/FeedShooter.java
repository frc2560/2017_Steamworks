package org.usfirst.frc.team2560.robot.commands;

import org.usfirst.frc.team2560.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class FeedShooter extends Command {

    public FeedShooter() {
        // Use requires() here to declare subsystem dependencies
    	requires(Robot.shoot);
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.shoot.feed_shooter();
    	Robot.shoot.shoot();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
//    	Robot.shoot.feed_stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
