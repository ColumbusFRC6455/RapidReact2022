package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.math.Num;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;
import com.ctre.phoenix.motorcontrol.TalonSRXFeedbackDevice;

public class PivotArm1Subsystem extends SubsystemBase {
    public PivotArm1Subsystem(){}

    @Override
    public void periodic() {
      // This method will be called once per scheduler run
      //RobotContainer.PivotTalon2.follow(RobotContainer.PivotTalon1); //This made them not completely work together
     // RobotContainer.PivotTalon2.set(ControlMode.Follower, RobotContainer.PivotTalon1.getDeviceID());
      double stick = RobotContainer.Joy2.getRawAxis(1);
      RobotContainer.PivotTalon1.set(ControlMode.PercentOutput, stick);
      RobotContainer.PivotTalon2.setInverted(true);
      RobotContainer.PivotTalon2.set(ControlMode.Follower, RobotContainer.PivotTalon1.getDeviceID());
     // RobotContainer.PivotTalon1.setNeutralMode(NeutralMode.Brake);
      //RobotContainer.PivotTalon2.set(ControlMode.PercentOutput, stick);
    }
    

    @Override
    public void simulationPeriodic() {
      // This method will be called once per scheduler run during simulation
    }
    //public void arcadedrive(double x, double y){
      //  RobotContainer.P_Drive.arcadeDrive(y, x);//This won't work...differentenial drive not updated enough
   // }
  }

