package com.example.tarea2;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.widget.Toolbar;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

public class interfaces extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private ListView     mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;
    private String[]     mMenuSections;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //setContentView(R.layout.inventario);
        setContentView(R.layout.pedidos);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mMenuSections = getResources().getStringArray(R.array.drawer_items);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        mDrawerList   = findViewById(R.id.left_drawer);

        mDrawerList.setAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, mMenuSections));
        mDrawerList.bringToFront();
        mDrawerLayout.requestLayout();

        mDrawerToggle = new ActionBarDrawerToggle(
                this, mDrawerLayout,
                R.string.app_name, R.string.app_name);

        mDrawerLayout.addDrawerListener(mDrawerToggle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        mDrawerList.setOnItemClickListener((parent, view, position, id) -> {
            Log.d("NAV_DRAWER", mMenuSections[position] + " presionado");
            mDrawerLayout.closeDrawer(mDrawerList);
        });
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mDrawerToggle.onOptionsItemSelected(item)) return true;
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
}
