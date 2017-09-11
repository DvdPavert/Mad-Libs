package com.example.daniel.pavert_pset2;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class InputActivity extends AppCompatActivity {

    private Story story;
    private EditText editWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        editWord =  (EditText) findViewById(R.id.editWord);

        try {
            getStory();
        } catch (IOException e) {
            e.printStackTrace();
        }

        editWord.setText(story.getNextPlaceholder());
    }

    public void toStory(View view) throws IOException {
        Intent intent = new Intent(this, StoryActivity.class);
        intent.putExtra("Story", story);
        startActivity(intent);
        finish();
    }

    private void getStory() throws IOException
    {
        /// TODO: 11/09/2017 randomize story picking
        InputStream targetStream;
        targetStream = getAssets().open("Stories/madlib0_simple.txt", AssetManager.ACCESS_UNKNOWN);
        story = new Story(targetStream);
    }


    public void onClick(View view) throws IOException {

        if(story.isFilledIn() == false)
        {
            story.fillInPlaceholder(editWord.getText().toString());
            editWord.setText(story.getNextPlaceholder());
        }
        else
        {
            toStory(view);
        }
    }
}
