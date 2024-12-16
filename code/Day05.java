
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Day05 extends Template {

    private ArrayList<int[]> part1 = new ArrayList<>();
    private ArrayList<int[]> part2 = new ArrayList<>();

    @Override
    protected void readFile() {

        List<Integer> column1 = new ArrayList<>();
        List<Integer> column2 = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("data/day05.txt"))) {
            String line;
            boolean isLowerPart = false;

            while ((line = br.readLine()) != null) {
                if (line.isBlank()) {
                    isLowerPart = true;
                    continue;
                }
                if (!isLowerPart) {
                    String[] parts = line.split("\\|");
                    column1.add(Integer.parseInt(parts[0]));
                    column2.add(Integer.parseInt(parts[1]));
                } else {
                    String[] parts = line.split(",");
                    int[] array = new int[parts.length];
                    for (int i = 0; i < parts.length; i++) {
                        array[i] = Integer.parseInt(parts[i]);
                    }
                    this.part2.add(array);
                }
            }
        } catch (Exception e) {
        }

        int[] column1Array = column1.stream().mapToInt(Integer::intValue).toArray();
        int[] column2Array = column2.stream().mapToInt(Integer::intValue).toArray();

        this.part1.add(column1Array);
        this.part1.add(column2Array);

    }

    @Override
    protected String solvePart1() {
        int totalMiddlePageNumber = 0;
        int[] col1 = this.part1.get(0);
        int[] col2 = this.part1.get(1);

        for (int[] update : this.part2) {
            boolean isOrdered = true;
            for (int k = 0; k < col1.length; k++) {
                int pos1 = findPosition(update, col1[k]);
                int pos2 = findPosition(update, col2[k]);
                if (pos1 != -1 && pos2 != -1 && pos1 > pos2) {
                    isOrdered = false;
                    break;
                }
            }
            if (isOrdered) {
                totalMiddlePageNumber += update[update.length / 2];
            }
        }
        return String.valueOf(totalMiddlePageNumber);
    }

    private int findPosition(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected String solvePart2() {
        int totalMiddlePageNumber = 0;
        int[] col1 = this.part1.get(0);
        int[] col2 = this.part1.get(1);

        for (int[] update : this.part2) {
            boolean isOrdered = true;

            for (int i = 0; i < col1.length; i++) {
                int pos1 = findPosition(update, col1[i]);
                int pos2 = findPosition(update, col2[i]);
                if (pos1 != -1 && pos2 != -1 && pos1 > pos2) {
                    isOrdered = false;
                    break;
                }
            }

            if (!isOrdered) {
                int[] correctedUpdate = correctUpdate(update, col1, col2);
                totalMiddlePageNumber += correctedUpdate[correctedUpdate.length / 2];
            }
        }

        return String.valueOf(totalMiddlePageNumber);
    }

    private int[] correctUpdate(int[] update, int[] col1, int[] col2) {
        List<Integer> sorted = new ArrayList<>();
        List<Integer> remaining = new ArrayList<>();
        for (int value : update) {
            remaining.add(value);
        }

        for (int k = 0; k < col1.length; k++) {
            int pos1 = findPosition(remaining.stream().mapToInt(Integer::intValue).toArray(), col1[k]);
            int pos2 = findPosition(remaining.stream().mapToInt(Integer::intValue).toArray(), col2[k]);

            if (pos1 != -1 && pos2 != -1 && pos1 > pos2) {
                sorted.add(col1[k]);
                sorted.add(col2[k]);
                remaining.remove((Integer) col1[k]);
                remaining.remove((Integer) col2[k]);
            }
        }

        sorted.addAll(remaining);
        return sorted.stream().mapToInt(Integer::intValue).toArray();
    }
}
