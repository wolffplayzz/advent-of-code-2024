import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class Day01 extends Template{

    private ArrayList<Integer> list1 = new ArrayList<>();
    private ArrayList<Integer> list2 = new ArrayList<>();
    
    @Override
    protected void readFile() {
        try{
            Scanner sc = new Scanner(new File("data/day01.txt"));
            String[] temp;
            String line;
            while(sc.hasNextLine()){
                line = sc.nextLine();
                if (line.length() != 0){ //if the line is empty it will cause NumberFormatException
                    temp = line.split("   ");
                    this.list1.add(Integer.valueOf(temp[0]));
                    this.list2.add(Integer.valueOf(temp[1]));
                }
            }sc.close();
        }catch(Exception e){
            e.printStackTrace(); //just log it for now
        }
    }

    @Override
    protected String solvePart1() {
        Collections.sort(this.list1);
        Collections.sort(this.list2);        
        int distanceTotal = 0;

        for (int i = 0; i < this.list1.size(); i++){
            int temp = this.list1.get(i) - this.list2.get(i);
            if (temp < 0){
                distanceTotal-= temp;
            }
            else {
                distanceTotal+= temp;
            }
        }

        return "" + distanceTotal;
    }

    @Override
    protected String solvePart2() {
        int end = 0;
        for (int i = 0; i < this.list1.size(); i++){
            int toTest = this.list1.get(i);
            int counter = 0;

            for (int j = 0; j < this.list2.size(); j++){
                if (toTest == this.list2.get(j)){
                    counter++;
                }
            }
            end += toTest * counter;
        }
        return "" + end;
    }
}