package solutions;

import java.util.Scanner;
import java.io.File;

public class December1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
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
                System.out.println("increased " + sumIncrease);
            }
        }
        
    }
}
