package org.usfirst.frc.team2560.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap 
{	
	//Joystick Ports
	public static int joystick0 = 0;
	public static int joystick1 = 1;
	
	//PWM Ports
	public static int climber = 2;
	public static int shooter = 3;
	
	//CAN IDs
	public static int rightfollowmotor = 1; //possible left follow motor
	public static int leftmotor = 2;
	public static int leftfollowmotor = 3; //possible right follow motor
	public static int rightmotor = 4;
	
	//Buttons
	public static int climbUp = 1;
	public static int shoot = 2;
	public static int resetEnc = 3; //experimental
	public static int halfPower = 5;
	public static int fullPowerMode = 6;
	public static int axisReverse = 7;
	public static int gyroDrive = 8;
}
