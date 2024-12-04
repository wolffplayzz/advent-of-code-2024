
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Day04 extends Template{

    private ArrayList<char[]> readFile = new ArrayList<>();

    @Override
    protected void readFile() {
        try {
            Scanner sc = new Scanner(new File("data/day02.txt"));
            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                if (!line.isEmpty()) {
                    char [] temp = new char[line.length()];
                    for (int i = 0; i < line.length(); i++){
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

        for (int i = 0; i < this.readFile.size(); i++){
            
            for (int j = 0; j < this.readFile.get(i).length; j++){
                if (this.readFile.get(i)[j] == 'X'){
                    if(this.readFile())
                }
            }
        }
    }

    @Override
    protected String solvePart2() {
        throw new UnsupportedOperationException("Not supported yet.");
    }


}