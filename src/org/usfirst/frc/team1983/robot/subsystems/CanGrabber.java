package org.usfirst.frc.team1983.robot.subsystems;

import org.usfirst.frc.team1983.com.PIDOutputWrapper;
import org.usfirst.frc.team1983.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class CanGrabber extends Subsystem {

	private PIDController pid;
	private PIDOutputWrapper pidWrapper;
	private AnalogInput pot;
	private CANTalon leftMecMotor;
	private CANTalon rightMecMotor;

	public CanGrabber() {
		pot = new AnalogInput(RobotMap.CAN_GRABBER_ANALOG_INPUT_PORT);
		pidWrapper = new PIDOutputWrapper(new Talon(
				RobotMap.CAN_GRABBER_MOTOR_LEFT_PORT), new Talon(
				RobotMap.CAN_GRABBER_MOTOR_RIGHT_PORT));
		pid = new PIDController(RobotMap.CAN_GRABBER_PID_TERM_P,
				RobotMap.CAN_GRABBER_PID_TERM_I,
				RobotMap.CAN_GRABBER_PID_TERM_D, pot, pidWrapper);
		leftMecMotor = new CANTalon(RobotMap.CAN_GRABBER_MEC_LEFT_MOTOR_PORT);
		rightMecMotor = new CANTalon(RobotMap.CAN_GRABBER_MEC_RIGHT_MOTOR_PORT);
	}

	public PIDController getPID() {
		return pid;
	}
	
	public CANTalon getLeftMecMotor(){
		return leftMecMotor;
	}
	
	public CANTalon getRightMecMotor(){
		return rightMecMotor;
	}


	@Override
	protected void initDefaultCommand() {

	}

}
