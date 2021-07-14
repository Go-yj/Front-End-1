package com.example.wer.Data.Finance;

/*
실제 서버에 요청 하고 응답값을 반환 받는 부분입니다.
 */

import com.example.wer.Domain.Finance.FinanceDataSource;
import com.example.wer.util.DataUnavailableException;
import com.example.wer.util.WrongRequestException;

import io.reactivex.Single;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class FinanceRemote implements FinanceDataSource {

    @Override
    public Single<FinanceFormat> getFinance(FinanceParam financeParam) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("요청 URL")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        return retrofit.create(FinanceApi.class).getFinance(
                financeParam.ID)
                .flatMap((response)->{
                    switch(response.code()) {
                        case 200:
                            return Single.just(response.body());
                        case 204:
                            return Single.just(new FinanceFormat());
                        case 400:
                        case 401:
                        case 404:
                            throw new WrongRequestException(response.message());
                        case 500:
                        case 502:
                        case 503:
                            throw new DataUnavailableException(response.message());
                        default:
                            throw new RuntimeException(response.message());
                    }
                });
    }
}
