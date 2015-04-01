package org.usfirst.frc.team1983.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
	
	public static final int TOTE_INTAKE_MOTOR_PORT = 0;
	public static final float TOTE_INTAKE_MOTOR_SPEED = 0.15f;
	public static final float TOTE_INTAKE_MOTOR_FULL = 0.15f;
	public static final int TOTE_INTAKE_SENSOR_PORT = 0;
	
	public static final int DRIVE_BASE_FRONT_LEFT = 0;
	public static final int DRIVE_BASE_FRONT_RIGHT = 1;
	public static final int DRIVE_BASE_BACK_LEFT = 2;
	public static final int DRIVE_BASE_BACK_RIGHT = 3;
	public static final double DRIVE_P = 3.0;
	public static final double DRIVE_I = 0.0;
	public static final double DRIVE_D = 5.0;
	public static final double DRIVE_JOYSTICK_DEGREES_PER_TICK = 8.0;
	public static final boolean IS_FIELD_ORIENTED = true;
	public static final double DRIVE_ASPECT_RATIO = 0.5;
	
	public static final int ELEVATOR_MOTOR_LEFT_PORT = 4;
	public static final int ELEVATOR_MOTOR_RIGHT_PORT = 5;
	public static final int ELEVATOR_ENCODER_PORT_A = 1;
	public static final int ELEVATOR_ENCODER_PORT_B = 1;
	
	public static final float ELEVATOR_PID_TERM_P = 0;
	public static final float ELEVATOR_PID_TERM_I = 0;
	public static final float ELEVATOR_PID_TERM_D = 0;
	public static final double ELEVATOR_PID_TOLERANCE = 0;
	
	public static final double TOTE_LIFTER_FLOOR_HEIGHT = 0;
	public static final double TOTE_LIFTER_CARRY_HEIGHT = 0;
	public static final double TOTE_LIFTER_FLOOR_LOAD_HEIGHT = 0;
	public static final double TOTE_LIFTER_LOAD_HEIGHT = 0;
	public static final int TOTE_LIFTER_MAG_SENSOR_PORT = 0;

	public static final double CAN_LIFTER_UP_POSITION = 0;
	public static final double CAN_LIFTER_DOWN_POSITION = 0;
	
	public static final int CAN_LIFTER_LEFT_PORT = 6;
	public static final int CAN_LIFTER_RIGHT_PORT = 7;
	
	public static final float CAN_GRABBER_PID_TERM_P = 0;
	public static final float CAN_GRABBER_PID_TERM_I = 0;
	public static final float CAN_GRABBER_PID_TERM_D = 0;
	
	public static final int CAN_GRABBER_ANALOG_INPUT_PORT = 0;
	
	public static final int CAN_INTAKE_LEFT_PORT = 11;
	public static final int CAN_INTAKE_RIGHT_PORT = 4;
	
	public static final int WRIST_PORT_LEFT = 1;
	public static final int WRIST_PORT_RIGHT = 6;
	
	public static final int CLAW_LOCK_LEFT_PORT = 2;
	public static final int CLAW_LOCK_RIGHT_PORT = 5;
	
	public static final int CAN_BURGLAR_PORT_A = 7;
	public static final int CAN_BURGLAR_PORT_B = 0;
	
	public static final int COMPRESSOR_PRESSURE_SENSOR_PORT = 0;
	public static final int COMPRESSOR_RELAY_PORT = 0;
	
	public static final double OI_JOYSTICK_DRIVE_DEADBAND = 0.05;
	public static final double OI_JOYSTICK_ROT_DEADBAND = 0.15;
	public static final double TOTE_LIFTER_TICKS_PER_INCH = 64;
}
