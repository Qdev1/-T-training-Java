/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import model.Employee;

public class ManageEmployee {

    List<Employee> listEmployees = new ArrayList<Employee>();
    
    /**
     * this function use to get list student
     * @return listEmployees
     */
    public List<Employee> getListStudent() {
        return listEmployees;
    }
    
    /**
     * this function use to check duplicate
     * @param id
     * @return true or false
     */
    public boolean checkDuplicate(String id) {
        for (Employee employee : listEmployees) {
            if (employee.getId().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * this function use to add an employee
     * @param employee 
     */
    public void addEmployee(Employee employee) {
        listEmployees.add(employee);
    }
    
    /**
     * this function use to get employee by ID 
     * @param id
     * @return employee or null
     */
    public Employee getEmployeeByID(String id) {
        for (Employee employee : listEmployees) {
            if (employee.getId().equalsIgnoreCase(id)) {
                return employee;
            }
        }
        return null;
    }
    
    /**
     * this function use to delete an employee
     * @param employee 
     */
    public void deleteEmployee(Employee employee) {
        listEmployees.remove(employee);
    }
    
    /**
     * this function use to get list student by name
     * @param name
     * @return 
     */
    public List<Employee> getListEmployeeByName(String name) {
        List<Employee> listSearch = new ArrayList<>();
        name = name.toUpperCase();
        for (Employee employee : listEmployees) {
            String fullName = employee.getFirstName() + " " + employee.getLastName();
            if (fullName.toUpperCase().contains(name)) {
                listSearch.add(employee);
            }
        }
        return listSearch;

    }   
    
    /**
     * this function use to sort a list
     * @return a list
     */
    public List<Employee> sortList() {
        List<Employee> listSort = new ArrayList<>();
        listSort.addAll(listEmployees);
        /*Loop from the first to last person , 
        after each loop, one person is sorted*/
        for (int i = 0; i < listSort.size(); i++) {
            //Loop from first to last person through unsorted person
            for (int j = 0; j < listSort.size() - 1 - i; j++) {
                //swap two person if not in ascending order
                if (listSort.get(j).getSalary() > listSort.get(j + 1).getSalary()) {
                    Collections.swap(listSort, j, j + 1);
                }
            }
        }
        return listSort;
    }

}
