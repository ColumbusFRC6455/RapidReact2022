// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.commands.ArmDownCommand;
import frc.robot.commands.ArmUpCommand;
import frc.robot.commands.DriveMain;
import frc.robot.commands.DumptruckCommand1;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.DumptruckSubsystem1;
import edu.wpi.first.wpilibj.Servo;
import frc.robot.subsystems.DumptruckSubsystem2;
import frc.robot.subsystems.ExtendingArm2Subsystem;
import frc.robot.subsystems.PivotArm1Subsystem;
import frc.robot.commands.DumptruckCommand2;
import frc.robot.commands.PivotArm1Command;

import javax.net.ssl.ExtendedSSLSession;
import javax.print.attribute.standard.PrinterInfo;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import frc.robot.RobotContainer;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.Joystick;
/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private Command m_autonomousCommand;

  private RobotContainer m_robotContainer;
  private double startTime;
  TalonSRX extendingTalon2;
  private final ArmSubsystem m_extendingArmSubsystem = new ArmSubsystem();
  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    // Instantiate our RobotContainer.  This will perform all our button bindings, and put our
    // autonomous chooser on the dashboard.
    m_robotContainer = new RobotContainer();
    extendingTalon2 = new TalonSRX(5);
    extendingTalon2.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);
    
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
    // commands, running already-scheduled commands, removing finished or interrupted commands,
    // and running subsystem periodic() methods.  This must be called from the robot's periodic
    // block in order for anything in the Command-based framework to work.
    CommandScheduler.getInstance().run();
  }

  /** This function is called once each time the robot enters Disabled mode. */
  @Override
  public void disabledInit() {}

 
  @Override
  public void disabledPeriodic() {}

  /** This autonomous runs the autonomous command selected by your {@link RobotContainer} class. */
  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
    startTime = Timer.getFPGATimestamp();
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {
    double time = Timer.getFPGATimestamp();
    if(time-startTime < 2.5){
 RobotContainer.Victor1.set(0.4);
 RobotContainer.Victor2.set(0.4);
 RobotContainer.Victor3.set(-0.4);
 RobotContainer.Victor4.set(-0.4);
    }else{
      RobotContainer.Victor1.set(0);
 RobotContainer.Victor2.set(0);
 RobotContainer.Victor3.set(0);
 RobotContainer.Victor4.set(0);
    }
  
}
  
  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  //when the buttons for dumptruck are held, it executes dumptruck command 1/2 and dumptruck subsystem 1/2. See dumptruck subsystem/command 1 for more info
    RobotContainer.dumptruckButton1.whenHeld(new DumptruckCommand1(new DumptruckSubsystem1())); 
    RobotContainer.dumptruckButton2.whenHeld(new DumptruckCommand2(new DumptruckSubsystem2()));
    //extending arm button, does the same thing as the dumptruck buttons, but with talons
    
    //RobotContainer.extendArmButton.whenHeld(new ExtendingArmCommand(new ExtendingArmSubsystem()));
    new DriveMain(new DriveSubsystem()).schedule(); // added this line should make drive work
    new PivotArm1Command(new PivotArm1Subsystem()).schedule();
    //RobotContainer.downButton.whenHeld(new downArmCommand(new 
    RobotContainer.upButton.whenHeld(new ArmUpCommand(m_extendingArmSubsystem)); //go up+
    RobotContainer.downButton.whenHeld(new ArmDownCommand(m_extendingArmSubsystem, -.75)); //go down
  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
   // System.out.println(-extendingTalon2.getSelectedSensorPosition());
   // double stick = RobotContainer.Joy2.getRawAxis(0);
    //RobotContainer.PivotTalon1.set(ControlMode.PercentOutput, stick); MOVED THESE 2 LINES TO SUBSYSTEM
  }
 // new DriveMain(new DriveSubsystem()); <-- doesnt work
  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}
}
