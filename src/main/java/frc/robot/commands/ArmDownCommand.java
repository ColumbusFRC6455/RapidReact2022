package frc.robot.commands;
import javax.print.attribute.standard.PrinterInfo;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.PrintCommand;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.RobotContainer;

public class ArmDownCommand extends CommandBase {
    private final ArmSubsystem m_Sys;
    double speed;
    //RobotContainer.ExtendingTalon.changeControlMode(ControlMode.Position)
    //RobotContainer.ExtendingTalon.setFeedbackDevice
    boolean enabled = false;
    public boolean Status(){
     return enabled;
  
    }

    //speed & position positive = up, vise versa
    public ArmDownCommand(ArmSubsystem m_system, double speed){
      //m_sys is the subsystem along with m_system, this speed is the equivalent of m_Sys
        m_Sys = m_system;
        this.speed = speed;
        addRequirements(m_Sys);
    }
    @Override
    public void initialize(){
    }
        @Override
        public void execute(){
          //setting the speed the entire time
          m_Sys.setSpeed(speed);
}

        @Override
        public void end(boolean interrupted){
          //shuts the commands off
          m_Sys.Off();
        }

        @Override 
        public boolean isFinished(){
          //once the m_Sys gets the limit switch it turns m_Sys off
          if (m_Sys.getLimitSwitch()){
            return true;
          }
          return false;
    }
}
