package com.example.daniel.pavert_pset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class StoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);
        getStory();
    }

    @Override
    public void onBackPressed()
    {
        Intent intent = new Intent(this, StartActivity.class);
        startActivity(intent);
        finish();
    }

    public Story getStory()
    {
        Story story =(Story) getIntent().getExtras().getSerializable("Story");

        TextView textViewStory = (TextView) findViewById(R.id.textViewStory);
        textViewStory.setText(story.toString());
        return story;
    }
}
