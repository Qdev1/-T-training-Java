
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    /**
     * This method will accept a string and prints the words in opposite order,
     * capital letter at begin of sentence.
     *
     * @param string is an string parameter
     */
    public static void printReverse(String string) {
        Scanner sc = new Scanner(System.in);
        while (string.trim().isEmpty()) {
            System.out.print("input string : ");
            string = sc.nextLine();
        }
        String sentences[] = string.trim().split("\\."); //split string into sentences at dot
        StringBuilder resultAfterProcessing = new StringBuilder(); // save the result after processing sentences
        for (int i = sentences.length - 1; i >= 0; i--) {
            if (sentences[i].length() != 0) {
                String tempWords[] = sentences[i].trim().split("\\s+"); // separate sentences to words at spaces
                for (int j = tempWords.length - 1; j >= 0; j--) {
                    if (tempWords.length - 1 == j) {
                        // if it's the first word, replace the first lowercase character with uppercase
                        resultAfterProcessing.append(tempWords[j].replace(tempWords[j].charAt(0),
                                tempWords[j].substring(0, 1).toUpperCase().charAt(0))).append(" ");
                    } else if (j == 0) {
                        // if it's the last word, don't add spaces
                        resultAfterProcessing.append(tempWords[j]);
                    } else {
                        // add a space after each word if it's not a last word
                        resultAfterProcessing.append(tempWords[j]).append(" ");
                    }
                }
            }
            //if end string with dot, keep the dot position 
            if (string.endsWith(".")) {
                resultAfterProcessing.append(". ");
            } else {
                //end of the string append a dot
                if (i != 0) {
                    resultAfterProcessing.append(". ");
                }
            }
        }
        System.out.println("Result is: " + resultAfterProcessing);
    }

    /**
     * This is the main method to run the program.
     *
     * @param args
     */
    public static void main(String[] args) {
        printReverse(" ");
    }
}
