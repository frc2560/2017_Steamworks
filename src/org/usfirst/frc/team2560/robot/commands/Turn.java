package org.usfirst.frc.team2560.robot.commands;

import org.usfirst.frc.team2560.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Turn extends Command {

	private double requiredAngle;
	//private double Kp = 0.1; //experimental value
	private double power;
	
    public Turn(double requiredAngle, double power) 
    {
        requires(Robot.gyro);
        requires(Robot.drivetrain); //turn robot using drive and Kp
        this.requiredAngle = requiredAngle;
        this.power = power;
    } 

    // Called just before this Command runs the first time
    protected void initialize() 
    { 
    	Robot.gyro.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
    	double endAngle = Robot.gyro.angle();
    	while(endAngle < requiredAngle)
    	{
    		endAngle = Robot.gyro.angle();
    		Robot.drivetrain.tankDrive(power, -power);	//create method that turns robot according to gyro angle
    	} //extra testing code in testing project
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
