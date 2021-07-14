package com.example.wer.Domain.Finance;

import com.example.wer.Data.Finance.FinanceFormat;
import com.example.wer.Data.Finance.FinanceParam;
import com.example.wer.Domain.UseCase;

import io.reactivex.Single;

public class FinanceUseCase extends UseCase <FinanceParam, FinanceFormat> {
    private FinanceService mFinanceService;

    public FinanceUseCase() {
        mFinanceService = new FinanceServiceImpl();
    }

    @Override
    protected Single<FinanceFormat> buildUseCaseSingle(FinanceParam financeParam) {
        return mFinanceService.getFinance(financeParam);
    }
}
