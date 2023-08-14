/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Ultility {
     //global
    static Scanner scanner = new Scanner(System.in);
    public static final String REGEX_STRING = "[a-zA-Z0-9 ]+";
    public static final String REGEX_PHONE = "[0][0-9]{9,10}";
    public static final String REGEX_YN = "[yYnN]";
    public static final String REGEX_EMAIL = "[\\w]+[@]([\\w]+[.]){1,2}[\\w]+";
    public static final String REGEX_DATE = "\\d{1,2}[/]\\d{1,2}[/]\\d{4}";

    public static int getInt(String message, String error, int min, int max) {
        String REGEX_NUMBER = "[0-9]+";
        while (true) {
            System.out.print(message);
            String result = scanner.nextLine();
            if (result.isEmpty()) {
                System.out.println("Input cannot be empty");
                //neu result khop voi cai regex => cho qua
                //neu khong khop (false )
            } else if (result.matches(REGEX_NUMBER) == false) {
                System.out.println(error);

            } else {

                try {
                    int number = Integer.parseInt(result);
                    if (number >= min && number <= max) {
                        return number;

                    } else {
                        System.out.println("number must in range from " + min + " to " + max);
                    }

                } catch (NumberFormatException e) {
                    System.out.println(error);

                }
            }
        }
    }

    public static float getFloat(String message, String error, float min, float max) {
        String REGEX_NUMBER = "[0-9.]+";
        while (true) {
            System.out.print(message);
            String result = scanner.nextLine();
            if (result.isEmpty()) {
                System.out.println("Input cannot be empty");
                //neu result khop voi cai regex => cho qua
                //neu khong khop (false )
            } else if (result.matches(REGEX_NUMBER) == false) {
                System.out.println(error);
            } else {

                try {
                    float number = Float.parseFloat(result);
                    if (number > min && number < max) {
                        return number;

                    } else {
                        System.out.println("number must in range from " + min + " to " + max);

                    }

                } catch (NumberFormatException e) {
                    System.out.println(error);

                }
            }
        }
    }

    public static double getDouble(String message, String error, double min, double max) {
        String REGEX_NUMBER = "[0-9.]+";
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine();
            //b1: check is empty
            if (input.isEmpty()) {
                System.out.println("Input cannot be empty");
            } else {
                try {
                    double number = Double.parseDouble(input);
                    //b2: check range
                    if (number < min || number > max) {
                        System.out.println("Input must be in range from " + min + " to " + max);
                    } //b3: check regex ???
                    else if (!input.matches(REGEX_NUMBER)) {
                        System.out.println(error);
                    } else {
                        return number;
                    }
                    //tuong trung cho viec parse loi 
                } catch (NumberFormatException e) {
                    System.out.println(error);
                }

            }
        }
    }

    public static String getString(String message, String error, String regex) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Input cannot be empty !!!");
            } else {
                if (input.matches(regex)) {
                    return input;
                } else {
                    System.out.println(error);
                }
            }
        }
    }

    public static String getDate(String message, String error, String regex) {
        Scanner scanner = new Scanner(System.in);
        while (true) {

            System.out.print(message);
            String input = scanner.nextLine(); //24/3/2022

            if (input.isEmpty()) {
                System.out.println("Input cannot be empty !!!");
            } else {
                if (!input.matches(regex)) {
                    System.out.println(error);
                } else {

                    try {
                        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                        dateFormat.setLenient(false);

                        Date dateInput = new Date();
                        //parse ra ngay thang nhap vao theo dung format
                        dateInput = dateFormat.parse(input);

                        //format ngay thang hien tai theo format 
                        Date currentDate = new Date();
                        String currentDatString = dateFormat.format(currentDate);
                        boolean ageEnough = checkAge(input, currentDatString);
                        if (ageEnough == false) {
                            System.out.println("You not old enough !!");
                        } else {
                            return input;
                        }

                    } catch (ParseException ex) {
                        System.out.println("Date does not exist !!!");
                    }

                }
            }
        }
    }

    private static boolean checkAge(String input, String currentDatString) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date firstDate = dateFormat.parse(input);
            Date secondDate = dateFormat.parse(currentDatString);
            
            long first = firstDate.getTime() / (60*60*24l*365*1000 );
            long second = secondDate.getTime() / (60*60*24l*365*1000 );
            
            //check greater than 16 
            if (second - first < 16) {
                return false;
            }else {
                return true;
            }

        } catch (ParseException ex) {
            return false;
        }

    }
}
