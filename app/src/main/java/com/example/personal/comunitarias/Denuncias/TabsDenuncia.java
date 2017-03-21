package com.example.personal.comunitarias.Denuncias;


import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.example.personal.comunitarias.R;

public class TabsDenuncia extends AppCompatActivity {

    TabLayout tabLayout;
    CustomViewPager viewPager;
    LinearLayout tabStrip;
    CoordinatorLayout coordinatorLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tabs_denuncia);

        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayout1);

        //toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        viewPager = (CustomViewPager) findViewById(R.id.viewPager);
        viewPager.setPagingEnabled(false);
        viewPager.setAdapter(new CustomAdapter(getSupportFragmentManager(), getApplicationContext()));

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);

        tabStrip = ((LinearLayout) tabLayout.getChildAt(0));
        BloquearTabs();



        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }
        });

    }
    public void BloquearTabs(){
        tabStrip.getChildAt(0).setClickable(false);
        tabStrip.getChildAt(1).setClickable(false);
        tabStrip.getChildAt(2).setClickable(false);
        tabStrip.getChildAt(3).setClickable(false);
    }


    private class CustomAdapter extends FragmentPagerAdapter {

        private String fragments[] = {"Peticionario", "Denuncia", "Denunciado", "Mostrar Datos"};

        public CustomAdapter(FragmentManager supportFragmentManager, Context applicationContext) {
            super(supportFragmentManager);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new Peticionario(viewPager);
                case 1:
                    return new Denuncia(viewPager);
                case 2:
                    return new Denunciado(viewPager);
                case 3:
                    return new MostrarDatos(viewPager);
                //case 4:
                    //return new MostrarDatos(viewPager);
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return fragments.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return fragments[position];
        }
    }




    //Acciones del boton regresar



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Snackbar.make(coordinatorLayout, "!Si retrocede se perderán los datos ingresados! ¿Desea regresar? ", Snackbar.LENGTH_LONG)
                //.setActionTextColor(Color.CYAN)
                .setActionTextColor(getResources().getColor(R.color.colorPrimary))
                .setAction("Si", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        finish();
                    }
                })
                .show();

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        //replaces the default 'Back' button action
        if(keyCode==KeyEvent.KEYCODE_BACK)
        {
            Snackbar.make(coordinatorLayout, "!Si retrocede se perderán los datos ingresados! ¿Desea regresar? ", Snackbar.LENGTH_LONG)
                    //.setActionTextColor(Color.CYAN)

                    .setActionTextColor(getResources().getColor(R.color.colorAccent))
                    .setDuration(6000)
                    .setAction("Si", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            finish();
                        }
                    })
                    .show();

        }
        return true;
    }
}
