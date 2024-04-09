package ro.pub.cs.systems.eim.practicaltest01var04;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText ed1, ed2, ed3;
    Button b1, b2;
    CheckBox c1, c2;
    ActivityResultLauncher<Intent> activityResultLauncher;
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(Constants.INPUT1, ed1.getText().toString());
        outState.putString(Constants.INPUT2, ed2.getText().toString());
        outState.putString(Constants.INPUT3, ed3.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if(savedInstanceState.containsKey(Constants.INPUT1)){
            ed1.setText(savedInstanceState.getString(Constants.INPUT1));
        }else{
            ed1.setText("");
        }
        if(savedInstanceState.containsKey(Constants.INPUT2)){
            ed2.setText(savedInstanceState.getString(Constants.INPUT2));
        }else{
            ed2.setText("");
        }
        if(savedInstanceState.containsKey(Constants.INPUT3)){
            ed2.setText(savedInstanceState.getString(Constants.INPUT3));
        }else{
            ed2.setText("");
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1=findViewById(R.id.editTextText);
        ed2=findViewById(R.id.editTextText2);
        ed3=findViewById(R.id.editTextText3);
        b1=findViewById(R.id.button);
        b2=findViewById(R.id.button2);
        c1=findViewById(R.id.checkBox);
        c2=findViewById(R.id.checkBox2);
        b2.setOnClickListener(v->{
            String big="";
            Boolean a=true;
           if(c1.isChecked()==true){
               String unu=ed1.getText().toString();
               if(unu.isEmpty()){
                   //toasteer
                   Toast.makeText(this,"Primul camp nu e completat", Toast.LENGTH_LONG).show();
                a=false;
               }else{
                   big=unu;
               }
           }

            if(c2.isChecked()==true){
                String doi=ed2.getText().toString();
                if(doi.isEmpty()){
                    //toasteer
                    Toast.makeText(this,"Primul camp nu e completat", Toast.LENGTH_LONG).show();
                    a=false;
                }else{
                    big=big+doi;

                }
            }
            if(a){
                ed3.setText(big);
            }else{
                ed3.setText("");
            }

        });
        activityResultLauncher=registerForActivityResult( new ActivityResultContracts.StartActivityForResult(), result ->{
            if(result.getResultCode()== RESULT_OK){

                Toast.makeText(this," SAVE ->ok", Toast.LENGTH_LONG).show();

            }else{
                Toast.makeText(this," Cancel  -> !ok", Toast.LENGTH_LONG).show();

            }
        });
        b1.setOnClickListener(v->{
            Intent intent =new Intent(getApplicationContext(), PracticalTest01Var04SecondaryActivity.class);
            intent.putExtra(Constants.INPUT1, ed1.getText().toString());
            intent.putExtra(Constants.INPUT2, ed2.getText().toString());
            // startActivity(intent);

            activityResultLauncher.launch((intent));
        });



    }
}