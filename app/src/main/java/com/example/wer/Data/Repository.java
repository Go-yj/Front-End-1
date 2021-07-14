package com.example.wer.Data;

/*
subscribeOn으로 observable을 구독하고 observable이 방출하는 Data를 수신할 것입니다.
Observable이 IO 스레드에서 코드를 실행하라고 알려줍니다.
 */

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

public abstract class Repository<ResponseFormat> {
    protected Single<ResponseFormat> setThread(Single<ResponseFormat> response) {
        return response.subscribeOn(Schedulers.io())
                .observeOn(Schedulers.computation());
    }
}
