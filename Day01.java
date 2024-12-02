import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Day01{

    public static void main (String [] args){
        
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        try{
            Scanner sc = new Scanner(new File("/home/till-heinrichs/Documents/Projects/advent-of-code-2024/day01.txt"));
            String[] temp;
            String line;
            while(sc.hasNextLine()){
                line = sc.nextLine();
                if (line.length() != 0){ //if the line is empty it will cause NumberFormatException
                    temp = line.split("   ");
                    list1.add(Integer.valueOf(temp[0]));
                    list2.add(Integer.valueOf(temp[1]));
                }
            }sc.close();
        }catch(Exception e){
            e.printStackTrace(); //just log it for now
        }
        Collections.sort(list1);
        Collections.sort(list2);        
        int distanceTotal = 0;

        for (int i = 0; i < list1.size(); i++){
            int temp = list1.get(i) - list2.get(i);
            if (temp < 0){
                distanceTotal-= temp;
            }
            else {
                distanceTotal+= temp;
            }
        }

        System.out.println(distanceTotal);

        //part 2 
        int end = 0;
        for (int i = 0; i < list1.size(); i++){
            int toTest = list1.get(i);
            int counter = 0;

            for (int j = 0; j < list2.size(); j++){
                if (toTest == list2.get(j)){
                    counter++;
                }
            }
            end += toTest * counter;
        }
        System.out.println(end);
    }
}