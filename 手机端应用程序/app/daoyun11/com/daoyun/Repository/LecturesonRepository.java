package daoyun11.com.daoyun.Repository;

import java.util.List;

import daoyun11.com.daoyun.Entity.HttpDefault;
import daoyun11.com.daoyun.Entity.Lecturecs;
import daoyun11.com.daoyun.Entity.Lectureson;
import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;


public interface LecturesonRepository {


    @FormUrlEncoded
    @POST("lectureson/getlectureson")
    Observable<HttpDefault<List<Lectureson>>> getlectureson(
            @Field("name") String name
    );

    @FormUrlEncoded
    @POST("lectureson/getoneson")
    Observable<HttpDefault<Lectureson>> getoneson(
            @Field("id") int id
    );


}
