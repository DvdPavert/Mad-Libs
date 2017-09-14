package com.example.daniel.pavert_pset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
    }
    
    public void toInput(View view)
    {
        Intent intent = new Intent(this, InputActivity.class);

        int storyNo = getStory();
        intent.putExtra("StoryNo", storyNo);
        startActivity(intent);
        finish();
    }

    private int getStory()
    {
        Spinner spinner = (Spinner) findViewById(R.id.spinnerStory);

        switch(spinner.getSelectedItem().toString())
        {
            case("Random"):
            {
                return -1;
            }
            case("Simple"):
            {
                return 0;
            }
            case("Tarzan"):
            {
                return 1;
            }
            case("University"):
            {
                return 2;
            }
            case("Clothes"):
            {
                return 3;
            }
            case("Dance"):
            {
                return 4;
            }
            default:
            {
                return -1;
            }

        }
    }
}
