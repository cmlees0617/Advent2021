package solutions;

import java.util.Scanner;
import java.io.*;
import java.util.*;

public class December9 {
    public static void main(String[] args) {
        try{
            Scanner scan = new Scanner(
                new File(".\\src\\December9_input.txt"));
            
            ArrayList<ArrayList<Pair>> floor = new ArrayList();
            
            // copy file data into floor ArrayList
            while (scan.hasNext()) {
                String line = scan.nextLine();
                ArrayList<Pair> curr = new ArrayList();
                Scanner lineScan = new Scanner(line).useDelimiter("");
                
                while (lineScan.hasNext()) {
                    curr.add(new Pair(lineScan.nextInt(), false));
                }
                
                floor.add(curr);
            }
            
            ArrayList<Integer> basinSizes = new ArrayList();
            
            for (int i = 0; i < floor.size(); i++) {
                for (int j = 0; j < floor.get(i).size(); j++) {
                    if (isLowPoint(i, j, floor)) {
                        basinSizes.add(basinSize(i, j, floor));
                    }
                }
            }
            
            // find three largest basins, multiply their sizes
            Long prod = 1l;
            int largeBasins = 0;
            while (largeBasins < 3) {
                int largestIndex = 0;
                for (int i = 0; i < basinSizes.size(); i++) {
                    if (basinSizes.get(i) > basinSizes.get(largestIndex)) {
                        largestIndex = i;
                    }
                }
                prod *= basinSizes.get(largestIndex);
                basinSizes.remove(largestIndex);
                largeBasins++;
                System.out.println(prod);
            }
        }
        catch(FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
    
    private static boolean isLowPoint(int i, int j, ArrayList<ArrayList<Pair>> floor) {
        int curr = floor.get(i).get(j).value;
        int above = 10;
        int below = 10;
        int left = 10;
        int right = 10;

        if (i > 0) {
            above = floor.get(i - 1).get(j).value;
        }
        if (i < floor.size() - 1) {
            below = floor.get(i + 1).get(j).value;
        }
        if (j > 0) {
            left = floor.get(i).get(j - 1).value;
        }
        if (j < floor.get(i).size() - 1) {
            right = floor.get(i).get(j + 1).value;
        }
        
        return curr < above && curr < below && curr < left && curr < right;
    }
    
    private static int basinSize(int i, int j, ArrayList<ArrayList<Pair>> floor) {
        Coord curr = new Coord(i, j);
        Queue<Coord> q = new LinkedList();
        int size = 0;
        
        q.add(curr);
        while (!q.isEmpty()) {
            curr = q.remove();
            size++;
            Integer currHeight = floor.get(curr.x).get(curr.y).value;
            
            // search north
            if (curr.x > 0 && floor.get(curr.x - 1).get(curr.y).value != 9) {
                if (floor.get(curr.x - 1).get(curr.y).value > currHeight) {
                    if (!floor.get(curr.x - 1).get(curr.y).found) {
                        floor.get(curr.x - 1).get(curr.y).found = true;
                        q.add(new Coord(curr.x - 1, curr.y));
                    }
                }
            }
            
            // search south
            if (curr.x < floor.size() - 1 && floor.get(curr.x + 1).get(curr.y).value != 9) {
                if (floor.get(curr.x + 1).get(curr.y).value > currHeight) {
                    if (!floor.get(curr.x + 1).get(curr.y).found) {
                        floor.get(curr.x + 1).get(curr.y).found = true;
                        q.add(new Coord(curr.x + 1, curr.y));
                    }
                }
            }
            
            // search east
            if (curr.y > 0 && floor.get(curr.x).get(curr.y - 1).value != 9) {
                if (floor.get(curr.x).get(curr.y - 1).value > currHeight) {
                    if (!floor.get(curr.x).get(curr.y - 1).found) {
                        floor.get(curr.x).get(curr.y - 1).found = true;
                        q.add(new Coord(curr.x, curr.y - 1));
                    }
                }
            }
            
            // search west
            if (curr.y < floor.get(curr.x).size() - 1 && floor.get(curr.x).get(curr.y + 1).value != 9) {
                if (floor.get(curr.x).get(curr.y + 1).value > currHeight) {
                    if (!floor.get(curr.x).get(curr.y + 1).found) {
                        floor.get(curr.x).get(curr.y + 1).found = true;
                        q.add(new Coord(curr.x, curr.y + 1));
                    }
                }
            }
        }
        
        return size;
    }
    
    private static class Coord {
        public int x;
        public int y;
        
        public Coord(int xIn, int yIn) {
            x = xIn;
            y = yIn;
        }
    }
    
    private static class Pair {
        public Integer value;
        public Boolean found;
        
        public Pair(Integer v, Boolean f) {
            value = v;
            found = f;
        }
    }
}
