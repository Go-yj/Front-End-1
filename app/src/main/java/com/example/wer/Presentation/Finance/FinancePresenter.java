package com.example.wer.Presentation.Finance;

import com.example.wer.Data.Finance.FinanceFormat;
import com.example.wer.Data.Finance.FinanceParam;
import com.example.wer.Domain.Finance.FinanceUseCase;
import com.example.wer.util.DataUnavailableException;
import com.example.wer.util.WrongRequestException;

public class FinancePresenter implements FinanceContract.Presenter {
    private FinanceContract.View view;
    private FinanceUseCase financeUseCase;

    public FinancePresenter(FinanceContract.View view) {
        this.view = view;
        financeUseCase = new FinanceUseCase();
    }

    @Override
    public void loadFinance(FinanceParam financeParam) {
        financeUseCase.execute(financeParam, (response)-> {
            bindView(response); // callback
        }, (error)->handleError(error));
    }

    @Override
    public void bindView(FinanceFormat financeFormat) {
        view.setUpContent(financeFormat);
    }

    public void handleError(Throwable e){
        if(e instanceof DataUnavailableException){
            view.handleDataUnavailable((DataUnavailableException)e);
        }
        else if(e instanceof WrongRequestException){
            view.handleWrongRequest((WrongRequestException)e);
        }
        else{
            System.out.println("other errors");
        }
    }
}
