package com.kentubman5.magiclifecounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    HashMap<View, Integer> counters = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    @Override
    protected void onResume(){
        super.onResume();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    public void init(){
        counters.put(findViewById(R.id.counter1), 20);
        counters.put(findViewById(R.id.counter2), 20);

        for(final View v : counters.keySet()){
            ImageButton add_button = (ImageButton) v.findViewById(R.id.add_button);
            ImageButton sub_button = (ImageButton) v.findViewById(R.id.sub_button);

            add_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    TextView tempText = (TextView) v.findViewById(R.id.count);
                    Integer current = counters.get(v);
                    counters.remove(v);
                    counters.put(v, current+1);
                    if(counters.get(v)!=null) {
                        tempText.setText(Integer.toString(counters.get(v)));
                    }else{
                        Log.d("WARNING", "Counter is null");
                    }
                }
            });

            add_button.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    TextView tempText = (TextView) v.findViewById(R.id.count);
                    Integer current = counters.get(v);
                    counters.remove(v);
                    counters.put(v, current+5);
                    if(counters.get(v)!=null) {
                        tempText.setText(Integer.toString(counters.get(v)));
                    }else{
                        Log.d("WARNING", "Counter is null");
                    }
                    return true;
                }
            });

            sub_button.setOnClickListener((new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    TextView tempText = (TextView) v.findViewById(R.id.count);
                    Integer current = counters.get(v);
                    counters.remove(v);
                    counters.put(v, current-1);
                    if(counters.get(v)!=null) {
                        tempText.setText(Integer.toString(counters.get(v)));
                    }else{
                        Log.d("WARNING", "Counter is null");
                    }
                }
            }));

            sub_button.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    TextView tempText = (TextView) v.findViewById(R.id.count);
                    Integer current = counters.get(v);
                    counters.remove(v);
                    counters.put(v, current-5);
                    if(counters.get(v)!=null) {
                        tempText.setText(Integer.toString(counters.get(v)));
                    }else{
                        Log.d("WARNING", "Counter is null");
                    }
                    return true;
                }
            });
        }
    }
}
