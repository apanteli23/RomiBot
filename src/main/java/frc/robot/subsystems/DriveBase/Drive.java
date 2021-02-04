/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems.DriveBase;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;

/**
 * An example command that uses an example subsystem.
 */
public class Drive extends CommandBase {

  private final DriveSubsystem m_drive;
  private final DoubleSupplier m_rightSpeed, m_leftSpeed;
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public Drive(final DriveSubsystem drive, final DoubleSupplier rightSpeed, final DoubleSupplier leftSpeed) {
    
    m_drive = drive;
    m_rightSpeed = rightSpeed;
    m_leftSpeed = leftSpeed;

    addRequirements(drive);
  }


// Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_drive.driveRightMotor(m_rightSpeed.getAsDouble());
    m_drive.driveLeftMotor(m_leftSpeed.getAsDouble());
  }
}
