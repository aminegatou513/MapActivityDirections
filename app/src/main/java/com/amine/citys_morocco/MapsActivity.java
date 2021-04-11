package com.amine.citys_morocco;

import androidx.annotation.DrawableRes;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import de.hdodenhof.circleimageview.CircleImageView;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    public static Bitmap createCustomMarker(Context context, @DrawableRes int resource, String _name) {

        View marker = ((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.custom_marker_layout, null);

        CircleImageView markerImage = marker.findViewById(R.id.user_dp);
        markerImage.setImageResource(resource);
        TextView txt_name = marker.findViewById(R.id.name);
        txt_name.setText(_name);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        marker.setLayoutParams(new ViewGroup.LayoutParams(52, ViewGroup.LayoutParams.WRAP_CONTENT));
        marker.measure(displayMetrics.widthPixels, displayMetrics.heightPixels);
        marker.layout(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels);
        marker.buildDrawingCache();
        Bitmap bitmap = Bitmap.createBitmap(marker.getMeasuredWidth(), marker.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        marker.draw(canvas);

        return bitmap;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in El Jadida and move the camera
        //33.236837, -8.497276
        LatLng ElJadida = new LatLng(33.236837, -8.497276);
        mMap.addMarker(new MarkerOptions().position(ElJadida).title("ElJadida").icon(BitmapDescriptorFactory.fromBitmap(createCustomMarker(this, R.drawable.eljadida, "ELJADIDA")))).setTitle("ELJADIDA");
        mMap.moveCamera(CameraUpdateFactory.newLatLng(ElJadida));
        //mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ElJadida,15));
        // Casablanca
        //33.558168, -7.567899
        LatLng Casablanca = new LatLng(33.558168, -7.567899);
        mMap.addMarker(new MarkerOptions().position(Casablanca).icon(BitmapDescriptorFactory.fromBitmap(createCustomMarker(this, R.drawable.casa, "CASABLANCA")))).setTitle("CASABLANCA");
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Casablanca));
        //Rabat
        //34.02398429173406, -6.82269882204039
        LatLng Rabat = new LatLng(34.02398429173406, -6.82269882204039);
        mMap.addMarker(new MarkerOptions().position(Rabat).icon(BitmapDescriptorFactory.fromBitmap(createCustomMarker(this, R.drawable.rabat, "RABAT")))).setTitle("RABAT");
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Rabat));
        //Tanger
        //35.74633035410671, -5.822925069833076
        LatLng Tanger = new LatLng(35.7463303541067, -5.822925069833076);
        mMap.addMarker(new MarkerOptions().position(Tanger).icon(BitmapDescriptorFactory.fromBitmap(createCustomMarker(this, R.drawable.tanger, "TANGER")))).setTitle("TANGER");
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Tanger));
        //Agadir
        //30.406565672960536, -9.595642282292577
        LatLng Agadir = new LatLng(30.406565672960536, -9.595642282292577);
        mMap.addMarker(new MarkerOptions().position(Agadir).icon(BitmapDescriptorFactory.fromBitmap(createCustomMarker(this, R.drawable.agadir, "AGADIR")))).setTitle("AGADIR");
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Agadir));
        //////////////
        //mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);

    }
    

}