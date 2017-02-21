package org.usfirst.frc.team2560.robot.commands;

import org.usfirst.frc.team2560.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GyroStraightDrive extends Command {

    public GyroStraightDrive() 
    {
    	requires(Robot.drivetrain);
    	requires(Robot.gyro);	
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
    	Robot.gyro.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
    	double angle = Robot.gyro.angle();
    	double power = Robot.drivetrain.maxJoystick(Robot.oi.joystick0.getRawAxis(1), Robot.oi.joystick0.getRawAxis(3));
    	
    	double values[]= Robot.drivetrain.gyroStraight(angle, power);
    	Robot.drivetrain.arcadeDrive(-values[0], 0);
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
