import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener
{
    MyButton playButton;
    MyButton exitButton;
    JLabel titleLabel;
    JLabel background;
    Drawing boardDraw;
    MyFrame()
    {
        ImageIcon title = new ImageIcon("C:\\Users\\gefen\\IdeaProjects\\Catan1.0\\Images\\CatanLogo.png");
        ImageIcon back = new ImageIcon("C:\\Users\\gefen\\IdeaProjects\\Catan1.0\\Images\\CatanBack.png");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //setExtendedState(JFrame.MAXIMIZED_BOTH);

        titleLabel = new JLabel();
        titleLabel.setIcon(title);
        titleLabel.setBounds(500, 50, title.getIconWidth(), title.getIconHeight());
        titleLabel.setVisible(true);


        background = new JLabel();
        background.setIcon(back);
        background.setBounds(0, 0, back.getIconWidth(), back.getIconHeight());
        background.setVisible(true);
        playButton = new MyButton(650, 400, "Play the game!", 100);
        playButton.addActionListener(this);
        exitButton = new MyButton(650, 600, "Exit", 100);
        exitButton.addActionListener(this);

        boardDraw = new Drawing();


        boardDraw.setVisible(false);
        boardDraw.setBounds(80, 170, 1500, 800);
        //bLabel.add(boardDraw);

        boardDraw.setVisible(false);


        setSize(back.getIconWidth(), back.getIconHeight());
        setResizable(false);
        setUndecorated(true);
        setLayout(null);


        add(boardDraw);
        add(playButton);
        add(exitButton);
        add(titleLabel);
        add(background);

        validate();
        //pack();
        setVisible(true);
        //setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == playButton)
        {
            boardDraw.setVisible(true);
            playButton.setEnabled(false);
            exitButton.setEnabled(false);
        }

        if(e.getSource() == exitButton)
        {
            dispose();
        }
    }
}
