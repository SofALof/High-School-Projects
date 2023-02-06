//**********************I have a couple of images --if its giving you an error it is probably due to different pathnames

import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.temporal.ChronoField;
import java.util.*;
public class Interfaz extends JPanel implements  KeyListener, MouseListener  {

    private Sudoku s;
    private int increment;
    private int border;
    private int [] highlighted;
    private boolean check;
    private int buttonSizeX; private int buttonSizeY; //size of squares
    private int buttonRowX;   private int buttonRowY; //size of squares
    private int sizeEasterEgg; //for easter egg
    private static long startTime;
    private int screen;
    private boolean start;
    private boolean isSolved;
    private static String finalTime;

    private static ArrayList <String> aboutMe; //I added a hidden aboutMe page. If you click on my name in the second (sudoku) screen it will show up
    private static String aboutMe1;            // (or if you rapidly double click my name on the first (loading) screen.
    private static String aboutMe2;
    private static String aboutMe3;
    private static String aboutMe4;
    private static String aboutMe5;
    private static String aboutMe6;
    private static String aboutMe7;
    private static String aboutMe8;
    private static String aboutMe9;
    private static String aboutMe10;
    private static String aboutMe11;
    private static String aboutMe12;

    public Interfaz (Sudoku sudoku) throws IOException {
        s = sudoku;

        highlighted = new int [2]; //for highlighted/selected square
        highlighted[0] = -1; highlighted[1]=-1;

        check = false; //for check button
        screen = 0; //start/sudoku/win
        start = false; //for the timer
        isSolved = false; //self-explanatory

        //"fun" mouse/key listener setup
        addKeyListener(this);
        addMouseListener(this);
       setFocusable(true);
       requestFocusInWindow();


        aboutMe1 = "Born in New York, New York on October 31 2003,";
        aboutMe2 =  "Sofia Medina is a self proclaimed \"ObNoxiOus";
       aboutMe3 = "ComPuTEr SCiENcETiST.\" Some examples of her \"art\"";
       aboutMe4 = "include asking for help on projects with variables";
       aboutMe5 = "that are just different letters of the alphabet";
       aboutMe6 = "because variables are merely \"arbitray\" and" ;
       aboutMe7 = "their names hold no real value. She would also";
       aboutMe8 = "like to add that features like this HiDdEn EAsTer";
       aboutMe9 = "eGg are prime examples of obnoxious coding. It ";
       aboutMe10 = "would be remise to not tell you that all this was";
       aboutMe11 = "done with 12 different \"aboutMe(N) StringVaribles ";
       aboutMe12 = " -- which have now been added to an ArrayList :)";


       aboutMe = new ArrayList<String>();
       aboutMe.add(aboutMe1); aboutMe.add(aboutMe2); aboutMe.add(aboutMe3); aboutMe.add(aboutMe4); aboutMe.add(aboutMe5); aboutMe.add(aboutMe6);
       aboutMe.add(aboutMe7); aboutMe.add(aboutMe8); aboutMe.add(aboutMe9); aboutMe.add(aboutMe10); aboutMe.add(aboutMe11);aboutMe.add(aboutMe12);



    }

    public void paint(Graphics g){
        super.paintComponent(g);


        //Numbers for Formatting
        int x = getWidth();
        int y = getHeight();
        increment = (x-(x/3))/9;
        border =(x - increment*9)/2;
        setBackground(Color.white);
        int sizeLettersBold = increment-increment/(border);
        int sizeLettersPlain = increment-increment/border;
        int sizeLettersButton = increment -2*increment/4;
        int sizeLettersBanner = increment - increment/border;
        sizeEasterEgg = increment/4;
        long currentTime = System.nanoTime();

        //Start screen
        if(screen == 0){
            g.setFont(new Font("default", Font.ROMAN_BASELINE, sizeLettersBanner));
            g.drawString("SUDOKU", x/2-sizeLettersBanner*2,y/2);

            //my name
            g.setFont(new Font("EasterEgg", Font.ITALIC, sizeEasterEgg));
            g.drawString("SMedina", x-sizeEasterEgg*6, border/4);
        }

        //win screen
        else if(screen == 2){
            g.setFont(new Font("default", Font.ROMAN_BASELINE, sizeLettersBanner));
            g.drawString("SUDOKU SOLVED", x/2-sizeLettersBanner*4,y/2);
            g.setFont(new Font("default", Font.ROMAN_BASELINE, sizeLettersButton));
            g.drawString(finalTime, x/2-sizeLettersButton,y/2 +sizeLettersBanner);

            g.setFont(new Font("EasterEgg", Font.ITALIC, sizeEasterEgg));
            g.drawString("SMedina", x-sizeEasterEgg*6, border/4);

        }
        //EasterEgg Screen - "About the Creator"
        else if(screen ==3){
            g.setFont(new Font("default", Font.ROMAN_BASELINE, sizeLettersBanner));
            for(int i = 0; i < 3; i ++) {
                g.drawLine(x / 2 - (int) (sizeLettersBanner * (4 + 1.0 / 7)), sizeLettersBanner +i, x / 2 + (int) (32.0 / 7 * sizeLettersBanner), sizeLettersBanner+i);
            }
            g.drawString("About the Creator", x/2-sizeLettersBanner*4,sizeLettersBanner);
            BufferedImage masked = null;
            BufferedImage books = null;

            //YOU WILL HAVE TO CHANGE THE PATHNAME TO VIEW THE IMAGE**********************
            try {
                masked = ImageIO.read(new File("/Users/sofiamedina/Desktop/Coding/IdeaProjects/Sudoku/src/Medina_Mask_Filter.PNG"));
                books = ImageIO.read(new File("/Users/sofiamedina/Desktop/Coding/IdeaProjects/Sudoku/src/Medina_with_Books.PNG"));
            }
            catch(IOException e){
                e.printStackTrace();
            }


            g.drawImage(masked,x/2,2*sizeLettersBanner,border,border*2,null);
            g.drawImage(books,x/2-border,2*sizeLettersBanner,border,border*2,null);

            g.setFont(new Font("default", Font.ROMAN_BASELINE, sizeLettersButton));
            for(int i = 0; i < aboutMe.size(); i++){
                g.drawString(aboutMe.get(i), border/4,3*border+ border/10 + sizeLettersButton*i);
            }


        }


        //Sudoku Screen
        else if(screen == 1) {


            if(start == false){ //timer starts when sudoku starts
                startTime = System.nanoTime();
                start = true;
            }
            //timer fun math stuff
            String timer;
            long timeElapsed =  currentTime-startTime;
            long timeElapsedSec = timeElapsed /1000000000;
            int timeElapsedMin =  (int)(timeElapsedSec/60);
            int timeSec = (int)(timeElapsedSec - 60*timeElapsedMin);

            if(timeSec < 10)
                timer = "" + timeElapsedMin+ ":0" +timeSec;
            else
                timer = "" + timeElapsedMin+ ":" +timeSec;

            //display timer
            g.setFont(new Font("default", Font.PLAIN, sizeLettersButton));
            g.drawString(timer, x / 2 - sizeLettersButton, (border - sizeLettersBanner) / 2 + sizeLettersBanner);

            //Sudoku banner
            g.setFont(new Font("default", Font.BOLD, sizeLettersButton));
            g.drawString("Sudoku", x / 2 - sizeLettersButton * 2, border / 4);

            //My name EasterEgg
            g.setFont(new Font("EasterEgg", Font.ITALIC, sizeEasterEgg));
            //useful for x/y coordinates don't delete yet
            //g.drawRect(x-sizeEasterEgg*6, border/4-sizeEasterEgg, sizeEasterEgg*4, sizeEasterEgg);
            g.drawString("SMedina", x-sizeEasterEgg*6, border/4);

            //SQUARES
            for (int r = 0; r < 9; r++) {
                for (int c = 0; c < 9; c++) {
                    String num = Integer.toString(s.getSquareVals()[r][c]);
                    if (s.getValShown()[r][c] == 1) { //if it is a given Value
                        g.setColor(Color.LIGHT_GRAY); //Fill the square gray
                        g.fillRect(border + r * increment, border + c * increment, increment, increment);
                        g.setColor(Color.black);
                        g.setFont(new Font("default", Font.BOLD, sizeLettersBold));
                        g.drawString(num, r * increment + border + (border / 10), c * increment + border + sizeLettersBold - (border / 20)); //and have the number be bold
                    } else if (s.getSquareInput()[r][c] != 0) { //if an input has been given
                        g.setColor(Color.gray);
                        if (check) { //if the check button has been pressed
                            if (s.getSquareInput()[r][c] == s.getSquareVals()[r][c]) //if it is correct
                                g.setColor(Color.green); //fill green
                            else
                                g.setColor(Color.red); //else fill red
                        }

                        g.setFont(new Font("default", Font.PLAIN, sizeLettersPlain));
                        g.drawString("" + s.getSquareInput()[r][c], r * increment + border + 1 / 3 * (sizeLettersPlain) + (border / 20), c * increment + border + sizeLettersPlain - (border / 20));
                    }

                    //drawing the squares
                    g.setColor(Color.GRAY);
                    g.drawRect(border + r * increment, border + c * increment, increment, increment);
                }
            }



            //BORDER
            g.setColor(Color.black);
            g.drawRect(border, border, 9 * increment, 9 * increment);

            //LINES SEPARATING EVERY 3 SQUARES
            g.setColor(Color.GRAY);
            for (int i = -1; i < 2; i++) {
                g.drawLine(increment * 3 + border + i, border, increment * 3 + border + i, increment * 9 + border);//VERTICAL - 3*1
                g.drawLine(increment * 6 + border + i, border, increment * 6 + border + i, increment * 9 + border);  //VERTICAL - 3*2
                g.drawLine(border, increment * 3 + border + i, increment * 9 + border, increment * 3 + border + i);//HORIZONTAL- 1*3
                g.drawLine(border, increment * 6 + border + i, increment * 9 + border, increment * 6 + border + i); //HORIZONTAL - 2 *3
            }

            //Selected Square
            if (highlighted[0] != -1 && highlighted[1] != -1) {
                g.setColor(Color.ORANGE);
                for (int i = -1; i < 2; i++)
                    g.drawRect(border + highlighted[0] * increment, border + highlighted[1] * increment, increment + i, increment + i);
            }

//Buttons
            //fun formatting numbers for math
            buttonSizeX = 2 * increment;
            buttonSizeY = 3 / 2 * increment;
            buttonRowX = border + border / 1 / 6 + (increment) / 2;
            buttonRowY = increment * 19 / 2 + border;

            //SOlVE BUTTON
            g.setColor(Color.lightGray);
            g.fillRect(buttonRowX - border / 1 / 6, buttonRowY, buttonSizeX, buttonSizeY);
            g.setColor(Color.black);
            g.setFont(new Font("default", Font.PLAIN, sizeLettersButton));
            g.drawString("Solve", buttonRowX, buttonRowY + sizeLettersButton + sizeLettersButton / 1 / 3);

            //Clear Button
            g.setColor(Color.lightGray);
            g.fillRect((buttonRowX - border / 1 / 6) + 3 * increment, buttonRowY, buttonSizeX, buttonSizeY);
            g.setColor(Color.black);
            g.setFont(new Font("default", Font.PLAIN, sizeLettersButton));
            g.drawString("Clear", buttonRowX + (3 * increment), increment * 19 / 2 + border + sizeLettersButton + sizeLettersButton / 1 / 3);

            //Check Button
            g.setColor(Color.lightGray);
            g.fillRect((buttonRowX - border / 1 / 6) + 6 * increment, buttonRowY, buttonSizeX, buttonSizeY);
            g.setColor(Color.black);
            g.setFont(new Font("default", Font.PLAIN, sizeLettersButton));
            g.drawString("Check", buttonRowX + (6 * increment) - border / 15, buttonRowY + sizeLettersButton + sizeLettersButton / 1 / 3);


            //stops the timer, sends to win screen
            if(isSolved){
                screen = 2;
                finalTime = timer;
            }

        }
        try {
            Thread.sleep(17);


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        repaint();

    }


    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        // System.out.println("clicked");


    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
       // System.out.println("pressed");

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
       // System.out.println("released");
        if(screen == 0){
            screen =1;
        }
        int x = mouseEvent.getX(); int y = mouseEvent.getY();

        //Easter Egg
        if(x >= getWidth()-sizeEasterEgg*6 && x <= getWidth() -sizeEasterEgg*2 && y >= border/4-sizeEasterEgg && y <= border/4 && screen ==1){
            screen = 3;
        }
        //Highlight Square
        for(int r = 0; r < 9; r++){
            for(int c = 0; c <9; c++) {
                if(x >= increment*r+border && x<=increment*r+border+increment && y >= increment*c+border && y<=increment*c+border+increment) {
                    if (s.getValShown()[r][c] == 0) {
                        highlighted[0] = r;
                        highlighted[1] = c;

                    }
                }
            }
        }

        //Check
        if(x>=border+6*increment && x <=(border+6*increment)+buttonSizeX && y >= buttonRowY && y<= buttonRowY + buttonSizeY){
            boolean checkSolved = true;
            check =true;
            for(int r = 0; r < 9; r++) {
                for (int c = 0; c < 9; c++) {
                    if (s.getValShown()[r][c] == 0) {
                     if (s.getSquareInput()[r][c] != s.getSquareVals()[r][c])
                        checkSolved = false;
                    }
                }
            }
            if(checkSolved)
                isSolved = true;
        }
        else //set check to false if mouse pressed
            check = false;


        //Clear
         if(x>=border+3*increment && x <=(border+3*increment)+buttonSizeX && y >= buttonRowY && y<= buttonRowY + buttonSizeY){
            for(int r = 0; r < 9; r++){
                for(int c = 0; c < 9; c++){
                    if(s.getValShown()[r][c] ==0){
                        s.setSquareInput(r,c,0);
                    }
                }
            }
        }


        //Solve
         if(x>=border && x <=border+buttonSizeX && y >= buttonRowY && y<= buttonRowY + buttonSizeY) {
             for (int r = 0; r < 9; r++) {
                 for (int c = 0; c < 9; c++) {
                     if (s.getValShown()[r][c] == 0) {
                         s.setSquareInput(r, c, s.getSquareVals()[r][c]);
                     }
                 }
             }
         }
    }


    @Override
    public void mouseEntered(MouseEvent mouseEvent) {
        //System.out.println("entered");
    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {
        //System.out.println("exit");
        highlighted[0] = -1; highlighted[1] = -1;
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
       // System.out.println("type");

        if(screen == 0){
            screen =1;
        }

        char n = keyEvent.getKeyChar();

        if(Character.isDigit(n)) {
            int num = Integer.parseInt("" + n);
            System.out.println(num);
            if (highlighted[0] != -1 && highlighted[1] != -1) { //checks to see if there is a square selected
                if (s.getValShown()[highlighted[0]][highlighted[1]] == 0) { //double checks that the square is not a hint
                    s.setSquareInput(highlighted[0], highlighted[1], num);

                }
            }

        }
        else
            s.setSquareInput(highlighted[0],highlighted[1],0);
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        //System.out.println("press");
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
       // System.out.println("release");
    }
}
