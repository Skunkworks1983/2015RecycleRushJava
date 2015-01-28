package org.usfirst.frc.team1983.robot.subsystems;

import org.usfirst.frc.team1983.robot.RobotMap;
import org.usfirst.frc.team1983.robot.commands.RunIntake;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ToteIntake extends Subsystem {

	private Talon driveMotor;
	private DigitalInput sensor;

	public ToteIntake() {
		driveMotor = new Talon(RobotMap.TOTE_INTAKE_MOTOR_PORT);
		sensor = new DigitalInput(RobotMap.TOTE_INTAKE_SENSOR_PORT);
	}

	public void initDefaultCommand() {
		setDefaultCommand(new RunIntake());
	}

	public void setMotor(float speed) {
		driveMotor.set(speed);
	}

	public boolean getSensorValue() {
		return sensor.get();
	}
}
