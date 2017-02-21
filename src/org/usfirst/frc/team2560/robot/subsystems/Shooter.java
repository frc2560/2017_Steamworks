package org.usfirst.frc.team2560.robot.subsystems;

import org.usfirst.frc.team2560.robot.RobotMap;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends Subsystem {

    public double up = 0.45;
    
    private Spark shoot;
    
    public Shooter()
    {
    	shoot = new Spark(RobotMap.shooter);
    }
    
    public void shoot()
    {
    	shoot.set(up);
    }
    
    public void stop()
    {
    	shoot.set(0);
    }
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

