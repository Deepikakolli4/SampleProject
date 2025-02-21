package com.example.myapp1;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private boolean isBigFont = true;
    private int colorIndex = 0;

    // Define multiple colors
    private final int[] colors = {
            Color.RED,
            Color.BLUE,
            Color.GREEN,
            Color.MAGENTA,
            Color.CYAN
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        Button button1 = findViewById(R.id.button1);

        // Adjusting padding for system insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Button click listener to toggle font size and cycle colors
        button1.setOnClickListener(v -> {
            // Toggle font size
            if (isBigFont) {
                textView.setTextSize(16);
            } else {
                textView.setTextSize(30);
            }
            isBigFont = !isBigFont;

            // Cycle through colors
            textView.setTextColor(colors[colorIndex]);
            colorIndex = (colorIndex + 1) % colors.length; // Move to the next color, reset if needed
        });
    }
}
