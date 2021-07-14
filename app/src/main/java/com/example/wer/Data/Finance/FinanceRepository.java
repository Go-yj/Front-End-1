package com.example.wer.Data.Finance;

/*
FinanceRemote를 생성하는 부분입니다.
싱글톤 형태로 구현하여 Remote 객체가 단 하나만 존재하도록 보장합니다.
 */

import com.example.wer.Data.Repository;
import com.example.wer.Domain.Finance.FinanceDataSource;

import io.reactivex.Single;

public class FinanceRepository extends Repository<FinanceFormat> implements FinanceDataSource {
    private static FinanceRepository INSTANCE = null;
    private final FinanceDataSource mFinanceRemote;

    // 싱글톤 구현 시작
    private FinanceRepository() {
        mFinanceRemote = new FinanceRemote();
    }

    public static FinanceRepository getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new FinanceRepository();
        }
        return INSTANCE;
    }
    // 싱글톤 구현 끝

    @Override
    public Single<FinanceFormat> getFinance(FinanceParam financeParam) {
        return setThread(mFinanceRemote.getFinance(financeParam));
    }
}
