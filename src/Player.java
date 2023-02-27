import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Player
{
    protected int Ores;
    protected int Woods;
    protected int Wheats;
    protected int Bricks;
    protected int Sheeps;
    String name;
    Color color;
    int colorIndex;

    private BufferedImage wheatImg;
    private BufferedImage oreImg;
    private BufferedImage brickImg;
    private BufferedImage sheepImg;
    private BufferedImage woodImg;

    int victoryPoints;
    boolean hasWon;

    Player(String name, Color color)
    {
        this.name = name;
        this.color = color;
        if (color == Color.blue) colorIndex = 1;
        if (color == Color.yellow) colorIndex = 2;
        if (color == Color.red) colorIndex = 3;
        if (color == Color.white) colorIndex = 4;
        this.victoryPoints = 0;
        this.hasWon = false;
        this.Ores = 0;
        this.Sheeps = 0;
        this.Bricks = 0;
        this.Woods = 0;
        this.Wheats = 0;

        try
        {
            woodImg = ImageIO.read((new File("C:\\Users\\gefen\\IdeaProjects\\Catan1.0\\Images\\woodCard.png")));
            brickImg = ImageIO.read((new File("C:\\Users\\gefen\\IdeaProjects\\Catan1.0\\Images\\brickCard.png")));
            oreImg = ImageIO.read((new File("C:\\Users\\gefen\\IdeaProjects\\Catan1.0\\Images\\oreCard.png")));
            wheatImg = ImageIO.read((new File("C:\\Users\\gefen\\IdeaProjects\\Catan1.0\\Images\\wheatCard.png")));
            sheepImg = ImageIO.read((new File("C:\\Users\\gefen\\IdeaProjects\\Catan1.0\\Images\\sheepCard.png")));
        }
        catch (Exception e)
        {
            //e.printStackTrace();
            System.out.println("u suck1");
        }
    }

    public void AddResource(String newR)
    {
        switch (newR) {
            case "Brick"  -> Bricks++;
            case "Wood" -> Woods++;
            case "Ore" -> Ores++;
            case "Sheep" -> Sheeps++;
            case "Wheat" -> Wheats++;
            default -> {
            }
        }
    }

    public void RemResource(String toRem)
    {
        switch (toRem) {
            case "Brick" -> Bricks--;
            case "Wood" -> Woods--;
            case "Ore" -> Ores--;
            case "Sheep" -> Sheeps--;
            case "Wheat" -> Wheats--;
            default -> {
            }
        }
    }

    public void displayResources(Graphics g, int x, int y)
    {
        float scale = 0.11f;
        int i;
        Point pos = new Point(x, y);

        for(i = 0; i < Woods; i++)
        {
            g.drawImage(woodImg.getScaledInstance((int)(scale * woodImg.getWidth()), (int)(scale * woodImg.getHeight()), Image.SCALE_DEFAULT), pos.x - 80, pos.y + 50, null);
            pos.x += (int)(scale * woodImg.getWidth()) + 10;
        }
        pos.x = x;
        if (Woods > 0)
            pos.y = pos.y + (int)(scale * woodImg.getHeight()) + 15;

        for(i = 0; i < Sheeps; i++)
        {
            g.drawImage(sheepImg.getScaledInstance((int)(scale * sheepImg.getWidth()), (int)(scale * sheepImg.getHeight()), Image.SCALE_DEFAULT), pos.x - 80, pos.y + 50, null);
            pos.x += (int)(scale * sheepImg.getWidth()) + 10;
        }

        pos.x = x;
        if (Sheeps > 0)
            pos.y = pos.y + (int)(scale * sheepImg.getHeight()) + 15;

        for(i = 0; i < Ores; i++)
        {
            g.drawImage(oreImg.getScaledInstance((int)(scale * oreImg.getWidth()), (int)(scale * oreImg.getHeight()), Image.SCALE_DEFAULT), pos.x - 80, pos.y + 50, null);
            pos.x += (int)(scale * oreImg.getWidth()) + 10;
        }

        pos.x = x;
        if (Ores > 0)
            pos.y = pos.y + (int)(scale * oreImg.getHeight()) + 15;

        for(i = 0; i < Wheats; i++)
        {
            g.drawImage(wheatImg.getScaledInstance((int)(scale * wheatImg.getWidth()), (int)(scale * wheatImg.getHeight()), Image.SCALE_DEFAULT), pos.x - 80, pos.y + 50, null);
            pos.x += (int)(scale * wheatImg.getWidth()) + 10;
        }

        pos.x = x;
        if (Wheats > 0)
            pos.y = pos.y + (int)(scale * wheatImg.getHeight()) + 15;


        for(i = 0; i < Bricks; i++)
        {
            g.drawImage(brickImg.getScaledInstance((int)(scale * brickImg.getWidth()), (int)(scale * brickImg.getHeight()), Image.SCALE_DEFAULT), pos.x - 80, pos.y + 50, null);
            pos.x += (int)(scale * brickImg.getWidth()) + 10;
        }

    }


}

