package org.usfirst.frc.team1983.robot.commands;

import org.usfirst.frc.team1983.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class PushStack extends Command {

	private boolean isPush;

	public PushStack(boolean isPush) {
		this.isPush = isPush;
	}

	@Override
	protected void initialize() {
		Robot.stackpusher.setSolenoids(isPush);
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
