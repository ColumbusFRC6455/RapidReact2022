//down extending arm
package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.TalonSRXFeedbackDevice;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj.DigitalInput;
import frc.robot.Constants;

public class ArmSubsystem extends SubsystemBase {
    final TalonSRX extendingTalon2;
    final int maxExtention = 15000;
    final int minExtention = 0;

    public ArmSubsystem(){
        extendingTalon2 = new TalonSRX(5);
        extendingTalon2.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);

    }
    private DigitalInput
        m_limitSwitch = new DigitalInput(Constants.LIMIT_SWITCH);
    
    
 @Override
 public void periodic(){
    // if(extendingTalon2.getSelectedSensorPosition() >= maxExtention)
    // {
    //     Off();
    // }
  //  double percent = RobotContainer.Joy2.getRawButton(5);
  //  RobotContainer.PivotTalon1.set(ControlMode.PercentOutput, stick);  
}

public double position()
{
    return extendingTalon2.getSelectedSensorPosition() ;
}
public void setSpeed(double speed){
    extendingTalon2.set(ControlMode.PercentOutput, speed);
}

// public void down(){
//     extendingTalon2.set(ControlMode.PercentOutput, 0.75);
// }

public void Off(){
    extendingTalon2.set(ControlMode.PercentOutput, 0);

}
public Boolean getLimitSwitch(){
    return
    m_limitSwitch.get();
}
public double getMaxExtension(){
    return maxExtention;
}

public double getMinExtension(){
    return minExtention;
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
