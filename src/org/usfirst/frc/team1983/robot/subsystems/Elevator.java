package org.usfirst.frc.team1983.robot.subsystems;

import org.usfirst.frc.team1983.com.PIDOutputWrapper;
import org.usfirst.frc.team1983.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Elevator extends Subsystem {

	private PIDOutputWrapper pidWrapper;
	private Encoder encoder;
	private PIDController pid;

	public enum ElevatorHeight {
		FLOOR(0), SCORE(3), TOTE(12), CAN(27);
		ElevatorHeight(float val) {
			this.val = val;
		}

		public float val;
	}

	public Elevator() {
		pidWrapper = new PIDOutputWrapper(new Talon(
				RobotMap.ELEVATOR_MOTOR_LEFT_PORT), new Talon(
				RobotMap.ELEVATOR_MOTOR_RIGHT_PORT));
		encoder = new Encoder(RobotMap.ELEVATOR_ENCODER_PORT_1,
				RobotMap.ELEVATOR_ENCODER_PORT_2);
		pid = new PIDController(RobotMap.ELEVATOR_PID_TERM_P,
				RobotMap.ELEVATOR_PID_TERM_I, RobotMap.ELEVATOR_PID_TERM_D,
				encoder, pidWrapper);
	}

	public Encoder getEncoder() {
		return encoder;
	}

	public PIDController getPID() {
		return pid;
	}

	public void setPID(double setpoint) {
		pid.setSetpoint(setpoint);
	}

	@Override
	protected void initDefaultCommand() {

	}

}
