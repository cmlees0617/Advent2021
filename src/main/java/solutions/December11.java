package solutions;

import java.util.Scanner;
import java.io.*;
import java.util.*;

public class December11 {
    private static ArrayList<ArrayList<Octopus>> octopi;
    private static Long numFlashes;
    private static final int NUM_ITERATIONS = 100;
    
    public static void main(String[] args) {
        try{
            Scanner scan = new Scanner(
                new File(".\\src\\December11_input.txt"));
            
            octopi = new ArrayList();
            numFlashes = 0l;
            
            int colIndex = 0;
            while (scan.hasNext()) {
                int rowIndex = 0;
                ArrayList<Octopus> curr = new ArrayList();
                String line = scan.nextLine();
                Scanner lineScan = new Scanner(line).useDelimiter("");
                
                while (lineScan.hasNext()) {
                    Octopus oct = new Octopus(lineScan.nextInt(), new Coord(rowIndex, colIndex));
                    curr.add(oct);
                    rowIndex ++;
                }
                
                octopi.add(curr);
                colIndex++;
            }
            
            /* THIS WAS USED FOR PART I
            for (int i = 0; i < NUM_ITERATIONS; i++) {
                calculateFlashes();
            }
            */
            
            // run a loop to check for synchronization
            int stepCounter = 0;
            while (true) {
                stepCounter++;
                calculateFlashes();
                if (isSynchronized()) {
                    break;
                }
            }
            
            printOctopi();
            System.out.println("\n" + "FIRST SYNCHRONIZATION STEP:" + stepCounter);
        }
        catch(FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
    
    private static void calculateFlashes() {
        // increase energy level of each octopus by 1
        for (ArrayList<Octopus> row : octopi) {
            for (Octopus p : row) {
                increment(p.loc);
            }
        }
        
        // all octopi with energy greater than 9 perform "flash" routine
        for (ArrayList<Octopus> row : octopi) {
            for (Octopus p : row) {
                checkFlash(p);
            }
        }
        
    }
    
    private static void checkFlash(Octopus p) {
        // if my energy is greater than 9 and I have not already flashed during
        // this step, do the flash routine 
        if (p.energy > 9 && !octopi.get(p.loc.y).get(p.loc.x).justFlashed) {
            numFlashes++;
            doFlash(p);
            reset(p.loc);
        }
    }
    
    private static void doFlash(Octopus p) {
        // tell everyone that I flashed
        octopi.get(p.loc.y).get(p.loc.x).justFlashed = true;
        
        int x = p.loc.x;
        int y = p.loc.y;
        
        // store adjacent locations in an arraylist
        Coord up = new Coord(x, y - 1);
        Coord down = new Coord(x, y + 1);
        Coord left = new Coord(x - 1, y);
        Coord right = new Coord(x + 1, y);
        Coord upLeft = new Coord(x - 1, y - 1);
        Coord upRight = new Coord(x + 1, y - 1);
        Coord downLeft = new Coord(x - 1, y + 1);
        Coord downRight = new Coord(x + 1, y + 1);
        
        ArrayList<Coord> adjacents = new ArrayList();
        adjacents.add(right);
        adjacents.add(upRight);
        adjacents.add(up);
        adjacents.add(upLeft);
        adjacents.add(left);
        adjacents.add(downLeft);
        adjacents.add(down);
        adjacents.add(downRight);
        
        // increment energy of all valid adjacent octopi (including diagonals)
        for (Coord loc : adjacents) {
            if (isValid(loc) && octopi.get(loc.y).get(loc.x).energy != 0) {
                increment(loc);
            }
        }
        
        // check for flashes in adjacent octopi
        for (Coord loc : adjacents) {
            if (isValid(loc)) {
                checkFlash(octopi.get(loc.y).get(loc.x));
            }
        }
    }
    
    private static boolean isValid(Coord loc) {
        boolean valid = false;
        if (loc.x > -1 && loc.x < octopi.get(0).size()) {
            if (loc.y > -1 && loc.y < octopi.size()) {
                valid = true;
            }
        }
        return valid;
    }
    
    private static void increment(Coord loc) {
        octopi.get(loc.y).get(loc.x).energy++;
    }
    
    private static void reset(Coord loc) {
        octopi.get(loc.y).get(loc.x).energy = 0;
        octopi.get(loc.y).get(loc.x).justFlashed = false;
    }
    
    public static boolean isSynchronized() {
        boolean inSync = true;
        
        // if all octopus energies are simultaneously 0, we are synchronized
        for (ArrayList<Octopus> row : octopi) {
            for (Octopus p : row) {
                if (p.energy != 0) {
                    inSync = false;
                    break;
                }
            }
        }
        
        return inSync;
    }
    
    private static void printOctopi() {
        for (ArrayList<Octopus> row : octopi) {
            for (Octopus p : row) {
                System.out.print(p.energy);
            }
            System.out.println();
        }
    }
    
    private static class Coord {
        public int x;
        public int y;
        
        public Coord(int xIn, int yIn) {
            x = xIn;
            y = yIn;
        }
    }
    
    private static class Octopus {
        public Integer energy;
        public final Coord loc;
        public boolean justFlashed;
        
        public Octopus(Integer e, Coord l) {
            energy = e;
            loc = l;
            justFlashed = false;
        }
    }
}
