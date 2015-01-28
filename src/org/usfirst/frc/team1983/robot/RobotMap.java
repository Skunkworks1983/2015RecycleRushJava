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
	public static final float TOTE_INTAKE_MOTOR_SPEED = 0.75f;
	public static final int TOTE_INTAKE_SENSOR_PORT = 0;
	
	public static final int DRIVE_BASE_FRONT_LEFT = 0;
	public static final int DRIVE_BASE_FRONT_RIGHT = 1;
	public static final int DRIVE_BASE_BACK_LEFT = 2;
	public static final int DRIVE_BASE_BACK_RIGHT = 3;
	public static final int GYRO_PORT = 0;
	
	public static final int ELEVATOR_MOTOR_LEFT_PORT = 4;
	public static final int ELEVATOR_MOTOR_RIGHT_PORT = 5;
	public static final int ELEVATOR_ENCODER_PORT_1 = 1;
	public static final int ELEVATOR_ENCODER_PORT_2 = 2;
	
	public static final float ELEVATOR_PID_TERM_P = 0;
	public static final float ELEVATOR_PID_TERM_I = 0;
	public static final float ELEVATOR_PID_TERM_D = 0;
	public static final double ELEVATOR_PID_TOLERANCE = 0;
	
	public static final int CAN_GRABBER_MOTOR_LEFT_PORT = 6;
	public static final int CAN_GRABBER_MOTOR_RIGHT_PORT = 7;
	public static final float CAN_GRABBER_PID_TERM_P = 0;
	public static final float CAN_GRABBER_PID_TERM_I = 0;
	public static final float CAN_GRABBER_PID_TERM_D = 0;
	public static final int CAN_GRABBER_ANALOG_INPUT_PORT = 0;
	public static final double CAN_GRABBER_GROUND_POINT = 0;
	public static final double CAN_GRABBER_UP_POINT = 10;
	public static final double CAN_GRABBER_PID_TOLERANCE = 3.1415926535;
	public static final int CAN_GRABBER_MEC_LEFT_MOTOR_PORT = 7;
	public static final int CAN_GRABBER_MEC_RIGHT_MOTOR_PORT = 7;
	public static final double CAN_GRABBER_MEC_MOTOR_SPEED = 1;
	
	public static final int STACK_PUSHER_SOLENOID_1_PORT = 0;
	public static final int STACK_PUSHER_SOLENOID_2_PORT = 1;
	
}
