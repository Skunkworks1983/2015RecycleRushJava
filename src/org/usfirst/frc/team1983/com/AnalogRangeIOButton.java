package org.usfirst.frc.team1983.com;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick;

public class AnalogRangeIOButton {
	private int port;
	private Joystick.AxisType axis;
	private double lowThreshold;
	private double highThreshold;
	
	public AnalogRangeIOButton(int joystickPort,
		Joystick.AxisType axis, double lowThreshold, double highThreshold) {
		this.port = joystickPort;
		this.axis = axis;
		this.lowThreshold = lowThreshold;
		this.highThreshold = highThreshold;
	}
	
	public boolean get() {
		double volts = DriverStation.getInstance().getStickAxis(port, axis.value);
		return volts >= lowThreshold && volts <= highThreshold;
	}
}
