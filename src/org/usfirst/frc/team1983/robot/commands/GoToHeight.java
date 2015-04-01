package org.usfirst.frc.team1983.robot.commands;

import org.usfirst.frc.team1983.robot.Robot;
import org.usfirst.frc.team1983.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class GoToHeight extends Command {

	private double setPoint;

	public GoToHeight(double setPoint) {
		this.setPoint = setPoint;
	}

	@Override
	protected void initialize() {
		Robot.elevator.setSetPoint(setPoint);
		Robot.elevator.getPID().enable();
	}

	@Override
	protected void execute() {
		if (Robot.elevator.getPID().isEnable()) {
			System.out.println("The PID is running...");
		} else {
			System.out.println("ERROR: THE PID IS NOT RUNNING");
		}
	}

	@Override
	protected boolean isFinished() {
		return Robot.elevator.getPID().getError() <= RobotMap.ELEVATOR_PID_TOLERANCE;
	}

	@Override
	protected void end() {
		Robot.elevator.getPID().disable();
	}

	@Override
	protected void interrupted() {
		Robot.elevator.getPID().disable();

	}

}
