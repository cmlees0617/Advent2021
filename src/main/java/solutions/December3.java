package solutions;

import java.io.*;
import java.util.*;

public class December3 {
    public static void main(String[] args) {
        try{
            Scanner scan = new Scanner(
                new File(".\\src\\December3_input.txt"));
            
            ArrayList<String> OGR = new ArrayList();
            ArrayList<String> CO2 = new ArrayList();

            while (scan.hasNext()) {
                String curr = scan.nextLine();
                OGR.add(curr);
                CO2.add(curr);
            }

            for (int i = 0; i < 12; i++) {
                int num1s = 0;
                int num0s = 0;
                int numElements = 0;

                for (String s : OGR) {
                    if (s != null) {
                        if (digit(s, i) == 1) {
                            num1s++;
                        }
                        else {
                            num0s++;
                        }
                        numElements++;
                    }
                }

                if (numElements == 1) {
                    break;
                }

                if (num1s >= num0s) {
                    for (int j = 0; j < OGR.size(); j++) {
                        if (OGR.get(j) != null) {
                            if (digit(OGR.get(j),i) == 0 && OGR.size() > 1) {
                                OGR.set(j, null);
                            }
                        }
                    }
                }
                else {
                    for (int j = 0; j < OGR.size(); j++) {
                        if (OGR.get(j) != null) {
                            if (digit(OGR.get(j),i) == 1 && OGR.size() > 1) {
                                OGR.set(j, null);
                            }
                        }
                    }
                }
            }

            for (int i = 0; i < 12; i++) {
                int num1s = 0;
                int num0s = 0;
                int numElements = 0;
                for (String s : CO2) {
                    if (s != null) {
                        if (digit(s, i) == 1) {
                            num1s++;
                        }
                        else {
                            num0s++;
                        }
                        numElements++;
                    }
                }

                if (numElements == 1) {
                    break;
                }

                if (num0s <= num1s) {
                    for (int j = 0; j < CO2.size(); j++) {
                        if (CO2.get(j) != null) {
                            if (digit(CO2.get(j),i) == 1 && CO2.size() > 1) {
                                CO2.set(j, null);
                            }
                        }
                    }
                }
                else {
                    for (int j = 0; j < CO2.size(); j++) {
                        if (CO2.get(j) != null) {
                            if (digit(CO2.get(j),i) == 0 && CO2.size() > 1) {
                                CO2.set(j, null);
                            }
                        }
                    }
                }
            }

            for (String s : OGR) {
                if (s != null) {
                    System.out.println(s);
                }
            }

            for (String s : CO2) {
                if (s != null) {
                    System.out.println(s);
                }
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
    
    private static int digit(String s, int i) {
            int d = 0;
            if (s.charAt(i) == '1') {
                return 1;
            }
            return d;
        }
    
}
