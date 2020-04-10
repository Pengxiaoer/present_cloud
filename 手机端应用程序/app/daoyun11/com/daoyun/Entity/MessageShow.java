package daoyun11.com.daoyun.Entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class MessageShow implements Serializable {
    @SerializedName("id")
    int id;
    @SerializedName("headimg")
    String headimg;
    @SerializedName("name")
    String name;
    @SerializedName("description")
    String description;
    @SerializedName("message")
    String message;
    @SerializedName("time")
    String time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHeadimg() {
        return headimg;
    }

    public void setHeadimg(String headimg) {
        this.headimg = headimg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTime() {
        return time;
    }

}
