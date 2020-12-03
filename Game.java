/**
 *
 * @author jmbartlett
 */

import java.util.Scanner;

public class Game {
    
    private Scanner sc = new Scanner(System.in);
    private int height, width, row, col;
    public Grid grid; 
    public Grid dGrid;
            
    public void start()
    {
        System.out.print("Enter the height of the grid: ");
        height = sc.nextInt();
        
        System.out.print("Enter the width of the grid: ");
        width = sc.nextInt();
        
        grid = new Grid (height, width);
        grid.randomFillGrid();
        grid.displayGrid();
        gameLoop();        
    }
    
    public void gameLoop()
    {
        boolean playing = true;
        
        while(playing == true) 
        {
            System.out.println("Pick a spot to check for a mine.");
            System.out.println("First enter the row number then the "
                    + "column number:");
            row = sc.nextInt() - 1;
            col = sc.nextInt() - 1;
            checkLocation(row, col);
            
            if (checkLocation(row, col) == false)
            {
                if(win() == false)
                {
                    grid.displayGrid();
                    checkLocation(row, col);
                }
                else
                {
                    grid.displayGrid();
                    System.out.println("You Win!");
                    playing = false;
                }
            }
            else 
            {
                System.out.println("GameOver!");
                grid.displayGridData();
                playing = false;  
            }
        }
    }
    
    public int numberOfMines(int row, int col)
    {
        int mines = 0;
        
        for (int r = row - 1; r <= row + 1; r++) 
        {
            for (int c = col - 1; c <= col + 1; c++)
            {
                if (r >= 0 && r < height && c >= 0 && c < width)
                {
                    if (grid.grid[r][c] == "*")
                    {
                        mines = mines + 1;
                    }
                }
            }
        }
        
        return mines;
    }    
    
    public boolean checkLocation(int row, int col)
    {        
        if (grid.grid[row][col] == "*")
        {
            
            return true;
        } 
        else 
        {      
            clearBlanks(row, col);
            return false;
        }             
    }
  
    public void clearBlanks(int row, int col)
    {             
        int mines = numberOfMines(row, col);
        if (mines > 0) 
        {
            grid.dGrid[row][col] = Integer.toString(mines);
        } 
        else 
        {
            for (int r = row - 1; r <= row + 1; r++) 
            {
                for (int c = col - 1; c <= col + 1; c++)
                {
                    if (r >= 0 && r < height && c >= 0 && c < width)
                    {
                        
                        if (grid.dGrid[r][c] == "*")
                        {
                            grid.dGrid[r][c] = " ";
                            clearBlanks(r, c);
                        }
                    }
                }
            }
        }
    }

    public boolean win()
    {
        int count = 0;
        
        for (int r = 0; r < height; r++)
        {
            for (int c = 0; c < width; c++)
            {
                if (grid.dGrid[r][c] == "*")
                {
                    count++;
                }
            }
        }
        if (count == 10)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
}
