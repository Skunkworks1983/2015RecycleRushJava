package org.usfirst.frc.team1983.robot.commands;

import org.usfirst.frc.team1983.robot.Robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;

/**
 * Open or close the claw
 */
public class ActuateCanStabilizer extends Command {
	private State state;
	private boolean usingTimeout;

	public enum State {
		open, close
	}

	public ActuateCanStabilizer(State state, float timeout) {
		requires(Robot.claw);
		setTimeout(timeout);
		this.state = state;
		usingTimeout = true;
	}

	public ActuateCanStabilizer(State state) {
		requires(Robot.claw);
		this.state = state;
		usingTimeout = false;
	}

	protected void initialize() {
		switch (state) {
		case open:
			Robot.claw.setActuated(DoubleSolenoid.Value.kReverse);
			break;
		case close:
			Robot.claw.setActuated(DoubleSolenoid.Value.kForward);
			break;
		}
	}

	protected void execute() {
	}

	protected boolean isFinished() {
		return !usingTimeout || isTimedOut();
	}

	protected void end() {
	}

	protected void interrupted() {
	}
}
