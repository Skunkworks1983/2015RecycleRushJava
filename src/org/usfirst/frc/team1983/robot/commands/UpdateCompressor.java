package org.usfirst.frc.team1983.robot.commands;

import org.usfirst.frc.team1983.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * It's like the lungs of the robot
 */
public class UpdateCompressor extends Command {
	private int ticksSinceUpdate;

    public UpdateCompressor() {
        requires(Robot.pneumatics);
    	ticksSinceUpdate = 0;
    }

    protected void initialize() {
    	ticksSinceUpdate = 0;
    }

    protected void execute() {
    	if (ticksSinceUpdate > 10) {
    		boolean state = Robot.pneumatics.isBelowPressure();
    		Robot.pneumatics.set(state);
    		ticksSinceUpdate = 0;
    	}
    	++ticksSinceUpdate;
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.pneumatics.set(false);
    }

    protected void interrupted() {
    	end();
    }
}
