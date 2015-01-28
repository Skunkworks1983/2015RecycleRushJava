package org.usfirst.frc.team1983.robot.subsystems;

import java.util.EnumMap;

import org.usfirst.frc.team1983.robot.RobotMap;
import org.usfirst.frc.team1983.robot.commands.MecanumDrive;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveBase extends Subsystem {

	public enum MotorSide {
		FRONTLEFT, FRONTRIGHT, BACKLEFT, BACKRIGHT
	}

	private EnumMap<MotorSide, Talon> motors = new EnumMap<MotorSide, Talon>(
			MotorSide.class);

	public DriveBase() {
		motors.put(MotorSide.FRONTLEFT, new Talon(
				RobotMap.DRIVE_BASE_FRONT_LEFT));
		motors.put(MotorSide.FRONTRIGHT, new Talon(
				RobotMap.DRIVE_BASE_FRONT_RIGHT));
		motors.put(MotorSide.BACKLEFT,
				new Talon(RobotMap.DRIVE_BASE_BACK_LEFT));
		motors.put(MotorSide.BACKRIGHT, new Talon(
				RobotMap.DRIVE_BASE_BACK_RIGHT));
	}

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new MecanumDrive());
	}

	public Talon getMotor(MotorSide side) {
		return motors.get(side);
	}

	public void setMotor(MotorSide side, double speed) {
		motors.get(side).set(speed);
		;
	}
}
