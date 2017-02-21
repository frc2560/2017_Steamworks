package org.usfirst.frc.team2560.robot.subsystems;

import org.usfirst.frc.team2560.robot.RobotMap;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Climber extends Subsystem {

	public int up = 1;
	public int down = -1;
	public int stop = 0;
	
	private SpeedController climb;
   
   public Climber()
   {
	   climb = new Spark(RobotMap.climber);
   }

   public void up()
   {
	   climb.set(up);
   }
   
   public void down()
   {
	   climb.set(down);
   }
   
   public void stop()
   {
	   climb.set(stop);
   }

   public void initDefaultCommand() 
   {
	// TODO Auto-generated method stub
	
   }
   
   
    
}

