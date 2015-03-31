package org.usfirst.frc.team1983.robot.subsystems;

import org.usfirst.frc.team1983.robot.RobotMap;
import org.usfirst.frc.team1983.robot.commands.UpdateCompressor;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Pneumatics extends Subsystem {
    private DigitalInput pressureSwitch;
    private Compressor relay;
	
	public Pneumatics() {
		pressureSwitch = new DigitalInput(RobotMap.COMPRESSOR_PRESSURE_SENSOR_PORT);
		relay = new Compressor(RobotMap.COMPRESSOR_RELAY_PORT);
	}

    public void initDefaultCommand() {
    	setDefaultCommand(new UpdateCompressor());
    }
    
    public void set(boolean state) {
    	if(state){
    		relay.start();
    	} else {
    		relay.stop();
    	}
    }
    
    public boolean isCompressorOn() {
    	return relay.enabled();
    }
    
    public boolean isBelowPressure() {
    	return !relay.getPressureSwitchValue();
    }
}

