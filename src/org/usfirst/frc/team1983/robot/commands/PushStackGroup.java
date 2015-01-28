package org.usfirst.frc.team1983.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class PushStackGroup extends CommandGroup {

	public PushStackGroup() {
		addSequential(new PushStack(true));
		addSequential(new Delay(1000));
		addSequential(new PushStack(false));
	}
}
