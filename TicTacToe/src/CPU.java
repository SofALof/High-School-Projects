/**
 * This is the CPU class
 * @author Sofia  Medina
 * @version 1/14/2020
 */

public class CPU {
    int [] squares = new int [9];
    int starter;

    public CPU(int [] squareStates, int playerOneTwo) {
        int i = 0;
        for(int val: squareStates){
            squares[i] = val; i++;
        }
        starter = playerOneTwo; //to see who will begin the game

    }
    public int checkPotentialWinX() { //returns indexes + 1 = square num
        //if X has a win

        //ROW 1
        if(squares[0] == 0 && squares[1] == 0) return 2+1;
        else if(squares[0]==0 && squares[2] == 0) return 1+1;
        else if(squares[1]==0 && squares[2] == 0) return 0+1;

        //ROW 2
        else if(squares[3]==0 && squares[4] == 0) return 5+1;
        else if(squares[3]==0 && squares[5] == 0) return 4+1;
        else if(squares[4]==0 && squares[5] == 0) return 3+1;

        //ROW 3
        else if(squares[6]==0 && squares[7] == 0) return 8+1;
        else if(squares[6]==0 && squares[8] == 0) return 7+1;
        else if(squares[7]==0 && squares[8] == 0) return 6+1;

        //Column 1
        else if(squares[0]==0 && squares[3] == 0) return 6+1;
        else if(squares[0]==0 && squares[6] == 0) return 3+1;
        else if(squares[3]==0 && squares[6] == 0) return 0+1;

        //Column 2
        else if(squares[1]==0 && squares[4] == 0) return 7+1;
        else if(squares[1]==0 && squares[7] == 0) return 4+1;
        else if(squares[4]==0 && squares[7] == 0) return 1+1;

        //Column 3
        else if(squares[2]==0 && squares[5] == 0) return 8+1;
        else if(squares[2]==0 && squares[8] == 0) return 5+1;
        else if(squares[5]==0 && squares[8] == 0) return 2+1;

        //Diagonal 1
        else if(squares[0]==0 && squares[4] == 0) return 8+1;
        else if(squares[0]==0 && squares[8] == 0) return 4+1;
        else if(squares[4]==0 && squares[8] == 0) return 0+1;

        //Diagonal 2
        else if(squares[2]==0 && squares[4] == 0) return 6+1;
        else if(squares[2]==0 && squares[6] == 0) return 4+1;
        else if(squares[4]==0 && squares[6] == 0) return 2+1;


        return -1;
    }
    public int checkPotentialWinY(){//returns indexes + 1 = square num
        //if Y has a win

        //ROW 1
        if(squares[0] == 1 && squares[1] == 1) return 2+1;
        else if(squares[0]==1 && squares[2] == 1) return 1+1;
        else if(squares[1]==1 && squares[2] == 1) return 0+1;

        //ROW 2
        else if(squares[3]==1 && squares[4] == 1) return 5+1;
        else if(squares[3]==1 && squares[5] == 1) return 4+1;
        else if(squares[4]==1 && squares[5] == 1) return 3+1;

        //ROW 3
        else if(squares[6]==1 && squares[7] == 1) return 8+1;
        else if(squares[6]==1 && squares[8] == 1) return 7+1;
        else if(squares[7]==1 && squares[8] == 1) return 6+1;

        //Column 1
        else if(squares[0]==1 && squares[3] == 1) return 6+1;
        else if(squares[0]==1 && squares[6] == 1) return 3+1;
        else if(squares[3]==1 && squares[6] == 1) return 0+1;

        //Column 2
        else if(squares[1]==1 && squares[4] == 1) return 7+1;
        else if(squares[1]==1 && squares[7] == 1) return 4+1;
        else if(squares[4]==1 && squares[7] == 1) return 1+1;

        //Column 3
        else if(squares[2]==1 && squares[5] == 1) return 8+1;
        else if(squares[2]==1 && squares[8] == 1) return 5+1;
        else if(squares[5]==1 && squares[8] == 1) return 2+1;

        //Diagonal 1
        else if(squares[0]==1 && squares[4] == 1) return 8+1;
        else if(squares[0]==1 && squares[8] == 1) return 4+1;
        else if(squares[4]==1 && squares[8] == 1) return 0+1;

        //Diagonal 2
        else if(squares[2]==1 && squares[4] == 1) return 6+1;
        else if(squares[2]==1 && squares[6] == 1) return 4+1;
        else if(squares[4]==1 && squares[6] == 1) return 2+1;


        return -1;

    }
    public boolean movedToCorner(){ //if corner is not empty
        if (squares[0] != 2) return true;//corners
        else if (squares[2] != 2) return true;
        else if (squares[6] != 2) return true;
        else if (squares[8] != 2) return true;

        return false;
    }

    public int checkCorners(){//if corner empty
        if (squares[0] == 2) return 0 + 1;//corners
        else if (squares[2] == 2) return 2 + 1;
        else if (squares[6] == 2) return 6 + 1;
        else if (squares[8] == 2) return 8 + 1;

        return -1;
    }
    public int checkMiddle(){ //if middle empty
        if (squares[4] == 2) return 4 + 1;//the middle
        return -1;
    }
    public int emptySquare(){ //nonCorner & nonMiddle
        if (squares[1] == 2) return 1 + 1;//corners
        else if (squares[3] == 2) return 3 + 1;
        else if (squares[5] == 2) return 5 + 1;
        else if (squares[7] == 2) return 7 + 1;

        return -1;
    }

    public int TieAlg(int start, int move){
        if(start == 1) { //start = 1 if player X

            if (checkPotentialWinX() != -1) return checkPotentialWinX();
            else if (checkPotentialWinY() != -1) return checkPotentialWinY();
            else if(checkMiddle() != -1) return checkMiddle();
            else if (checkCorners() != -1) return checkCorners();

            return emptySquare();

            }
        else {//start = 2 if player Y (O)
            if( move ==1){ //if on first move
                if (movedToCorner()) { //on the first move check to see if they moved to a corner and if so avoid the middle
                    return checkCorners();
                }
            }

            if (checkPotentialWinY() != -1) return checkPotentialWinY();
            else if (checkPotentialWinX() != -1) return checkPotentialWinX();
            else if(checkMiddle() != -1) return checkMiddle();
            else if (checkCorners() != -1) return checkCorners();

            return emptySquare();
        }
    }
}

