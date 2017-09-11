package com.mycompany.gojapan;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;


public class scheduleActivity extends ListActivity {
    ArrayList<HashMap<String, String>> productsList;
    private static final String TAG_PID = "pid";
    private static final String TAG_NAME = "name";
    static final String[] places = new String[]{
            "大阪花園難波酒店"
            ,"電器、電子產品商城"
            ,"Pokemon Center"
            ,"心齋橋筋商店街"
            ,"日本大阪府大阪市北區梅田 yodobashi"
            ,"日本大阪府大阪心斎橋 crystal 地下街"
            ,"AppBank"
            ,"住之江(平林)"
            ,"關西空港"
            ,"OSAKA海遊きっぷ"
            ,"梅田"
            ,"祗園"
            ,"清水寺"
            ,"黑門市場"
            ,"BIG STEP"
            ,"NANBA CITY"
            ,"天王寺"
            ,"大阪城"
            ,"道顿堀"
    };

    static final String[] pno = new String[]{
            "1"
            ,"2"
            ,"3"
            ,"4"
            ,"5"
            ,"6"
            ,"7"
            ,"8"
            ,"9"
            ,"10"
            ,"11"
            ,"12"
            ,"13"
            ,"14"
            ,"15"
            ,"16"
            ,"17"
            ,"18"
            ,"19"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        productsList = new ArrayList<HashMap<String, String>>();
       // setContentView(R.layout.activity_schedule);
        setAdapter();
        clickCallBack();
    }

    public void clickCallBack(){
        ListView lv;
        lv = getListView();
        lv.setTextFilterEnabled(true);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // getting values from selected ListItem

                String pid = ((TextView) view.findViewById(R.id.pid)).getText()
                        .toString();




                // Starting new intent
                Bundle bundle = new Bundle();
                bundle.putString("place",pid);
                Intent intent = new Intent();
                intent.putExtras(bundle);
                setResult(RESULT_OK,intent);
                scheduleActivity.this.finish();

                 /*
                String pid = ((TextView) view.findViewById(R.id.pid)).getText()
                        .toString();

                Toast.makeText(getApplicationContext(),pid, Toast.LENGTH_SHORT).show();
                */
            }
        });

    }
    private void setAdapter(){

        for(int i =0;i<places.length;i++)
        {
           String p=places[i];
           String n=pno[i];
            HashMap<String, String> map = new HashMap<String, String>();
            map.put(TAG_PID,n);
            map.put(TAG_NAME,p);
            productsList.add(map);
        }
        SimpleAdapter adapter = new SimpleAdapter(
                this, productsList,
                R.layout.list_item, new String[] { TAG_PID,
                TAG_NAME },
                new int[] { R.id.pid, R.id.name });

        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_item, places);
        setListAdapter(adapter);
    }




}
