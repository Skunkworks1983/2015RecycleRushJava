package org.usfirst.frc.team1983.robot.subsystems;

import org.usfirst.frc.team1983.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * The can burglar is a rake on a single pneumatic that retrieve cans from the
 * center
 */
public class CanBurglar extends Subsystem {
	public enum GrabState {
		GRAB, RETRACT, TOGGLE
	}

	private DoubleSolenoid solenoid;

	public CanBurglar() {
		solenoid = new DoubleSolenoid(RobotMap.CAN_BURGLAR_PORT_A,
				RobotMap.CAN_BURGLAR_PORT_B);
	}

	public void initDefaultCommand() {
	}

	public void set(GrabState state) {
		switch (state) {
		case GRAB:
			solenoid.set(Value.kReverse);
			break;
		case RETRACT:
			solenoid.set(Value.kForward);
			break;
		case TOGGLE:
			if (solenoid.get() == Value.kForward) {
				solenoid.set(Value.kReverse);
			} else if (solenoid.get() == Value.kReverse) {
				solenoid.set(Value.kForward);
			}
			break;
		}
	}
}
