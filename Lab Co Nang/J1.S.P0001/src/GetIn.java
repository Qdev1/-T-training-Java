
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author duong
 */
public class GetIn {
     private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
     //check input of user from keyboard
    public static int checkInput() {
        // check until use input right
        while (true) {
            try {
                System.out.println("Enter number of arrray: ");
                int num;
                num = Integer.parseInt(in.readLine());
                if (1 <= num && num <= 100) {
                    return num;
                } else {
                    System.out.println("Number inrange [" + "1" + " - " + "100" + "]");
                }
            } catch (IOException | NumberFormatException ex) {
                System.err.println("Number of arrray is a positive integer. Please enter again!");
            }
        }
    }
}

