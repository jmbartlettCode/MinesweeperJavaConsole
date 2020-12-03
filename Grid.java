/**
 *
 * @author jmbartlett
 */

import java.util.Random;

public class Grid {
    
    String[][] grid;
    String[][] dGrid;
    int height, width;

    public Grid(int height, int width)
    {
        grid = new String [height][width];
        dGrid = new String [height][width];
        this.height = height;    
        this.width = width;
        
        for (int r = 0; r < height; r++)
        {
            for (int c = 0; c < width; c++)            
                dGrid [r][c] = "*";
        }
        for (int r = 0; r < height; r++)
        {
            for (int c = 0; c < width; c++)
                grid [r][c] = " ";
        }
    }
    
    public void randomFillGrid()
    {
        int mines = 10;
        int placed = 0;
        
        Random random = new Random();
        
        while (placed < mines)
        {
            int x = random.nextInt(height);
            int y = random.nextInt(width);
            //String z = Integer.toString(x);
            if (grid[x][y]!= "*") 
            {
                grid[x][y] = "*";
                placed++;
            }            
        }    
    }
    
    public void displayGrid()
    {
        System.out.println("There are a total of 10 mines in the mine field.");
        System.out.print("  ");
        for (int c = 0; c < width; c++)
        {
            System.out.print(((c + 1)) + " ");
        }
        
        System.out.println();
        
        for (int r = 0; r < height; r++)
        {
            System.out.print(r + 1);
            System.out.print(" ");
            
            for (int c = 0; c < width; c++ )
            {
                System.out.print(dGrid [r][c] + " ");
            }   
            System.out.println();
        }        
    }
    
    public void displayGridData()
    {
        System.out.println("There are a total of 10 mines in the mine field.");
        System.out.print("  ");
        
        for (int c = 0; c < width; c++)
        {
            System.out.print(((c + 1)) + " ");
        }
        System.out.println();
        
        for (int r = 0; r < height; r++)
        {
            System.out.print(r + 1);
            System.out.print(" ");
            for (int c = 0; c < width; c++)
            {
                
                if (grid[r][c] == " " && dGrid[r][c] == "*")
                {
                    dGrid[r][c] = ".";
                }
                System.out.print(dGrid [r][c] + " ");
            }
            System.out.println();
        }
    }    
}
