
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
        int middlePageNumberOfOrdered = 0;
        int[] col1 = this.part1.get(0);
        int[] col2 = this.part1.get(1);
        int[] visited = new int[this.part2.size()];
        int i = 0;

        for (int[] line : this.part2) {
            boolean lineMatched = false;
            for (int j = 0; j < col1.length; j++) {
                int e1 = col1[j];
                int e2 = col2[j];
                int posE1 = -1, posE2 = -1;

                for (int k = 0; k < line.length; k++) {
                    if (line[k] == e1) {
                        posE1 = k;
                    }
                    if (line[k] == e2) {
                        posE2 = k;
                    }
                    if (posE1 != -1 && posE2 != -1) {
                        break;
                    }
                }

                if (posE1 != -1 && posE2 != -1 && posE1 < posE2) {
                    lineMatched = true;
                    break;
                }
            }

            if (lineMatched && visited[i] == 0) {
                middlePageNumberOfOrdered = middlePageNumberOfOrdered + line[(line.length / 2)];
            }
            visited[i] = i;

            i++;
        }

        return String.valueOf(middlePageNumberOfOrdered);
    }

    @Override
    protected String solvePart2() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
