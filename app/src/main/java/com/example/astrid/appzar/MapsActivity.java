package com.example.astrid.appzar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends AppCompatActivity implements GoogleMap.OnInfoWindowClickListener,
        OnMapReadyCallback {

    private GoogleMap mMap;

    private Marker mUSJ;
    private Marker mPilar;
    private Marker mAljaferia;
    private Marker mTeatroRom;
    private Marker mLaSeo;
    private Marker mForoRom;

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

        // Marcador de la USJ
        mUSJ = mMap.addMarker(new MarkerOptions().position(puntosMapa.usj).title("USJ"));

        //Marcador de 5 sitios turisticos Zgz
        mPilar = mMap.addMarker(new MarkerOptions().position(puntosMapa.pilar)
                .title("Basílica del Pilar")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));
        mAljaferia = mMap.addMarker(new MarkerOptions().position(puntosMapa.aljaferia)
                .title("Palacio de la Aljafería")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE)));
        mTeatroRom = mMap.addMarker(new MarkerOptions().position(puntosMapa.teatroRomano)
                .title("Teatro Romano")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        mLaSeo = mMap.addMarker(new MarkerOptions().position(puntosMapa.laSeo)
                .title("Catedral de La Seo")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
        mForoRom = mMap.addMarker(new MarkerOptions().position(puntosMapa.foroRomano)
                .title("Foro Romano")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)));

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(puntosMapa.pilar, 13));
        mMap.setOnInfoWindowClickListener(this);
    }

    @Override
    public void onInfoWindowClick(Marker marker) {
        if (marker.getTitle().equals("USJ")){
            Toast.makeText(this, "Punto de Partida", Toast.LENGTH_SHORT).show();

        }else {
            Intent i = new Intent(this, InfoActivity.class);
            i.putExtra("marcador", marker.getTitle());
            startActivity(i);
        }
    }
}
