package com.mycompany.gojapan;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.support.v4.app.FragmentActivity;
import android.content.Intent;
import android.os.AsyncTask;
import com.google.android.gms.common.api.GoogleApiClient;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import java.lang.Object;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.os.AsyncTask;
import android.location.Location;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import android.widget.TextView;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Locale;
public class MapsActivity extends FragmentActivity implements
        ConnectionCallbacks, OnConnectionFailedListener, LocationListener {
    Marker marker;
    Marker markers;
    Marker markerz;
    Marker markeri;
    Marker markermy;
    List<Marker> markerList = new ArrayList<Marker>();
    public Location mLastLocation;
    public Location mCurrentLocation;
    private GoogleMap mMap; // Might be null if Google Play services APK is not available.
    double lat;
    double lng;
    String mLastUpdateTime;
    int name;
    String nameString;
    GoogleApiClient mGoogleApiClient;
    JSONParser jParser = new JSONParser();
    protected static final String TAG = "basic-location-sample";
    ArrayList<HashMap<String, String >> productsList;
    JSONParser jsonParser = new JSONParser();
    private static final String TAG_LAT= "lat";
    private static final String TAG_LNG="lng";
    private static final String TAG_SUCCESS = "success";
    private static final String TAG_NAME = "name";
    private static final String TAG_PRODUCT = "products";
    private static final String url_update_product = "http://plbpc013.ouhk.edu.hk/s1129900/travel/update_travel.php";
    private static String url_all_products = "http://plbpc013.ouhk.edu.hk/s1129900/travel/get_all_products.php";
    JSONArray productObj;
    JSONArray products = null;
    boolean connect = true;
    private static final String TAG_PRODUCTS = "products";
    private static final int ACTIVITY_REPORT = 1000;
    boolean mRequestingLocationUpdates = true;
    boolean locationChange = false;

    static final String[] pl = new String[]{
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
    static final String[] placej = new String[]{
            "フローラルイン難波"
            ,""
            ,""
            ,"地鐵御堂筋線「心齋橋站」 5/6號出口 徒步1分"
            ,"jump shop"
            ,""
            ,""
            ,""
            ,"關西空港到難波 :南海電鐵(890),車頭有這個字樣「空港急行 なんば」"
            ,"轉搭中央線-->大阪港"
            ,""
            ,""
            ,""
            ,""
            ,""
            ,""
            ,""
            ,""
            ,"螃蟹道樂本家\n四點之前有比較便宜的套餐"
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
    static final  double[] plan = new double[]{
            34.667452
            ,34.668555
           ,34.701788
            ,34.673445
            ,34.7040949
            ,34.6876742
            ,34.705618
            ,34.609705
            ,34.432268
            ,34.654514
            ,34.700599
            ,35.003847
            ,34.994857
            ,34.665276
            ,34.672322
            ,34.663098
            ,34.64802
            ,34.687227
            ,34.668749
    };
    static final double[] plng = new double[]{
            135.503924
            ,135.502705
            ,135.496391
            ,135.501624
            ,135.4963557
            ,135.4988073
            ,135.494709
            ,135.468282
            ,135.230566
            ,135.428899
            ,135.495692
            ,135.777244
            ,135.784966
            ,135.506563
            ,135.498792
            ,135.502346
            ,135.513233
            ,135.526051
            ,135.501348
    };
    static final int[] kind = new int[]{
             1
            ,2
            ,2
            ,2
            ,2
            ,2
            ,2
            ,2
            ,4
            ,5
            ,2
            ,2
            ,2
            ,3
            ,2
            ,2
            ,2
            ,2
            ,3


    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        name = intent.getIntExtra(MainActivity.EXTRA_NAME,0);
        if(name==1)
        {
            this.nameString="Sze";
        }else if (name==2){
            this.nameString="Zero";

        }else if(name==3){
            this.nameString="Tam";
        }else if (name==4){
            this.nameString="Ip";
        }
        setContentView(R.layout.activity_maps);
        setUpMapIfNeeded();
       // new SaveProductDetails().execute();
        setUpPlace();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
        if (mGoogleApiClient.isConnected() && !mRequestingLocationUpdates) {
            startLocationUpdates();
        }

        }

    protected synchronized void buildGoogleApiClient() {
        // protected   void buildGoogleApiClient() {
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();



        //  sendMessage();


    }

    @Override
    protected void onStart() {
        super.onStart();
        mGoogleApiClient.connect();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mGoogleApiClient.isConnected()) {
            mGoogleApiClient.disconnect();
        }
    }
    /**
     * Sets up the map if it is possible to do so (i.e., the Google Play services APK is correctly
     * installed) and the map has not already been instantiated.. This will ensure that we only ever
     * call {@link #setUpMap()} once when {@link #mMap} is not null.
     * <p/>
     * If it isn't installed {@link SupportMapFragment} (and
     * {@link com.google.android.gms.maps.MapView MapView}) will show a prompt for the user to
     * install/update the Google Play services APK on their device.
     * <p/>
     * A user can return to this FragmentActivity after following the prompt and correctly
     * installing/updating/enabling the Google Play services. Since the FragmentActivity may not
     * have been completely destroyed during this process (it is likely that it would only be
     * stopped or paused), {@link #onCreate(Bundle)} may not be called again so we should call this
     * method in {@link #onResume()} to guarantee that it will be called.
     */

    ////
    protected void createLocationRequest() {
        LocationRequest mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(10000);
        mLocationRequest.setFastestInterval(5000);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
    }

    protected void startLocationUpdates() {

        LocationRequest mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(10000);
        mLocationRequest.setFastestInterval(5000);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        LocationServices.FusedLocationApi.requestLocationUpdates(
                mGoogleApiClient, mLocationRequest, this);
    }

    @Override
    public void onLocationChanged(Location location) {
        mCurrentLocation = location;
        mLastUpdateTime = DateFormat.getTimeInstance().format(new Date());
        locationChange = true;
        //updateUI();
    }

    private void updateUI() {
        //mCurrentLocation.getLatitude();
        //mCurrentLocation.getLongitude();
        //mMap.addMarker(new MarkerOptions().position(new LatLng(mLastLocation.getLatitude(), mLastLocation.getLongitude())).title(ms));
        //mLastUpdateTimeTextView.setText(mLastUpdateTime);
    }




    ///



    private void setUpPlace(){
        for(int i =0;i<pl.length;i++){
            String place = pl[i];

            if(kind[i]==1)
            {
                marker = mMap.addMarker(new MarkerOptions().position(new LatLng(plan[i], plng[i])).title(place).icon(BitmapDescriptorFactory.fromResource(R.drawable.hotel)));
                markerList.add(marker);
            }
            if(kind[i]==2)
            {
                marker = mMap.addMarker(new MarkerOptions().position(new LatLng(plan[i], plng[i])).title(place).icon(BitmapDescriptorFactory.fromResource(R.drawable.shop)));
                markerList.add(marker);
            }
            if(kind[i]==3)
            {
                marker = mMap.addMarker(new MarkerOptions().position(new LatLng(plan[i], plng[i])).title(place).icon(BitmapDescriptorFactory.fromResource(R.drawable.restaurant)));
                markerList.add(marker);
            }
            if(kind[i]==4)
            {
                marker = mMap.addMarker(new MarkerOptions().position(new LatLng(plan[i], plng[i])).title(place).icon(BitmapDescriptorFactory.fromResource(R.drawable.airport)));
                markerList.add(marker);
            }
            if(kind[i]==5)
            {
                marker = mMap.addMarker(new MarkerOptions().position(new LatLng(plan[i], plng[i])).title(place).icon(BitmapDescriptorFactory.fromResource(R.drawable.fish)));
                markerList.add(marker);
            }

            //marker = mMap.addMarker(new MarkerOptions().position(new LatLng(plan[i], plng[i])).title(place));
            //markerList.add(marker);

        }
    }



    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }

    public void friendOnClick(View view){
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm.getActiveNetworkInfo() != null) {
            productsList = new ArrayList<HashMap<String, String>>();
            new LoadAllProducts().execute();

        }

    }

    public void scheduleOnClick(View view){
        Intent getIntent1 = new Intent(this, scheduleActivity.class);
        startActivityForResult(getIntent1, ACTIVITY_REPORT);



    }

    public void updateOnClick(View view){
        //buildGoogleApiClient();



        mLastLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
        if (mLastLocation != null && locationChange ==true){
            String ms =nameString;

            if(markermy!=null) {
                markermy.remove();
            }

            if(nameString.equals("Sze")) {

                markermy =mMap.addMarker(new MarkerOptions().position(new LatLng(mCurrentLocation.getLatitude(), mCurrentLocation.getLongitude())).title(ms));
                markerList.add(markermy);
            }
            if(nameString.equals("Zero")) {
                mMap.addMarker(new MarkerOptions().position(new LatLng(mCurrentLocation.getLatitude(), mCurrentLocation.getLongitude())).title(ms).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
            }
            if(nameString.equals("Tam")) {
                mMap.addMarker(new MarkerOptions().position(new LatLng(mCurrentLocation.getLatitude(), mCurrentLocation.getLongitude())).title(ms).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
            }
            if(nameString.equals("Ip")){
                mMap.addMarker(new MarkerOptions().position(new LatLng(mCurrentLocation.getLatitude(), mCurrentLocation.getLongitude())).title(ms).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
            }
            //LatLng ll = new LatLng(mLastLocation.getLatitude(),mLastLocation.getLongitude());
            LatLng ll = new LatLng(mCurrentLocation.getLatitude(),mCurrentLocation.getLongitude());
            CameraUpdate update = CameraUpdateFactory.newLatLngZoom(ll, 17);
            mMap.animateCamera(update);
            new SaveProductDetails().execute();
        }

    }

    /**
     * This is where we can add markers or lines, add listeners or move the camera. In this case, we
     * just add a marker near Africa.
     * <p/>
     * This should only be called once and when we are sure that {@link #mMap} is not null.
     */
    private void setUpMap() {
        buildGoogleApiClient();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent){
       super.onActivityResult(requestCode, resultCode, intent);
        if(resultCode==RESULT_OK){
            if(requestCode==ACTIVITY_REPORT){
                Bundle bundle = intent.getExtras();
                String complace = bundle.getString("place");
                for(int i =0;i<pno.length;i++){
                    if(complace.equals(pno[i])){
                        TextView tv = (TextView) findViewById(R.id.textView);
                        TextView tv1 = (TextView) findViewById(R.id.textView2);
                        tv.setText(pl[i]);
                        tv1.setText(placej[i]);
                        LatLng ll = new LatLng(plan[i],plng[i]);
                        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(ll, 17);
                        mMap.animateCamera(update);
                    }
                }


            }
        }
    }





    @Override
    public void onConnected(Bundle connectionHint) {
        // Provides a simple way of getting a device's location and is well suited for
        // applications that do not require a fine-grained location and that do not need location
        // updates. Gets the best and most recent location currently available, which may be null
        // in rare cases when a location is not available.

        mLastLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);


        if(mLastLocation != null){
            //Toast.makeText(this,"Current Location is available", Toast.LENGTH_LONG).show();
            if (mRequestingLocationUpdates) {
                startLocationUpdates();
            }

            this.lat=mLastLocation.getLatitude();
            this.lng=mLastLocation.getLongitude();
            Date now = new Date();
            SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm",Locale.ENGLISH);

            //String ms ="Me: "+df.format(now.getTime());

            String ms =nameString;
            if(name==1) {
                markermy =mMap.addMarker(new MarkerOptions().position(new LatLng(mLastLocation.getLatitude(), mLastLocation.getLongitude())).title(ms));
                markerList.add(markermy);

            }
            if(name==2) {
                mMap.addMarker(new MarkerOptions().position(new LatLng(mLastLocation.getLatitude(), mLastLocation.getLongitude())).title(ms).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
            }
            if(name==3) {
                mMap.addMarker(new MarkerOptions().position(new LatLng(mLastLocation.getLatitude(), mLastLocation.getLongitude())).title(ms).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
            }
            if(name==4) {
                mMap.addMarker(new MarkerOptions().position(new LatLng(mLastLocation.getLatitude(), mLastLocation.getLongitude())).title(ms).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
            }
            LatLng ll = new LatLng(mLastLocation.getLatitude(),mLastLocation.getLongitude());
            if(connect==true) {
                connect=false;
                CameraUpdate update = CameraUpdateFactory.newLatLngZoom(ll, 15);
                mMap.animateCamera(update);
            }
        }
        else {
            Toast.makeText(this, "Current location is Not available", Toast.LENGTH_LONG).show();
            this.lat=0;
            this.lng=0;
        }

        ///


        ///

    }

    //
    @Override
    protected void onPause() {
        super.onPause();
        stopLocationUpdates();
    }

    protected void stopLocationUpdates() {
        LocationServices.FusedLocationApi.removeLocationUpdates(
                mGoogleApiClient, this);
    }


    //
    @Override
    public void onConnectionFailed(ConnectionResult result) {
        // Refer to the javadoc for ConnectionResult to see what error codes might be returned in
        // onConnectionFailed.
        Log.i(TAG, "Connection failed: ConnectionResult.getErrorCode() = " + result.getErrorCode());
    }


    @Override
    public void onConnectionSuspended(int cause) {
        // The connection to Google Play services was lost for some reason. We call connect() to
        // attempt to re-establish the connection.
        Log.i(TAG, "Connection suspended");
        mGoogleApiClient.connect();
    }

    class SaveProductDetails extends AsyncTask<String, String, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }
        protected String doInBackground(String... args) {
            String latt=Double.toString(mLastLocation.getLatitude());
            String lngg=Double.toString(mLastLocation.getLongitude());
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair(TAG_NAME,nameString));
            params.add(new BasicNameValuePair(TAG_LAT, latt));
            params.add(new BasicNameValuePair(TAG_LNG, lngg));
            JSONObject json = jsonParser.makeHttpRequest(url_update_product,
                    "GET", params);



        try {
            int success = json.getInt(TAG_SUCCESS);

            if (success == 1) {
                // successfully updated
               // Intent i = getIntent();
                // send result code 100 to notify about product update
              //  setResult(100, i);
               // finish();
            } else {
                // failed to update product
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

        protected void onPostExecute(String file_url) {
            // dismiss the dialog once product uupdated

        }


    }

    class LoadAllProducts extends AsyncTask<String, String, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }
        protected String doInBackground(String... args) {
            // Building Parameters
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            // getting JSON string from URL
            JSONObject json = jParser.makeHttpRequest(url_all_products, "GET", params);

            // Check your log cat for JSON reponse
            //Log.d("All Products: ", json.toString());

            try {
                // Checking for SUCCESS TAG
                int success = json.getInt(TAG_SUCCESS);

                if (success == 1) {
                    // products found
                    // Getting Array of Products
                    products = json.getJSONArray(TAG_PRODUCTS);

                    // looping through All Products
                    for (int i = 0; i < products.length(); i++) {
                        JSONObject c = products.getJSONObject(i);

                        // Storing each json item in variable
                        String name = c.getString(TAG_NAME);
                        String lat = c.getString(TAG_LAT);
                        String lng = c.getString(TAG_LNG);

                        //
                        // String price = c.getString(TAG_PRICE);
                        //String description = c.getString(TAG_DESCRIPTION);
                        //


                        // creating new HashMap
                        HashMap<String, String> map = new HashMap<String, String>();

                        // adding each child node to HashMap key => value
                       map.put(TAG_NAME, name);
                       map.put(TAG_LAT, lat);
                        map.put(TAG_LNG,lng);
                        // map.put(TAG_PRICE, price);
                        //map.put(TAG_DESCRIPTION, description);
                        // adding HashList to ArrayList
                        productsList.add(map);
                    }
                } else {
                    // no products found
                    // Launch Add New product Activity

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }
        protected void onPostExecute(String file_url) {
            String nametask1 = productsList.get(1).get(TAG_NAME);
            double lattask1 = Double.parseDouble(productsList.get(1).get(TAG_LAT));
            double lngtask1 = Double.parseDouble(productsList.get(1).get(TAG_LNG));

            String nametask2 = productsList.get(3).get(TAG_NAME);
            double lattask2 = Double.parseDouble(productsList.get(3).get(TAG_LAT));
            double lngtask2 = Double.parseDouble(productsList.get(3).get(TAG_LNG));

            String nametask3 = productsList.get(2).get(TAG_NAME);
            double lattask3 = Double.parseDouble(productsList.get(2).get(TAG_LAT));
            double lngtask3 = Double.parseDouble(productsList.get(2).get(TAG_LNG));

            String nametask4 = productsList.get(0).get(TAG_NAME);
            double lattask4 = Double.parseDouble(productsList.get(0).get(TAG_LAT));
            double lngtask4 = Double.parseDouble(productsList.get(0).get(TAG_LNG));


           if(markers!=null) {
               markers.remove();
           }
           if(markerz!=null) {
               markerz.remove();
           }
            if(markeri!=null) {
                markeri.remove();
            }
            if (!nametask1.equals(nameString)&nametask1.equals("Sze"))
            {
                markers = mMap.addMarker(new MarkerOptions().position(new LatLng(lattask1, lngtask1)).title(nametask1));
                markerList.add(markers);
            }
            if (!nametask2.equals(nameString)&nametask2.equals("Zero"))
            {
                markerz = mMap.addMarker(new MarkerOptions().position(new LatLng(lattask2, lngtask2)).title(nametask2).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
                markerList.add(markerz);
            }

            if (!nametask4.equals(nameString)&nametask4.equals("Ip"))
            {
                markerz = mMap.addMarker(new MarkerOptions().position(new LatLng(lattask4, lngtask4)).title(nametask4).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
                markerList.add(markerz);
            }
            if (!nametask3.equals(nameString)&nametask3.equals("Tam"))
            {
                markerz = mMap.addMarker(new MarkerOptions().position(new LatLng(lattask3, lngtask3)).title(nametask3).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
                markerList.add(markerz);
            }


        }





    }


}
