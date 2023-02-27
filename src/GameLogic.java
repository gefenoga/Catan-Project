import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.Stack;


public class GameLogic
{
    private static final int POINTS_TO_WIN = 10;
    public static Scanner reader = new Scanner(System.in);

    Player player1;
    Player player2;

    Board boardInst;


    GameLogic(Board board)
    {
        this.boardInst = board;

        playersInput();

        gameStart();

        int turn = 1;
        int counter = 0;
        while(counter++ < 5)
        {
            turn = manageTurns(turn);
            System.out.println("1: " + player1.Wheats + " " + player1.Ores+ " " + player1.Sheeps+ " " + player1.Woods+ " " + player1.Bricks);
            System.out.println("2: " + player2.Wheats + " " + player2.Ores+ " " + player2.Sheeps+ " " + player2.Woods+ " " + player2.Bricks);

        }
    }

    private void playersInput()
    {
        String name1;
        String name2;
        Color c1;
        Color c2;
        System.out.print("Enter Player 1's Name: ");
        name1 = reader.next();
        System.out.print("Enter Player 2's Name: ");
        name2 = reader.next();
        System.out.print("Enter Player 1's Color: ");
        try {
            Field field = Class.forName("java.awt.Color").getField(reader.next().toLowerCase());
            c1 = (Color)field.get(null);
        } catch (Exception e) {
            c1 = null; // Not defined
        }

        System.out.print("Enter Player 2's Color: ");
        try {
            Field field = Class.forName("java.awt.Color").getField(reader.next().toLowerCase());
            c2 = (Color)field.get(null);
        } catch (Exception e) {
            c2 = null; // Not defined
        }

        player1 = new Player(name1, c1);
        player2 = new Player(name2, c2);
    }

    private void gameStart()
    {
        switch (player1.colorIndex) {
            case 1 -> { // blue
                player1.AddResource("Brick");
                player1.AddResource("Sheep");
                player1.AddResource("Ore");
            } // yellow
            case 2, 3 -> { // red
                player1.AddResource("Wood");
                player1.AddResource("Sheep");
                player1.AddResource("Wheat");
            }
            case 4 -> { // white
                player1.AddResource("Wood");
                player1.AddResource("Sheep");
                player1.AddResource("Ore");
            }
            default -> {
            }
        }

        switch (player2.colorIndex) {
            case 1 -> { // blue
                player2.AddResource("Brick");
                player2.AddResource("Sheep");
                player2.AddResource("Ore");
            } // yellow
            case 2, 3 -> { // red
                player2.AddResource("Wood");
                player2.AddResource("Sheep");
                player2.AddResource("Wheat");
            }
            case 4 -> { // white
                player2.AddResource("Wood");
                player2.AddResource("Sheep");
                player2.AddResource("Ore");
            }
            default -> {
            }
        }
    }

    private int manageTurns(int turn)
    {
        int dice1 = (int)(Math.random() * (6) + 1);
        int dice2 = (int)(Math.random() * (6) + 1);
        System.out.println("Player" + turn + "'s turn. The numbers are:" + dice1 + ", " + dice2);
        int sum = dice1 + dice2;

        Stack<Hexagon> temp = new Stack<>();

        while (!boardInst.rands.isEmpty())
        {
            Hexagon help = boardInst.rands.peek();
            if (help.number == sum)
            {
                player1.AddResource(help.resource);
                player2.AddResource(help.resource);

            }
            temp.push(boardInst.rands.pop());
        }

        while (!temp.isEmpty())
        {
            boardInst.rands.push(temp.pop());
        }

        return 3 - turn;

    }

}
