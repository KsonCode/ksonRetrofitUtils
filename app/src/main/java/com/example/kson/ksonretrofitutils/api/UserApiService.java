package com.example.kson.ksonretrofitutils.api;


import com.example.kson.ksonretrofitutils.bean.BaseResponseBean;
import com.example.kson.ksonretrofitutils.bean.UserInfoBean;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import retrofit2.http.GET;

public interface UserApiService {
    @GET("user/verify/v1/getUserById")
    Observable<BaseResponseBean<UserInfoBean>> getUserInfo();

}
