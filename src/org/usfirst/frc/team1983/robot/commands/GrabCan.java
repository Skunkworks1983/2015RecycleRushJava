package org.usfirst.frc.team1983.robot.commands;

import org.usfirst.frc.team1983.robot.Robot;
import org.usfirst.frc.team1983.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class GrabCan extends Command {

	@Override
	protected void initialize() {
		Robot.cangrabber.().set(
				RobotMap.CAN_GRABBER_MEC_MOTOR_SPEED);
	}

	@Override
	protected void execute() {

	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		Robot.cangrabber.getRightMecMotor().set(0);
	}

	@Override
	protected void interrupted() {
		Robot.cangrabber.getRightMecMotor().set(0);
	}

}
