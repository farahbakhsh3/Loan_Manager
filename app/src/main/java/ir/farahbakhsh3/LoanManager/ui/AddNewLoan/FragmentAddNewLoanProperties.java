package ir.farahbakhsh3.LoanManager.ui.AddNewLoan;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputLayout;
import com.mohamadamin.persianmaterialdatetimepicker.date.DatePickerDialog;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import ir.farahbakhsh3.LoanManager.R;

public class FragmentAddNewLoanProperties extends Fragment {
    private static final String LOAN_PREFERENCES = "Loan_Preferences";
    private static final String ARG_TARIKH = "Tarikh";
    private String mTarikh = "";

    public FragmentAddNewLoanProperties() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences settings = getActivity().getSharedPreferences(LOAN_PREFERENCES, MODE_PRIVATE);
        mTarikh = settings.getString(ARG_TARIKH, "");
    }

    @Override
    public void onPause() {
        super.onPause();

        TextView textViewTarikh = getActivity().findViewById(R.id.textViewTarikhAvalinGhest);
        String x = textViewTarikh.getText().toString();

        SharedPreferences settings = getActivity().getSharedPreferences(LOAN_PREFERENCES, MODE_PRIVATE);
        SharedPreferences.Editor prefEditor = settings.edit();
        prefEditor.putString(ARG_TARIKH, x);
        prefEditor.commit();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_add_new_loan_properties, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextInputLayout textInputLayout = getActivity().findViewById(R.id.textInputLayoutTarikhAvalinGhest);
        TextView textView = getActivity().findViewById(R.id.textViewTarikhAvalinGhest);

        if (!mTarikh.equals(""))
            textView.setText(mTarikh);

        textInputLayout.setOnClickListener(view2 -> {
            String str = textView.getText().toString();
            if (str.equals("")) {
                showCalendar();
            } else {
                showCalendar(str);
            }
        });
        textView.setOnClickListener(view2 -> {
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
        datePickerDialog.setOnDateSetListener(this::onDateSet);
        datePickerDialog.show(getActivity().getFragmentManager(), "");
    }

    private void showCalendar(String date) {
        int year = Integer.parseInt(date.split("/")[0]);
        int month = Integer.parseInt(date.split("/")[1]) - 1;
        int day = Integer.parseInt(date.split("/")[2]);
        DatePickerDialog datePickerDialog = DatePickerDialog.newInstance(this::onDateSet, year, month, day);
        datePickerDialog.setOnDateSetListener(this::onDateSet);
        datePickerDialog.show(getActivity().getFragmentManager(), "");
    }

    private void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        NumberFormat numberFormater = new DecimalFormat("00");
        String date = year + "/" +
                numberFormater.format(monthOfYear + 1) + "/" +
                numberFormater.format(dayOfMonth);
        TextView textView = getActivity().findViewById(R.id.textViewTarikhAvalinGhest);
        textView.setText(date);
    }
}