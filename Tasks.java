import java.time.LocalDateTime;

public class Tasks {
     private int id=0;

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

    @Override
    public String toString(){
        return "ID: " + id + " | " +description + " | Created: " + createdAt;
    }
}

