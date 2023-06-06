package frc.robot.commands;

import frc.robot.subsystems.DumptruckSubsystem2;
import edu.wpi.first.wpilibj2.command.CommandBase;

/* An example command that uses an example subsystem. */
public class DumptruckCommand2 extends CommandBase {
  //@SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
private final DumptruckSubsystem2 m_Sys;
private boolean enabled = true;
  /*
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public DumptruckCommand2(DumptruckSubsystem2 subsystem) {
    m_Sys = subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_Sys);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    if (enabled) {
        enabled = true;
        m_Sys.On();
    } else {
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

