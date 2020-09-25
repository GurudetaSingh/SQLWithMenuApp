package edu.csustan.cs4950.sqlwithmenu;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class InsertActivity extends AppCompatActivity {
    private Container container;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        container = new Container(this);
        setContentView(R.layout.activity_insert);
    }

    public void insert(View v) {
        // Get data
        EditText inputName = findViewById(R.id.inputName);
        EditText inputPoint = findViewById(R.id.inputPoint);
        String name = inputName.getText().toString();
        float point = Float.parseFloat(inputPoint.getText().toString());

        // Insert data into table
        container.insert(name, point);

        // Go back to main screen
        Toast.makeText(this, "inserted", Toast.LENGTH_SHORT).show();
        finish();
    }
}
