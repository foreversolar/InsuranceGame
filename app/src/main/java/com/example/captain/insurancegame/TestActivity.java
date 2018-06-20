package com.example.captain.insurancegame;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class TestActivity extends Activity {
   private Button mybutton;
   private Context mcontext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        mcontext=this;
        mybutton=(Button)findViewById(R.id.buttontest);
        mybutton.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            Toast.makeText(mcontext,"adad",Toast.LENGTH_SHORT).show();
                                        }
                                    }
        );
    }
}
