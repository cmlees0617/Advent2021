package solutions;

import java.util.Scanner;

public class December2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int hor = 0;
        int depth = 0;
        int aim = 0;
        
        while(scan.hasNext()) {
            String curr = scan.next();
            if (curr.equals("forward")) {
                int i = scan.nextInt();
                hor += i;
                depth += aim * i;
                System.out.println("forward: " + hor + " " + depth);
            }
            else if (curr.equals("down")) {
                aim += scan.nextInt();
                System.out.println("aim: " + aim);
            }
            else if (curr.equals("up")) {
                aim -= scan.nextInt();
                System.out.println("aim: " + aim);
            }
            else {
                throw new RuntimeException("EXPLODED");
            }
        }
    }
}
