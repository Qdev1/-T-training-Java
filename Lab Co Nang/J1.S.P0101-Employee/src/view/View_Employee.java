/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ManageEmployee;
import java.util.List;
import model.Employee;

public class View_Employee {

    ManageEmployee manage = new ManageEmployee();

    /**
     * this function
     */
    void inputEmployee() {
        //b1: nhap thuoc tinh
        String id;
        do {
            id = getID();
            if (manage.checkDuplicate(id)) {
                System.out.println("ID was existed");
            } else {
                break;
            }

        } while (true);

        String firstName = getFirstName();
        String lastName = getLastName();
        String phone = getPhone();
        String email = getEmail();
        String address = getAddress();
        String DOB = getDOB();
        int sex = getSex();
        double salary = getSalary();
        String agency = getAgency();

        Employee employee = new Employee(id, firstName, lastName, phone, email, address, DOB, agency, salary, sex);
        manage.addEmployee(employee);
        System.out.println("Add successfull !!");

    }

    /**
     * this function use to get id from user input
     *
     * @return id
     */
    private String getID() {
        String id = Ultility.getString("Enter id: ", "Wrong", Ultility.REGEX_STRING);
        return id;
    }

    /**
     * this function use to get firstName from user input
     *
     * @return firstName
     */
    private String getFirstName() {
        String firstName = Ultility.getString("first name: ", "Error", Ultility.REGEX_STRING);
        return firstName;
    }

    /**
     * this function use to get lastName from user input
     *
     * @return lastName
     */
    private String getLastName() {
        String lastName = Ultility.getString("lastName: ", "Error", Ultility.REGEX_STRING);
        return lastName;
    }

    /**
     * this function use to get phone from user input
     *
     * @return phone
     */
    private String getPhone() {
        String phone = Ultility.getString("phone: ", "Error", Ultility.REGEX_PHONE);
        return phone;
    }

    /**
     * this function use to get email from user input
     *
     * @return email
     */
    private String getEmail() {
        String email = Ultility.getString("email: ", "Error", Ultility.REGEX_EMAIL);
        return email;
    }

    /**
     * this function use to get address from user input
     *
     * @return address
     */
    private String getAddress() {
        String address = Ultility.getString("address: ", "Error", Ultility.REGEX_STRING);
        return address;
    }

    /**
     * this function use to get DOB from user input
     *
     * @return DOB
     */
    private String getDOB() {
        String DOB = Ultility.getDate("DOB: ", "Error", Ultility.REGEX_DATE);
        return DOB;
    }

    /**
     * this function use to get agency from user input
     *
     * @return agency
     */
    private String getAgency() {
        String agency = Ultility.getString("agency: ", "Error", Ultility.REGEX_STRING);
        return agency;
    }

    /**
     * this function use to get sex from user input
     *
     * @return sex
     */
    private int getSex() {
        int sex = Ultility.getInt("Enter SEX (1: male, 0: female): ", "Error", 0, 1);
        return sex;
    }

    /**
     * this function use to get salary from user input
     *
     * @return salary
     */
    private double getSalary() {
        double salary = Ultility.getDouble("Enter salary: ", "Wrong", 0, Double.MAX_VALUE);
        return salary;
    }

    /**
     * this function use to get name from user input
     *
     * @return name
     */
    private String getName() {
        String name = Ultility.getString("Enter name: ", "Wrong", Ultility.REGEX_STRING);
        return name;
    }
    
    /**
     * this function use to remove an employee by id input 
     */
    void remove() {
        String id = getID();

        Employee employee = manage.getEmployeeByID(id);
        if (employee == null) {
            System.out.println("NOT FOUND");
        } else {
            manage.deleteEmployee(employee);
            System.out.println("Delete successfull !!");
        }
    }
    
    /**
     * this function use to search employees by name
     */
    void search() {
        String name = Ultility.getString("Enter name: ", "Wrong", Ultility.REGEX_STRING);

        List<Employee> listSearch = manage.getListEmployeeByName(name);
        //if list search size is 0 => not found
        //else display
        if (listSearch.size() == 0) {
            System.out.println("NOT FOUND");
        } else {
            displayListEmployee(listSearch);
        }
    }
    
    /**
     * this function use to display list by parameter
     * @param listSearch 
     */
    private void displayListEmployee(List<Employee> listSearch) {
        System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s"
                + "%-20s %-20s\n", "ID", "First", "Last", "Phone", "Email", "Address",
                "DOB", "Sex", "Salary", "Agency");
        for (Employee employee : listSearch) {
            System.out.println(employee);
        }
    }
    
    /**
     * this function use to sort list employee
     */
    void sort() {
        if (manage.getListStudent().size() == 0) {
            System.out.println("LIST IS EMPTY");
        } else {
            List<Employee> listSort = manage.sortList();
            displayListEmployee(listSort);
        }
    }
    
    /**
     * this function use to update employee
     */
    void update() {
        //b1: input id want to find
        String id = getID();

        //b2: find employee
        Employee employee = manage.getEmployeeByID(id);
        if (employee == null) {
            System.out.println("NOT FOUND");
            return;
        }
        /*
        true => want to update
        false => not want to update
         */

        if (checkWantToUpdate("id")) {
            while (true) {
                String idUpdate = getID();
                if (idUpdate == id) {
                    System.out.println("You not update");
                    break;
                }

                if (manage.checkDuplicate(idUpdate)) {
                    System.out.println("ID existed");
                } else {
                    employee.setId(idUpdate);
                    break;
                }
            }
        }

        if (checkWantToUpdate("first name")) {
            String firstName = getFirstName();
            employee.setFirstName(firstName);
        }

        if (checkWantToUpdate("last name")) {
            String lastName = getLastName();

            employee.setLastName(lastName);
        }
        if (checkWantToUpdate("phone")) {
            String phone = getPhone();

            employee.setPhone(phone);
        }
        if (checkWantToUpdate("email")) {
            String email = getEmail();

            employee.setEmail(email);
        }
        if (checkWantToUpdate("address")) {
            String address = getAddress();

            employee.setAddress(address);
        }
        if (checkWantToUpdate("DOB")) {
            String DOB = getDOB();

            employee.setDOB(DOB);
        }
        if (checkWantToUpdate("sex")) {
            int sex = getSex();

            employee.setSex(sex);
        }
        if (checkWantToUpdate("salary")) {
            double salary = getSalary();

            employee.setSalary(salary);
        }
        if (checkWantToUpdate("agency")) {
            String agency = getAgency();

            employee.setAgency(agency);
        }

    }
    
    /**
     * this function use to check use want to update or not ?
     * @param message
     * @return true or false
     */
    private boolean checkWantToUpdate(String message) {
        String result = Ultility.getString("Do you want to update " + message + " (y/n)? ",
                "ONLY y or n !!!", Ultility.REGEX_YN);
        //if result == y => true
        //else => false 
        if (result.equalsIgnoreCase("y")) {
            return true;
        }
        return false;
    }

}
