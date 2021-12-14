package solutions;

import java.util.*;
import java.io.*;

public class December4 {
    public static void main(String[] args) {
        try {
            Scanner scan = new Scanner(
                new File(".\\src\\December4_input.txt"));
            
            // WRITE SOLUTION HERE
            
            String drawString = scan.nextLine();
            
            // parse string of draws
            ArrayList<Integer> draws = new ArrayList();
            int front = 0;
            
            for (int i = 0; i < drawString.length(); i++) {
                if (drawString.charAt(i) == ',') {
                    String temp = drawString.substring(front, i);
                    draws.add(Integer.parseInt(temp));
                    front = i + 1;
                }
            }
            draws.add(75);
            
            // parse game boards
            ArrayList<Integer[][]> boards = new ArrayList();
            
            while (scan.hasNext()) {
                Integer[][] array = new Integer[5][5];
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        int curr = scan.nextInt();
                        if (curr != 0) {
                            array[i][j] = -curr;
                        }
                        else {
                            array[i][j] = -1000;
                        }
                    }
                }
                boards.add(array);
            }
            
            // for each board, draw numbers until it wins
            Integer[] numDraws = new Integer[75];
            Integer[] sums = new Integer[75];
            int maxDraws = -1;
            int maxIndex = -1;
            
            int minDraws = 10000;
            int minIndex = -1;
            
            for (int i = 0; i < 75; i++) {
                numDraws[i] = 0;
                sums[i] = 0;
                Integer[][] board = boards.get(i);
                loop:
                for (Integer draw : draws) {
                    numDraws[i]++;
                    for (int j = 0; j < 5; j++) {
                        for (int k = 0; k < 5; k++) {
                            if (draw.equals(-board[j][k])) {
                                board[j][k] = -board[j][k];
                                if (checkRow(board, j, k) != -1) {
                                    sums[i] += checkRow(board, j, k);
                                    break loop;
                                }
                                else if (checkCol(board, j, k) != -1) {
                                    sums[i] += checkCol(board, j, k);
                                    break loop;
                                }
                            }
                            else if (draw == 0 && board[j][k] == -1000) {
                                board[j][k] = 0;
                                if (checkRow(board, j, k) != -1) {
                                    sums[i] += checkRow(board, j, k);
                                    break loop;
                                }
                                else if (checkCol(board, j, k) != -1) {
                                    sums[i] += checkCol(board, j, k);
                                    break loop;
                                }
                            }
                        }
                    }
                }
                
                if (numDraws[i] < minDraws) {
                    minDraws = numDraws[i];
                    minIndex = i;
                }
                if (numDraws[i] > maxDraws) {
                    maxDraws = numDraws[i];
                    maxIndex = i;
                }
            }
        System.out.println("FIRST: " + sums[minIndex]);
        System.out.println("LAST: " + sums[maxIndex]);
    }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
    
    private static int checkRow(Integer[][] array, int row, int col) {
        boolean won = true;
        for (int i : array[row]) {
            if (i < 0) {
                won = false;
            }
        }
        
        if (won) {
            int sum = 0;
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (array[i][j] < 0) {
                        if (array[i][j] != -1000) {
                            sum += -array[i][j];
                        }
                    }
                }
            }
            sum *= array[row][col];
            return sum;
        }
        else {
            return -1;
        }
    }
    
    private static int checkCol(Integer[][] array, int row, int col) {
        boolean won = true;
        for (Integer[] a : array) {
            if (a[col] < 0) {
                won = false;
            }
        }
        
        if (won) {
            int sum = 0;
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (array[i][j] < 0) {
                        if (array[i][j] != -1000) {
                            sum += -array[i][j];
                        }
                    }
                }
            }
            sum *= array[row][col];
            return sum;
        }
        else {
            return -1;
        }
    }
}
