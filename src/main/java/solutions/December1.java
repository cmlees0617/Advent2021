package solutions;

import java.util.Scanner;
import java.io.*;

public class December1 {
    public static void main(String[] args) {
        try{
            Scanner scan = new Scanner(
                new File("C:\\Users\\Caleb Lees\\Documents\\NetBeansProjects\\Advent_Of_Code_2021\\December1_input.txt"));
            Integer prevPrev = scan.nextInt();
            Integer prev = scan.nextInt();
            Integer curr = scan.nextInt();
        
            int currSum = prevPrev + prev + curr;
            int prevSum;
        
            int sumIncrease = 0;
        
            while (scan.hasNext()) {
                prevPrev = prev;
                prev = curr;
                curr = scan.nextInt();

                prevSum = currSum;
                currSum = prevPrev + prev + curr;

                if (currSum > prevSum) {
                    sumIncrease++;
                }
            }
            
            System.out.println(sumIncrease);
        }
        catch(FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}
