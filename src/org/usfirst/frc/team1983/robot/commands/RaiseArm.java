package org.usfirst.frc.team1983.robot.commands;

import org.usfirst.frc.team1983.robot.Robot;
import org.usfirst.frc.team1983.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class RaiseArm extends Command {
	ArmPosition pos;

	public enum ArmPosition {
		UP, DOWN
	}

	public RaiseArm(ArmPosition pos) {
		requires(Robot.armLifter);
		this.pos = pos;
	}

	@Override
	protected void initialize() {
		Robot.armLifter.getPID().setSetpoint(
				pos == ArmPosition.DOWN ? RobotMap.CAN_LIFTER_DOWN_POSITION
						: RobotMap.CAN_LIFTER_UP_POSITION);
		Robot.armLifter.getPID().enable();
	}

	@Override
	protected void execute() {

	}

	@Override
	protected boolean isFinished() {
		return true;
	}

	@Override
	protected void end() {
	}

	@Override
	protected void interrupted() {
	}

}
