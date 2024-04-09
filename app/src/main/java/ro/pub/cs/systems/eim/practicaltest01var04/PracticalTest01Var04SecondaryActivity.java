package ro.pub.cs.systems.eim.practicaltest01var04;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PracticalTest01Var04SecondaryActivity extends AppCompatActivity {

    Button cancel, save;
    TextView ed1, e2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var04_secondary);

        cancel=findViewById(R.id.button3);
        save=findViewById(R.id.button4);
        ed1=findViewById(R.id.textView);
        e2=findViewById(R.id.textView2);

        Intent intent= getIntent();
        String sum=intent.getStringExtra(Constants.INPUT1);
        String sum2=intent.getStringExtra(Constants.INPUT2);
        ed1.setText(String.valueOf(sum));
        e2.setText(String.valueOf(sum2));
        save.setOnClickListener(v->{
            Intent result= new Intent();
            setResult(RESULT_OK, result);
            finish();
        });
        cancel.setOnClickListener(v->{
            Intent result= new Intent();
            setResult(RESULT_CANCELED, result);
            finish();
        });
    }
    }
