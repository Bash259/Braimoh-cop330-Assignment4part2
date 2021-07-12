/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Fouad Braimoh
 */



package ucf.assignments;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;

public class TodoListCollector {
    private SimpleStringProperty Progress;
    private SimpleStringProperty Task;
    private SimpleStringProperty Date;

    public TodoListCollector(String Progress, String Task, String Date) {
        this.Progress = new SimpleStringProperty(Progress);
       this.Task = new SimpleStringProperty(Task);
       this.Date = new SimpleStringProperty(Date);
    }

    public String getTask(){
        return Task.get();
    }

    public void setTask(String Task){
        this.Task = new SimpleStringProperty(Task);
    }

    public String getDate(){
        return Date.get();
    }

    public void setDate(String Date){
        this.Date = new SimpleStringProperty(Date);
    }

    public String getProgress(){
        return Progress.get();
    }

    public void setProgress(String Progress){
        this.Progress = new SimpleStringProperty(Progress);
    }

}