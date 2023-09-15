package ir.farahbakhsh3.LoanManager;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import ir.farahbakhsh3.LoanManager.ui.AddNewLoan.FragmentAddNewLoanProperties;
import ir.farahbakhsh3.LoanManager.ui.AddNewLoan.FragmentAddNewLoanSave;

public class AddNewLoanActivity extends AppCompatActivity {

    public static final String LOAN_PREFERENCES = "Loan_Preferences";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //ActivityAddNewLoanBinding binding = ActivityAddNewLoanBinding.inflate(getLayoutInflater());
        //binding.getRoot());
        setContentView(R.layout.activity_add_new_loan);
        getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        SharedPreferences settings = getSharedPreferences(LOAN_PREFERENCES, MODE_PRIVATE);
        SharedPreferences.Editor prefEditor = settings.edit();
        prefEditor.clear();
        prefEditor.commit();

        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav_view_add_new_loan);

        FragmentReplacer(new FragmentAddNewLoanProperties());

        bottomNav.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.item_new_loan_properties) {
                if (bottomNav.getSelectedItemId() != R.id.item_new_loan_properties)
                    FragmentReplacer(new FragmentAddNewLoanProperties());
            } else if (item.getItemId() == R.id.item_new_loan_save) {
                if (bottomNav.getSelectedItemId() != R.id.item_new_loan_save)
                    FragmentReplacer(new FragmentAddNewLoanSave());
            }
            return true;
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return true;
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void FragmentReplacer(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
//        ft.setCustomAnimations(R.anim.enter, R.anim.exit);
        ft.replace(R.id.fragment_add_new_loan, fragment);
        ft.commit();
    }
}