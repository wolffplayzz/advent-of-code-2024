
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Day04 extends Template {

    private ArrayList<char[]> readFile = new ArrayList<>();

    @Override
    protected void readFile() {
        try {
            Scanner sc = new Scanner(new File("data/day04.txt"));
            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                if (!line.isEmpty()) {
                    char[] temp = new char[line.length()];
                    for (int i = 0; i < line.length(); i++) {
                        temp[i] = line.charAt(i);
                    }
                    readFile.add(temp);

                }
            }
            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected String solvePart1() {
        int xmasCount = 0;

        for (int i = 0; i < this.readFile.size(); i++) {

            for (int j = 0; j < this.readFile.get(i).length; j++) {
                if (this.readFile.get(i)[j] == 'X') {
                    try {
                        if (this.readFile.get(i)[j + 1] == 'M' && this.readFile.get(i)[j + 2] == 'A' && this.readFile.get(i)[j + 3] == 'S') {
                            xmasCount++;
                        }
                    } catch (Exception e) {
                    }
                    try {
                        if (this.readFile.get(i)[j - 1] == 'M' && this.readFile.get(i)[j - 2] == 'A' && this.readFile.get(i)[j - 3] == 'S') {
                            xmasCount++;
                        }
                    } catch (Exception e) {
                    }
                    try {
                        if (this.readFile.get(i + 1)[j] == 'M' && this.readFile.get(i + 2)[j] == 'A' && this.readFile.get(i + 3)[j] == 'S') {
                            xmasCount++;
                        }
                    } catch (Exception e) {
                    }
                    try {
                        if (this.readFile.get(i - 1)[j] == 'M' && this.readFile.get(i - 2)[j] == 'A' && this.readFile.get(i - 3)[j] == 'S') {
                            xmasCount++;
                        }
                    } catch (Exception e) {
                    }
                    try {
                        if (this.readFile.get(i + 1)[j + 1] == 'M' && this.readFile.get(i + 2)[j + 2] == 'A' && this.readFile.get(i + 3)[j + 3] == 'S') {
                            xmasCount++;
                        }
                    } catch (Exception e) {
                    }
                    try {
                        if (this.readFile.get(i - 1)[j - 1] == 'M' && this.readFile.get(i - 2)[j - 2] == 'A' && this.readFile.get(i - 3)[j - 3] == 'S') {
                            xmasCount++;
                        }
                    } catch (Exception e) {
                    }
                    try {
                        if (this.readFile.get(i + 1)[j - 1] == 'M' && this.readFile.get(i + 2)[j - 2] == 'A' && this.readFile.get(i + 3)[j - 3] == 'S') {
                            xmasCount++;
                        }
                    } catch (Exception e) {
                    }
                    try {
                        if (this.readFile.get(i - 1)[j + 1] == 'M' && this.readFile.get(i - 2)[j + 2] == 'A' && this.readFile.get(i - 3)[j + 3] == 'S') {
                            xmasCount++;
                        }

                    } catch (Exception e) {
                    }

                }
            }
        }
        return "" + xmasCount;
    }

    @Override
    protected String solvePart2() {

        int xMASCount = 0;

        for (int i = 0; i < this.readFile.size(); i++) {

            for (int j = 0; j < this.readFile.get(i).length; j++) {
                if (this.readFile.get(i)[j] == 'A') {
                    try {
                        if (this.readFile.get(i - 1)[j - 1] == 'M' && this.readFile.get(i + 1)[j + 1] == 'S' || this.readFile.get(i + 1)[j + 1] == 'M' && this.readFile.get(i - 1)[j - 1] == 'S') {
                            if (this.readFile.get(i + 1)[j - 1] == 'M' && this.readFile.get(i - 1)[j + 1] == 'S' || this.readFile.get(i - 1)[j + 1] == 'M' && this.readFile.get(i + 1)[j - 1] == 'S') {
                                xMASCount++;
                            }
                        }
                    } catch (Exception e) {
                    }
                }
            }

        }
        return "" + xMASCount;
    }
}
