/**
 * This is the grid class
 * @author Sofia  Medina
 * @version 1/14/2020
 */


import java.util.*;
public class Grid {
    String[][] grid;
   ArrayList <Integer> sqs;
    int[] sqX; int[] sqY;

    public Grid(ArrayList <Integer> sq) {
        sqs = sq;
        grid = new String[11][11];

        //rows & cols = line indexes
        int lineS = (grid.length - 2) / 3;
        int lineL = lineS * 2 + 1;

        //key squares (USING MATH) INDEXES
        sqX = new int[9];
        sqY = new int[9];

        for (int i = 0; i < 9; i++) { //coordinates for the squares: sqX contains all the x coordinates; sqY contains all the Y coordinates
            if (i + 1 == 1 || i + 1 == 4 || i + 1 == 7)
                sqY[i] = lineS / 2;
            else if (i + 1 == 2 || i + 1 == 5 || i + 1 == 8)
                sqY[i] = lineS / 2 + lineS + 1;
            else
                sqY[i] = ((lineS / 2) + lineS + 1) + lineS + 1;
        }

        for (int j = 0; j < 9; j++) {
            if (j + 1 == 1 || j + 1 == 2 || j + 1 == 3)
                sqX[j] = lineS / 2;
            else if (j + 1 == 4 || j + 1 == 5 || j + 1 == 6)
                sqX[j] = (lineS / 2) + lineS + 1;
            else
                sqX[j] = ((lineS / 2) + lineS + 1) + lineS + 1;
        }

        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (i == lineS || i == lineL)
                    grid[i][j] = " +";
                else if (j == lineS || j == lineL)
                    grid[i][j] = "    +";
                else
                    grid[i][j] = " ";
            }
        }
    }
    /**

     * This method attempts to play an X

     * @param sq This is the square that is going to be played


     * @return returns false if the box is already full

     */
    public boolean playX(int sq){
        if( grid[sqX[sq-1]][sqY[sq-1]].equals("O") ) {
            System.out.println("YOUUUUU CANT DO THAT");
            return false;
        }
        else {
            grid[sqX[sq - 1]][sqY[sq - 1]] = "X";
            return true;
        }
    }

    /**

     * This method attempts to play an Y (O)

     * @param sq This is the square that is going to be played


     * @return returns false if the box is already full

     */
    public boolean playY(int sq){
        if(grid[sqX[sq-1]][sqY[sq-1]].equals("X") ) {
            System.out.println("YOUUUUU CANT DO THAT");
            return false;
        }
        else{
        grid[sqX[sq-1]][sqY[sq-1]] = "O";
        return true;
        }
    }

    /**

     * This method prints the grid

     */
    public void print() {
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }
}