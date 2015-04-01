package autonomous;

import org.usfirst.frc.team1983.robot.commands.BurgleTheCan;
import org.usfirst.frc.team1983.robot.subsystems.CanBurglar.GrabState;

import automatic.TimedDrive;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class Autonomous extends CommandGroup {

	public Autonomous() {
		// If they create a new Autonomous, it will run this "default" command
		this.addSequential(getCenterCan());
	}

	static CommandGroup getCenterCan() {
		CommandGroup cmd = new CommandGroup("GetCenterCan");
		cmd.addParallel(new BurgleTheCan(GrabState.GRAB));
		cmd.addSequential(new TimedDrive(1.0, -.8));
		cmd.addSequential(new TimedDrive(1.5, .8));
		cmd.addSequential(new BurgleTheCan(GrabState.RETRACT));
		cmd.addSequential(new WaitCommand(420));
		return cmd;
	}
}
