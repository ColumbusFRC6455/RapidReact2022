package frc.robot.subsystems;
//import java.time.YearMonth;

//import edu.wpi.first.wpi; - unfinished import ???
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;

 public class DriveSubsystem extends SubsystemBase{

     public DriveSubsystem(){
    
    }
  @Override
    public void periodic(){

    }
    public void arcadedrive(double y, double x){
        RobotContainer.Drive.arcadeDrive(x, -y);//changed to Drive and not m_Drive
    }
}
