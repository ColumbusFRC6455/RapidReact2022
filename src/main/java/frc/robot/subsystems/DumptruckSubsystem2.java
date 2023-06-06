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
public class DumptruckSubsystem2 extends SubsystemBase {
   //Creates a new ExampleSubsystem. 
 public DumptruckSubsystem2() {}

@Override
public void periodic() {
    // This method will be called once per scheduler run
}

boolean enabled = true;
public boolean Status(){
    return enabled;
}
public void On(){
    enabled = true;
    RobotContainer.Servo1.setAngle(0);
 }
public void Off(){
    //enabled = false;
    //RobotContainer.Servo1.setAngle(360);

 }
  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}