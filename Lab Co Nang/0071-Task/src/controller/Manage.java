/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import model.Task;

public class Manage {

    List<Task> listTask = new ArrayList<Task>();

    /**
     * this function use to get listTask
     *
     * @return listTask
     */
    public List<Task> getListTask() {
        return listTask;
    }

    /**
     * this function use to check duplicate
     *
     * @param date
     * @param assignee
     * @param planFrom
     * @param planTo
     * @return true or false
     */
    public boolean checkDuplicate(String date, String assignee, double planFrom, double planTo,
            int taskType, String requirementName, String reviewer) {
        if (listTask.size() == 0) {
            return false;
        }

        for (Task task : listTask) {
            if (task.getDate().equalsIgnoreCase(date)
                    && task.getAssignee().equalsIgnoreCase(date)
                    && task.getName().equalsIgnoreCase(requirementName)
                    && task.getReviewer().equalsIgnoreCase(reviewer)
                    && task.getFrom() == (planFrom)
                    && task.getTo() == (planTo)
                    && task.getTypeTask()== (taskType)) {
                return true;
            }
        }
        return false;
    }

    /**
     * this function use to add a task
     *
     * @param task
     */
    public void addTask(Task task) {
        listTask.add(task);
    }

    /**
     * this function use to get a task by ID input
     *
     * @param id
     * @return
     */
    public Task getTaskByID(int id) {
        for (Task task : listTask) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }

    /**
     * this function use to remove a task
     *
     * @param task
     */
    public void removeTask(Task task) {
        listTask.remove(task);
    }

}
