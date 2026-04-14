package src;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;


public class Tasks {

    private String state;

    private int id;

    private  String description;

    private  LocalDateTime createdAt;

    private  LocalDateTime updatedAt;


    public  int getId(){
        return id;
    }

    public int setId(int id){
        return this.id=id;
    }

    public  String getDescription() {
        return this.description = description;
    }

    public String setDescription(String description) {
        return this.description = description;
    }


    public  LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public  LocalDateTime getUpdatedAt(){
        return updatedAt;
    }

    public LocalDateTime setCreatedAt(LocalDateTime now){
        return this.createdAt=now;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return "ID: " + id + " | " +description + " | Created: " + createdAt.format(formatter) + "| Status: " + state;
    }

}

