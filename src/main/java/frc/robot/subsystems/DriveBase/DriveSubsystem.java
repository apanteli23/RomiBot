/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems.DriveBase;


import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;


public class DriveSubsystem extends SubsystemBase {
  /**
   * Creates a new ExampleSubsystem.
   */
    private final Spark m_leftMotor = new Spark(DriveConstants.left_Drive);
    private final Spark m_rightMotor = new Spark(DriveConstants.right_Drive);

    private final Encoder m_leftEncoder = new Encoder(DriveConstants.left_EncoderA, DriveConstants.left_EncoderB);
    private final Encoder m_rightEncoder = new Encoder(DriveConstants.right_EncoderA, DriveConstants.right_EncoderB);


  public DriveSubsystem() {
    // Sets inches as unit for encoder distance
    m_leftEncoder.setDistancePerPulse((Math.PI * DriveConstants.kWheelDiameterInch) / DriveConstants.kCountsPerRevolution);
    m_rightEncoder.setDistancePerPulse((Math.PI * DriveConstants.kWheelDiameterInch) / DriveConstants.kCountsPerRevolution);
    resetEncoders();
  }
  
  
  public void driveRightMotor(Double speed) {
    m_rightMotor.set(speed);
  }

  public void driveLeftMotor (Double speed){
    m_leftMotor.set(speed);
  }

  public void resetEncoders() {
    m_leftEncoder.reset();
    m_rightEncoder.reset();
  }

  public int getLeftEncoderCount() {
    return m_leftEncoder.get();
  }

  public int getRightEncoderCount() {
    return m_rightEncoder.get();
  }

  public double getLeftDistanceInch() {
    return m_leftEncoder.getDistance();
  }

  public double getRightDistanceInch() {
    return m_rightEncoder.getDistance();
  }

  public double getAverageDistanceInch() {
    return (getLeftDistanceInch() + getRightDistanceInch()) / 2.0;
  }
}
