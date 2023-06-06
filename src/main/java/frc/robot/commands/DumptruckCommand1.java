package frc.robot.commands;

import frc.robot.subsystems.DumptruckSubsystem1;
import edu.wpi.first.wpilibj2.command.CommandBase;

/* An example command that uses an example subsystem. */
public class DumptruckCommand1 extends CommandBase {
  //@SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
private final DumptruckSubsystem1 m_Sys;
private boolean enabled = true;
  /*
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  // saying that dumptruckSubsystem 1 is subsystem, its the variable
  public DumptruckCommand1(DumptruckSubsystem1 subsystem) {
    //saying that m_Sys is also subsystem
    m_Sys = subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_Sys);
  }

  // Called when the command is initially scheduled.
  @Override
  //if enabled is true, turn m_Sys(DumptruckSubsystem) on, if false turn m_Sys off
  public void initialize() {
    if (enabled) {
      enabled = true;
      m_Sys.On();
    }else {
      enabled = false;
      m_Sys.Off();
}

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
} 