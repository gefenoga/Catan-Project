import java.awt.*;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Stack;

public class Board
{

    int prop;

    public Stack<Hexagon> rands;

    public Dictionary<String, Color> colMatch;

    public Board(int prop)
    {
        this.prop = prop;
        rands = new Stack<>();
    }

    public void  drawBoard(Graphics g)
    {

        Dictionary<Integer, Integer> counters = new Hashtable<>();

        counters.put(1, 4); // sheep
        counters.put(2, 4); // trees
        counters.put(3, 3); // rocks
        counters.put(4, 3); // clay
        counters.put(5, 4); // wheat
        counters.put(6, 1); // dessert

        int x = 525;
        int y = 250;


        colMatch = new Hashtable<>();
        colMatch.put("Sheeps", Color.green.brighter().brighter());
        colMatch.put("Trees", Color.green.darker().darker());
        colMatch.put("Rocks", Color.gray);
        colMatch.put("Ores", Color.red.darker());
        colMatch.put("Wheats", Color.yellow.darker());
        colMatch.put("Dessert", Color.orange.brighter());

        int i;
        for (i = 0;  i < 3; i++)
        {
            if     (counters.get(1) == 0 &&
                    counters.get(2) == 0 &&
                    counters.get(3) == 0 &&
                    counters.get(4) == 0 &&
                    counters.get(5) == 0 &&
                    counters.get(6) == 0)
            {
                break;
            }

            int feedback = helper(g, i, counters, colMatch, x, y);
            if (feedback == 1) x += 2 * prop;
            else i--;
        }

        x = x - 7 * prop;
        y += (int) (1.5 * prop);
        for (i = 0;  i < 4; i++ )
        {
            if     (counters.get(1) == 0 &&
                    counters.get(2) == 0 &&
                    counters.get(3) == 0 &&
                    counters.get(4) == 0 &&
                    counters.get(5) == 0 &&
                    counters.get(6) == 0)
            {
                break;
            }

            int feedback = helper(g, i, counters, colMatch, x, y);
            if (feedback == 1) x += 2 * prop;
            else i--;
        }

        x = x - 9 * prop;
        y += (int) (1.5 * prop);

        for (i = 0;  i < 5; i++ )
        {
            if     (counters.get(1) == 0 &&
                    counters.get(2) == 0 &&
                    counters.get(3) == 0 &&
                    counters.get(4) == 0 &&
                    counters.get(5) == 0 &&
                    counters.get(6) == 0)
            {
                break;
            }
            int feedback = helper(g, i, counters, colMatch, x, y);

            if (feedback == 1) x += 2 * prop;
            else i--;
        }




        x = x - 9 * prop;
        y += (int) (1.5 * prop);

        for (i = 0;  i < 4; i++ )
        {
            if     (counters.get(1) == 0 &&
                    counters.get(2) == 0 &&
                    counters.get(3) == 0 &&
                    counters.get(4) == 0 &&
                    counters.get(5) == 0 &&
                    counters.get(6) == 0)
            {
                break;
            }

            int feedback = helper(g, i, counters, colMatch, x, y);
            if (feedback == 1) x += 2 * prop;
            else i--;
        }

        x = x - 7 * prop;
        y += (int) (1.5 * prop);

        for (i = 0;  i < 3; i++ )
        {
            if     (counters.get(1) == 0 &&
                    counters.get(2) == 0 &&
                    counters.get(3) == 0 &&
                    counters.get(4) == 0 &&
                    counters.get(5) == 0 &&
                    counters.get(6) == 0)
            {
                break;
            }

            int feedback = helper(g, i, counters, colMatch, x, y);
            if (feedback == 1) x += 2 * prop;
            else i--;
        }


    }

    private int helper(Graphics g, int i, Dictionary<Integer, Integer> counters, Dictionary<String, Color> colMatch, int x, int y)
    {
        int option;
        option = (int)(Math.random() * (6) + 1);

        if (counters.get(option) == 0) return -1;

        String chosenRes = "";
        switch (option)
        {
            case 1 -> chosenRes = "Sheeps";
            case 2 -> chosenRes = "Trees";
            case 3 -> chosenRes = "Rocks";
            case 4 -> chosenRes = "Ores";
            case 5 -> chosenRes = "Wheats";
            case 6 -> chosenRes = "Dessert";
        }

        Color ColorTemp = colMatch.get(chosenRes);

        Hexagon temp = new Hexagon(x, y, prop, ColorTemp, chosenRes);
        int rand = (int)(Math.random() * 11 + 2);

        if (rand != 7)
            temp.paint(g, rand);
        else
        {
            rand = (int)(Math.random() * 11 + 2);
            temp.paint(g, rand);

        }
        rands.push(temp);

        int num = counters.get(option) - 1;
        counters.remove(option);
        counters.put(option, num);
        return 1;
    }



}



