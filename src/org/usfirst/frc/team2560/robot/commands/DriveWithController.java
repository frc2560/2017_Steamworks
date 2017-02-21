package org.usfirst.frc.team2560.robot.commands;

import org.usfirst.frc.team2560.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveWithController extends Command {

    public DriveWithController() 
    {
    	requires(Robot.drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
    	//Robot.drivetrain.resetLeftEncoder();
    	//Robot.drivetrain.resetRightEncoder();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
    	double multiplier = 0.8;
    	//Robot.drivetrain.tankDrive(-Robot.oi.getJoystick0().getRawAxis(1)*multiplier, -Robot.oi.getJoystick0().getRawAxis(3)*multiplier);*/    }
    	Robot.drivetrain.arcadeDrive(-Robot.oi.joystick0.getRawAxis(1)*multiplier,-Robot.oi.joystick0.getRawAxis(2)*0.66);
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
