package dailyprogrammer;

/*
https://www.reddit.com/r/dailyprogrammer/comments/9cvo0f/20180904_challenge_367_easy_subfactorials_another/
 */

public class Challenge367Easy {

    private static void display(long[] in, long[] out, long[] r) {
        if (in.length  != out.length) {
            System.out.println("Input & Output arrays have not same length");
        } else {
            for (int i = 0; i < in.length; i++) {
                System.out.println("!"+in[i]+" = "+out[i]+" // "+r[i]);
            }
        }
    }

    private static long derangements(long in) {
        long result;
        if (in==1){
            result = 0;
        } else if (in==0) {
            result = 1;
        } else {
            result = (in-1) * (derangements((in-1)) + derangements((in-2)));
        }
        return result;
    }

    public static void main() {
        System.out.println("Welcome form inside of Challenge367Easy");
        // change last value to fit result in "long" range, originally was 6, 9, 14
        long[] input = {6, 9, 12};
        long[] result = {265, 133496, 176214841};
        long[] output = new long[input.length];

        for (int i = 0; i < input.length; i++) {
            output[i] = derangements(input[i]);
        }
        display(input, output, result);
    }
}
