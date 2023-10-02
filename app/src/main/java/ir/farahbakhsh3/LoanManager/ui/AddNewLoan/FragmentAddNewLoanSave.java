package ir.farahbakhsh3.LoanManager.ui.AddNewLoan;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ir.farahbakhsh3.LoanManager.R;

public class FragmentAddNewLoanSave extends Fragment {
    private static final String LOAN_PREFERENCES = "Loan_Preferences";
    private static final String ARG_TARIKH = "Tarikh";
    private String mTarikh = "";

    public FragmentAddNewLoanSave() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences settings = getActivity().getSharedPreferences(LOAN_PREFERENCES, MODE_PRIVATE);
        mTarikh = settings.getString(ARG_TARIKH, "");
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_add_new_loan_save, container, false);
    }
}