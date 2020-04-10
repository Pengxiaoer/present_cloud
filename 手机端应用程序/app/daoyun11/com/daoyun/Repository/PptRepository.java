package daoyun11.com.daoyun.Repository;

import java.util.List;

import daoyun11.com.daoyun.Entity.Exam;
import daoyun11.com.daoyun.Entity.HttpDefault;
import daoyun11.com.daoyun.Entity.PptShow;
import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;


public interface PptRepository {

    @FormUrlEncoded
    @POST("ppt/pptshow")
    Observable<HttpDefault<List<PptShow>>> pptshow(
            @Field("tel") String tel
    );

    @FormUrlEncoded
    @POST("ppt/deletePPT")
    Observable<HttpDefault<String>> deletePPT(
            @Field("id") int id
    );

    @POST("ppt/pptlistShow")
    Observable<HttpDefault<List<PptShow>>> pptlistShow();

    @FormUrlEncoded
    @POST("ppt/getPPT")
    Observable<HttpDefault<List<PptShow>>> getPPT(
            @Field("name") String name
    );

}
