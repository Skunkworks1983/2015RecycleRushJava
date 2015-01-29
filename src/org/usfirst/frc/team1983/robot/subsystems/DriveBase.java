package org.usfirst.frc.team1983.robot.subsystems;

import java.util.EnumMap;

import org.usfirst.frc.team1983.robot.RobotMap;
import org.usfirst.frc.team1983.robot.commands.MecanumDrive;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

public class DriveBase extends PIDSubsystem {

	public enum MotorSide {
		FRONTLEFT, FRONTRIGHT, BACKLEFT, BACKRIGHT
	}

	private EnumMap<MotorSide, CANTalon> motors = new EnumMap<MotorSide, CANTalon>(
			MotorSide.class);
	
	public Gyro gyro;

	public DriveBase() {
		super("DriveBase", RobotMap.DRIVE_P, RobotMap.DRIVE_I, RobotMap.DRIVE_D);
		motors.put(MotorSide.FRONTLEFT, new CANTalon(
				RobotMap.DRIVE_BASE_FRONT_LEFT));
		motors.put(MotorSide.FRONTRIGHT, new CANTalon(
				RobotMap.DRIVE_BASE_FRONT_RIGHT));
		motors.put(MotorSide.BACKLEFT,
				new CANTalon(RobotMap.DRIVE_BASE_BACK_LEFT));
		motors.put(MotorSide.BACKRIGHT, new CANTalon(
				RobotMap.DRIVE_BASE_BACK_RIGHT));
	}

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new MecanumDrive());
	}

	public CANTalon getMotor(MotorSide side) {
		return motors.get(side);
	}

	public void setMotor(MotorSide side, double speed) {
		motors.get(side).set(speed);
	}

	@Override
	protected double returnPIDInput() {
		// TODO Auto-generated method stub
		return gyro.getAngle();
	}

	@Override
	protected void usePIDOutput(double output) {
		// TODO Auto-generated method stub
		
	}
}
