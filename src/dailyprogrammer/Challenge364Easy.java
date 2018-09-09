package dailyprogrammer;
/*
https://www.reddit.com/r/dailyprogrammer/comments/8s0cy1/20180618_challenge_364_easy_create_a_dice_roller/
 */

import java.util.Random;

public class Challenge364Easy {

    private static String left(String[] in) {
        String result = "";
        for (int i = 0; !in[i].equals("d"); i++) {
            result += in[i];
        }
        return result;
    }
    private static String right(String[] in) {
        String result = "";
        boolean afterD = false;
        for (int i = 0; i<in.length; i++) {
            if (afterD) {
                result += in[i];
            }
            if (in[i].equals("d")) {
                afterD=true;
            }
        }
        return result;
    }

    private static int roll(int side) {
        int output = (new Random().nextInt(side)) +1;
        return output;
    }

    public static void main() {
        String[] input = {"5d12", "6d4", "1d2", "3d6", "4d20", "100d100"};
        int rolls;
        int sides;

        for (int i = 0; i < input.length; i++) {
            int[] result = new int[input.length];
            String[] inpArr = input[i].split("");
            rolls = Integer.parseInt(left(inpArr));
            sides = Integer.parseInt(right(inpArr));
            for (int j = 0; j < rolls; j++) {
                result[i] += roll(sides);
            }
            System.out.println(input[i]+" // "+result[i]);
        }
    }
}
