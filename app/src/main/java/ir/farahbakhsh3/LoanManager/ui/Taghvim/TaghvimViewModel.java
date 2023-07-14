package ir.farahbakhsh3.LoanManager.ui.Taghvim;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TaghvimViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public TaghvimViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is taghvim fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}