package org.usfirst.frc.team1983.robot.commands;

import org.usfirst.frc.team1983.robot.Robot;
import org.usfirst.frc.team1983.robot.RobotMap;
import org.usfirst.frc.team1983.robot.subsystems.ToteIntake;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class RunIntake extends Command {

	private ToteIntake intake = Robot.toteintake;
	private static final long msWait = 500;
	private double waitStartTime = 0;
	private boolean toteWasThereFlag = false;

	/*
	 * Intended to be run at all time
	 * TODO: need to add it so that manual override is possible
	 */
	public RunIntake() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.toteintake);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if (intake.getSensorValue()) {
			intake.setMotor(RobotMap.TOTE_INTAKE_MOTOR_SPEED);
			toteWasThereFlag = true;
		} else {
			if(toteWasThereFlag){
				toteWasThereFlag = false;
				waitStartTime = Timer.getFPGATimestamp();
			}
			if (waitStartTime + msWait > Timer.getFPGATimestamp()) {
				intake.setMotor(0);
			}
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		intake.setMotor(0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		intake.setMotor(0);
	}

}
