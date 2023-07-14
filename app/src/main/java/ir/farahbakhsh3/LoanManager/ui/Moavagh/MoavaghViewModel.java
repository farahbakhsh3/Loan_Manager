package ir.farahbakhsh3.LoanManager.ui.Moavagh;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MoavaghViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public MoavaghViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is moavagh fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}