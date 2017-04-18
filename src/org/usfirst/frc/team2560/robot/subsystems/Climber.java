package org.usfirst.frc.team2560.robot.subsystems;

import org.usfirst.frc.team2560.robot.RobotMap;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Climber extends Subsystem {

	public double up = -1;
	public double down = 1;
	public double stop = 0;
	
	private SpeedController climb;
	private SpeedController climb2;
   
   public Climber()
   {
	   climb = new Spark(RobotMap.climber);
	   climb2 = new Spark(RobotMap.climber2);
   }

   public void up()
   {
	   climb.set(up);
	   climb2.set(-up);
   }
   
   public void down()
   {
	   climb.set(down);
	   climb2.set(-down);
   }
   
   public void stop()
   {
	   climb.set(stop);
	   climb2.set(stop);
   }

   public void initDefaultCommand() 
   {
	// TODO Auto-generated method stub
	
   }
   
   
    
}

