package com.example.wer.Data.Finance;

/*
서버와 통신하는 요청 API를 정의합니다.
서버와 요청 API에 대한 논의 후 구현할 예정입니다.
 */

import io.reactivex.Single;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface FinanceApi {
    @GET("result/{result}")
    Single<Response<FinanceFormat>> getFinance(@Path("result") String result);

}
