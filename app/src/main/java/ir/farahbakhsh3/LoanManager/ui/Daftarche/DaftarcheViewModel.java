package ir.farahbakhsh3.LoanManager.ui.Daftarche;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DaftarcheViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public DaftarcheViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is daftarche fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}