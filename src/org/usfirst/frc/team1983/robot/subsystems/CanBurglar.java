package org.usfirst.frc.team1983.robot.subsystems;

import org.usfirst.frc.team1983.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * The can burglar is a rake on a single pneumatic that retrieve cans from the
 * center
 */
public class CanBurglar extends Subsystem {
	private DoubleSolenoid solenoid;
	
	public CanBurglar() {
		solenoid = new DoubleSolenoid(RobotMap.CAN_BURGLAR_PORT_A, RobotMap.CAN_BURGLAR_PORT_B);
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
	
	public void set(DoubleSolenoid.Value value) {
		solenoid.set(value);
	}
	
	public void toggle() {
		if(solenoid.get() == DoubleSolenoid.Value.kForward) {
			solenoid.set(DoubleSolenoid.Value.kReverse);
		} else {
			solenoid.set(DoubleSolenoid.Value.kForward);
		}
	}
}
