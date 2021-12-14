package solutions;

import java.util.Scanner;
import java.io.*;
import java.util.*;

public class December6 {
    public static void main(String[] args) {
        try{
            Scanner scan = new Scanner(
                new File(".\\src\\December6_input.txt"));
            
            String line = scan.nextLine().replaceAll(",", " ");
            
            Scanner scanLine = new Scanner(line);
            
            ArrayList<Long> fish = new ArrayList();
            for (int i = 0; i < 10; i++) {
                fish.add(0l);
            }
            
           while (scanLine.hasNextInt()) {
               int curr = scanLine.nextInt();
               fish.set(curr, fish.get(curr) + 1);
           }
           
           for (int i = 1; i <= 256; i++) {
               Long dueFish = fish.remove(0);
               fish.set(6, fish.get(6) + dueFish);
               fish.set(8, fish.get(8) + dueFish);
               fish.add(0l);
           }
           
           // sum over all elements in fish arraylist
           Long sum = 0l;
           for (Long i : fish) {
               sum += i;
           }
           
           System.out.println(sum);
        }
        catch(FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}



