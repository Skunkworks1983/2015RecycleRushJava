package org.usfirst.frc.team1983.robot.commands;

import org.usfirst.frc.team1983.robot.Robot;
import org.usfirst.frc.team1983.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class RaiseArm extends Command {
	ArmPosition pos;

	public enum ArmPosition {
		RAISE, LOWER
	}

	public RaiseArm(ArmPosition pos) {
		this.pos = pos;
	}

	@Override
	protected void initialize() {
		Robot.cangrabber.getPID().setSetpoint(
				pos == ArmPosition.LOWER ? RobotMap.CAN_GRABBER_GROUND_POINT
						: RobotMap.CAN_GRABBER_UP_POINT);
		Robot.cangrabber.getPID().enable();
	}

	@Override
	protected void execute() {

	}

	@Override
	protected boolean isFinished() {
		return Robot.cangrabber.getPID().getError() < RobotMap.CAN_GRABBER_PID_TOLERANCE;
	}

	@Override
	protected void end() {
		Robot.cangrabber.getPID().disable();
	}

	@Override
	protected void interrupted() {
		Robot.cangrabber.getPID().disable();
	}

}
