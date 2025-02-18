package com.example.czcionka;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private TextView quoteText;
    private TextView textSizeLabel;
    private SeekBar seekBar;
    private Button button;
    private String[] quotes = {"Dzień dobry", "Good morning", "Buenos dias"};
    private int currentQuoteIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quoteText = findViewById(R.id.quoteText);
        textSizeLabel = findViewById(R.id.textSizeLabel);
        seekBar = findViewById(R.id.seekBar);
        button = findViewById(R.id.button);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textSizeLabel.setText("Rozmiar: " + progress);
                quoteText.setTextSize(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) { }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentQuoteIndex = (currentQuoteIndex + 1) % quotes.length;
                quoteText.setText(quotes[currentQuoteIndex]);
            }
        });
    }
}