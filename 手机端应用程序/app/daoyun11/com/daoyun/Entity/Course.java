package daoyun11.com.daoyun.Entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;



public class Course implements Serializable {
    @SerializedName("name")
    private String name;
    @SerializedName("time")
    private String time;
    @SerializedName("detail")
    private String detail;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}