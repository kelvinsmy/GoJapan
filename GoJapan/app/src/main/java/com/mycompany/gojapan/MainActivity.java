package com.mycompany.gojapan;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;


public class MainActivity extends ActionBarActivity {

    public static final String PREF ="PREF";
    public static final String PREF_INFO = "PREF_INFO";
    public final static String EXTRA_NAME ="NAME";
    int name=5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        restoredPrefs();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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





    private void restoredPrefs(){
        SharedPreferences settings = getSharedPreferences(PREF,0);
        int pref_info = settings.getInt(PREF_INFO, 0);
        if(pref_info!=0) {
            if (pref_info == 1) {
                name = 1;
            } else if (pref_info == 2) {
                name = 2;
            } else if (pref_info == 3) {
                name = 3;
            } else if (pref_info == 4) {
                name = 4;
            }
            Intent getIntent = new Intent(this, MapsActivity.class);
            getIntent.putExtra(EXTRA_NAME, name);
            if(name!=5) {
                startActivity(getIntent);
            }
        }
        }





    public void textOnClick(View view) {
        RadioButton radioButton1 = (RadioButton) findViewById(R.id.radioButton);
        RadioButton radioButton2 = (RadioButton) findViewById(R.id.radioButton2);
        RadioButton radioButton3 = (RadioButton) findViewById(R.id.radioButton3);
        RadioButton radioButton4 = (RadioButton) findViewById(R.id.radioButton4);
        if(radioButton1.isChecked()){
            name=1;
            SharedPreferences settings = getSharedPreferences(PREF,0);
            SharedPreferences.Editor editor = settings.edit();
            editor.putInt(PREF_INFO,name);
            editor.commit();
        }else if(radioButton2.isChecked()){
            name=2;
            SharedPreferences settings = getSharedPreferences(PREF,0);
            SharedPreferences.Editor editor = settings.edit();
            editor.putInt(PREF_INFO,name);
            editor.commit();
        }else if(radioButton3.isChecked()){
            name=3;
            SharedPreferences settings = getSharedPreferences(PREF,0);
            SharedPreferences.Editor editor = settings.edit();
            editor.putInt(PREF_INFO,name);
            editor.commit();
        }else if(radioButton4.isChecked()){
            name=4;
            SharedPreferences settings = getSharedPreferences(PREF,0);
            SharedPreferences.Editor editor = settings.edit();
            editor.putInt(PREF_INFO,name);
            editor.commit();
        }else{
            name=5;
        }
        Intent getIntent = new Intent(this, MapsActivity.class);
        getIntent.putExtra(EXTRA_NAME, name);
        if(name!=5) {
            startActivity(getIntent);
        }


    }







}
