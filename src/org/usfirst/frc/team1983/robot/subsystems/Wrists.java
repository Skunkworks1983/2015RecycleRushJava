package org.usfirst.frc.team1983.robot.subsystems;

import org.usfirst.frc.team1983.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * The wrists are a pair of pneumatics on the end of the greater subsystem which
 * acquires cans.
 */
public class Wrists extends Subsystem {
	private DoubleSolenoid wrists;
	
	public Wrists() {
		wrists = new DoubleSolenoid(RobotMap.WRIST_PORT_LEFT, RobotMap.WRIST_PORT_RIGHT);
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
	
	public void setWrist(DoubleSolenoid.Value value) {
		wrists.set(value);
	}
	
	public void toggle() {
		if(wrists.get()==DoubleSolenoid.Value.kForward){
			setWrist(DoubleSolenoid.Value.kReverse);
		} else {
			setWrist(DoubleSolenoid.Value.kForward);
		}
	}
}
