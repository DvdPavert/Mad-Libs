package com.example.daniel.pavert_pset2;

import android.content.Intent;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

public class InputActivity extends AppCompatActivity {

    private Story story;
    private EditText editWord;
    private int storyNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        storyNo =  getIntent().getIntExtra("StoryNo", 0);
        editWord =  (EditText) findViewById(R.id.editWord);

        try
        {
            getStory();
        }  catch (IOException e)  {
            e.printStackTrace();
        }

        editWord.setText(story.getNextPlaceholder());
    }


    public void getStory() throws IOException
    {

        InputStream targetStream  = null;

        if(storyNo == -1)
        {
            Random r = new Random();
            storyNo = r.nextInt(5);
        }

        switch (storyNo)
        {
            case(0):
            {
                targetStream = getAssets().open("Stories/madlib0_simple.txt", AssetManager.ACCESS_UNKNOWN);
                break;
            }

            case(1):
            {
                targetStream = getAssets().open("Stories/madlib1_tarzan.txt", AssetManager.ACCESS_UNKNOWN);
                break;
            }

            case(2):
            {
                targetStream = getAssets().open("Stories/madlib2_university.txt", AssetManager.ACCESS_UNKNOWN);
                break;
            }

            case(3):
            {
                targetStream = getAssets().open("Stories/madlib3_clothes.txt", AssetManager.ACCESS_UNKNOWN);
                break;
            }

            case(4):
            {
                targetStream = getAssets().open("Stories/madlib4_dance.txt", AssetManager.ACCESS_UNKNOWN);
                break;
            }

        }

        story = new Story(targetStream);
    }


    public void onClick(View view) throws IOException {

        story.fillInPlaceholder(editWord.getText().toString());
        editWord.setText(story.getNextPlaceholder());

        if(story.isFilledIn())
        {
            toStory();
        }
    }

    @Override
    public void onBackPressed()
    {
        Intent intent = new Intent(this, StartActivity.class);
        startActivity(intent);
        finish();
    }

    private void toStory() throws IOException {
        Intent intent = new Intent(this, StoryActivity.class);

        Bundle bundle = new Bundle();
        bundle.putSerializable("Story", story);

        intent.putExtras(bundle);

        startActivity(intent);
        finish();
    }


}
