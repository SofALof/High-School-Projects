/**
 * This is the main class
 * @author  Sofia Medina
 * @version 1/14/2020
 */
import java.util.*;
public class Main {

    static Grid g;
    static int[] sq;

    public static void main(String[] args) {
        ArrayList sr = new ArrayList(Arrays.asList(2, 2, 2, 2, 2, 2, 2));
        g = new Grid(sr);
        sq = new int[9]; //marks what is in each box of the game //0 = X and 1 = Y (O)
        for (int i = 0; i < sq.length; i++)
            sq[i] = 2;

        System.out.println("\n\n\nWelcome to Tic-Tac-Toe: \nStarting from the top-left hand corner and moving to the right the squares are numbered 1-9 \nType the number at which you would like to play \n\n  ex:\n     1  2  3\n     4  5  6\n     7  8  9\n\n\n");
        g.print();

        Scanner s = new Scanner(System.in);
        int counter = 1;
        int sqr = -1;
        int RowsCollumnsDiagsCounter = -1;


        System.out.println("\n\nFor a local game of TicTacToe press 1: To play against a CPU (and lose) press 2: ");
        int player = s.nextInt();

        if (player == 1) {
            while (true) { //Loop breaks when there is a tic-tac-toe or when all 9 moves have been played

                if (counter == 10) {
                    RowsCollumnsDiagsCounter = 0;
                    break;
                } else if ((sq[0] != 2 && sq[0] == sq[1] && sq[1] == sq[2]) || (sq[3] != 2 && sq[3] == sq[4] && sq[3] == sq[5])
                        || (sq[6] != 2 && sq[6] == sq[7] && sq[6] == sq[8])) {
                    RowsCollumnsDiagsCounter = 1;
                    System.out.println("11");
                    break;
                }// rows
                else if ((sq[0] != 2 && sq[0] == sq[3] && sq[0] == sq[6]) || (sq[1] != 2 && sq[1] == sq[4] && sq[1] == sq[7])
                        || (sq[2] != 2 && sq[2] == sq[5] && sq[2] == sq[8])) {
                    RowsCollumnsDiagsCounter = 2;
                    System.out.println("2");
                    break;
                } //collumns
                else if ((sq[0] != 2 && sq[0] == sq[4] && sq[0] == sq[8]) || (sq[6] != 2 && sq[6] == sq[4] && sq[6] == sq[2])) {
                    RowsCollumnsDiagsCounter = 3;
                    break;
                }


                if (counter % 2 == 1) { //play X
                    System.out.println("Player X: ");
                    sqr = s.nextInt();
                    while (g.playX(sqr) == false) {
                        System.out.println("Player X: ");
                        sqr = s.nextInt();
                        g.playX(sqr);
                    }
                    sq[sqr - 1] = 0;
                } else {  //Play O
                    System.out.println("Player Y: ");
                    sqr = s.nextInt();
                    g.playY(sqr);
                    while (g.playY(sqr) == false) {
                        System.out.println("Player Y: ");
                        sqr = s.nextInt();
                        g.playY(sqr);
                    }
                    sq[sqr - 1] = 1;
                }


                counter++;
                g.print();


            }
            if (RowsCollumnsDiagsCounter == 0)
                System.out.println("Its a tie");

            else if (RowsCollumnsDiagsCounter == 1) {
                if ((sq[0] == 1 && sq[0] == sq[1] && sq[1] == sq[2]) || (sq[3] == 1 && sq[3] == sq[4] && sq[3] == sq[5])
                        || (sq[6] == 1 && sq[6] == sq[7] && sq[6] == sq[8]))
                    System.out.println("O wins! 1");
                else
                    System.out.println("X wins!2");
            } else if (RowsCollumnsDiagsCounter == 2) {
                if ((sq[0] == 1 && sq[0] == sq[3] && sq[0] == sq[6]) || (sq[1] == 1 && sq[1] == sq[4] && sq[1] == sq[7])
                        || (sq[2] == 1 && sq[2] == sq[5] && sq[2] == sq[8]))
                    System.out.println("O wins!3");
                else
                    System.out.println("X wins!4");
            } else if (RowsCollumnsDiagsCounter == 3) {
                if ((sq[0] == 1 && sq[0] == sq[4] && sq[0] == sq[8]) || (sq[6] == 1 && sq[6] == sq[4] && sq[6] == sq[2]))
                    System.out.println("O wins!");
                else
                    System.out.println("X wins!");
            }
        }
        else { //CPU PART STARTS HERE
            System.out.println("Why huLLO thErE. Im gLaD u HAVE deCidEd to PlAy tHe CpU aNd voIdEd aNy cHanCe of IncReasIng Ur SeLf EstEEm By WInNing \nbc yOu WILL nOt bE aBLe tO wIn. Since you have given up ur possibility of winning Ill let you choose if you want to go first of second. \nPress 1 for first and 2 for second: ");
            int move = s.nextInt();
            counter = 1; //counts what turn it is.
            int square = -1;


            if (move == 1) {
                System.out.println("Well...at least you have some sense. Playing first increases your odds of winning (against an imperfect opponent)");
                while (true) {
                    if (counter == 9) break;
                    else if ((sq[0] != 2 && sq[0] == sq[1] && sq[1] == sq[2]) || (sq[3] != 2 && sq[3] == sq[4] && sq[3] == sq[5])
                            || (sq[6] != 2 && sq[6] == sq[7] && sq[6] == sq[8])) break;// rows
                    else if ((sq[0] != 2 && sq[0] == sq[3] && sq[0] == sq[6]) || (sq[1] != 2 && sq[1] == sq[4] && sq[1] == sq[7])
                            || (sq[2] != 2 && sq[2] == sq[5] && sq[2] == sq[8])) break; //collumns
                    else if ((sq[0] != 2 && sq[0] == sq[4] && sq[0] == sq[8]) || (sq[6] != 2 && sq[6] == sq[4] && sq[6] == sq[2]))
                        break;


                    CPU cpu = new CPU(sq, move);

                    if (counter % 2 == 1) {
                        System.out.println("Player X: ");
                        square = s.nextInt();
                        while (g.playX(square) == false) {
                            System.out.println("Player X: ");
                            square = s.nextInt();
                            g.playX(square);
                        }
                        sq[sqr - 1] = 0;
                    } else {
                        square = cpu.TieAlg(move, counter);
                        g.playY(square);
                        sq[square - 1] = 1;

                    }
                    counter++;
                    g.print();
                }


            }
            else {
                System.out.println("Hmmm...moron. Playing second is logically the lesser choice...smh.");
                while (true) {

                    if (counter == 10) break;
                    else if ((sq[0] != 2 && sq[0] == sq[1] && sq[1] == sq[2]) || (sq[3] != 2 && sq[3] == sq[4] && sq[3] == sq[5])
                            || (sq[6] != 2 && sq[6] == sq[7] && sq[6] == sq[8])) break;// rows
                    else if ((sq[0] != 2 && sq[0] == sq[3] && sq[0] == sq[6]) || (sq[1] != 2 && sq[1] == sq[4] && sq[1] == sq[7])
                            || (sq[2] != 2 && sq[2] == sq[5] && sq[2] == sq[8])) break; //collumns
                    else if ((sq[0] != 2 && sq[0] == sq[4] && sq[0] == sq[8]) || (sq[6] != 2 && sq[6] == sq[4] && sq[6] == sq[2]))
                        break;


                    CPU cpu = new CPU(sq, move);

                    if (counter % 2 == 1) {
                        square = cpu.TieAlg(move, counter);
                        System.out.println(square);
                        g.playY(square);
                        sq[square - 1] = 0;
                        counter++;
                    } else {
                        System.out.println("Player X: ");
                        square = s.nextInt();
                        while (g.playX(square) == false) {
                            System.out.println("Player X: ");
                            square = s.nextInt();
                            g.playX(square);
                        }
                        sq[square - 1] = 1;
                        counter++;

                    }
                    g.print();
                }
            }
        }
    }
}

