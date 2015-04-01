package org.usfirst.frc.team1983.robot.subsystems;

import org.usfirst.frc.team1983.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ArmLifter extends Subsystem implements PIDSource, PIDOutput {

	private PIDController pid;
	private AnalogInput pot;
	private CANTalon leftLiftMotor, rightLiftMotor;

	public ArmLifter() {
		pot = new AnalogInput(RobotMap.CAN_GRABBER_ANALOG_INPUT_PORT);
		leftLiftMotor = new CANTalon(RobotMap.CAN_LIFTER_LEFT_PORT);
		rightLiftMotor = new CANTalon(RobotMap.CAN_LIFTER_LEFT_PORT);
		pid = new PIDController(RobotMap.CAN_GRABBER_PID_TERM_P,
				RobotMap.CAN_GRABBER_PID_TERM_I,
				RobotMap.CAN_GRABBER_PID_TERM_D, this, this);
	}

	public PIDController getPID() {
		return pid;
	}

	public CANTalon getLiftMotor() {
		return leftLiftMotor;
	}

	@Override
	protected void initDefaultCommand() {

	}

	@Override
	public void pidWrite(double output) {
		leftLiftMotor.set(output);
		rightLiftMotor.set(-output);
	}

	@Override
	public double pidGet() {
		return pot.pidGet();
	}

}
