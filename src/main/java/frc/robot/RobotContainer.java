// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.PS4Controller.Button;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.ExtendingArm2Subsystem;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX; 
import com.ctre.phoenix.motorcontrol.ControlMode;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
//5 is the extending arm, 6 is the left pivot arm, 7 is the right arm
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);
  //drive Victors
public static WPI_VictorSPX Victor1 = new WPI_VictorSPX(1);
public static WPI_VictorSPX Victor2 = new WPI_VictorSPX(2);
public static WPI_VictorSPX Victor3 = new WPI_VictorSPX(3);
public static WPI_VictorSPX Victor4 = new WPI_VictorSPX(4);
//end driving motors
//servo for the dumptruck
public static Servo Servo1 = new Servo(2);
//motor controllers, make the robot move it move it
public static MotorControllerGroup RightOne = new MotorControllerGroup (Victor1, Victor2);
public static MotorControllerGroup LeftOne = new MotorControllerGroup (Victor3, Victor4);
//Extending arm talon
// public static WPI_TalonSRX ExtendingTalon = new WPI_TalonSRX(5);
//Pivot arm talons
public static WPI_TalonSRX PivotTalon1 = new WPI_TalonSRX(6);
public static WPI_TalonSRX PivotTalon2 = new WPI_TalonSRX(7);

//public static MotorControllerGroup PivotMotors = new MotorControllerGroup(PivotTalon1, PivotTalon2);
//control the things that move it move it
public static final DifferentialDrive Drive = new DifferentialDrive(LeftOne, RightOne);//took out m_Drive and made it just Drive, servos
//public static final DifferentialDrive P_Drive = new DifferentialDrive(PivotTalon1, PivotTalon2);//this won't work
//public static final DifferentialDrive T_Drive = new DifferentialDrive(PivotMotors, ExtendingTalon);
//joysticks, joy 1 for driving, joy 2 for buttons
public static Joystick Joy1 = new Joystick(1);
public static Joystick Joy2 = new Joystick(0);
public static XboxController Xbox1 = new XboxController(2);
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  //Buttons for dumptruck because servo is smelly
  //Switched all these buttons to joystick 1 for demo
  public static JoystickButton dumptruckButton1 = new JoystickButton(Joy1, 12);
  public static JoystickButton dumptruckButton2 = new JoystickButton(Joy1, 11);
  public static JoystickButton downButton =  new JoystickButton(Joy1, 7);
  public static JoystickButton upButton = new JoystickButton(Joy1, 8);
  /*public static JoystickButton extendArmButton = new JoystickButton(Joy2, 5);*/
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
