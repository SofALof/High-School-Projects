import java.util.*;

public class Maths{
    int h;
    int m;
    int s;

    public Maths(int hrs, int min, int sec){
        h = hrs;
        m = min;
        s = sec;
    }

    private int getLargestPowerOfTwo(int num){

        int exp = 0;
        int power = (int)(Math.pow(2,exp));
        int bound = num-1;

        while(power < bound){ //bound is one less than original num bc exponent
            exp++;            //is added before checking (ie one bigger than it shld be)
            power = (int)(Math.pow(2,exp));
        }

        if(power > num) { //here even with the reduced bound an error can be made
            return exp-=1;//(so this makes sure the error doesn't go thro)
        }
        return exp;
    }

    public int [] binaryH(){
        int [] binary = new int[6]; //each spot represents a power of two (6bit binary "block")
        int bH = h;
        int pow = getLargestPowerOfTwo(bH);//pow = power of two

        while(bH > 0){
            binary[pow] = 1;
            bH-= Math.pow(2,pow);
            pow = getLargestPowerOfTwo(bH);
        }

        return binary;
    }
    public int [] binaryM(){
        int [] binary = new int[6]; //each spot represents a power of two (6bit binary "block")
        int bM = m; //binary minutes
        int pow = getLargestPowerOfTwo(bM);//pow = power of two

        while(bM > 0){
            binary[pow] = 1;
            bM-= Math.pow(2,pow);
            pow = getLargestPowerOfTwo(bM);
        }

        return binary;
    }
    public int [] binaryS(){
        int [] binary = new int[6]; //each spot represents a power of two (6bit binary "block")
        int bS = s; //binary seconds
        int pow = getLargestPowerOfTwo(bS); //pow = power of two

        while(bS > 0){
            binary[pow] = 1; //,,,
            bS-= Math.pow(2,pow);//,,,
            pow = getLargestPowerOfTwo(bS);
        }

        return binary;
    }



}