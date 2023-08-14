
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Strongest
 */
public class InputManager {

    //get choice input from user
    public static int getOption(String message, int min, int max) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print(message);
                String input = scanner.nextLine();
                //if input is empty then tell user
                if (input.isEmpty()) {
                    System.out.println("Input cannot be empty !!!");
                } else {
                    int number = Integer.parseInt(input);
                    //if number in range then return number
                    //else tell user number must in range
                    if (min <= number && number <= max) {
                        return number;
                    } else {
                        System.out.println("Input must in range from "
                                + min + " to " + max);
                    }

                }
            } //if string is not number
            catch (NumberFormatException e) {
                System.out.println("Wrong format!");
            }
        }

    }

    // get string input from user
    public static String getInput(int inputBase) {
        Scanner scanner = new Scanner(System.in);
        String regex = "";
        String message = "";
        String error = "";
        switch (inputBase) {
            case 1:
                //[0-1] matches with character from the range 0 to 1
                //+ matches with one or more character        
                message = "Input binary number:";
                error = "Binary number only contain 0 and 1";
                regex = "[0-1]+";
                break;
            case 2:
                //[0-9] matches with character from range 0 to 9
                //+ matches with one or more character
                message = "Input decimal number:";
                error = "Decimal only contain digit";
                regex = "[0-9]+";
                break;
            case 3:
                //[0-9A-Fa-f] matches with character from range 0 to 9,A to F, and a to f
                //+ matches with one or more character
                message = "Input hexadecimal number:";
                error = "It must contain 0-9 and A-F";
                regex = "[0-9a-fA-F]+";
                break;
        }
        //loop until user enter correct input
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();
            //if input is empty print error:
            if (input.isEmpty()) {
                System.out.println("Input cannot be empty !!!");
            } //if input matches with regex then return input
            else if (input.matches(regex)) {
                //any lower case character return to upper case character
                return input.toUpperCase();
            } //if input is not matches with regex
            else {
                System.out.println(error);
            }
        }
    }
}
