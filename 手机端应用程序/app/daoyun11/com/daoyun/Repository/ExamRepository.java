package daoyun11.com.daoyun.Repository;

import java.util.List;

import daoyun11.com.daoyun.Entity.Exam;
import daoyun11.com.daoyun.Entity.HttpDefault;
import daoyun11.com.daoyun.Entity.Lecturecs;
import daoyun11.com.daoyun.Entity.Teacher;
import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Query;



public interface ExamRepository {

    @FormUrlEncoded
    @POST("exam/findexam")
    Observable<HttpDefault<Exam>> findExam(
            @Field("name") String name
    );

    @FormUrlEncoded
    @POST("exam/answer")
    Observable<HttpDefault<Lecturecs>> answer(
            @Field("tel") String tel,
            @Field("name") String name,
            @Field("answer") String answer
    );

    @POST("exam/list")
    Observable<HttpDefault<List<Exam>>> list();

    @POST("exam/deleteExam")
    Observable<HttpDefault<String>> deleteExam(
            @Query("id" ) int id
    );

    @FormUrlEncoded
    @POST("exam/getExam")
    Observable<HttpDefault<List<Exam>>> getExam(
            @Field("name") String name
    );

}
