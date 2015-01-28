
package org.usfirst.frc.team1983.robot;

import org.usfirst.frc.team1983.robot.subsystems.CanGrabber;
import org.usfirst.frc.team1983.robot.subsystems.DriveBase;
import org.usfirst.frc.team1983.robot.subsystems.Elevator;
import org.usfirst.frc.team1983.robot.subsystems.StackPusher;
import org.usfirst.frc.team1983.robot.subsystems.ToteIntake;

import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	public static ToteIntake toteintake;
	public static DriveBase drivebase;
	public static OI oi;
	public static Gyro gyro;
	public static Elevator elevator;
	public static CanGrabber cangrabber;
	public static StackPusher stackpusher;
	
    Command autonomousCommand;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		oi = new OI();
		toteintake = new ToteIntake();
		gyro = new Gyro(RobotMap.GYRO_PORT);
		drivebase = new DriveBase();
		elevator = new Elevator();
		cangrabber = new CanGrabber();
		stackpusher = new StackPusher();
	}
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
        // schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
