/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Manage;
import model.Task;


public class View_Task {

    Manage manage = new Manage();

    void inputTask() {
           int taskType;
        String requirementName, date, assignee, reviewer;
        double planFrom, planTo;
        
        //user input information task
        requirementName = getRequirementName();
        taskType = getTaskType();
        date = getDate();
        planFrom = getPlanFrom();
        planTo = getPlanTo(planFrom);
        assignee = getAssignee();
        reviewer = getReviewer();
        
        if (manage.checkDuplicate(date, assignee, planFrom, planTo, taskType, requirementName, 
                reviewer)) {
            System.out.println("Duplicate");
        }else {
            Task task = new Task(taskType, date, date, assignee, reviewer, planFrom, planTo);
            manage.addTask(task);
            System.out.println("Add successfully");
        }
        
    }
    
    
    /**
     * this function use to input requirement name
     *
     * @return requirementName
     */
    private static String getRequirementName() {
        String requirementName = Ultility.getString("Requirement Name: ",
                "Name must be a string ", Ultility.REGEX_STRING);
        return requirementName;
    }

    /**
     * this function use to input taskType
     *
     * @return taskType
     */
    private static int getTaskType() {
        int taskType = Ultility.getInt("Task Type: ",
                "Task Type must be decimal integer ", 1, 4);
        return taskType;
    }

    /**
     * this function use to input date
     *
     * @return date
     */
    private static String getDate() {
        String date = Ultility.getDate("Date: ", "Format must be"
                + " dd-MM-yyyy", "\\d{1,2}[-]\\d{1,2}[-]\\d{4}");
        return date;
    }

    /**
     * this function use to input planFrom
     *
     * @return planFrom
     */

    private static double getPlanFrom() {
        double planFrom = Ultility.getDouble("From: ", "From[8.0"
                + " - 17]", 8.0, 17);
        return planFrom;
    }

    /**
     * this function use to input planTo
     *
     * @return planTo
     */

    private static double getPlanTo(double planFrom) {
        double planTo = Ultility.getDouble("To: ", "To[" + (planFrom + 0.5)
                + " - 17.5]", (planFrom + 0.5), 17.5);
        return planTo;
    }

    /**
     * this function use to input assignee
     *
     * @return assignee
     */
    private static String getAssignee() {
        String assignee = Ultility.getString("Assignee: ",
                "Assignee must be a string ", "^[a-z A-Z]+$");
        return assignee;
    }

    /**
     * this function use to input reviewer
     *
     * @return reviewer
     */

    private static String getReviewer() {
        String reviewer = Ultility.getString("Reviewer: ",
                "Reviewer must be a string ", "^[a-z A-Z]+$");
        return reviewer;
    }
    
    /**
     * this function use to delete a task 
     */
    void deleteTask() {
        int id = getID();
        
        Task task = manage.getTaskByID(id);
        
        //if task == null => not found
        //else remove
        if (task == null) {
            System.out.println("NOT FOUND TASK");
        }else {
            manage.removeTask(task);
            System.out.println("Delete successfull");
        }
        
    }
    
    /**
     * this function use to get id input from user
     * @return 
     */
    private int getID() {
        int id = Ultility.getInt("Enter id: ", "Wrong", 0, Integer.MAX_VALUE);
        return  id;
    }
    
    /**
     * this function use to display a task
     */
    void displayTask() {
        if (manage.getListTask().size() == 0) {
            System.out.println("LIST TASK IS EMPTY");
            return;
        }
        System.out.printf("%-10s %-10s %-10s %-20s %-10s %-10s %-10s %-10s\n", "ID",
                "Name", "TaskType", "Date", "From", "To", "Assignee", "Reviewer");
        for (Task task : manage.getListTask()) {
            System.out.println(task);
        }
    }
    
}
