package org.usfirst.frc.team1983.robot;

import org.usfirst.frc.team1983.robot.commands.GoToHeight;
import org.usfirst.frc.team1983.robot.commands.GrabCan;
import org.usfirst.frc.team1983.robot.commands.PushStackGroup;
import org.usfirst.frc.team1983.robot.commands.RaiseArm;
import org.usfirst.frc.team1983.robot.commands.RaiseArm.ArmPosition;
import org.usfirst.frc.team1983.robot.commands.RunIntake;
import org.usfirst.frc.team1983.robot.subsystems.Elevator.ElevatorHeight;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	// // CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	// // TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());

	private Button goToFloor, goToScore, goToTote, goToCan;		//elevator buttons
	private Button lowerArm, raiseArm, grabCan;					//CanGrabber Arm buttons
	private Button toteIntakeOvr;
	private Button pushStackOut;
	private Joystick leftStick, rightStick;

	OI() {
		leftStick = new Joystick(1);
		rightStick = new Joystick(2);
		
		goToFloor = new JoystickButton(leftStick, 1);
		goToScore = new JoystickButton(leftStick, 2);
		goToTote = new JoystickButton(leftStick, 3);
		goToCan = new JoystickButton(leftStick, 4);
		
		lowerArm = new JoystickButton(leftStick, 5);
		raiseArm = new JoystickButton(leftStick, 6);
		grabCan = new JoystickButton(leftStick, 7);

		toteIntakeOvr = new JoystickButton(leftStick, 8);
		
		pushStackOut = new JoystickButton(leftStick, 9);
		
		goToFloor.whenPressed(new GoToHeight(ElevatorHeight.FLOOR));
		goToScore.whenPressed(new GoToHeight(ElevatorHeight.SCORE));
		goToTote.whenPressed(new GoToHeight(ElevatorHeight.TOTE));
		goToCan.whenPressed(new GoToHeight(ElevatorHeight.CAN));
		
		lowerArm.whenPressed(new RaiseArm(ArmPosition.LOWER));
		raiseArm.whenPressed(new RaiseArm(ArmPosition.RAISE));
		grabCan.whenPressed(new GrabCan());
		
		toteIntakeOvr.whenPressed(new RunIntake());
		
		pushStackOut.whenPressed(new PushStackGroup());
	}
	
	public Joystick getLeftJoystick(){
		return leftStick;
	}
	
	public Joystick getRightJoystick(){
		return rightStick;
	}

}
