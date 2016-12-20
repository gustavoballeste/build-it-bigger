package com.balleste.android.displayjoke;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeDisplayActivity extends AppCompatActivity {

    public static final String EXTRA_JOKE = "joke";

    TextView textViewJoke;

    public static Intent getDisplayActivityIntent(Context context, String joke) {
        Intent intent = new Intent(context, JokeDisplayActivity.class);
        intent.putExtra(EXTRA_JOKE, joke);
        return intent;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_display);

        textViewJoke = (TextView) findViewById(R.id.textview_joke);
        String joke = getIntent().getExtras().getString(EXTRA_JOKE);

        textViewJoke.setText(joke);

    }
}
