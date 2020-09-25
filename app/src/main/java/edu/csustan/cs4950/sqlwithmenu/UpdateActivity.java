package edu.csustan.cs4950.sqlwithmenu;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class UpdateActivity extends AppCompatActivity {
    private Container container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        container = new Container(this);
        setContentView(R.layout.activity_update);
    }

    public void update(View v) {
        EditText inputID = findViewById(R.id.inputID);
        EditText inputPoint = findViewById(R.id.inputPoint);
        int id = Integer.parseInt(inputID.getText().toString());
        float point = Float.parseFloat(inputPoint.getText().toString());

        // Update data in table
        container.update(id, point);

        // Go back to main screen
        Toast.makeText(this, "updated", Toast.LENGTH_SHORT).show();
        finish();
    }
}
