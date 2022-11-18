package com.example.myapplication_;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.app.ActivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.graphics.BitmapFactory;

import com.example.myapplication_.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    int score = 0;
    // Used to load the 'myapplication_' library on application startup.
    static {
        System.loadLibrary("myapplication_");
    }

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Example of a call to a native method
        TextView tv = binding.score;
        tv.setText(stringFromJNI());
        Button bt = binding.addscore;
        bt.setOnClickListener(new View.OnClickListener(){ 
            @Override
            public void onClick(View puppet){

            	    score++;
            	    tv.setText(String.valueOf(score));
               }

            });	
        Button bt2 = binding.bluetooth;
        bt2.setOnClickListener(new View.OnClickListener(){ 
            @Override
            public void onClick(View puppet){

            	    score--;
            	    tv.setText(String.valueOf(score));
               }

            });	
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
           this.setTaskDescription(
               new ActivityManager.TaskDescription(
                   "KEY_STATE_PRESSED2"  //or null for default title
           ) ); 
       }
    
    }
    /**
     * A native method that is implemented by the 'myapplication_' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}
