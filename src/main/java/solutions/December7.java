package solutions;

import java.util.Scanner;
import java.io.*;
import java.util.*;

public class December7 {
    public static void main(String[] args) {
        try{
            Scanner scan = new Scanner(
                new File(".\\src\\December7_input.txt"));
            
            String line = scan.nextLine().replaceAll(",", " ");
            Scanner lineScan = new Scanner(line);
            
            // initialize arraylist of horizontal positions
            ArrayList<Integer> positions = new ArrayList();
            int num = 0;
            while (lineScan.hasNextDouble()) {
                Integer curr = lineScan.nextInt();
                positions.add(curr);
                num++;
            }
            
            // for each i, pretend i is the position to move toward
            ArrayList<Integer> costs = new ArrayList();
            for (int i = 0; i < num; i++) {
                int currCost = 0;
                for (int j : positions) {
                    int dist = Math.abs(j - i);
                    currCost += (dist*(dist+1))/2;
                }
                costs.add(currCost);
            }
            
            System.out.println(findMinCost(costs));
            
        }
        catch(FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
    
    private static int findMinCost(ArrayList<Integer> costs) {
        int minCost = costs.get(0);
        for (int i : costs) {
            if (i < minCost) {
                minCost = i;
            }
        }
        return minCost;
    }
}



