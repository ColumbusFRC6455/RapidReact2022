package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.PivotArm1Subsystem;
import frc.robot.RobotContainer;

public class PivotArm1Command extends CommandBase{
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    private final PivotArm1Subsystem o_Sys;
    private boolean enabled = false;

    public PivotArm1Command(PivotArm1Subsystem o_system){
        o_Sys = o_system;
        addRequirements(o_Sys);
    }
    @Override 
    public void initialize(){}
    
    @Override
    public void execute(){
    double speed = RobotContainer.Joy2.getRawAxis(1); //for forward backward speed
    if (speed > 0.5){
    speed = 0.5;} 
    else{
        if (speed < -0.5){//forward backwards axis
            speed = -0.5;
            }
        }
    }
    
    
    @Override
    public void end(boolean interrupted){
    
    }
    
    @Override
    public boolean isFinished() {
        return false;
    }
    }