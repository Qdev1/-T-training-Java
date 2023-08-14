/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Employee {

    private String id;
    private String firstName, lastName, phone, email, address, DOB, agency;
    private double salary;
    private int sex;

    /**
     * create a employee with parameter
     *
     * @param id
     * @param firstName
     * @param lastName
     * @param phone
     * @param email
     * @param address
     * @param DOB
     * @param agency
     * @param salary
     * @param sex
     */
    public Employee(String id, String firstName, String lastName, String phone, String email, String address, String DOB, String agency, double salary, int sex) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.DOB = DOB;
        this.agency = agency;
        this.salary = salary;
        this.sex = sex;
    }

    /**
     * create a default employee
     */
    public Employee() {
    }

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id != null) {
            this.id = id;
        }
    }

    /**
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName != null) {
            this.firstName = firstName;
        }
    }

    /**
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName != null) {
            this.lastName = lastName;
        }
    }

    /**
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        if (phone != null) {
            this.phone = phone;
        }
    }

    /**
     * @return email
     */
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email != null) {
            this.email = email;
        }
    }

    /**
     * @return address
     */
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (address != null) {
            this.address = address;
        }
    }

    /**
     * @return DOB
     */
    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date firstDate = dateFormat.parse(DOB);
            Date currendDate = new Date();

            long first = firstDate.getTime() / (60 * 60 * 24l * 365 * 1000);
            long second = currendDate.getTime() / (60 * 60 * 24l * 365 * 1000);

            //check greater than 16 
            if (second - first < 16) {
                throw new Exception("You not old enough");
            } else {
                this.DOB = DOB;
            }

        } catch (Exception ex) {
            Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * @return agency
     */
    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        if (agency != null) {
            this.agency = agency;
        }
    }

    /**
     * @return salary
     */
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary >= 0) {
            this.salary = salary;
        }
    }

    /**
     * @return sexRESULT
     */
    public String getSex() {
        String sexRESULT = null;
        switch (sex) {
            case 1:
                sexRESULT = "male";
                break;
            case 0:
                sexRESULT = "female";
                break;
        }
        return sexRESULT;
    }

    public void setSex(int sex) {
        if (sex >= 0) {
            this.sex = sex;
        }
    }

    @Override
    public String toString() {
        return String.format("%-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s"
                + "%-20s %-20s ", id, firstName, lastName, phone, email, address, DOB, getSex(), salary, agency);
    }
}
