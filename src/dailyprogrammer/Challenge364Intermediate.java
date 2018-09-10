package dailyprogrammer;
/*
https://www.reddit.com/r/dailyprogrammer/comments/8sjcl0/20180620_challenge_364_intermediate_the_ducci/
 */

import static java.lang.Math.abs;

class c364solve {

    public int steps = 1;

    private void displayRow(int[] input) {
        for (int i=0; i < input.length; i++) {
            System.out.print(input[i] + ", ");
        }
        System.out.println();
    }

    public c364solve(int[] input) {
        boolean finish=false;
        displayRow(input);
        
        // creating nest line copying source one
        int[] output = input.clone();
        int[] oldInput = input.clone();

        while (!finish){
            // calculating values of next iteration
            for (int i=0; i < input.length; i++) {
                if (i==(input.length-1)) {
                    output[i] = abs(input[0]-input[i]);
                } else {
                    output[i] = abs(input[i+1]-input[i]);
                }
            }
            this.steps++;           // adding step
//            displayRow(output);     // display row

            if (this.steps > input.length) {
                oldInput = input.clone()
            }

            input = output.clone(); // clone calculated row as new input row
            
            // counting quantity of zeros
            int quantityZeros = 0;
            for (int i=0; i < output.length; i++) {
                if (output[i] == 0) {
                    quantityZeros++;
                }
            }

            // checking if its done
            if (quantityZeros == output.length) {
                finish=true;
                System.out.println(this.steps+" steps");
            } else if (this.steps == 100) {
                finish=true;
                System.out.println("Reach max steps range = "+this.steps+" steps");
            }
        }
    }

}

public class Challenge364Intermediate {
    
    public static void main() {
        int[][] input = {
                {0, 653, 1854, 4063},
                {1, 5, 7, 9, 9},
                {1, 2, 1, 2, 1, 0},
//                {10, 12, 41, 62, 31, 50},
//                {10, 12, 41, 62, 31}
        };

        System.out.println(input.length);
        for (int i = 0; i < input.length; i++) {
            new c364solve(input[i]);
            System.out.println();
        }

//        c364solve example1 = new c364solve(input[0]);
    }
}
