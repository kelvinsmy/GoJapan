package com.mycompany.gojapan;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class ActivityMap extends ActionBarActivity {
    int name;
    String nameString;
    private TextView testview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_map);
        Intent intent = getIntent();
        name = intent.getIntExtra(MainActivity.EXTRA_NAME,0);
        if(name==1)
        {
            this.nameString="Sze";
        }else if (name==2){
            this.nameString="Zero";

        }else if(name==3){
            this.nameString="Kaming";
        }else if (name==4){
            this.nameString="Ip";
        }
        //this.testview=(TextView)this.findViewById(R.id.testview);
        //this.testview.setText(nameString);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_map, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
