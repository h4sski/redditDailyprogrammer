package dailyprogrammer;

public class separateClass {

    public static void main() {

        System.out.println("inside the separateClass");
//        int[][] array = new int[3][4];
        int[][] array = {{1, 2, 3, 4}, {2, 3, 4, 5}, {3, 4, 5, 6}};
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                array[i][j] = (i+1)*(j+1);
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(array[i][j]+"  ");
            }
            System.out.println("");
        }
    }
}
