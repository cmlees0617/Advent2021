package solutions;

import java.util.Scanner;
import java.io.*;

public class December5 {
    public static void main(String[] args) {
        try{
            Scanner scan = new Scanner(
                new File(".\\src\\December5_input.txt"));
            
            // initialize plane
            Integer[][] plane = new Integer[1000][1000];
            for (int i = 0; i < 1000; i++) {
                for (int j = 0; j < 1000; j++) {
                    plane[i][j] = 0;
                }
            }
            
            while (scan.hasNextLine()) {
                String line = scan.nextLine().replaceAll(",", " ");
                Scanner lineScan = new Scanner(line.replaceAll("->", " "));
                
                // get coordinate values
                Integer startX = lineScan.nextInt();
                Integer startY = lineScan.nextInt();
                Integer endX = lineScan.nextInt();
                Integer endY = lineScan.nextInt();
                
                // make coordinates
                Coord start = new Coord(startX, startY);
                Coord end = new Coord(endX, endY);
                
                // if horizontal or vertical, fill in marked coordinates
                if (isHorizontal(start, end)) {
                    for (int i = Math.min(start.y, end.y); i <= Math.max(start.y, end.y); i++) {
                        plane[start.x][i]++;
                    } 
                }
                else if (isVertical(start, end)) {
                    for (int i = Math.min(start.x, end.x); i <= Math.max(start.x, end.x); i++) {
                        plane[i][start.y]++;
                    } 
                }
                
                // if diagonal, fill in marked coordinates
                else {
                    // switch start and end so we iterate from left to right
                    if (start.x > end.x) {
                        Coord temp = start;
                        start = end;
                        end = temp;
                    }
                    
                    int horIter = start.x;
                    int vertIter = start.y;
                    if (start.y < end.y) {
                        while (horIter <= end.x) {
                            plane[horIter][vertIter]++;
                            horIter++;
                            vertIter++;
                        }
                    }
                    else {
                        while (horIter <= end.x) {
                            plane[horIter][vertIter]++;
                            horIter++;
                            vertIter--;
                        }
                    }
                } 
            }
            
            // find number of intersections
            int numIntersect = 0;
            for (int i = 0; i < 1000; i++) {
                for (int j = 0; j < 1000; j++) {
                    if (plane[i][j] > 1) {
                        numIntersect++;
                    }
                }
            }
            
            System.out.println(numIntersect);
        }
        catch(FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
    
    private static boolean isHorizontal(Coord start, Coord end) {
        return start.x == end.x;
    }
    
    private static boolean isVertical(Coord start, Coord end) {
        return start.y == end.y;
    }
    
    // nested coordinate class
    private static class Coord {
        public int x;
        public int y;
        
        public Coord(int xIn, int yIn) {
            x = xIn;
            y = yIn;
        }
    }
}



