package com.example.kson.ksonretrofitutils;

import android.os.Bundle;

import com.example.kson.ksonretrofitutils.api.UserApiService;
import com.example.kson.ksonretrofitutils.bean.BaseResponseBean;
import com.example.kson.ksonretrofitutils.bean.UserInfoBean;
import com.example.kson.ksonretrofitutils.network.RetrofitUtils;
import com.example.kson.ksonretrofitutils.network.RxUtils;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 继承rxjva生命周期的
 */
public class MainActivity extends RxAppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        RetrofitUtils.getInstance().createService(UserApiService.class)
                .getUserInfo()
                .compose(this.<BaseResponseBean<UserInfoBean>>bindToLifecycle())//绑定rxlifecycle生命周期，回收资源，避免内存泄漏
                .compose(RxUtils.schdulers())//切换线程
                .subscribe(new Observer() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Object o) {



                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
