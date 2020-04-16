package de.htw_berlin.fb4.ai.schwotzer.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import adder.Adder;
import de.htw_berlin.fb4.ai.schwotzer.R;
import de.htw_berlin.fb4.ai.schwotzer.control.AdderFactory;
import de.htw_berlin.fb4.ai.schwotzer.model.SumMemorySingleton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int restoredSum = SumMemorySingleton.getSumMemoryInstance(this).restore();
        TextView sumTextView = this.findViewById(R.id.sum);
        sumTextView.setText(String.valueOf(restoredSum));
    }

    public void onAddClick(View view) {
        TextView sumTextView = this.findViewById(R.id.sum);

        CharSequence text = sumTextView.getText();
        int sum = Integer.parseInt(text.toString());

        EditText summandView = this.findViewById(R.id.summand);

        text = summandView.getText();
        int summand = Integer.parseInt(text.toString());

        Adder adder = AdderFactory.createAdder();
        try {
            sum = adder.add(sum, summand);
        } catch (Exception e) {
            Toast.makeText(this, "Overflow happened", Toast.LENGTH_SHORT).show();
        }

        sumTextView.setText(String.valueOf(sum));

        SumMemorySingleton.getSumMemoryInstance(this).save(sum);
    }
}
