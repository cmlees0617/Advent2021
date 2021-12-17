package solutions;

import java.util.Scanner;
import java.io.*;
import java.util.*;

public class December8 {
    public static void main(String[] args) {
        try{
            Scanner scan = new Scanner(
                new File(".\\src\\December8_input.txt"));
            
            Long sum = 0l;
            while (scan.hasNext()) {
                // get second half of each line
                String line = scan.nextLine();
                int index = line.indexOf("|");
                String line1 = line.substring(0, index - 1);
                String line2 = line.substring(index + 2, line.length());
                
                // decode the input digits
                Scanner line1Scan = new Scanner(line1);
                UnscramblePair[] pairs = new UnscramblePair[10];
                
                for (int i = 0; i < 10; i++) {
                    String curr = line1Scan.next();
                    pairs[i] = determineDigits(curr);
                }
                
                pairs = unscramble(pairs);
                
                // alphabetize 
                for (UnscramblePair p : pairs) {
                    p.wires = alphabetize(p.wires);
                }
                
                // decode the output digits
                Scanner line2Scan = new Scanner(line2);
                String[] output = new String[4];
                for (int i = 0; i < 4; i++) {
                    output[i] = alphabetize(line2Scan.next());
                }
                
                String digit = "";
                for (String s : output) {
                    for (UnscramblePair p : pairs) {
                        String wire = p.wires;
                        if (wire.equals(s)) {
                            digit += p.digits.get(0).toString();
                            break;
                        }
                    }
                }
                sum += Integer.parseInt(digit);
            }
            System.out.println(sum);
        }
        catch(FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
    
    private static UnscramblePair determineDigits(String s) {
        ArrayList<Integer> digits = new ArrayList();
        int len = s.length();
        switch (len) {
            case 2 -> digits.add(1);
            case 3 -> digits.add(7);
            case 4 -> digits.add(4);
            case 5 -> {
                digits.add(2);
                digits.add(3);
                digits.add(5);
            }
            case 6 -> {
                digits.add(0);
                digits.add(6);
                digits.add(9);
            }
            case 7 -> digits.add(8);
        }
        
        return new UnscramblePair(s, digits);
    }
    
    private static UnscramblePair[] unscramble(UnscramblePair[] pairs) {
        String oneTop = null;
        String oneBottom = null;
        int fourIndex = -1;
        
        ArrayList<Integer> fiveIndexes = new ArrayList();
        ArrayList<Integer> sixIndexes = new ArrayList();
        
        for (int i = 0; i < 10; i++) {
            UnscramblePair curr = pairs[i];
            
            // populate list of length-five strings
            if (curr.wires.length() == 5) {
                fiveIndexes.add(i);
            }
            
            // populate list of length-six strings
            else if (curr.wires.length() == 6) {
                sixIndexes.add(i);
            }
            
            // save segement values of 'one'
            else if (curr.digits.get(0).equals(1)) {
                // guess the top and bottom segements of 'one'
                oneTop = String.valueOf(curr.wires.charAt(0));
                oneBottom = String.valueOf(curr.wires.charAt(1));
            }
            else if (curr.digits.get(0).equals(4)) {
                fourIndex = i;
            }
        }
        
        // identify 'three'
        if (intersect(pairs[fiveIndexes.get(0)].wires, pairs[fiveIndexes.get(1)].wires).length() == 3) {
            pairs[fiveIndexes.get(2)].digits.remove((Integer)2);
            pairs[fiveIndexes.get(2)].digits.remove((Integer)5);
            pairs[fiveIndexes.get(0)].digits.remove((Integer)3);
            pairs[fiveIndexes.get(1)].digits.remove((Integer)3);
            fiveIndexes.remove(2);
        }
        else if (intersect(pairs[fiveIndexes.get(0)].wires, pairs[fiveIndexes.get(2)].wires).length() == 3) {
            pairs[fiveIndexes.get(1)].digits.remove((Integer)2);
            pairs[fiveIndexes.get(1)].digits.remove((Integer)5);
            pairs[fiveIndexes.get(0)].digits.remove((Integer)3);
            pairs[fiveIndexes.get(2)].digits.remove((Integer)3);
            fiveIndexes.remove(1);
        }
        else {
            pairs[fiveIndexes.get(0)].digits.remove((Integer)2);
            pairs[fiveIndexes.get(0)].digits.remove((Integer)5);
            pairs[fiveIndexes.get(1)].digits.remove((Integer)3);
            pairs[fiveIndexes.get(2)].digits.remove((Integer)3);
            fiveIndexes.remove(0);
        }
        
        // identify 'six'
        if (!pairs[sixIndexes.get(0)].wires.contains(oneTop) || !pairs[sixIndexes.get(0)].wires.contains(oneBottom)) {
            pairs[sixIndexes.get(0)].digits.remove((Integer)0);
            pairs[sixIndexes.get(0)].digits.remove((Integer)9);
            pairs[sixIndexes.get(1)].digits.remove((Integer)6);
            pairs[sixIndexes.get(2)].digits.remove((Integer)6);
            sixIndexes.remove(0);
        }
        else if (!pairs[sixIndexes.get(1)].wires.contains(oneTop) || !pairs[sixIndexes.get(1)].wires.contains(oneBottom)) {
            pairs[sixIndexes.get(1)].digits.remove((Integer)0);
            pairs[sixIndexes.get(1)].digits.remove((Integer)9);
            pairs[sixIndexes.get(0)].digits.remove((Integer)6);
            pairs[sixIndexes.get(2)].digits.remove((Integer)6);
            sixIndexes.remove(1);
        }
        else if (!pairs[sixIndexes.get(2)].wires.contains(oneTop) || !pairs[sixIndexes.get(2)].wires.contains(oneBottom)) {
            pairs[sixIndexes.get(2)].digits.remove((Integer)0);
            pairs[sixIndexes.get(2)].digits.remove((Integer)9);
            pairs[sixIndexes.get(0)].digits.remove((Integer)6);
            pairs[sixIndexes.get(1)].digits.remove((Integer)6);
            sixIndexes.remove(2);
        }
        
        // identify 'nine' and 'zero'
        if (intersect(pairs[sixIndexes.get(0)].wires, pairs[fourIndex].wires).length() == 4) {
            pairs[sixIndexes.get(0)].digits.remove((Integer)0);
            pairs[sixIndexes.get(1)].digits.remove((Integer)9);
            sixIndexes.remove(0);
        }
        else {
            pairs[sixIndexes.get(1)].digits.remove((Integer)0);
            pairs[sixIndexes.get(0)].digits.remove((Integer)9);
            sixIndexes.remove(1);
        }
        
        // identify 'two' and 'five'
        if (intersect(pairs[fiveIndexes.get(0)].wires, pairs[fourIndex].wires).length() == 3) {
            pairs[fiveIndexes.get(0)].digits.remove((Integer)2);
            pairs[fiveIndexes.get(1)].digits.remove((Integer)5);
            fiveIndexes.remove(0);
        }
        else {
            pairs[fiveIndexes.get(1)].digits.remove((Integer)2);
            pairs[fiveIndexes.get(0)].digits.remove((Integer)5);
            fiveIndexes.remove(1);
        }
        
        // at this point, each list of digits in pairs should only contain one
        // element. If this is not the case, something went wrong; will throw
        // the following exception:
        for (UnscramblePair p : pairs) {
            if (p.digits.size() != 1) {
                throw new RuntimeException("NOT UNSCRAMBLED CORRECTLY");
            }
        }
        
        return pairs;
    }
    
    private static String intersect(String firstString, String secondString) {
        char[] firstStringToCharArray = firstString.replaceAll("\\s+", "").toCharArray();
        char[] secondStringToCharArray = secondString.replaceAll("\\s+", "").toCharArray();
        Set<Character> firstStringSet = new TreeSet<>();
        Set<Character> secondStringSet = new TreeSet<>();
         
        for (char c : firstStringToCharArray) {
            firstStringSet.add(c);
        }
         
        for (char c : secondStringToCharArray){
            secondStringSet.add(c);
        }
        
        firstStringSet.retainAll(secondStringSet); 
        
        // convert intersection set to a char array
        String intersection = "";
        if (firstStringSet.contains('a')) {
            intersection += "a";
        }
        if (firstStringSet.contains('b')) {
            intersection += "b";
        }
        if (firstStringSet.contains('c')) {
            intersection += "c";
        }
        if (firstStringSet.contains('d')) {
            intersection += "d";
        }
        if (firstStringSet.contains('e')) {
            intersection += "e";
        }
        if (firstStringSet.contains('f')) {
            intersection += "f";
        }
        if (firstStringSet.contains('g')) {
            intersection += "g";
        }
        
        return intersection;
    }
    
    private static String alphabetize(String s) {
        char[] tempArray = s.toCharArray();
        Arrays.sort(tempArray);
        return new String(tempArray);
    }
    
    private static class UnscramblePair {
        public String wires;
        public ArrayList<Integer> digits;
        
        public UnscramblePair(String s, ArrayList<Integer> d) {
            wires = s;
            digits = d;
        } 
    }
}
