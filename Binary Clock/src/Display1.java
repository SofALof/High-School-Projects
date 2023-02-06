import java.awt.*;
import javax.swing.*;
import java.util.*;

public class Display1 extends JPanel{

    int h, m, s;
    int [] hrs, min, sec;
    GregorianCalendar cal;

    int layout = 0;
    int counter = 0;

    public Display1(Color c){
        setBackground(c);
    }                                                                            //=timeInterval
    private double [] moveItMoveIt(int middleX, int middleY, int r, int nPoints, int switcheroo) { //circle orbit x,y coordinates method

        double [] xy = new double[2]; //first x, second y

        double midPX = middleX;
        double midPY = middleY;

        double radius = r;

        double numOfPoints = 2*Math.PI/nPoints;

        double radian = numOfPoints*switcheroo;

        xy[0] = middleX + radius*Math.cos(radian);
        xy[1] = middleY + radius*Math.sin(radian);

        return xy;
    }
    public void paint(Graphics g){
        super.paintComponent(g);
        cal = new GregorianCalendar(); //updates the Cal
        h = cal.get(Calendar.HOUR_OF_DAY);
        m = cal.get(Calendar.MINUTE);
        s = cal.get(Calendar.SECOND);
        Maths M = new Maths(h,m,s);
        hrs = M.binaryH();
        min = M.binaryM();
        sec = M.binaryS();



        int x = getWidth(); //helpful nums for layouts
        int y = getHeight();
        counter++;

        if(layout ==0){ //TITLE PG
            setBackground(Color.black);
            g.setColor(Color.white);
            g.drawString("binary clock",x/2-39,y/2);

            if(counter % 200 == 0) {
                counter = 1;
                layout = 1;
            }
        }
        else if(layout ==3) { //analog
            // gonna be done in a square (ie a smaller chunk of the screen)
            // -- so that circle can fit ez
            g.setColor(Color.white);
            g.drawString("Sofia Medina   " + h + ":" + m + ":" + s, x - 150, 10);
            //Here are the coordinates for the square
            int xZ = x/3; //zeroEquiv
            int xW = 2*xZ;//widthEquiv

    //CONCENTRIC CIRCLES
            int dInc = xZ/18; //d for diameter inc for increment
            int middle = xZ+xZ/2; //equal to the middle of the part of the screen being used

            g.setColor(Color.white);
            for(int i = 1; i < 20; i++)
                        //middle - radiusCircle, midY - radiusCircle, diam, diam
                g.drawOval(middle - (dInc*i)/2 , y/2 - (dInc*i)/2,dInc*i,dInc*i);

            //COLORED CIRCLES
            g.setColor(Color.green);
            g.drawOval(middle - (dInc*19)/2 , y/2 - (dInc*19)/2,dInc*19,dInc*19); //outer circle
            g.setColor(Color.blue);
            g.drawOval(middle - (dInc*13)/2 , y/2 - (dInc*13)/2,dInc*13,dInc*13);  //MIDDLE CIRCLE
            g.setColor(Color.RED);
            g.drawOval(middle - (dInc*7)/2 , y/2 - (dInc*7)/2,dInc*7,dInc*7);  //INNER CIRCLE

    //Moving circles
            g.setColor(Color.pink);
           // int [] xy = moveItMoveIt(middle,y/2,dInc*5,60,100);


        }
        else if(layout ==2){ //DIGITAL

            setBackground(Color.black);
            g.setColor(Color.white);
            String time = "";

            for(int val: hrs)
                time+=""+val;
            time+=":";
            for(int val: min)
                time+=""+val;
            time+=":";
            for(int val: sec)
                time+=""+val;

            g.drawString(time,x/2-80,y/2);
            g.drawString("Sofia Medina   " + h + ":" + m + ":" + s, x - 150, 10);
            if(counter % 200 ==0){
                counter = 1;
                layout = 1;
            }
        }

        else if(layout ==1) { //WITH CUBE THINGS
            if(counter % 200==0) {
                counter = 0;
                layout = 2;
            }

            int incr = y / 3 - 10; //helpful nums for layout(1)
            int increment = x / 7;

//LABELS - layout(1)
            g.setColor(Color.white);
            //powers of two
            g.drawString("2^5", x - 6 * increment, y-10);
            g.drawString("2^4", x - 5 * increment, y-10);
            g.drawString("2^3", x - 4 * increment, y-10);
            g.drawString("2^2", x - 3 * increment, y-10);
            g.drawString("2^1", x - 2 * increment, y-10);
            g.drawString("2^0", x - 1 * increment, y-10);

            //min/hrs/secs
            g.drawString("Hrs", 10, y - 3 * incr + 20);
            g.drawString("Min", 10, y - 2 * incr + 20);
            g.drawString("Sec", 10, y - 1 * incr + 20);
            //my name+real time
            g.drawString("Sofia Medina   " + h + ":" + m + ":" + s, x - 150, 10);


//BLOCKS - layout(1)
            g.setColor(Color.green);
            //HOURS//
            for (int i = 0; i < hrs.length; i++) {
                if (hrs[i] == 1)
                    g.fillRect(x - (i + 1) * increment + 10, y - 3 * incr + 20, 10, 10);
            }


            //MIN//
            for (int i = 0; i < min.length; i++) {
                if (min[i] == 1)
                    g.fillRect(x - (i + 1) * increment + 10, y - 2 * incr + 20, 10, 10);
            }

            //SEC//
            for (int i = 0; i < sec.length; i++) {
                if (sec[i] == 1)
                    g.fillRect(x - (i + 1) * increment + 10, y - 1 * incr + 20, 10, 10);
            }
        }

            try {
                Thread.sleep(17);


            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            repaint();

    }

}