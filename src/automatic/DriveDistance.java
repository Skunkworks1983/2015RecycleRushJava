package automatic;

import org.usfirst.frc.team1983.robot.Robot;
import org.usfirst.frc.team1983.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon.ControlMode;
import edu.wpi.first.wpilibj.command.Command;

public class DriveDistance extends Command {

	private double target, oldAvg;
	private int count;
	private boolean stopped;
	public DriveDistance(double targetDistance){
		this.target = targetDistance * RobotMap.DRIVE_TICKS_PER_INCH;
	}
	
	@Override
	protected void initialize() {
		Robot.drivebase.setModeAll(ControlMode.Position);
		Robot.drivebase.setSetPointAll(target);
		count = 0;
	}

	@Override
	protected void execute() {
		if(Robot.drivebase.getAverageEncoderDistance() == oldAvg){
			count++;
		}
		oldAvg = Robot.drivebase.getAverageEncoderDistance();
	}

	@Override
	protected boolean isFinished() {
		return count < RobotMap.DRIVE_DISTANCE_COUNT_IS_STOPPPED;
	}

	@Override
	protected void end() {
		Robot.drivebase.setSetPointAll(0);
		Robot.drivebase.enablePIDALL(false);
	}

	@Override
	protected void interrupted() {
		end();
	}

}
