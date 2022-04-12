package com.example.ekz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity
{




    public static class MyAdapter extends FragmentPagerAdapter {

        MyAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return 3;
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 1:
                case 2:
                    return new Fragment2();

                default:
                    return new Fragment();
            }
        }
    }




    void inten(String nameAni)
    {
        Intent intent = new Intent(MainActivity.this,Activity2.class);
        intent.putExtra("NameAni", nameAni);
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageButton ibLion = (ImageButton) findViewById(R.id.ibLion);
        ImageButton ibElephant = (ImageButton) findViewById(R.id.ibElephant);
        ImageButton ibCrocodile = (ImageButton) findViewById(R.id.ibCrocodile);
        ImageButton ibGiraf = (ImageButton) findViewById(R.id.ibGiraf);


        MyAdapter adapter = new MyAdapter(getSupportFragmentManager());

        ViewPager viewPager = findViewById(R.id.viewpager);
        viewPager.setAdapter(adapter); // устанавливаем адаптер
        viewPager.setCurrentItem(1); // выводим второй экран



        View.OnClickListener oclibLion = new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                inten("Lion");
            }
        };
        View.OnClickListener oclibElephant = new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                inten("Elephant");
            }
        };
        View.OnClickListener oclibCrocodile = new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                inten("Crocodile");
            }
        };
        View.OnClickListener ocliGiraf = new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                inten("Giraf");
            }
        };
        ibElephant.setOnClickListener(oclibElephant);
        ibLion.setOnClickListener(oclibLion);
        ibCrocodile.setOnClickListener(oclibCrocodile);
        ibGiraf.setOnClickListener(ocliGiraf);
    }
}