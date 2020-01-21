package com.example.database;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListPopupWindow;
import android.widget.Toast;

import static android.widget.Toast.*;

public class MainActivity extends AppCompatActivity {
EditText vall1 ,vall2,ans;
Button cal;
//Double valu1,valu2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     vall1=(EditText) findViewById(R.id.val1);
     vall2=(EditText) findViewById(R.id.val2);
      ans=(EditText) findViewById(R.id.ans);
     cal=(Button) findViewById(R.id.calculate);
        mydatabase myDb=new mydatabase(this);
       Boolean b= myDb.addData("Tawakaltu","Adio","adio2@gmail.com");
        if(b)
        {
            makeText(MainActivity.this,"Successfully", LENGTH_LONG).show();
        }else
            {
                makeText(MainActivity.this,"Failed", LENGTH_LONG).show();

            }
//        cal.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                valu1=Float.parseFloat(val1.getText().toString());
//                valu2=Float.parseFloat(val2.getText().toString());
//                makeText(MainActivity.this,valu1, LENGTH_LONG).show();
//                makeText(this, "Result: " +  valu2, LENGTH_LONG).show();
////                ans.setText(valu1 - valu2);
//
//            }
//        });
        onCalculate();
    }

    public void alert(String msg)
    {
        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_LONG).show();
    }



    public void onCalculate()
    {
        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Double valu1=Double.parseDouble(vall1.getText().toString());
               Double valu2=Double.parseDouble(vall2.getText().toString());
               Double res=valu1-valu2;
            alert("here"+valu1);
               ans.setText(""+ res);

            }
        });
    }
}
