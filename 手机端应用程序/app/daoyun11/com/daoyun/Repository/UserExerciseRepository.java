package daoyun11.com.daoyun.Repository;

import java.util.List;

import daoyun11.com.daoyun.Entity.HttpDefault;
import daoyun11.com.daoyun.Entity.User;
import daoyun11.com.daoyun.Entity.UserExercise;
import daoyun11.com.daoyun.Entity.UserExerciseShow;
import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Query;



public interface UserExerciseRepository {

    @FormUrlEncoded
    @POST("userexercise/getrecordshow")
    Observable<HttpDefault<List<UserExerciseShow>>> getrecordshow(
            @Field("tel") String tel,
            @Field("name") String name
    );

    @FormUrlEncoded
    @POST("userexercise/answer")
    Observable<HttpDefault<UserExercise>> answer(
            @Field("tel") String tel,
            @Field("name") String name,
            @Field("lecturename") String lecturename,
            @Field("answer") String answer
    );

    @FormUrlEncoded
    @POST("userexercise/getuserrecord")
    Observable<HttpDefault<UserExercise>> getrecord(
            @Field("tel") String tel,
            @Field("name") String name,
            @Field("lecturename") String lecturename
    );

}
