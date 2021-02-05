package frc.robot.control;

import edu.wpi.first.wpilibj2.command.button.Button;

/**
 * A {@link Button} that gets its state from an {@link XboxController}.
 */
public class XboxControllerButton extends Button
{

    private final XboxController m_joystick;
    private final int m_buttonNumber;

    /**
     * Create a joystick button for triggering commands.
     *
     * @param joystick The XboxController object that has that button
     * @param kb   The button number (see {@link Button})
     */
    public XboxControllerButton(XboxController joystick, frc.robot.control.XboxController.Button kb)
    {
        m_joystick = joystick;
        m_buttonNumber = kb.value;
    }



	/**
     * Gets the value of the joystick button.
     *
     * @return The value of the joystick button
     */
    public boolean get()
    {
        return m_joystick.getRawButton(m_buttonNumber);
    }
}