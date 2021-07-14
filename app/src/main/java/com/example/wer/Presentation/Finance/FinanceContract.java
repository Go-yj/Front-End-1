package com.example.wer.Presentation.Finance;

import com.example.wer.Data.Finance.FinanceFormat;
import com.example.wer.Data.Finance.FinanceParam;
import com.example.wer.util.DataUnavailableException;
import com.example.wer.util.WrongRequestException;

public interface FinanceContract {
    interface View {
        public void setUpContent(FinanceFormat financeFormat);
        public void handleWrongRequest(WrongRequestException exception);
        public void handleDataUnavailable(DataUnavailableException exception);
    }

    interface Presenter {
        void loadFinance(FinanceParam financeParam);
        void bindView(FinanceFormat financeFormat);
    }
}
