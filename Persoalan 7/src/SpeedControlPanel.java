// ******************************************************************
// SpeedControlPanel.java
//
// The panel for the bouncing ball. Similar to
// ReboundPanel.java in Listing 8.16 in the text, except a circle
// rather than a happy face is rebounding off the edges of the
// window.
// ******************************************************************
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class SpeedControlPanel extends JPanel
{
    private final int WIDTH = 600;
    private final int HEIGHT = 400;
    private final int BALL_SIZE = 50;
    private Circle bouncingBall; // the object that moves
    private Timer timer;
    private int moveX, moveY; // increment to move each time
    private  JSlider sJSlider;
    private JPanel sJPanel;

    // ---------------------------------------------
    // Sets up the panel, including the timer
    // for the animation
    // ---------------------------------------------
    public SpeedControlPanel ()
    {
        timer = new Timer(30, new ReboundListener());

        // Instantiate sJSlider to be a JSlider that is horizontal
        // with values ranging from 0 to 200, initially set to 30.
        sJSlider = new JSlider(JSlider.HORIZONTAL, 0, 200, 300);

        // Set the major tick spacing to 40 and the minor tick spacing to 10.
        SlideListener sListener = new SlideListener();
        sJSlider.setMajorTickSpacing(40);
        sJSlider.setMinorTickSpacing(10);

        //Set paint ticks and paint labels to true and the X alignment to left.
        sJSlider.setPaintTicks(true);
        sJSlider.setPaintLabels(true);
        sJSlider.setAlignmentX(Component.LEFT_ALIGNMENT);

        // Add the change listener to the JSlider object.
        sJSlider.addChangeListener(sListener);

        // Create a label ("Timer Delay") for the slider and align it to the left
        JLabel sJLabel = new JLabel("Timer Delay");
        sJLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        // Create a JPanel object and add the label and slider to it
        // then add  panel to the SOUTH of the main panel
        sJPanel = new JPanel();
        sJPanel.add(sJLabel);
        sJPanel.add(sJSlider);
        this.add(sJPanel, "SOUTH");
        this.setLayout (new BorderLayout());
        bouncingBall = new Circle(BALL_SIZE);
        moveX = moveY = 5;
        // Set up a slider object here
        setPreferredSize (new Dimension (WIDTH, HEIGHT));
        setBackground(Color.black);
        timer.start();
    }
    // --------------------
    // Draw the ball
    // --------------------
    public void paintComponent (Graphics page)
    {
        super.paintComponent (page);
        bouncingBall.draw(page);
    }
    // ***************************************************
    // An action listener for the timer
    // ***************************************************
    public class ReboundListener implements ActionListener
    {
        // ----------------------------------------------------
        // actionPerformed is called by the timer -- it updates
        // the position of the bouncing ball
        // ----------------------------------------------------
        public void actionPerformed(ActionEvent action)
        {
            int slidePanelHt = sJPanel.getSize().height;
            bouncingBall.move(moveX, moveY);

            // change direction if ball hits a side
            int x = bouncingBall.getX();
            int y = bouncingBall.getY();
            if (x < 0 || x >= WIDTH - BALL_SIZE)
                moveX = moveX * -1;
            if (y <= 0 || y >= HEIGHT - slidePanelHt - BALL_SIZE)
                moveY = moveY * -1;
            repaint();
        }
    }
    // *****************************************************
    // A change listener for the slider.
    // *****************************************************
    private class SlideListener implements ChangeListener
    {
        // -------------------------------------------------
        // Called when the state of the slider has changed;
        // resets the delay on the timer.
        // -------------------------------------------------
        
        // Determine the value of timer delay
        // with the method setDelay (int delay) in the Timer class.
        public void stateChanged (ChangeEvent event)
        {
            timer.setDelay(sJSlider.getValue());
        }
    }
}