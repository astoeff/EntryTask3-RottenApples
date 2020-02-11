import java.io.IOException;
import java.util.*;

public class Main {
    /*
     * Function to check if a dot with coordinates (j,i) is in the rotten square for a dot with coordinates (n,m)
     */
    public static boolean checkIfAppleAtPositionIsRotten(int n, int m, int i, int j, int numberOfChanges) {
        return j >= n - numberOfChanges && j <= n + numberOfChanges && i >= m - numberOfChanges && i <= m + numberOfChanges;
    }

    public static void printBox(int n, int m, List<Integer> values_N, List<Integer> values_M, int numberOfChanges){
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int positionInListOfMCoordinates = 0;
                char currentOutput = 'O';
                for (Iterator<Integer> iter = values_N.iterator(); iter.hasNext(); ) {
                    int currentValue_N = iter.next();
                    int currentValue_M = values_M.get(positionInListOfMCoordinates);
                    if (checkIfAppleAtPositionIsRotten(currentValue_N, currentValue_M, i, j, numberOfChanges)) {
                        currentOutput = 'X';
                        break;
                    }
                    positionInListOfMCoordinates++;
                }
                System.out.print(currentOutput);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Enter the size of the box: ");
        String inputSizeOfBox = new String();
        Scanner in = new Scanner(System.in);
        inputSizeOfBox = in.nextLine();
        String[] arrayOfSize = inputSizeOfBox.split("x");
        int size_N = Integer.parseInt(arrayOfSize[0]);
        int size_M = Integer.parseInt(arrayOfSize[1]);
        System.out.println("Еnter the coordinates of the rotten apples: ");
        String inputCoordinatesOfRottenApples = new String();
        inputCoordinatesOfRottenApples = in.nextLine();
        System.out.println("After how many days will you come back: ");
        String daysToWait = in.nextLine();
        int changesDependingOnDays = Integer.parseInt(daysToWait) / 3;  //how many times we have new rotten apples (changes in the box)
        inputCoordinatesOfRottenApples = inputCoordinatesOfRottenApples.replaceAll("[^0-9]", " ");
        inputCoordinatesOfRottenApples = inputCoordinatesOfRottenApples.replace("  ", " ");
        String[] values = inputCoordinatesOfRottenApples.split(" ");
        List<Integer> values_N = new LinkedList<>();
        List<Integer> values_M = new LinkedList<>();
        for (int i = 1; i < values.length; i += 3) {
            values_N.add(Integer.parseInt(values[i]));
            values_M.add(Integer.parseInt(values[i + 1]));
        }
        printBox(size_N,size_M,values_N,values_M,changesDependingOnDays);
    }
}
