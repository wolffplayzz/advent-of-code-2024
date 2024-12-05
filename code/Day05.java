
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Day05 extends Template {

    private ArrayList<int[]> part1 = new ArrayList<>();
    private ArrayList<int[]> part2 = new ArrayList<>();

    @Override
    protected void readFile() {

        ArrayList<Integer> column1 = new ArrayList<>();
        ArrayList<Integer> column2 = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("/data/day05.txt"))) {
            String line;
            boolean isLowerPart = false;

            while ((line = br.readLine()) != null) {
                if (line.isBlank()) {
                    isLowerPart = true;
                    continue;
                }
                if (!isLowerPart) {
                    String[] parts = line.split("\\|");
                    column1.add(Integer.valueOf(parts[0]));
                    column2.add(Integer.valueOf(parts[1]));
                } else {
                    String[] parts = line.split(",");
                    int[] array = Arrays.stream(parts).mapToInt(Integer::parseInt).toArray();
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

        for (int i = 0; i < this.part2.size(); i++){
            
            
        }

        return "" + middlePageNumberOfOrdered;
    }

    @Override
    protected String solvePart2() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
