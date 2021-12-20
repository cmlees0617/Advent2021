package solutions;

import java.util.Scanner;
import java.io.*;
import java.util.*;

public class December10 {
    public static void main(String[] args) {
        try{
            Scanner scan = new Scanner(
                new File(".\\src\\December10_input.txt"));
            
            ArrayList<Long> scores = new ArrayList();
            ArrayList<String> lines = new ArrayList();
            
            // put all lines into an arraylist
            while (scan.hasNext()) {
                lines.add(scan.nextLine());
            }
            
            // remove coprrupted lines
            boolean loopDone = false;
            while (!loopDone) {
                System.out.println(lines.size());
                int i;
                loop:
                for (i = 0; i < lines.size(); i++) {
                    String line = lines.get(i);
                    Scanner lineScan = new Scanner(line).useDelimiter("");

                    Stack<String> stack = new Stack();
                    
                    
                    while (lineScan.hasNext()) {
                        String curr = lineScan.next();
                        if (isOpening(curr)) {
                            stack.push(curr);
                        }
                        else {
                            String open = stack.pop();
                            
                            // delete any corrupted lines
                            if (!isLegal(open, curr)) {
                                lines.remove(i);
                                break loop;
                            }
                        }
                    }
                }
                
                if (i == lines.size() - 1) {
                    loopDone = true;
                }
            }
            
            for (String s : lines) {
                Scanner lineScan = new Scanner(s).useDelimiter("");
                
                Stack<String> stack = new Stack();
                while (lineScan.hasNext()) {
                    String curr = lineScan.next();
                    if (isOpening(curr)) {
                        stack.push(curr);
                    }
                    else {
                        String open = stack.pop();
                        // ignore corrupted lines
                        if (!isLegal(open, curr)) {
                            break;
                        }
                    }
                }
                
                // copy all remaining opening delimeters into an arraylist (in reverse order)
                ArrayList<String> leftovers = new ArrayList();
                while (!stack.isEmpty()) {
                    leftovers.add(stack.pop());
                }
                scores.add(score(complete(leftovers)));
            }
            
            System.out.println(median(scores));
        }
        catch(FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
    
    private static boolean isOpening(String s) {
        return s.equals("(") || s.equals("[") || s.equals("{") || s.equals("<");
    }
    
    private static boolean isLegal(String open, String close) {
        boolean legal = false;
        switch(open) {
            case "(" -> {
                if (close.equals(")")) {
                    legal = true;
                }
            }
            case "[" -> {
                if (close.equals("]")) {
                    legal = true;
                }
            }
            case "{" -> {
                if (close.equals("}")) {
                    legal = true;
                }
            }
            case "<" -> {
                if (close.equals(">")) {
                    legal = true;
                }
            }
        }
        return legal;
    }
    
    private static Long penalty(String s) {
        Long penalty = 0l;
        switch(s) {
            case ")" -> penalty = 1l;
            case "]" -> penalty = 2l;
            case "}" -> penalty = 3l;
            case ">" -> penalty = 4l;
        }
        
        return penalty;
    }
    
    private static ArrayList<String> complete(ArrayList<String> list) {
        ArrayList newArr = new ArrayList();
        for (String s : list) {
            newArr.add(complement(s));
        }
        
        return newArr;
    }
    
    private static String complement(String open) {
        String close = null;
        
        switch(open) {
            case "(" -> close = ")";
            case "[" -> close = "]";
            case "{" -> close = "}";
            case "<" -> close = ">";
        }
        
        return close;
    }
    
    private static Long score(ArrayList<String> arr) {
        Long score = 0l;
        
        for (String s : arr) {
            score *= 5;
            score += penalty(s);
        }
        
        return score;
    }
    
    private static Long median(ArrayList<Long> arr) {
        Collections.sort(arr);
        return arr.get((arr.size() - 1)/ 2);
    }
}
