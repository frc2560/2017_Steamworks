package org.usfirst.frc.team2560.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team2560.robot.commands.AxisReverse;
import org.usfirst.frc.team2560.robot.commands.ClimbUp;
import org.usfirst.frc.team2560.robot.commands.HalfPowerMode;
import org.usfirst.frc.team2560.robot.commands.ResetEncoders;
import org.usfirst.frc.team2560.robot.commands.ShootBalls;
import org.usfirst.frc.team2560.robot.commands.FullPowerMode;
import org.usfirst.frc.team2560.robot.commands.GyroStraightDrive;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI 
	{
	public Joystick joystick0, joystick1;

	public OI()
	{
		joystick0 = new Joystick(RobotMap.joystick0);
		joystick1 = new Joystick(RobotMap.joystick1);
		
		Button halfPowerMode = new JoystickButton(joystick0, RobotMap.halfPower);
		halfPowerMode.whileHeld(new HalfPowerMode());
		
		Button fullPowerMode = new JoystickButton(joystick0, RobotMap.fullPowerMode);
		fullPowerMode.whileHeld(new FullPowerMode());
		
		Button axisReverse = new JoystickButton(joystick0, RobotMap.axisReverse);
		axisReverse.whileHeld(new AxisReverse());
		
		Button climbUp = new JoystickButton(joystick0, RobotMap.climbUp);
		climbUp.whileHeld(new ClimbUp());
		
		Button gyroDriveStraight = new JoystickButton(joystick0, RobotMap.gyroDrive);
		gyroDriveStraight.whileHeld(new GyroStraightDrive());
		
		Button shoot = new JoystickButton(joystick0, RobotMap.shoot);
		shoot.whileHeld(new ShootBalls());
		
		Button resetEnc = new JoystickButton(joystick0 , RobotMap.resetEnc);
		resetEnc.whileHeld(new ResetEncoders( ));
	}
    
	public Joystick getJoystick0()
	{
		return joystick0;
	}
	
	public Joystick getJoystick1()
	{
		return joystick1;
	}
}

