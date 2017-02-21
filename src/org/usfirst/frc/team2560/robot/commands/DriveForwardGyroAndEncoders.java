package org.usfirst.frc.team2560.robot.commands;

import org.usfirst.frc.team2560.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveForwardGyroAndEncoders extends Command {
	
	private double requiredDistance;
	private double power;
	
    public DriveForwardGyroAndEncoders(double requiredDistance, double power) 
    {
        requires(Robot.drivetrain);
        requires(Robot.gyro);
        this.requiredDistance = requiredDistance;
        this.power = power;
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
    	Robot.gyro.reset();
    	Robot.drivetrain.resetEncoders();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
    	double endLeftDistance = Robot.drivetrain.getLeftEncoderPosition();
    	double endRightDistance = Robot.drivetrain.getRightEncoderPosition();
    	double angle = Robot.gyro.angle();
    	double Kp = 0.03;
  
    	while(endLeftDistance < requiredDistance && endRightDistance < requiredDistance);
    	{
    		endLeftDistance = Robot.drivetrain.getLeftEncoderPosition();
    		endRightDistance = Robot.drivetrain.getRightEncoderPosition();
    		angle = Robot.gyro.angle();
    		Robot.drivetrain.gyroDrive(power, -angle*Kp);
    	}

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
