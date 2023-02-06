import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class main {
    public static void main(String[] args)  {

        int [] []val = { {7,1,6,8,4,5,3,9,2},
                {9,5,8,3,7,2,4,6,1},
                {4,3,2,1,6,9,5,7,8},
                {8,2,7,4,9,3,1,5,6},
                {5,4,9,6,2,1,7,8,3},
                {1,6,3,7,5,8,9,2,4},
                {6,8,5,9,1,4,2,3,7},
                {2,7,1,5,3,6,8,4,9},
                {3,9,4,2,8,7,6,1,5}
        };
        int [] [] shwn = {  {0,1,1,0,1,0,1,0,1},
                {0,0,1,0,1,0,0,0,0},
                {0,1,0,1,0,1,1,0,0},
                {1,0,1,0,0,1,0,1,1},
                {1,0,0,1,0,0,1,1,0},
                {1,0,1,1,1,0,0,0,1},
                {0,1,0,0,1,1,0,1,0},
                {0,0,1,1,1,1,0,1,0},
                {1,1,0,0,0,0,1,0,1}
        };

        System.out.println("hi");
        //GRAPHICS
        JFrame GUI = new JFrame();
        GUI.setTitle("Sudoku");
        GUI.setSize(700,700);
        GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container pane = GUI.getContentPane();

        Sudoku s = new Sudoku(val, shwn);
        try {
            Interfaz interfaz = new Interfaz(s);
            pane.add(interfaz);
        }
        catch(IOException e){
            e.printStackTrace();
        }




        GUI.setVisible(true);






    }
}
