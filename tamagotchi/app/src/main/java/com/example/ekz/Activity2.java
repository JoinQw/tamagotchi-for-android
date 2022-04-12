package com.example.ekz;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

class Fragment2 extends Fragment {

    public Fragment2() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.activity_2, container, false);
    }
}

public class Activity2 extends AppCompatActivity
{
    public Button button;
    public Button exit;
    public TextView satiety;
    public ImageView imageAni;
    public TextView Name;
    public int corm;
    private void display(int number) {
        satiety.setText("Сытость: "+number);
    }
    public void inten()
    {
        Intent intent = new Intent(Activity2.this,MainActivity.class);
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        button = findViewById(R.id.button);
        satiety =findViewById(R.id.satiety);
        imageAni = findViewById(R.id.imageAni);
        exit = findViewById(R.id.exit);
        Name = findViewById(R.id.etName);
        corm = 30;

        CountDownTimer my_timer;
        my_timer = new CountDownTimer(600000, 1000)
        {
            @Override
            public void onTick(long millisUntilFinished)
            {
                    corm--;
                    satiety.setText("Сытость: "+corm);
            }

            @Override
            public void onFinish()
            {

            }
        };
        my_timer.start();
        CountDownTimer timer;
        timer = new CountDownTimer(600000, 1000)
        {
            @Override
            public void onTick(long millisUntilFinished)
            {
                if(corm>100||corm<0) {
                    imageAni.setImageResource(R.drawable.rip);
                    button.setText("Завести нового друга");
                    my_timer.cancel();
                }
            }

            @Override
            public void onFinish()
            {

            }
        };
        timer.start();
        String nameAni = getIntent().getStringExtra("NameAni");
        String name = getIntent().getStringExtra("Name");
        switch (nameAni)
        {   case ("Lion"): imageAni.setImageResource(R.drawable.lion); break;
            case ("Elephant"): imageAni.setImageResource(R.drawable.elephant);break;
            case ("Crocodile"): imageAni.setImageResource(R.drawable.crocodile);break;
            case ("Giraf"): imageAni.setImageResource(R.drawable.giraf);break;
        }
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                switch (button.getText().toString())
                {
                    case("Покормить"):
                        corm+=5;
                        display(corm);
                        break;
                    case("Завести нового друга"):
                        inten();
                        break;
                }
            }
        });
        exit.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                inten();
            }
        });
    }
}