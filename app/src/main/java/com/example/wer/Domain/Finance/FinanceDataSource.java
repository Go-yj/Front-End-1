package com.example.wer.Domain.Finance;

import com.example.wer.Data.Finance.FinanceFormat;
import com.example.wer.Data.Finance.FinanceParam;

import io.reactivex.Single;

public interface FinanceDataSource {
    Single<FinanceFormat> getFinance(FinanceParam financeParam);
}
