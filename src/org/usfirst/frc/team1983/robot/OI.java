package org.usfirst.frc.team1983.robot;

import org.usfirst.frc.team1983.com.AnalogRangeIOButton;
import org.usfirst.frc.team1983.robot.commands.ActuateCanStabilizer;
import org.usfirst.frc.team1983.robot.commands.RunIntake;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
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
		
		// Can manipulation
		// TODO can arms
		// TODO transfer
		// TODO collect fwd / rvs
		craaawToggle.whenPressed(new ActuateCanStabilizer(ActuateCanStabilizer.State.open));
		craaawToggle.whenReleased(new ActuateCanStabilizer(ActuateCanStabilizer.State.close));
		
		// Loading/Stacking
		alignToteFwd.whileHeld(new RunIntake(RobotMap.TOTE_INTAKE_MOTOR_FULL*2));
		alignToteRvs.whileHeld(new RunIntake(-RobotMap.TOTE_INTAKE_MOTOR_FULL));
		// TODO loadPos
		// TODO floorPos
		// TODO toggleAutoZone (get center can)
		
		// Scoring
		// TODO floorLoader
		// TODO score
		// TODO carryPos
		
		// Overrides
		// TODO wristOverride
		// TODO toteLifterUp
		// TODO toteLifterDown
		// TODO canArmOverrideUp
		// TODO canArmOverrideDown
		
		// Special driver buttons
		// TODO moveArmsWhackMode
		// TODO toteLifterUpDriver
		// TODO toteLifterDownDriver
		// TODO wristToggleDriver
	}

	public Joystick getLeftJoystick() {
		return joystickLeft;
	}

	public Joystick getRightJoystick() {
		return joystickRight;
	}

}
