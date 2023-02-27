import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageConsumer;
import java.io.File;

public class Drawing extends JPanel
{
    Board board;
    GameLogic gameDisplay;


    public Drawing()
    {
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();

        setPreferredSize(new Dimension((int)size.getWidth(), (int)size.getHeight()));

        board = new Board(70);
        gameDisplay = new GameLogic(board);

    }


    @Override

    public void paintComponent(Graphics g)
    {
        super.paintComponents(g);

        board.drawBoard(g);

        int p1X = 1200;
        int p2X = 120;
        int pY = 50;
        g.setColor(gameDisplay.player1.color);
        g.setFont(new Font("Roman", Font.BOLD, 50));
        g.drawString(gameDisplay.player1.name, p1X, pY);

        g.setColor(gameDisplay.player2.color);
        g.drawString(gameDisplay.player2.name, p2X, pY);

        gameDisplay.player1.displayResources(g, p1X, pY);
        gameDisplay.player2.displayResources(g, p2X, pY);


        //repaint();

    }


}
