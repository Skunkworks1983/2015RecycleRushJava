package org.usfirst.frc.team1983.robot.subsystems;

import org.usfirst.frc.team1983.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class StackPusher extends Subsystem {

	private Solenoid solenoid1, solenoid2;

	public StackPusher() {
		solenoid1 = new Solenoid(RobotMap.STACK_PUSHER_SOLENOID_1_PORT);
		solenoid2 = new Solenoid(RobotMap.STACK_PUSHER_SOLENOID_2_PORT);
	}

	public void setSolenoids(boolean isPush){
		solenoid1.set(isPush);
		solenoid2.set(isPush);
	}
	
	@Override
	protected void initDefaultCommand() {

	}

}
