package org.usfirst.frc.team3528.robot;


import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This is a demo program showing the use of the RobotDrive class, specifically it 
 * contains the code necessary to operate a robot with tank drive.
 *
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the SampleRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 *
 * WARNING: While it may look like a good choice to use for your code if you're inexperienced,
 * don't. Unless you know what you are doing, complex code will be much more difficult under
 * this system. Use IterativeRobot or Command-Based instead if you're new.
 */
public class Robot extends SampleRobot {
    RobotDrive myRobot;  
    Joystick joyStick;  
    Compressor compressor;
    Solenoid solenoid1;
    Solenoid solenoid2;
    double left;
    double right;
    Button aButton;
    
    public Robot() {
        myRobot = new RobotDrive(0, 1);
        
        joyStick = new Joystick(0);
        
        compressor = new Compressor(1);
        compressor.setClosedLoopControl(true);
        
        solenoid1 = new Solenoid(1, 1);
        solenoid2 = new Solenoid(1, 3);
        
        aButton = new JoystickButton(joyStick, 1);
        
    }

    
    /**
     * Runs the motors with tank steering.
     */
    public void operatorControl() {
   
    	
        while (isOperatorControl() && isEnabled()) {
        	left = joyStick.getRawAxis(1) * -1;
        	right = joyStick.getRawAxis(5) * -1;
        	
        	if (aButton.get()) {
        		solenoid1.set(true);
        		solenoid2.set(false);
        	}
        	
        	myRobot.tankDrive(Utils.rampSpeed(left, .5), Utils.rampSpeed(right, .5));
            
        	Timer.delay(0.005);		// wait for a motor update time
        }
    }

}
