package org.usfirst.frc.team1983.robot;

import org.usfirst.frc.team1983.com.AnalogRangeIOButton;
import org.usfirst.frc.team1983.robot.commands.GoToHeight;
import org.usfirst.frc.team1983.robot.commands.GrabCan;
import org.usfirst.frc.team1983.robot.commands.RaiseArm;
import org.usfirst.frc.team1983.robot.commands.RaiseArm.ArmPosition;
import org.usfirst.frc.team1983.robot.commands.RunIntake;

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

	private static final int OPERATOR_PORT = 2;

	private Joystick joystickLeft, joystickRight, op;
	private JoystickButton canArms, canCollectFwd, canCollectRvs,
			canToCraaawTransfer, craaawToggle, toggleAutoZone;
	private JoystickButton alignToteFwd, alignToteRvs, loadPos, floorPos;
	private AnalogRangeIOButton floorLoader, carryPos, score;
	private JoystickButton canArmOverrideUp, canArmOverrideDown, wristOverride,
			toteLifterUp, toteLifterDown, zeroLifter;
	private JoystickButton moveArmsWhackMode, toteLifterUpDriver,
			toteLifterDownDriver, toteIndexFwd, toteIndexRv, wristToggleDriver;

	OI() {
		joystickLeft = new Joystick(0);
		joystickRight = new Joystick(1);
		op = new Joystick(OPERATOR_PORT);

		// Can getting
		canArms = new JoystickButton(op, 11);
		canCollectFwd = new JoystickButton(op, 13);
		canCollectRvs = new JoystickButton(op, 12);
		canToCraaawTransfer = new JoystickButton(op, 10);
		craaawToggle = new JoystickButton(op, 14);
		toggleAutoZone = new JoystickButton(joystickLeft, 2);

		// Tote stacking
		alignToteFwd = new JoystickButton(op, 7);
		alignToteRvs = new JoystickButton(op, 8);
		loadPos = new JoystickButton(op, 6);
		floorPos = new JoystickButton(op, 5);

		// Scoring
		floorLoader = new AnalogRangeIOButton(OPERATOR_PORT,
				Joystick.AxisType.kX, 0.5f, 0.9f);
		carryPos = new AnalogRangeIOButton(OPERATOR_PORT, Joystick.AxisType.kX,
				-0.25f, 0.25f);
		score = new AnalogRangeIOButton(OPERATOR_PORT, Joystick.AxisType.kX,
				-1.0f, -0.4f);

		// Overrides
		canArmOverrideUp = new JoystickButton(op, 3);
		canArmOverrideDown = new JoystickButton(op, 4);
		wristOverride = new JoystickButton(op, 2);
		toteLifterUp = new JoystickButton(op, 9);
		toteLifterDown = new JoystickButton(op, 15);
		zeroLifter = new JoystickButton(op, 16);

		// Driver buttons
		moveArmsWhackMode = new JoystickButton(joystickLeft, 1);
		toteLifterUpDriver = new JoystickButton(joystickLeft, 4);
		toteLifterDownDriver = new JoystickButton(joystickLeft, 5);
		toteIndexFwd = new JoystickButton(joystickRight, 5);
		toteIndexRv = new JoystickButton(joystickRight, 3);
		wristToggleDriver = new JoystickButton(joystickRight, 1);
	}

	public void registerButtonListeners() {
		// TODO add button listeners when we have actual commands
	}

	public Joystick getLeftJoystick() {
		return joystickLeft;
	}

	public Joystick getRightJoystick() {
		return joystickRight;
	}

}
