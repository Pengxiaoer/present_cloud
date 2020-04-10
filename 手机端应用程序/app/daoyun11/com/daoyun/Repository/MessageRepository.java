package daoyun11.com.daoyun.Repository;

import java.util.List;

import daoyun11.com.daoyun.Entity.HttpDefault;
import daoyun11.com.daoyun.Entity.LectureShow;
import daoyun11.com.daoyun.Entity.MessageShow;
import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;


public interface MessageRepository {

    @GET("message/messageshow")
    Observable<HttpDefault<List<MessageShow>>> getmessageshow();

    @FormUrlEncoded
    @POST("message/save")
    Observable<HttpDefault<List<MessageShow>>> save(
            @Field("tel") String tel,
            @Field("description") String description
    );

    @FormUrlEncoded
    @POST("message/deletetmessage")
    Observable<HttpDefault<String>> deletetmessage(
            @Field("id") int id

    );

}
