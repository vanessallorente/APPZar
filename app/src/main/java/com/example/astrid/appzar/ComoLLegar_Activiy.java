package com.example.astrid.appzar;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.maps.android.PolyUtil;

import java.util.List;

public class ComoLLegar_Activiy extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private LatLng lugar;
    private List<LatLng> decodedPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_como_llegar__activiy);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        Bundle bundle = getIntent().getExtras();
        String marcador = bundle.getString("marcador");

        if (marcador.equals("Basílica del Pilar")){
            lugar = puntosMapa.pilar;
            decodedPath = PolyUtil.decode(puntosMapa.linePilar);
        } else if (marcador.equals("Palacio de la Aljafería")){
            lugar = puntosMapa.aljaferia;
            decodedPath = PolyUtil.decode(puntosMapa.lineAljaferia);
        } else if (marcador.equals("Teatro Romano")){
            lugar = puntosMapa.teatroRomano;
            decodedPath = PolyUtil.decode(puntosMapa.lineTeatroRom);
        } else if (marcador.equals("Catedral de La Seo")){
            lugar = puntosMapa.laSeo;
            decodedPath = PolyUtil.decode(puntosMapa.lineLaSeo);
        } else if (marcador.equals("Foro Romano")){
            lugar = puntosMapa.foroRomano;
            decodedPath = PolyUtil.decode(puntosMapa.lineForoRom);
        }

        mMap.addMarker(new MarkerOptions().position(puntosMapa.usj).title("USJ"));
        mMap.addMarker(new MarkerOptions().position(lugar).title(marcador)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        mMap.addPolyline(new PolylineOptions().addAll(decodedPath));

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(lugar, 17));

    }

}
