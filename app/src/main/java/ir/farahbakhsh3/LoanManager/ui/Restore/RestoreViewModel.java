package ir.farahbakhsh3.LoanManager.ui.Restore;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RestoreViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public RestoreViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is restore fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}