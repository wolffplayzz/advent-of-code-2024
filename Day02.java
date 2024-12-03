
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Day02 extends Template {

    private ArrayList<int[]> readFile = new ArrayList<>();

    @Override
    @SuppressWarnings("ConvertToTryWithResources")
    protected void readFile() {
        try {
            Scanner sc = new Scanner(new File("./day02.txt"));
            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                if (!line.isEmpty()) {
                    String[] temp = line.split(" ");
                    int[] lineTemp = new int[temp.length];
                    for (int i = 0; i < temp.length; i++) {
                        lineTemp[i] = Integer.parseInt(temp[i]);
                    }
                    readFile.add(lineTemp);
                }
            }
            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected String solvePart1() {
        int safeRows = 0;
        for (int[] row : readFile) {

            if (isSafe(row)) {
                safeRows++;
            }

        }
        return "" + safeRows;
    }

    @Override
    protected String solvePart2() {
        int safeRows = 0;
        for (int[] row : readFile) {
            boolean canBeMadeSafe = false;
            for (int i = 0; i < row.length; i++) {
                int[] modifiedRow = removeElement(row, i);
                if (isSafe(modifiedRow)) {
                    canBeMadeSafe = true;
                    break;
                }
            }
            if (canBeMadeSafe) {
                safeRows++;
            }
        }
        return "" + safeRows;
    }

    private static boolean isSafe(int[] row) {
        boolean isIncreasing = row[0] < row[1];
        for (int j = 1; j < row.length; j++) {
            int diff = row[j] - row[j - 1];
            if ((isIncreasing && (diff < 1 || diff > 3))
                    || (!isIncreasing && (diff > -1 || diff < -3))) {
                return false;
            }
        }
        return true;
    }

    private static int[] removeElement(int[] array, int index) {
        int[] result = new int[array.length - 1];
        int pos = 0;
        for (int i = 0; i < array.length; i++) {
            if (i != index) {
                result[pos++] = array[i];
            }
        }
        return result;
    }
}
