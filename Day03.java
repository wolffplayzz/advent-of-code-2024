import java.io.*;
import java.util.ArrayList;
import java.util.regex.*;

public class Day03 extends Template {

    private ArrayList<String> readFiltered = new ArrayList<>();
    private ArrayList<String> filteredForPart2 = new ArrayList<>();

    @Override
    protected void readFile() {

        String regex = "\\b(mul\\(\\d+\\,\\d+\\)|do\\(\\)|don't\\(\\))";

        try (BufferedReader br = new BufferedReader(new FileReader("./day03.txt"))) {
            String line;
            Pattern pattern = Pattern.compile(regex);

            while ((line = br.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    this.readFiltered.add(matcher.group());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected String solvePart1() {
        int[][] numbers = new int[this.readFiltered.size()][2];
        int mult = 0;

        String regex = "\\d+";

        for (int i = 0; i < this.readFiltered.size(); i++) {
            String instruction = this.readFiltered.get(i);
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(instruction);

            int index = 0;
            while (matcher.find() && index < 2) {
                numbers[i][index++] = Integer.parseInt(matcher.group());
            }
        }

        for (int i = 0; i < numbers.length; i++) {
            mult += numbers[i][0] * numbers[i][1];
        }

        return "" + mult;
    }

    @Override
    protected String solvePart2() {

        int[][] numbers = new int[this.filteredForPart2.size()][2];
        int mult = 0;

        String regex = "\\d+";

        for (int i = 0; i < this.filteredForPart2.size(); i++) {
            String instruction = this.filteredForPart2.get(i);
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(instruction);

            int index = 0;
            while (matcher.find() && index < 2) {
                numbers[i][index++] = Integer.parseInt(matcher.group());
            }
        }

        for (int i = 0; i < numbers.length; i++) {
            mult += numbers[i][0] * numbers[i][1];
        }

        return "" + mult;
    }

    @Override
    protected void restructureForPart2() {
        boolean isMulEnabled = true;

        for (String instruction : this.readFiltered) {
            if (instruction.equals("do()")) {
                isMulEnabled = true; 
            } else if (instruction.equals("don't()")) {
                isMulEnabled = false; 
            } else if (instruction.startsWith("mul(")) {
                if (isMulEnabled) {
                    this.filteredForPart2.add(instruction); 
                }
            }
        }
    }
}
