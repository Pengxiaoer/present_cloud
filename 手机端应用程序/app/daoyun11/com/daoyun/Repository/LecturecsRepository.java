package daoyun11.com.daoyun.Repository;

import java.util.List;

import daoyun11.com.daoyun.Entity.Course;
import daoyun11.com.daoyun.Entity.HttpDefault;
import daoyun11.com.daoyun.Entity.Lecture;
import daoyun11.com.daoyun.Entity.LectureShow;
import daoyun11.com.daoyun.Entity.Lecturecs;
import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;



public interface LecturecsRepository {

    @FormUrlEncoded
    @POST("lecturecs/choselecture")
    Observable<HttpDefault<Lecturecs>> choselecture(
            @Field("name") String name,
            @Field("tel") String tel
    );

    @GET("lecturecs/lecturedatashow")
    Observable<HttpDefault<List<List<LectureShow>>>> getlecturedatashow(
            @Query("tel") String tel
    );

    @GET("lecturecs/lectureshow")
    Observable<HttpDefault<List<LectureShow>>> getlectureshow(
            @Query("tel") String tel
    );

    @GET("lecturecs/getuserchose")
    Observable<HttpDefault<List<Course>>> getuserchose(
            @Query("tel") String tel
    );

    @FormUrlEncoded
    @POST("lecturecs/getlecturecs")
    Observable<HttpDefault<Lecturecs>> getlecturecs(
            @Field("tel") String tel,
            @Field("name") String name

    );

    @FormUrlEncoded
    @POST("lecturecs/unchose")
    Observable<HttpDefault<String>> unchose(
            @Field("tel") String tel,
            @Field("name") String name
    );

}
