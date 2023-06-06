package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveSubsystem;

public class DriveMain extends CommandBase {
    private final DriveSubsystem m_Drive;
    
    public DriveMain(DriveSubsystem Subsystem) {
        m_Drive = Subsystem;
        addRequirements(m_Drive);
    }
@Override 
public void initialize(){}

@Override
public void execute(){
double speed = RobotContainer.Joy1.getRawAxis(1); //for forward backward speed
if (speed > 0.80){
speed = 0.80;} 
else{
    if (speed < -0.80){//forward backwards axis
        speed = -0.80;
    }
}
/*m_Drive.arcadedrive(speed, RobotContainer.Joy1.getRawAxis(0));
if (speed > 0.25){
    speed = 0.25;} 
    else{
        if (speed < -0.25){ //turning speed?
            speed = -0.25;
        }
    }*/
}

@Override
public void end(boolean interrupted){

}

@Override
public boolean isFinished() {
    return false;
}
}


