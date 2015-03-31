package org.usfirst.frc.team1983.robot.subsystems;

import org.usfirst.frc.team1983.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * The can intake is at the end of the wrists and sucks the can in using mecanum
 * wheels
 */
public class CanIntake extends Subsystem {
	private CANTalon left, right;
	
	public CanIntake() {
		left = new CANTalon(RobotMap.CAN_INTAKE_LEFT_PORT);
		right = new CANTalon(RobotMap.CAN_INTAKE_RIGHT_PORT);
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
	
	public void set(float speed) {
		left.set(speed);
		right.set(-speed);
	}
	
	public CANTalon getLeftMotor() {
		return left;
	}
	
	public CANTalon getRightMotor() {
		return right;
	}
}
