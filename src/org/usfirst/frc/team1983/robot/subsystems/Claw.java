package org.usfirst.frc.team1983.robot.subsystems;

import org.usfirst.frc.team1983.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * The claw is a pair of pneumatics that hold onto the can and stabilize the
 * stack
 */
public class Claw extends Subsystem {
	private DoubleSolenoid clawLocker;
	private boolean isActuated;
	
	public Claw() {
		clawLocker = new DoubleSolenoid(RobotMap.CLAW_LOCK_LEFT_PORT, RobotMap.CLAW_LOCK_RIGHT_PORT);
		isActuated = true;
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
	
	public void setActuated(DoubleSolenoid.Value value) {
		isActuated = value == DoubleSolenoid.Value.kForward ? true : false;
		clawLocker.set(value);
	}
	
	public boolean isOpen() {
		return isActuated;
	}
}
