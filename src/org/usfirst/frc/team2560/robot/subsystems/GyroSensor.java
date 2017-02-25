package org.usfirst.frc.team2560.robot.subsystems;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GyroSensor extends Subsystem {

	public int sensitivity = 1;
	public double kP = 0;
	public double kI = 0;
	public double kD = 0;
	
	public static double toleranceDegrees = 2.5; //experimental value
	
	public ADXRS450_Gyro gyro;
	public PIDController rotatePID;
    
    public GyroSensor()
    {
    	gyro = new ADXRS450_Gyro();
    	calibrate();
    }
    
    public void reset()
    {
    	gyro.reset();
    }
    
    public double angle()
    {
    	return gyro.getAngle();
    }
    
    public void calibrate()
    {
    	gyro.calibrate();
    }
    
    public double rate()
    {
    	return gyro.getRate();
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

