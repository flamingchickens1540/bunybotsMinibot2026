package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import java.util.function.DoubleSupplier;

public class DriveBandGwiask extends SubsystemBase {
    private final TalonSRX fr = new TalonSRX(2);
    private final TalonSRX fl = new TalonSRX(1);


    public DriveBandGwiask() {
        fr.configFactoryDefault();
        fl.configFactoryDefault();

    }

    public Command driveGwiask(
            DoubleSupplier getLeftY, DoubleSupplier getRightX){

        return Commands.run(() -> {
           double forward = getLeftY.getAsDouble();
           double turn = -getRightX.getAsDouble();
           double leftPercentOutput = -forward;
           double rightPercentOutput = forward;



            fr.set(TalonSRXControlMode.PercentOutput, rightPercentOutput - turn);
            fl.set(TalonSRXControlMode.PercentOutput, leftPercentOutput - turn);
        }, this);
    }
}