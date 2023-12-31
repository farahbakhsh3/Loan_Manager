package ir.farahbakhsh3.LoanManager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import ir.farahbakhsh3.LoanManager.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private AppBarConfiguration mAppBarConfiguration2;
    private ActivityMainBinding binding;
    private long pressedTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbarMain);

        SQLiteHelper sqLiteHelper = new SQLiteHelper(this);

//        binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navViewMain;
        BottomNavigationView bottomNavView = findViewById(R.id.bottom_nav_view_main);

        mAppBarConfiguration2 = new AppBarConfiguration.Builder(
                R.id.nav_settings,
                R.id.nav_backup,
                R.id.nav_restore,
                R.id.nav_aboutus,
                R.id.navigation_moavagh,
                R.id.navigation_taghvim,
                R.id.navigation_daftarche
        )
                .build();
        NavController navController2 = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController2, mAppBarConfiguration2);
        NavigationUI.setupWithNavController(bottomNavView, navController2);

        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_settings,
                R.id.nav_backup,
                R.id.nav_restore,
                R.id.nav_aboutus,
                R.id.navigation_moavagh,
                R.id.navigation_taghvim,
                R.id.navigation_daftarche
        )
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = binding.drawerLayout;
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
            Toast.makeText(getBaseContext(), R.string.back_to_exit, Toast.LENGTH_SHORT).show();
        } else {
            if (pressedTime + 2000 > System.currentTimeMillis()) {
                super.onBackPressed();
                finish();
            } else {
                Toast.makeText(getBaseContext(), R.string.back_to_exit, Toast.LENGTH_SHORT).show();
            }
        }
        pressedTime = System.currentTimeMillis();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == R.id.action_menu_settings) {
            Intent GoActivity = new Intent(this, AddNewLoanActivity.class);
            startActivity(GoActivity);
        }

        return super.onOptionsItemSelected(item);
    }
}
