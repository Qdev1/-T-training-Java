

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Strongest
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //loop until user exit the program
        while(true){
            //Required user choose the base number input 
            int inputBase = getBase("INPUT");
            //Required user choose the base number out
            int outputBase = getBase("OUTPUT");
            //Required user enter the input value
            String input = InputManager.getInput(inputBase);
            //Program process 
            String result = ConvertManager.convert(input, inputBase, outputBase);
            //and print output value
            printResult(result);
            
        }
    }
    //display interface and call user input choice
    public static int getBase(String message) {        
    while(true){
        System.out.println("CHOOSE " + message + " BASE NUMBER");
        System.out.println("1. Binary");
        System.out.println("2. Decimal");
        System.out.println("3. Hexadecimal");
        System.out.println("4. Exit");
        int option = InputManager.getOption("Enter choice:", 1, 4);
        switch(option){
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                System.exit(0);
                break;
        }
        }  
    }
    //display converted result
    private static void printResult(String result) {
        System.out.println("Result:" + result);
        System.out.println("");
    }
}
