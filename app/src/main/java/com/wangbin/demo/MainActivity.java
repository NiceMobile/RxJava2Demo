package com.wangbin.demo;

import androidx.appcompat.app.AppCompatActivity;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    Integer integer = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        //  1. 创建被观察者 Observable 对象
//        Observable<Integer> observable = Observable.create(new ObservableOnSubscribe<Integer>() {
//            // 2. 在复写的subscribe（）里定义需要发送的事件
//            @Override
//            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
//                // 通过 ObservableEmitter类对象产生事件并通知观察者
//                // ObservableEmitter类介绍
//                // a. 定义：事件发射器
//                // b. 作用：定义需要发送的事件 & 向观察者发送事件
//                emitter.onNext(1);
//                emitter.onNext(2);
//                emitter.onNext(3);
//                emitter.onComplete();
//            }
//        });
//
//        // 步骤2：创建观察者 Observer 并 定义响应事件行为
//        Observer<Integer> observer = new Observer<Integer>() {
//            // 通过复写对应方法来 响应 被观察者
//            @Override
//            public void onSubscribe(Disposable d) {
//                Log.d(TAG, "开始采用subscribe连接");
//            }
//
//            @Override
//            public void onNext(Integer value) {
//                Log.d(TAG, String.format("对Next事件 %s 作出响应", value));
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                Log.d(TAG, "对Error事件作出响应");
//            }
//
//            @Override
//            public void onComplete() {
//                Log.d(TAG, "对Complete事件作出响应");
//            }
//        };
//        // 步骤3：通过订阅（subscribe）连接观察者和被观察者
//        observable.subscribe(observer);

        //1...基本创建(完整的创建被观察者对象)
        //    create（）方法
//        Observable.create(new ObservableOnSubscribe<Integer>() {
//            // 2. 在复写的subscribe（）里定义需要发送的事件
//            @Override
//            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
//                // 通过 ObservableEmitter类对象产生事件并通知观察者
//                // ObservableEmitter类介绍
//                // a. 定义：事件发射器
//                // b. 作用：定义需要发送的事件 & 向观察者发送事件
//                emitter.onNext(1);
//                emitter.onNext(2);
//                emitter.onNext(3);
//                emitter.onComplete();
//            }
//        }).subscribe(new Observer<Integer>() {
//            private Disposable mDisposable;
//            @Override
//            public void onSubscribe(Disposable d) {
//                Log.d(TAG, "开始采用subscribe连接");
//                mDisposable = d;
//            }
//
//            @Override
//            public void onNext(Integer value) {
//                Log.d(TAG, String.format("对Next事件 %s 作出响应", value));
//                if (value == 2) {
//                    // 设置在接收到第二个事件后切断观察者和被观察者的连接
//                    mDisposable.dispose();
//                    Log.d(TAG, "已经切断了连接：" + mDisposable.isDisposed());
//                }
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                Log.d(TAG, "对Error事件作出响应");
//            }
//
//            @Override
//            public void onComplete() {
//                Log.d(TAG, "对Complete事件作出响应");
//            }
//        });
//
//        Observable.just("Hello").subscribe(new Consumer<String>() {
//            // 每次接收到Observable的事件都会调用Consumer.accept（）
//            @Override
//            public void accept(String s) throws Exception {
//                Log.d(TAG, "输出；" + s);
//            }
//        });
//
//        //2....快速创建
//        //     just()方法:直接发送 传入的事件
//        Observable.just(1,2,3,4).subscribe(new Observer<Integer>() {
//            @Override
//            public void onSubscribe(Disposable d) {
//                Log.d(TAG, "开始采用subscribe连接");
//            }
//
//            @Override
//            public void onNext(Integer value) {
//                Log.d(TAG, "接收到了事件"+ value  );
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                Log.d(TAG, "对Error事件作出响应");
//            }
//
//            @Override
//            public void onComplete() {
//                Log.d(TAG, "对Complete事件作出响应");
//            }
//        });
//
//        //     fromArray()方法:直接发送 传入的事件
//        //使用场景：1.被观察者对象（Observable） & 发送10个以上事件（数组形式）
//        //         2.数组元素遍历
//        Integer[] array = new Integer[]{1,2,3,4};
//        Observable.fromArray(array).subscribe(new Observer<Integer>() {
//            @Override
//            public void onSubscribe(Disposable d) {
//                Log.d(TAG, "开始采用subscribe连接");
//            }
//
//            @Override
//            public void onNext(Integer value) {
//                Log.d(TAG, "接收到了事件"+ value  );
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                Log.d(TAG, "对Error事件作出响应");
//            }
//
//            @Override
//            public void onComplete() {
//                Log.d(TAG, "对Complete事件作出响应");
//            }
//        });
//
//        //     fromArray()方法:直接发送 传入的事件
//        //     直接发送 传入的集合List数据
//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        Observable.fromIterable(list).subscribe(new Observer<Integer>() {
//            @Override
//            public void onSubscribe(Disposable d) {
//                Log.d(TAG, "开始采用subscribe连接");
//            }
//
//            @Override
//            public void onNext(Integer value) {
//                Log.d(TAG, "接收到了list中的数字"+ value  );
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                Log.d(TAG, "对Error事件作出响应");
//            }
//
//            @Override
//            public void onComplete() {
//                Log.d(TAG, "对Complete事件作出响应");
//            }
//        });

        Observer<Integer> observer = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "开始采用subscribe连接");
            }

            @Override
            public void onNext(Integer value) {
                Log.d(TAG, "接收到了list中的数字" + value);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "对Error事件作出响应");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "对Complete事件作出响应");
            }
        };
        // empty()--->该方法创建的被观察者对象发送事件的特点：仅发送Complete事件，直接通知完成
//        Observable observable = Observable.empty();
//        该方法创建的被观察者对象发送事件的特点：仅发送Error事件，直接通知异常
//        Observable observable = Observable.error(new RuntimeException());
        // never()--->该方法创建的被观察者对象发送事件的特点：不发送任何事件
//        Observable observable = Observable.never();
//        observable.subscribe(observer);



//        //延迟创建
//        Observable<Integer> observable = Observable.defer(new Callable<ObservableSource<? extends Integer>>() {
//            @Override
//            public ObservableSource<? extends Integer> call() throws Exception {
//                return Observable.just(integer);
//            }
//        });
//        integer = 100;
//
//        observable.subscribe(observer);

        //延迟2秒创建
        //应用场景
        //---->延迟指定事件，发送一个0，一般用于检测
        // 注：timer操作符默认运行在一个新线程上
        // 也可自定义线程调度器（第3个参数）：timer(long,TimeUnit,Scheduler)
        Observable.timer(2, TimeUnit.SECONDS).subscribe(
                new Observer<Long>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "开始采用subscribe连接");
                    }

                    @Override
                    public void onNext(Long value) {
                        Log.d(TAG, "输出long类型值：" + value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "对Error事件作出响应");
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "对Complete事件作出响应");
                    }
                }
        );
    }
}
