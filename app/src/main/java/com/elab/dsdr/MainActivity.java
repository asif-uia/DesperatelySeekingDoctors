package com.elab.dsdr;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity
        implements MenuItem.OnMenuItemClickListener {
    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        //noinspection deprecation
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.hotline_emergency, R.id.join_dsdr,
                R.id.visit_page, R.id.visit_youtube, R.id.about_we)
                .setDrawerLayout(drawer)
                .build();
        final NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        MenuItem i = navigationView.getMenu().findItem(R.id.join_dsdr);
        MenuItem j = navigationView.getMenu().findItem(R.id.visit_page);
        MenuItem k = navigationView.getMenu().findItem(R.id.join_dsdr_special);
        MenuItem l = navigationView.getMenu().findItem(R.id.visit_youtube);

        i.setOnMenuItemClickListener(this);
        j.setOnMenuItemClickListener(this);
        k.setOnMenuItemClickListener(this);
        l.setOnMenuItemClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.exit) {
            finishAffinity();
        }
        if (id == R.id.share) {
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT,
                    "Check out DSDR app at: https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID);
            sendIntent.setType("text/plain");
            startActivity(sendIntent);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout d = findViewById(R.id.drawer_layout);
        if (d.isDrawerOpen(GravityCompat.START)) {
            d.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.visit_page) {
            startActivity(facebookPageIntent(getApplicationContext()));
        }
        if (id == R.id.join_dsdr) {
            startActivity(facebookGroupIntent(getApplicationContext(), "397519470727469"));
        }
        if (id == R.id.join_dsdr_special) {
            startActivity(facebookGroupIntent(getApplicationContext(), "675260586557796"));
        }
        if (id == R.id.visit_youtube) {
            startActivity(youtubeIntent("https://www.youtube.com/channel/UCND4mpI1O1TkmBXtUnENWDQ"));
        }
        return false;
    }

    private Intent youtubeIntent(String url) {
        try {
            getApplicationContext().getPackageManager().getPackageInfo("com.google.android.youtube", 0);
            Intent intent = new Intent();
            intent.setData(Uri.parse(url));
            intent.setPackage("com.google.android.youtube");
            return intent;
        } catch (Exception e) {
            return new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        }
    }

    private static Intent facebookGroupIntent(Context context, String id) {
        try {
            context.getPackageManager().getPackageInfo("com.facebook.katana", 0);
            return new Intent(Intent.ACTION_VIEW, Uri.parse("fb://group/" + id));
        } catch (Exception e) {
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.facebook.com/" + id));
        }
    }

    private static Intent facebookPageIntent(Context context) {
        try {
            context.getPackageManager().getPackageInfo("com.facebook.katana", 0);
            return new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/1127879400572096"));
        } catch (Exception e) {
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.facebook.com/sakalyen"));
        }
    }
}
