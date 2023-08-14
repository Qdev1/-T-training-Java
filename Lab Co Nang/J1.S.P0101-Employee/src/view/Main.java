/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;


public class Main {
    public static void main(String[] args) {
        View_Employee view = new View_Employee();
        while (true) {
            displayMenu();
            int option = Ultility.getInt("Option: ", "Wrong", 1, 6);
            switch (option) {
                case 1:
                    //1. input employee
                    view.inputEmployee();
                    break;
                case 2:
                    //2. update employee
                    view.update();
                    break;
                case 3:
                    //3. remove employee
                    view.remove();
                    break;
                case 4:
                    //4. search employee
                    view.search();
                    break;
                case 5:
                    //5. sort by salary
                    view.sort();
                    break;
                case 6:
                    System.exit(0);
                    break;

            }
        }

    }

    private static void displayMenu() {
        System.out.println("============================ MENU ============================");
        System.out.println("1.	Add employees \n"
                + "2.	Update employees\n"
                + "3.	Remove employees\n"
                + "4.	Search employees\n"
                + "5.	Sort employees by salary\n"
                + "6.	Exit\n"
                + "");
    }
    
}
