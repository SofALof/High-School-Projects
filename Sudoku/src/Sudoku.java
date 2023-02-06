public class Sudoku {

    private int [] [] squareInput;
    private int [] [] squareVals;
    private int [] [] valShown;

    public Sudoku(int [] [] vals, int [] [] shown){
        squareVals = new int [9][9];
        squareInput = new int [9][9];
        valShown = new int [9][9];

        for(int r = 0; r < 9; r++){
            for(int c = 0; c < 9; c++){
                squareVals[r][c] = vals[r][c];
                valShown[r][c] = shown[r][c];
            }
        }


    }

    public void setSquareInput(int r, int c, int val) {
        squareInput[r][c] = val;
    }
    public int [] [] getSquareInput(){
        return squareInput;
    }
    public int [] [] getValShown(){
        return valShown;
    }
    public int [] [] getSquareVals(){
        return squareVals;
    }

}
