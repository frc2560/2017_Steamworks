package org.usfirst.frc.team2560.robot.commands;

import org.usfirst.frc.team2560.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class NegativeTurn extends Command {

	private double requiredAngle;
	//private double Kp = 0.1; //experimental value
	private double power;
	
    public NegativeTurn(double requiredAngle, double power) 
    {
        //requires(Robot.gyro);
        requires(Robot.drivetrain); //turn robot using drive and Kp
        this.requiredAngle = requiredAngle; //requiredAngle = actualAngle - 5: so subtract 5 degrees from the actual angle you want to go
        this.power = power;
    } 

    // Called just before this Command runs the first time
    protected void initialize() 
    { 
    	Robot.drivetrain.reset();
    	Robot.drivetrain.rotatePID.setSetpoint(requiredAngle);
    	Robot.drivetrain.rotatePID.enable();
    	Robot.drivetrain.rotatePID.setAbsoluteTolerance(0.5);
    	Robot.drivetrain.rotatePID.setContinuous(false);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
    	double endAngle = Robot.drivetrain.angle();
    	while(endAngle > requiredAngle)
    	{
    		endAngle = Robot.drivetrain.angle();
    		Robot.drivetrain.arcadeDrive(0, Robot.drivetrain.rotatePID.get()/2);	//create method that turns robot according to gyro angle
    	} //extra testing code in testing project
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() 
    {
        return Robot.drivetrain.rotatePID.onTarget(); //return to false if error is given or program fails to work
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
