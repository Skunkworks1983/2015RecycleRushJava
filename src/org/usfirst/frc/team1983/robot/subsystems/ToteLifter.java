package org.usfirst.frc.team1983.robot.subsystems;

import org.usfirst.frc.team1983.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ToteLifter extends Subsystem implements PIDOutput, PIDSource{
	private Encoder encoder;
	private PIDController pid;
	private CANTalon leftMotor,rightMotor;
	private DigitalInput magSensor;

	public ToteLifter() {
		encoder = new Encoder(RobotMap.ELEVATOR_ENCODER_PORT_A,
				RobotMap.ELEVATOR_ENCODER_PORT_B);
		pid = new PIDController(RobotMap.ELEVATOR_PID_TERM_P,
				RobotMap.ELEVATOR_PID_TERM_I, RobotMap.ELEVATOR_PID_TERM_D,
				this, this);
		leftMotor = new CANTalon(RobotMap.ELEVATOR_MOTOR_LEFT_PORT);
		rightMotor = new CANTalon(RobotMap.ELEVATOR_MOTOR_RIGHT_PORT);
		magSensor = new DigitalInput(RobotMap.TOTE_LIFTER_MAG_SENSOR_PORT);
	}

	public Encoder getEncoder() {
		return encoder;
	}

	public PIDController getPID() {
		return pid;
	}

	public void setSetPoint(double setpoint) {
		pid.setSetpoint(setpoint);
	}
	
	public boolean getMagSensorInput(){
		return !magSensor.get();
	}

	@Override
	protected void initDefaultCommand() {
		
	}

	@Override
	public double pidGet() {
		return encoder.pidGet();
	}

	@Override
	public void pidWrite(double output) {
		leftMotor.set(output);
		rightMotor.set(output);
	}

}
