package org.usfirst.frc.team1983.robot.commands;

import org.usfirst.frc.team1983.robot.Robot;
import org.usfirst.frc.team1983.robot.subsystems.CanBurglar.GrabState;

import edu.wpi.first.wpilibj.command.Command;

public class BurgleTheCan extends Command {
	private GrabState state;

	public BurgleTheCan(GrabState state) {
		requires(Robot.canBurglar);
		this.state = state;
	}

	@Override
	protected void initialize() {
		Robot.canBurglar.set(state);
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
	}

	@Override
	protected void interrupted() {
	}

}
