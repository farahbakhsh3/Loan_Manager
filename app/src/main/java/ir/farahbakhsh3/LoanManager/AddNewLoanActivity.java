package ir.farahbakhsh3.LoanManager;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import ir.farahbakhsh3.LoanManager.databinding.ActivityAddNewLoanBinding;

public class AddNewLoanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //ActivityAddNewLoanBinding binding = ActivityAddNewLoanBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_add_new_loan); //binding.getRoot());
        getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav_view_add_new_loan);
        TextView itemText = findViewById(R.id.text_add_new_loan);

        bottomNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.item_new_loan_properties) {
                    itemText.setText(R.string.title_add_new_loan_properties);
                } else if (item.getItemId() == R.id.item_new_loan_save) {
                    itemText.setText(R.string.title_add_new_loan_save);
                }
                return true;
            }
        });
    }
}