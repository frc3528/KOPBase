package org.usfirst.frc.team3528.robot;


import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


public class Robot extends SampleRobot {
	
	// set up object variables
    RobotDrive myRobot;  
    Joystick joyStick;  
    Compressor compressor;
    DoubleSolenoid solenoid1;
    Button aButton;
    Button bButton;
    
    
    // variables to hold left and right joystick values
    double left;
    double right;
    
    
    public Robot() {
    
    	// create our objects
    	myRobot = new RobotDrive(0, 1);
        
        joyStick = new Joystick(0);
        
        compressor = new Compressor(1);
        compressor.setClosedLoopControl(true);
        
        
        
        solenoid1 = new DoubleSolenoid(1, 1, 3);
        
        aButton = new JoystickButton(joyStick, 1);
        bButton = new JoystickButton(joyStick, 2);
        
    }

    
    // teleop
    public void operatorControl() {
   
    	
        while ( isOperatorControl() && isEnabled() ) {
        	
        	// get left and right stick y axis values (invert them)
        	left = joyStick.getRawAxis(1) * -1;
        	right = joyStick.getRawAxis(5) * -1;
        	
        	// check for button A
        	if ( aButton.get() ) {
        		solenoid1.set( DoubleSolenoid.Value.kForward );
        	} else if ( bButton.get() ) {
        		solenoid1.set( DoubleSolenoid.Value.kReverse );
        	}
        	
        	// drive
        	myRobot.tankDrive(Utils.rampSpeed(left, .5), Utils.rampSpeed(right, .5));
            
        	Timer.delay(0.005);		// wait for a motor update time
        }
    }

}
