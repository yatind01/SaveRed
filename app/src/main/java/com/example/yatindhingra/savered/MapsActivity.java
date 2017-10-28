package com.example.yatindhingra.savered;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;


import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng delhi = new LatLng(28.546139, 77.273130);
        CameraPosition target = CameraPosition.builder().target(delhi).zoom((float) 14.6).bearing(82).tilt(30).build();

        mMap.addMarker(new MarkerOptions().position(new LatLng(28.546139, 77.273130)).title("Apollo Hospital"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(28.545555, 77.271730)).title("XYZ Hospital"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(28.538930, 77.266834)).title("ABC Hospital"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(28.538935, 77.272834)).title("PQR Hospital"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(28.538450, 77.268834)).title("MNO Hospital"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(delhi));
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(target));
    }
}
