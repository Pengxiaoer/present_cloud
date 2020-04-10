package daoyun11.com.daoyun.Repository;

import java.util.List;

import daoyun11.com.daoyun.Entity.Exercise;
import daoyun11.com.daoyun.Entity.ExerciseShow;
import daoyun11.com.daoyun.Entity.HttpDefault;
import daoyun11.com.daoyun.Entity.Lecture;
import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Query;



public interface ExerciseRepository {
    @FormUrlEncoded
    @POST("exercise/getexercise")
    Observable<HttpDefault<Exercise>> getexercise(
            @Field("lecturename") String lecturename,
            @Field("name") String name

    );

    @POST("exercise/exerciseshow")
    Observable<HttpDefault<List<ExerciseShow>>> exerciseshow();

    @FormUrlEncoded
    @POST("exercise/getExercise")
    Observable<HttpDefault<List<ExerciseShow>>> getExercise(
            @Field("name") String name

    );

    @FormUrlEncoded
    @POST("exercise/getexson")
    Observable<HttpDefault<List<Exercise>>> getexson(
            @Field("name") String name

    );

    @FormUrlEncoded
    @POST("exercise/deleteExercise")
    Observable<HttpDefault<String>> deleteExercise(
            @Field("id") int id

    );

    @FormUrlEncoded
    @POST("exercise/getoneexercise")
    Observable<HttpDefault<Exercise>> getoneexercise(
            @Field("id") int id
    );

}
