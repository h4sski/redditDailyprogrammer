package dailyprogrammer;

/*
https://www.reddit.com/r/dailyprogrammer/comments/6ze9z0/20170911_challenge_331_easy_the_adding_calculator/
 */


class test{
    public static boolean testLengthInput(int[] a, String[] s, int[] b, int[] r) {
        boolean check=false;
        if (a.length == b.length && a.length == s.length && a.length == r.length) {
            check = true;
        } else {
            System.out.println("a.length = "+a.length);
            System.out.println("b.length = "+b.length);
            System.out.println("s.length = "+s.length);
            System.out.println("r.length = "+s.length);
            System.out.println("Length of the input arrays are not equal.");
        }
        return check;
    }
}

public class Challenge365Easy {

    private static int add(int a, int b) {
        return a+b;
    }
    private static int subtract(int a, int b) {
        return a+(-b);
    }
    private static int multiply(int a, int b) {
        int result = 0;
        boolean factor = true;
        if (b<0) {
            b=-b;
            factor = false;
        }
        for (int i = 0; i < b; i++) {
            result = add(a,result);
        }
        if (factor == false) {
            result=-result;
        }
        return result;
    }
    private static int division(int a, int b) {
        int result = 0;
        boolean factor = true;
        if (a<0 && b<0) {
            a=-a;
            b=-b;
        } else if (a<0){
            a=-a;
            factor = false;
        } else if (b<0) {
            b=-b;
            factor = false;
        }
        if (b>0) {
            while (a != 0) {
                if (a < 0) {
                    System.out.println("Not integer result!");
                    break;
                }
                a -= b;
                result++;
            }
        } else {
            System.out.println("Cant divide by 0!");
        }
        if (factor == false) {
            result=-result;
        }
        return result;
    }
    private static int power(int a, int b) {
        int result = 0;
        if (b<0) {
            System.out.println("Not integer result!");
        } else if (b==0) {
            result=1;
        } else {
            result = a;
            for (int i = 1; i < b; i++) {
                result = multiply(result,a);
            }
        }
        return result;
    }

    /*
    1 -> +
    2 -> -
    3 -> *
    4 -> /
    5 -> ^
     */
    private static int calculate(int a, String b, int c) {
        int result=0;
        if (b=="+") {
            result = add(a,c);
        } else if (b=="-") {
            result = subtract(a,c);
        } else if (b=="*") {
            result = multiply(a,c);
        } else if (b=="/") {
            result = division(a,c);
        } else if (b=="^") {
            result = power(a,c);
        } else {
            System.out.println("Cannot calculate it!!");
        }
        return result;
    }
/*
    private static boolean testInputLenght(int[] a, String[] s, int[] b) {
        boolean check=false;
        if (a.length == b.length) {
            check = true;
        } else if (a.length == s.length) {
            check = true;
        } else {
            System.out.println("Lenght of the input arrays are not equal.");
        }
        return check;
    }*/

    public static void Challenge365Easy() {
        int[] input1 = {12, -30, 100, 100, -25, -41, 9, 9, -4, -12, 100, 75, -75, 7, 0, 5, -5, -8, -1, 1, 0, 5, 10};
//        int[] sign = {1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5};
        String[] sign = {"+", "+", "-", "-", "-", "-", "*", "*", "*", "*", "/", "/", "/", "/", "/", "^", "^", "^", "^", "^", "^", "^", "^"};
        int[] input2 = {25, 100, 30, -30, 29, -10, 3, -4, 8, -9, 2, -3, 3, 3, 0, 3, 3, 3, 1, 1, 5, 0, -3};
        int[] result = {37, 70, 70, 130, -54, -31, 27, -36, -32, 108, 50, -25, -25, 0, 0, 125, -125, -512, -1, 1, 0, 1, 0};

        boolean test1 = dailyprogrammer.test.testLengthInput(input1, sign, input2, result);
//        System.out.println("Length test result = " + test1);

        System.out.println("--------");
        for (int i = 0; i < 23; i++) {
            System.out.println(input1[i]+" "+sign[i]+" "+input2[i] +" = "+ calculate(input1[i], sign[i], input2[i]) +" // "+result[i]);
        }
        System.out.println("--------");
    }
}
