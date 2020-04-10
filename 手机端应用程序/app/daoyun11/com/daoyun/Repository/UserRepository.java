package daoyun11.com.daoyun.Repository;

import java.util.List;

import daoyun11.com.daoyun.Entity.HttpDefault;
import daoyun11.com.daoyun.Entity.User;
import io.reactivex.Observable;
import okhttp3.MultipartBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface UserRepository {

    //登录
    @POST("user/login")
    Observable<HttpDefault<User>> login(
            @Query("tel") String tel,
            @Query("password") String password
    );

    //注册
    @POST("user/register")
    Observable<HttpDefault<User>> register(
            @Query("tel") String tel,
            @Query("password") String password
    );


    //重置密码
    @POST("user/resetpsd")
    Observable<HttpDefault<User>> resetPassword(
            @Query("tel") String tel,
            @Query("oldpsd") String oldpsd,
            @Query("newpsd") String newpsd
    );


    //用户id查询用户信息
    @POST("user/QueryUser")
    Observable<HttpDefault<User>> queryUser(
            @Query("userid") int userid
    );

    //用户手机查询用户信息
    @POST("user/QueryUserbyPhone")
    Observable<HttpDefault<User>> queryUserbyPhone(
            @Query("tel") String tel
    );

    //更新个人信息
    @FormUrlEncoded
    @POST("user/updatemine")
    Observable<HttpDefault<User>> updatemine(
            @Field("name") String name,
            @Field("sex") String sex,
            @Field("description") String description,
            @Field("tel") String tel
    );

    @GET("user/userlist")
    Observable<HttpDefault<List<User>>> userlist();

    @GET("user/getuser")
    Observable<HttpDefault<List<User>>> getuser(
            @Query("tel") String tel

    );



    //设置用户头像
    @Multipart
    @POST("file/upload")
    Observable<HttpDefault<String>> updateHeadImg(
            @Query("tel") String tel,
            @Part MultipartBody.Part file
    );
    //删除用户
    @POST("user/deleteuser")
    Observable<HttpDefault<String>> deleteuser(
            @Query("id") int id
    );


    //更新个人信息
    @FormUrlEncoded
    @POST("user/updateUser")
    Observable<HttpDefault<User>> updatUser(
            @Field("id") int id,
            @Field("name") String name,
            @Field("tel") String tel,
            @Field("password") String password,
            @Field("sex") String sex,
            @Field("description") String description

    );

}