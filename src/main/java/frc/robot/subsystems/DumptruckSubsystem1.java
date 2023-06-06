/* */
 

package frc.robot.subsystems;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;


// public class DumptruckSubsystem {
  //   public static Servo(1)
// }
//@Override
//public void {

//}
//public class DumptruckSubsystem extends SubsystemBase {
    /** Creates a new ExampleSubsystem. */
   // public DumptruckSubsystem() {}
   // public static Servo dumpServo = new Servo(1);
   // @Override
  //  public void periodic() {
      // This method will be called once per scheduler run pog
      //public static Servo dumpServo = new Servo(1);

  //  }
  
  //  @Override
  //  public void simulationPeriodic() {
      // This method will be called once per scheduler run during simulation
  //  }
//anything from here to
 // }

// here is the second attempt
public class DumptruckSubsystem1 extends SubsystemBase {
   //Creates DumptruckSubsystem.
   public DumptruckSubsystem1() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
//the boolean starts as true, 
 boolean enabled = true;
public boolean Status(){
  return enabled;
}
//if public void on enabled is true and it sets the angle of the servo
public void On(){
  enabled = true;
  RobotContainer.Servo1.setAngle(360);
 }
public void Off(){
  //enabled = false;
  //RobotContainer.Servo1.setAngle(0);

 }
  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}