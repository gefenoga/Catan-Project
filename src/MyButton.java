import javax.swing.*;
import java.awt.*;

public class MyButton extends JButton
{
    MyButton(int x, int y, String text, int ratio)
    {
        setBounds(x, y, (int)(2.5 * ratio), ratio);
        setText(text);
        setFocusable(false);
        setBackground(Color.lightGray);
        setForeground(Color.red.darker());
        setFont(new Font("Roman", Font.ITALIC, 25));
        setBorder(BorderFactory.createEtchedBorder());
    }

}
