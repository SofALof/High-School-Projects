import javax.swing.*;
import java.awt.*;
public class main{

    public static void main(String [] args) {

        //GRAPHICS CRAP
        JFrame GUI = new JFrame();
        GUI.setTitle("Binary Clock");
        GUI.setSize(700,300);
        GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container pane = GUI.getContentPane();
        Display1 dis1 = new Display1(Color.black);

        pane.add(dis1);

        GUI.setVisible(true);

        Maths m = new Maths(24,24,24);

        int [] h = m.binaryH();
        for(int val: h)
            System.out.print(val);

    }
}