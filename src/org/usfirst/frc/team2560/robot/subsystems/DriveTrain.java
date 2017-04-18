package org.usfirst.frc.team2560.robot.subsystems;

import org.usfirst.frc.team2560.robot.Robot;
import org.usfirst.frc.team2560.robot.RobotMap;
import org.usfirst.frc.team2560.robot.commands.DriveWithController;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem implements PIDOutput {

    private CANTalon left, right, leftFollow, rightFollow;
    public ADXRS450_Gyro gyro;
    private RobotDrive drive;
    public PIDController rotatePID, movePID;
    
    public double kP = 0;
	public double kI = 0;
	public double kD = 0;
	
	public double mP = 0;
	public double mI = 0;
	public double mD = 0;
    
    public DriveTrain()
    {
    	left = new CANTalon(RobotMap.leftmotor);
    	left.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
    	right = new CANTalon(RobotMap.rightmotor);
    	right.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
    	
    	leftFollow = new CANTalon(RobotMap.leftfollowmotor);
    	leftFollow.changeControlMode(CANTalon.TalonControlMode.Follower);
    	leftFollow.set(left.getDeviceID());
    	
    	rightFollow = new CANTalon(RobotMap.rightfollowmotor);
    	rightFollow.changeControlMode(CANTalon.TalonControlMode.Follower);
    	rightFollow.set(right.getDeviceID());
    	
    	drive = new RobotDrive(left, right);
    	
    	gyro = new ADXRS450_Gyro();
    	rotatePID = new PIDController(kP, kI, kD, gyro,  this);
    	rotatePID.setContinuous(true);
    	rotatePID.setInputRange(-360, 360);
    	rotatePID.setOutputRange(-1.0, 1.0);
    	
    	movePID = new PIDController(mP, m)
    	calibrate();
    }

    public void tankDrive(double leftAxis, double rightAxis)
	{
		drive.tankDrive(leftAxis, rightAxis);
	}
	
	public void stop()
	{
		drive.tankDrive(0, 0);
	}
	
	public void gyroDrive(double outputMagnitude, double curve)
	{
		drive.drive(outputMagnitude, curve);
	}
	
	public void arcadeDrive(double forwardAxis, double twist)
	{
		drive.arcadeDrive(forwardAxis, twist);
	}

	public void setPositionMode()
	{
		left.changeControlMode(CANTalon.TalonControlMode.Position);
		right.changeControlMode(CANTalon.TalonControlMode.Position);
	}
	
	public void setPercentMode()
	{
		left.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		right.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
	}
	
	public double getLeftDecodedPulse()
	{
		return left.getPulseWidthPosition();
	}
	
	public double getRightDecodedPulse()
	{
		return right.getPulseWidthPosition();
	}
	
	public double getLeftEncoderPosition()
	{
		return left.getEncPosition();
	}
	
	public double getRightEncoderPosition()
	{
		return right.getEncPosition();
	}
	public void setPosition(double position)
	{
		left.set(position);
		right.set(position);
	}
	public void resetEncoders()
	{
		left.setEncPosition(0);
		right.setEncPosition(0);
	}
	public double maxJoystick(double joystick1, double joystick2)
	{
		double deadzone = 0.05;
		if(Math.abs(joystick1) < deadzone)
		{
			joystick1 = 0.0;
		}
		if(Math.abs(joystick2) < deadzone)
		{
			joystick2 = 0.0;
		}
		if((joystick1 < 0 && joystick2 > 0) ||(joystick1 > 0 && joystick2 < 0))
		{
			return 0.0;
		}
		if(Math.abs(joystick1) > Math.abs(joystick2))
		{
			return joystick1;
		}else{
			return joystick2;
		}
	}
	public double[] gyroStraight(double gyro, double power)
	{
		double leading = 0, trailing = 0;
		double leftM = 0, rightM = 0;
		
		//max off-axis of the robot
		double maxAngle = 30;
		
		//absolute value of gyro rotation
		double absGyro = Math.abs(gyro);
		
		//amount of power to subtract
		double subtractedPower = absGyro/maxAngle;
		//no negative power
		if (subtractedPower > 1)
		{
			subtractedPower = 1;
		}
		//max power = trailing
		trailing = power;
		//percentage of power
		leading = power * (1 - subtractedPower);
		
		if (gyro < 0 && power > 0)
		{
			leftM = trailing;
			rightM = leading;
		}else{
			rightM = trailing;
			leftM = leading;
		
		}
		double avgDrive = leftM + rightM / 2;
		double values[] = {avgDrive};
		return values;
	}
	
	public double[] adjustedEncPositions()
	{
		double leftEnc = Math.abs(getLeftEncoderPosition());
		double rightEnc = getRightEncoderPosition();
		
		double averageEnc = (leftEnc + rightEnc)/2;
		
		double encPositions[] = {averageEnc, averageEnc};
		return encPositions;
	}
	
	public void setPID(double P, double I, double D)
	{
		left.setPID(P, I, D);
		right.setPID(P, I, D);
	}
	
	//Gyro Related Methods
	
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
	
	public void initDefaultCommand() 
    {
        setDefaultCommand(new DriveWithController());
    }

	public void pidWrite(double output) {
		// TODO Auto-generated method stub
		
	}
}

