package daoyun11.com.daoyun.Entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;


public class LectureShow implements Serializable {
    @SerializedName("lectureName")
    private String lectureName;
    @SerializedName("teacherName")
    private String teacherName;
    @SerializedName("pictureUrl")
    private String pictureUrl;
    @SerializedName("type")
    private String type;

    public String getLectureName() {
        return lectureName;
    }

    public void setLectureName(String lectureName) {
        this.lectureName = lectureName;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setLectureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
