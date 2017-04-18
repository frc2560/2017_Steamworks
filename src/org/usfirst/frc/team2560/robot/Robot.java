
package org.usfirst.frc.team2560.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoSink;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.usfirst.frc.team2560.robot.commands.CenterStationAuto;
import org.usfirst.frc.team2560.robot.commands.CrossBaselineAuto;
import org.usfirst.frc.team2560.robot.commands.DriveForwardAuto;
import org.usfirst.frc.team2560.robot.commands.DriveForwardGEAuto;
import org.usfirst.frc.team2560.robot.commands.DriveForwardWithEncodersAuto;
import org.usfirst.frc.team2560.robot.commands.GyroAndDriveAuto;
import org.usfirst.frc.team2560.robot.commands.OneFullRotationAuto;
import org.usfirst.frc.team2560.robot.commands.RightStationAuto;
import org.usfirst.frc.team2560.robot.commands.TurnAuto;
import org.usfirst.frc.team2560.robot.subsystems.Climber;
import org.usfirst.frc.team2560.robot.subsystems.DriveTrain;
import org.usfirst.frc.team2560.robot.subsystems.ExampleSubsystem;
import org.usfirst.frc.team2560.robot.subsystems.GyroSensor;
import org.usfirst.frc.team2560.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
	public static OI oi;

    Command autonomousCommand;
    SendableChooser chooser;
    
    public static DriveTrain drivetrain;
    public static Climber climb;
    public static Shooter shoot;
//    public static VideoSink server;
    public static UsbCamera camServ, camServ2;
    
    public boolean[] autoArray = {false, false, false, false, false, false, false, false};
    
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	
    	drivetrain = new DriveTrain();
    	climb = new Climber();
    	shoot = new Shooter();
    	camServ = CameraServer.getInstance().startAutomaticCapture(0);
    	camServ2 = CameraServer.getInstance().startAutomaticCapture(1);
    	
//    	server = new VideoSink(0);
//    	server.setSource(camServ);
    	    	
    	oi = new OI();
        chooser = new SendableChooser();
        chooser.addDefault("Default Auto", new DriveForwardAuto());
        chooser.addObject("Gyro and Encoders", new DriveForwardGEAuto());
        chooser.addObject("Turn", new TurnAuto());
        chooser.addObject("Gyro", new GyroAndDriveAuto());
        SmartDashboard.putData("Auto mode", chooser);
    }
	
	/**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
     */
    public void disabledInit()
    {

    }
	
	public void disabledPeriodic() 
	{
		Scheduler.getInstance().run();
		
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString code to get the auto name from the text box
	 * below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the chooser code above (like the commented example)
	 * or additional comparisons to the switch structure below with additional strings & commands.
	 */
    public void autonomousInit() 
    {
    	autonomousCommand = new CenterStationAuto(); //RightStationAuto(); //CenterStationAuto(); //LeftStationAuto(); //CrossBaselineAuto();
        
		/* String autoSelected = SmartDashboard.getString("Auto Selector", "Default");
		switch(autoSelected) {
		case "My Auto":
			autonomousCommand = new MyAutoCommand();
			break;
		case "Default Auto":
		default:
			autonomousCommand = new ExampleCommand();
			break;
		} */
    	
    	// schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() 
    {
        Scheduler.getInstance().run();
        log();
    }

    public void teleopInit() 
    {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
    
        Robot.drivetrain.setPercentMode();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() 
    {
        Scheduler.getInstance().run();
        log();
        switchCameras();
//        if(Robot.oi.joystick0.getPOV(0)==0 || Robot.oi.joystick0.getPOV(0)==180)
//        {
//        	switchCameras();
//        }
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() 
    {
        LiveWindow.run();
        switchCameras();
    }
    
    private void log()
    {
    	SmartDashboard.putNumber("Angle", Robot.drivetrain.angle());
    	SmartDashboard.putNumber("Gyro Rate", Robot.drivetrain.rate());
    	SmartDashboard.putNumber("Left Encoder Pulse", Robot.drivetrain.getLeftDecodedPulse());
    	SmartDashboard.putNumber("Right Encoder Pulse", Robot.drivetrain.getRightDecodedPulse());
    	SmartDashboard.putNumber("Left Encoder Position", Math.abs(Robot.drivetrain.getLeftEncoderPosition())); //TODO: Uncommment when encoders are installed.
    	SmartDashboard.putNumber("Right Encoder Position", Robot.drivetrain.getRightEncoderPosition());
    	double angle = Robot.drivetrain.angle();
    	double power = Robot.drivetrain.maxJoystick(Robot.oi.joystick0.getRawAxis(1), Robot.oi.joystick0.getRawAxis(3));
    	double values[]= Robot.drivetrain.gyroStraight(angle, power);
    	SmartDashboard.putNumber("gyroStraight", values[0]);
    	SmartDashboard.putNumber("Max Joystick Value", power);
    	double encPositions[] = Robot.drivetrain.adjustedEncPositions();
    	SmartDashboard.putNumber("Left Adjusted Encoder Position", encPositions[0]);
    	SmartDashboard.putNumber("Right Adjusted Encoders Position", encPositions[1]);
    } 

    private void refreshAutoArray()
    {
    	for(int i = 0; i < autoArray.length; i++)
    	{
    		autoArray[i] = false;
    	}
    }
    public void switchCameras()
    {
//    	if(Robot.oi.joystick0.getPOV(0) == 0)
//    	{
//    		server.setSource(camServ2);
//    	}
//    	if(Robot.oi.joystick0.getPOV(0) == 180)
//    	{
//    		server.setSource(camServ);
//    	}
    }
}
