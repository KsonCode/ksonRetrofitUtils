package com.example.kson.ksonretrofitutils;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.blankj.utilcode.util.ToastUtils;
import com.example.kson.ksonretrofitutils.api.UserApiService;
import com.example.kson.ksonretrofitutils.bean.BaseResponseBean;
import com.example.kson.ksonretrofitutils.bean.UserInfoBean;
import com.example.kson.ksonretrofitutils.network.HttpObserver;
import com.example.kson.ksonretrofitutils.network.RetrofitUtils;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.HashMap;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
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
                .compose(this.<BaseResponseBean<UserInfoBean>>bindToLifecycle())//绑定生命周期
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<BaseResponseBean<UserInfoBean>>() {
                    @Override
                    public void onSubscribe(Subscription s) {

                    }

                    @Override
                    public void onNext(BaseResponseBean<UserInfoBean> userInfoBeanBaseResponseBean) {

                        System.out.println(userInfoBeanBaseResponseBean.message);
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
