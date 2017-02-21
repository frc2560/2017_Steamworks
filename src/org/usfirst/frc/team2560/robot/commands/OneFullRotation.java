package org.usfirst.frc.team2560.robot.commands;

import org.usfirst.frc.team2560.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class OneFullRotation extends Command {

	private double position;
	
    public OneFullRotation(double position) 
    {
        requires(Robot.drivetrain);
        this.position = position;
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
    	Robot.drivetrain.resetEncoders();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
    	Robot.drivetrain.setPositionMode();
    	Robot.drivetrain.setPosition(position);
    	Robot.drivetrain.setPID(0.5, 0.001, 0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() 
    {
        return false;
    }

    // Called once after isFinished returns true
    protected void end()
    {
    	Robot.drivetrain.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() 
    {
    	end();
    }
}
