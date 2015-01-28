package org.usfirst.frc.team1983.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class Delay extends Command {

	private double endTime, delayMS;
	
	public Delay(double delayMS){
		this.delayMS = delayMS;
	}
	
	@Override
	protected void initialize() {
		endTime = Timer.getFPGATimestamp() + delayMS;
	}

	@Override
	protected void execute() {
	}

	@Override
	protected boolean isFinished() {
		return Timer.getFPGATimestamp() >= endTime;
	}

	@Override
	protected void end() {
	}

	@Override
	protected void interrupted() {
	}

}
