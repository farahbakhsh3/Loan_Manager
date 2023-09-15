package ir.farahbakhsh3.LoanManager.ui.AddNewLoan;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.mohamadamin.persianmaterialdatetimepicker.date.DatePickerDialog;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import ir.farahbakhsh3.LoanManager.R;

public class FragmentAddNewLoanProperties extends Fragment {

    //    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//    private String mParam1;
//    private String mParam2;
    public static final String LOAN_PREFERENCES = "Loan_Preferences";
    private String Tarikh = "";

    public FragmentAddNewLoanProperties() {
        Log.d("FragmentAddNewLoan...", "FragmentAddNewLoanProperties");
    }

//    public static FragmentAddNewLoanProperties newInstance(String param1, String param2) {
//        FragmentAddNewLoanProperties fragment = new FragmentAddNewLoanProperties();
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

        SharedPreferences settings = getActivity().getSharedPreferences(LOAN_PREFERENCES, MODE_PRIVATE);
        Tarikh = settings.getString("Tarikh", "");
    }

    @Override
    public void onPause() {
        super.onPause();

        TextView textView = getActivity().findViewById(R.id.textViewTarikhAvalinGhest);
        String x = textView.getText().toString();

        SharedPreferences settings = getActivity().getSharedPreferences(LOAN_PREFERENCES, MODE_PRIVATE);
        SharedPreferences.Editor prefEditor = settings.edit();
        prefEditor.putString("Tarikh", x);
        prefEditor.commit();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_add_new_loan_properties, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView textView = getActivity().findViewById(R.id.textViewTarikhAvalinGhest);
        if (!Tarikh.equals(""))
            textView.setText(Tarikh);

        LinearLayout linearLayout = getActivity().findViewById(R.id.linearLayoutTarikhGhest);
        linearLayout.setOnClickListener((View view2) -> {
            String str = textView.getText().toString();
            if (str.equals("")) {
                showCalendar();
            } else {
                showCalendar(str);
            }
        });
    }

    private void showCalendar() {
        DatePickerDialog datePickerDialog = new DatePickerDialog();
        datePickerDialog.setOnDateSetListener(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
                NumberFormat numberFormater = new DecimalFormat("00");
                String date = String.valueOf(year) + "/" +
                        numberFormater.format(monthOfYear + 1) + "/" +
                        numberFormater.format(dayOfMonth);
                TextView textView = getActivity().findViewById(R.id.textViewTarikhAvalinGhest);
                textView.setText(date);
            }
        });
        datePickerDialog.show(getActivity().getFragmentManager(), "");
    }

    private void showCalendar(String date) {
        int year = Integer.parseInt(date.split("/")[0]);
        int month = Integer.parseInt(date.split("/")[1]) - 1;
        int day = Integer.parseInt(date.split("/")[2]);
        DatePickerDialog datePickerDialog = DatePickerDialog.newInstance(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
                NumberFormat numberFormater = new DecimalFormat("00");
                String date = String.valueOf(year) + "/" +
                        numberFormater.format(monthOfYear + 1) + "/" +
                        numberFormater.format(dayOfMonth);
                TextView textView = getActivity().findViewById(R.id.textViewTarikhAvalinGhest);
                textView.setText(date);
            }
        }, year, month, day);
        datePickerDialog.show(getActivity().getFragmentManager(), "");
    }
}