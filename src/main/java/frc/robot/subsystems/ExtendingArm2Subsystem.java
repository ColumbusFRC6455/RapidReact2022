//up extending arm
package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.TalonSRXFeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;

public class ExtendingArm2Subsystem extends SubsystemBase {
    final TalonSRX extendingTalon;

    public ExtendingArm2Subsystem(){
        extendingTalon = new TalonSRX(5);
    }

 @Override
 public void periodic(){
  //  double percent = RobotContainer.Joy2.getRawButton(5);
  //  RobotContainer.PivotTalon1.set(ControlMode.PercentOutput, stick);  
 }
  boolean enabled = false;
  public boolean Status(){
   return enabled;
}

public void On(){
    enabled = true;
    extendingTalon.set(ControlMode.PercentOutput, -0.75);
    extendingTalon.getSelectedSensorPosition(10);
}

public void Off(){
    enabled = false;
    extendingTalon.set(ControlMode.PercentOutput, 0);
    extendingTalon.getSelectedSensorPosition(0);
}
/* public void ExtendTalon(double degree){
     enabled = true;
     RobotContainer.ExtendingTalon.set(ControlMode.Position, degree);
 }
 public void deExtendTalon(double degree2){
     enabled = false;
     RobotContainer.ExtendingTalon.set(ControlMode.Position, degree2);
 }*/
 //public void drive(double left, double right){
   //  RobotContainer.T_Drive.tankDrive(left, right); //may have an issue with left and right
 
 @Override
 public void simulationPeriodic(){}
 }

