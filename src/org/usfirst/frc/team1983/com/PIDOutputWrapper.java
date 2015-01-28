package org.usfirst.frc.team1983.com;

import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.Talon;

public class PIDOutputWrapper implements PIDOutput {
	Talon Motor1, Motor2;

	public PIDOutputWrapper(Talon Motor1, Talon Motor2) {
		this.Motor1 = Motor1;
		this.Motor2 = Motor2;
	}

	@Override
	public void pidWrite(double output) {
		Motor1.set(output);
		Motor2.set(output);		//possibly needs to be swapped direction
	}

}
