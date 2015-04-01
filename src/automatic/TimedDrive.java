package automatic;

import org.usfirst.frc.team1983.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class TimedDrive extends Command {
	private double time, speed;

	public TimedDrive(double d, double e) {
		requires(Robot.drivebase);
		setTimeout(d);
		this.time = d;
		this.speed = e;
	}

	@Override
	protected void initialize() {
		Robot.drivebase.setSpeed(speed, speed, speed, speed);
	}

	@Override
	protected void execute() {
	}

	@Override
	protected boolean isFinished() {
		return isTimedOut();
	}

	@Override
	protected void end() {
	}

	@Override
	protected void interrupted() {
	}

}
