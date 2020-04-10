package daoyun11.com.daoyun.Repository;

import java.util.List;

import daoyun11.com.daoyun.Entity.HttpDefault;
import daoyun11.com.daoyun.Entity.Lecture;
import daoyun11.com.daoyun.Entity.LectureShow;
import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;



public interface LectureRepository {

    @GET("lecture/lecturelist")
    Observable<HttpDefault<List<Lecture>>> getlecturelist();

    @FormUrlEncoded
    @POST("lecture/findlecturebyname")
    Observable<HttpDefault<Lecture>> findlecturebyname(
            @Field("name") String name
    );


    @GET("lecture/lectureshow")
    Observable<HttpDefault<List<LectureShow>>> getlectureshow();

    @FormUrlEncoded
    @POST("lecture/findnamebyname")
    Observable<HttpDefault<String>> findnamenyname(
            @Field("name") String name
    );

    @FormUrlEncoded
    @POST("lecture/findlecturelikename")
    Observable<HttpDefault<List<LectureShow>>> findlecturelikename(
            @Field("name") String name
    );

    @FormUrlEncoded
    @POST("lecture/getlecturedata")
    Observable<HttpDefault<List<String>>> getlecturedata(
            @Field("name") String name
    );

    @FormUrlEncoded
    @POST("lecture/deletelecture")
    Observable<HttpDefault<String>> deletelecture(
            @Field("name") String name
    );

    @FormUrlEncoded
    @POST("lecture/getLecture")
    Observable<HttpDefault<List<LectureShow>>> getLecture(
            @Field("name") String name
    );
}
