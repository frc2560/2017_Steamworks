package org.usfirst.frc.team2560.robot.subsystems;

import org.usfirst.frc.team2560.robot.RobotMap;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends Subsystem {

    public final double shootPower = 0.55;
    public final double shootDelaySeconds = 0.5;
    public final double feed_speed = 0.75;
    public final double unfeed_speed = -1*feed_speed;
    
    private Spark shoot;
    private Victor shooter_feeder;
    
    public Shooter()
    {
    	shoot = new Spark(RobotMap.shooter);
    	shooter_feeder = new Victor(RobotMap.shooter_feeder);
    }
    
    public void shoot()
    {
    	shoot(0);
    }
    
    public final void shoot(double power)
    {    	
    	shoot.set(san(power));
    }
    
    public void stop()
    {
    	shoot(0);
    }
    
    public void feed(double power)
    {
    	
    	shooter_feeder.set(san(power));
    }
    
    private double san(double power)
    {
    	double newPower = power;
    	if(power > 1 || power < -1)
    	{
    		newPower = 0;
    	}
    	return newPower;
    }
    
    public void feed_stop()
    {
    	feed(0);
    }
    
    public void feed_shooter()
    {
    	feed(feed_speed);
    	
    }
    
    public void unfeed_shooter()
    {
    	feed(unfeed_speed); 
    }
    
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

