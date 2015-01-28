package org.usfirst.frc.team1983.robot.commands;

import org.usfirst.frc.team1983.robot.Robot;
import org.usfirst.frc.team1983.robot.subsystems.DriveBase.MotorSide;

import edu.wpi.first.wpilibj.command.Command;

public class MecanumDrive extends Command {

	public MecanumDrive() {
	}

	@Override
	protected void initialize() {

	}

	@Override
	protected void execute() {
		double x = Robot.oi.getLeftJoystick().getX(), y = Robot.oi
				.getLeftJoystick().getY();
		double fieldAngle = Robot.gyro.getAngle() - Math.tan(y / x);
		double xhat = Math.cos(fieldAngle), yhat = Math.sin(fieldAngle);

		double k = 1;	//constant k for change in horizontal direction
		double LF, RF, LB, RB;
		LF = y - yhat;
		RF = y - yhat;
		LB = y - yhat;
		RB = y - yhat;

		if (x - xhat > 0) {
			LF -= (x - xhat) * k;
			RF -= (x - xhat) * k;
		} else {
			LB += (x - xhat) * k;	//the sign is switched here, still needs testing
			RB += (x - xhat) * k;
		}

		Robot.drivebase.setMotor(MotorSide.FRONTLEFT, LF);
		Robot.drivebase.setMotor(MotorSide.FRONTRIGHT, RF);
		Robot.drivebase.setMotor(MotorSide.BACKLEFT, LB);
		Robot.drivebase.setMotor(MotorSide.BACKRIGHT, RB);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {

	}

	@Override
	protected void interrupted() {

	}

}
