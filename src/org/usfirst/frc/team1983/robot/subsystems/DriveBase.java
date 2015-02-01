package org.usfirst.frc.team1983.robot.subsystems;

import java.util.EnumMap;

import org.usfirst.frc.team1983.robot.RobotMap;
import org.usfirst.frc.team1983.robot.commands.MecanumDrive;

import com.kauailabs.nav6.frc.BufferingSerialPort;
import com.kauailabs.nav6.frc.IMUAdvanced;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.visa.VisaException;

public class DriveBase extends Subsystem implements PIDOutput, PIDSource {

	public enum MotorSide {
		FRONTLEFT, FRONTRIGHT, BACKLEFT, BACKRIGHT
	}

	private EnumMap<MotorSide, CANTalon> motors = new EnumMap<MotorSide, CANTalon>(
			MotorSide.class);

	public IMUAdvanced gyro;

	private PIDController pid;
	private double forward;
	private double right;
	private double clockwise;

	public DriveBase() {
		super("DriveBase");
		motors.put(MotorSide.FRONTLEFT, new CANTalon(
				RobotMap.DRIVE_BASE_FRONT_LEFT));
		motors.put(MotorSide.FRONTRIGHT, new CANTalon(
				RobotMap.DRIVE_BASE_FRONT_RIGHT));
		motors.put(MotorSide.BACKLEFT, new CANTalon(
				RobotMap.DRIVE_BASE_BACK_LEFT));
		motors.put(MotorSide.BACKRIGHT, new CANTalon(
				RobotMap.DRIVE_BASE_BACK_RIGHT));

		// Initialize gyro
		BufferingSerialPort serialPort;
		try {
			serialPort = new BufferingSerialPort(57600);
			byte updateRateHz = 50;
			gyro = new IMUAdvanced(serialPort, updateRateHz);
		} catch (VisaException e) {
			e.printStackTrace();
		}
		
		// Configure PID
		pid = new PIDController(RobotMap.DRIVE_P, RobotMap.DRIVE_I,
				RobotMap.DRIVE_D, gyro, this);
		pid.setInputRange(-180.0, 180.0);
		pid.setOutputRange(-180.0, 180.0);
		pid.setContinuous(true);
		pid.setSetpoint(0.0);
		
		forward = 0.0;
		right = 0.0;
		clockwise = 0.0;
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
	
	public void setSpeed(double frontLeft, double frontRight, double backLeft, double backRight) {
		// Normalize to the max
		double max = Math.abs(frontLeft);
		if(Math.abs(frontRight)>max) max = Math.abs(frontRight);
		if(Math.abs(backLeft)>max) max = Math.abs(backLeft);
		if(Math.abs(backRight)>max) max = Math.abs(backRight);
		
		if(max>1.0){
			frontLeft /= max;
			frontRight /= max;
			backLeft /= max;
			backRight /= max;
		}
		
		setMotor(MotorSide.FRONTLEFT, frontLeft);
		setMotor(MotorSide.FRONTRIGHT, frontRight);
		setMotor(MotorSide.BACKLEFT, backLeft);
		setMotor(MotorSide.BACKRIGHT, backRight);
	}
	
	public void execute() {
		double frontLeft = forward + clockwise - right;
		double frontRight = forward - clockwise + right;
		double backLeft = forward + clockwise + right;
		double backRight = forward - clockwise - right;

		setSpeed(frontLeft, frontRight, backLeft, backRight);
	}

	@Override
	public double pidGet() {
		return gyro.getYaw();
	}

	@Override
	public void pidWrite(double output) {
		output /= 180.0;
		setClockwise(output);
	}
	
	public void setTargetAngle(double theta) {
		pid.setSetpoint(theta);
	}
	
	public double getTargetAngle() {
		return pid.getSetpoint();
	}
	
	public void setClockwise(double c) {
		clockwise = c;
	}
	
	public double getClockwise() {
		return clockwise;
	}
	
	public void setRight(double r) {
		right = r;
	}
	
	public void setForward(double f) {
		forward = f;
	}
	
	public double getYaw() {
		return gyro.getYaw();
	}
}
