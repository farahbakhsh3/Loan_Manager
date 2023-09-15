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

//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//    private String mParam1;
//    private String mParam2;
    private SharedPreferences mPrefs;
    private String Tarikh = "";

    public FragmentAddNewLoanSave() {

    }
//
//    public static FragmentAddNewLoanSave newInstance(String param1, String param2) {
//        FragmentAddNewLoanSave fragment = new FragmentAddNewLoanSave();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
        mPrefs = getActivity().getSharedPreferences(getActivity().getLocalClassName(), MODE_PRIVATE);
        Tarikh = mPrefs.getString("Tarikh", "");
        Log.d("Tarikh_SaveFrag",Tarikh.toString());
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