package com.example.wer.Domain.Finance;

/*
Observable : 하나의 스레드에서 다른 스레드로 전달할 데이터 압축
Flatmap으로 getFinance의 반환을 someProcessing의 파라미터로 전달
someProcessing에서 FinanceFormat을 하나씩 방출
 */

import com.example.wer.Data.Finance.FinanceFormat;
import com.example.wer.Data.Finance.FinanceParam;
import com.example.wer.Data.Finance.FinanceRepository;

import io.reactivex.Single;

public class FinanceServiceImpl implements FinanceService {
    private FinanceDataSource mFinanceDataSource;

    public FinanceServiceImpl() {
        mFinanceDataSource = FinanceRepository.getInstance();
    }

    @Override
    public Single<FinanceFormat> getFinance(FinanceParam financeParam) {
        return mFinanceDataSource.getFinance(financeParam)
                .flatMap(this::someProcessing);
    }

    private Single<FinanceFormat> someProcessing(FinanceFormat formatSingle) {
        System.out.println("some processing");
        return Single.just(formatSingle);
    }
}
