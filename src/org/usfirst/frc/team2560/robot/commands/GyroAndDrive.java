package org.usfirst.frc.team2560.robot.commands;

import org.usfirst.frc.team2560.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GyroAndDrive extends Command {

    public GyroAndDrive() 
    {
    	requires(Robot.drivetrain);
    	//requires(Robot.gyro);
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
    	Robot.drivetrain.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
    	double multiplier = 0.5;
    	double angle = Robot.drivetrain.angle();
    	double Kp = 0.03;
    	Robot.drivetrain.gyroDrive(1*multiplier, -angle*Kp);
    	Timer.delay(0.04);
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
