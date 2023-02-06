
//DISREGARD THIS CLASS - NOT ENOUGH PROGRESS MADE

/*public class generateSudoku {
    public generateSudoku(){

    }
    public int [] [] createGrid(){ //generates a randomly solved grid
        int [] [] Grid = new int [9][9];
        int [] [] Square = new int [3][3];
        int [] row = new int [9];
        int [] col = new int [9];

        int rand = 0;

        for(int r = 0; r < 9; r++){
            for(int c = 0; c < 9; c++){
                while(!checkRow(getRow(r, Grid)) && ! checkCol(getCol(c,Grid)) && !checkSquare(getSquare(r,c, Grid)))
                    rand = (int)(Math.random()*9+1);


            }
        }

        return Grid;
    }
    private int[][] getSquare(int r, int c, int [] [] Grid){



        return
    }
    private int [] getRow(int rowNum, int [] [] arr){
        int [] row = new int [9];
        for(int c = 0; c < 9; c++){
            row[c] = arr[rowNum][c];
        }
        return row;
    }
    private int [] getCol(int colNum, int [] [] arr){
        int [] col = new int [9];
        for(int r = 0; r < 9; r++){
            col[r] = arr[r][colNum];
        }
    }

    private boolean checkRow(int [] row){ //helperMethod -- checks for repeats in row

        for(int i = 0; i < 9 ; i++){
            for(int j =i; j < 9; j ++){
                if(row[i] == row[j])
                    return false;
            }
        }
        return true;
    }
    private boolean checkCol(int [] col){ //helperMethod -- checks for repeats in col
        for(int i = 0; i < 9 ; i++){
            for(int j =i; j < 9; j ++){
                if(col[i] == col[j])
                    return false;
            }
        }
        return true;
    }
    private boolean checkSquare(int [] [] square){ //helperMethod -- checks for repeats in square
        for(int r = 0; r < 9; r++){
            for(int c = 0; c < 9; c++){
                for(int r2 = r; r2 < 9; r2++){
                    for(int c2 = c; c2 < 9; c2++){
                        if(square[r][c] == square [r2][c2])
                            return false;
                    }
                }
            }
        }

        return true;
    }

}
*/