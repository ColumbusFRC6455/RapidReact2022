// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class ArmUpCommand extends CommandBase {
  private final ArmSubsystem m_ArmSubsystem;
  private final double maxExtension = 16037.0;
  double startHeight;

  public ArmUpCommand(ArmSubsystem p_ArmSubsystem) {
    m_ArmSubsystem = p_ArmSubsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_ArmSubsystem);
  }


  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
      //just in case encoder is not at 0
    startHeight = m_ArmSubsystem.position();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
      m_ArmSubsystem.setSpeed(.75);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
      m_ArmSubsystem.Off();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    // if(startHeight + maxExtension >= m_ArmSubsystem.position())
    // {
    //     return true;
    // }
    return false;
  }
}
