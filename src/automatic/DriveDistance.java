package automatic;

import org.usfirst.frc.team1983.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveDistance extends Command {

	private double target;
	public DriveDistance(double targetDistance){
		this.target = targetDistance;
	}
	
	@Override
	protected void initialize() {

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
