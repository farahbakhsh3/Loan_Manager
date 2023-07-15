package ir.farahbakhsh3.LoanManager;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import ir.farahbakhsh3.LoanManager.ui.AddNewLoan.FragmentAddNewLoanProperties;
import ir.farahbakhsh3.LoanManager.ui.AddNewLoan.FragmentAddNewLoanSave;

public class AddNewLoanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //ActivityAddNewLoanBinding binding = ActivityAddNewLoanBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_add_new_loan); //binding.getRoot());
        getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav_view_add_new_loan);

        FragmentAddNewLoanProperties fgProperties = new FragmentAddNewLoanProperties();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragment_add_new_loan, fgProperties);
        ft.setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);
        ft.commit();

        bottomNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.item_new_loan_properties) {
                    FragmentAddNewLoanProperties fgProperties = new FragmentAddNewLoanProperties();
                    FragmentManager fm = getSupportFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);
                    ft.replace(R.id.fragment_add_new_loan, fgProperties);
                    ft.commit();
                } else if (item.getItemId() == R.id.item_new_loan_save) {
                    FragmentAddNewLoanSave fgSave = new FragmentAddNewLoanSave();
                    FragmentManager fm = getSupportFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);
                    ft.replace(R.id.fragment_add_new_loan, fgSave);
                    ft.commit();
                }
                return true;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return true;
    }

}