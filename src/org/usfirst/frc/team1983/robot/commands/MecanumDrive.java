package org.usfirst.frc.team1983.robot.commands;

import org.usfirst.frc.team1983.robot.Robot;
import org.usfirst.frc.team1983.robot.RobotMap;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

public class MecanumDrive extends Command {

	public MecanumDrive() {

	}

	@Override
	protected void initialize() {
		Robot.drivebase.setSpeed(0, 0, 0, 0);
	}

	@Override
	protected void execute() {
		double forward;
		double right;
		double clockwise;

		// Get input
		forward = -Robot.oi.getLeftJoystick().getAxis(Joystick.AxisType.kY);
		right = Robot.oi.getLeftJoystick().getAxis(Joystick.AxisType.kX);
		clockwise = Robot.oi.getRightJoystick().getAxis(Joystick.AxisType.kZ);

		// Adjust for deadband
		if (Math.abs(forward) < RobotMap.OI_JOYSTICK_DRIVE_DEADBAND) {
			forward = 0;
		}
		if (Math.abs(right) < RobotMap.OI_JOYSTICK_DRIVE_DEADBAND) {
			right = 0;
		}
		if (Math.abs(clockwise) < RobotMap.OI_JOYSTICK_ROT_DEADBAND) {
			clockwise = 0;
		} else {
			double sign = clockwise > 0 ? 1.0 : -1.0;
			clockwise -= RobotMap.OI_JOYSTICK_ROT_DEADBAND * sign;
		}

		// Tweak control
		clockwise = Math.pow(clockwise, 3.0);
		clockwise *= RobotMap.DRIVE_JOYSTICK_DEGREES_PER_TICK;
		forward = Math.pow(forward, 3.0);
		right = Math.pow(right, 3.0);

		// Adjust rotation for PID input
		if (Robot.drivebase.getClockwise() < 0.9) {
			double targetAngle = Robot.drivebase.getTargetAngle() + clockwise;
			double sign = targetAngle > 180 ? 1.0 : -1.0;
			targetAngle += 180.0 * sign;
			targetAngle %= 360.0;
			targetAngle -= 180.0 * sign;
			Robot.drivebase.setTargetAngle(targetAngle);
		}

		// Field oriented corrections
		if (RobotMap.IS_FIELD_ORIENTED) {
			double theta = Robot.drivebase.getYaw();
			theta *= Math.PI / 180.0;
			double temp = forward * Math.cos(theta) + right * Math.sin(theta);
			right = -forward * Math.sin(theta) + right * Math.cos(theta);
			forward = temp;
		}

		// Slow forward to compensate
		forward *= RobotMap.DRIVE_ASPECT_RATIO;

		Robot.drivebase.setForward(-forward);
		Robot.drivebase.setRight(right);
		Robot.drivebase.execute();
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		Robot.drivebase.setSpeed(0.0, 0.0, 0.0, 0.0);
	}

	@Override
	protected void interrupted() {
		end();
	}

}
