package daoyun11.com.daoyun.Entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class ExerciseShow implements Serializable {
    @SerializedName("name")
    String name;
    @SerializedName("number")
    String number;
    @SerializedName("id")
    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
