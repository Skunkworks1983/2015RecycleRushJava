package org.usfirst.frc.team1983.robot.commands;

import org.usfirst.frc.team1983.robot.Robot;
import org.usfirst.frc.team1983.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
/*
 * Equivalent to c++ version
 */
public class LiftToHeight extends Command {
	private double setPoint;

	public LiftToHeight(double setPoint) {
		requires(Robot.toteLifter);
		this.setPoint = setPoint;
	}

	@Override
	protected void initialize() {
		if (setPoint > Robot.toteLifter.getEncoder().pidGet()
				&& Robot.toteLifter.getMagSensorInput()
				&& setPoint != RobotMap.TOTE_LIFTER_CARRY_HEIGHT) {
			setPoint = Robot.toteLifter.getEncoder().pidGet();
		}
		Robot.toteLifter.setSetPoint(setPoint);
		Robot.toteLifter.getPID().enable();
	}

	@Override
	protected void execute() {
	}

	@Override
	protected boolean isFinished() {
		return setPoint > RobotMap.TOTE_LIFTER_CARRY_HEIGHT
				&& Robot.toteLifter.getMagSensorInput();
	}

	@Override
	protected void end() {
		Robot.toteLifter.setSetPoint(Robot.toteLifter.getEncoder().pidGet()
				+ (RobotMap.TOTE_LIFTER_TICKS_PER_INCH * .25));
	}

	@Override
	protected void interrupted() {
	}

}
