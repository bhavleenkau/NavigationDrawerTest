package navdrawer.test.com.navigationdrawertest.fragment;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import navdrawer.test.com.navigationdrawertest.R;
import navdrawer.test.com.navigationdrawertest.others.GPSTracke;


/**
 * A simple {@link Fragment} subclass.
 */
public class GoogelMapsFragment extends Fragment {

    MapView mapView;
    GoogleMap map;
    GPSTracke gps;
    private double latitude;
    private double longitude;

    @SuppressLint("MissingPermission")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_mapview, container, false);

        // Gets the MapView from the XML layout and creates it
        mapView = (MapView) v.findViewById(R.id.mapview);
        mapView.onCreate(savedInstanceState);

        getlocation();

        // Gets to GoogleMap from the MapView and does initialization stuff
        map = mapView.getMap();
        map.getUiSettings().setMyLocationButtonEnabled(false);
        map.setMyLocationEnabled(true);


        // Needs to call MapsInitializer before doing any CameraUpdateFactory calls
        try {
            MapsInitializer.initialize(this.getActivity());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Updates the location and zoom of the MapView
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(new LatLng(latitude, longitude), 13);

        map.animateCamera(cameraUpdate);


        //WOMEN WELFARE marker's

        map.addMarker(new MarkerOptions().position(new LatLng(-41.270441, 174.784276))
                .title("Birthright.")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_map_marker))
                .snippet("Address:204 Thorndon Quay, Pipitea, Wellington 6011."));

        map.addMarker(new MarkerOptions().position(new LatLng(-41.290762, 174.778869))
                .title("New Zealand Federation of Voluntary.")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_map_marker))
                .snippet("Address:Level 4, 173 Victoria St, TeAro, Wellington 6011."));

        map.addMarker(new MarkerOptions().position(new LatLng(-41.290206, 174.779471))
                .title("Evolve Wellington Youth Service.")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_map_marker))
                .snippet("Address:level 2,James Smith Building, Corner Cuba & Manners Streets, TeAro, Wellington 6011"));

        map.addMarker(new MarkerOptions().position(new LatLng(-41.286181, 174.779580))
                .title("Social Workers Registration Board.")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_map_marker))
                .snippet("Address:11 Chews Ln, Wellington, 6011."));

        map.addMarker(new MarkerOptions().position(new LatLng(-41.280026, 174.769136))
                .title("Ministry of Social Development.")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_map_marker))
                .snippet("Address:56 The Terrace, Wellington, 6011."));

        map.addMarker(new MarkerOptions().position(new LatLng(-41.290308, 174.768165))
                .title("Child, Youth and Family.")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_map_marker))
                .snippet("Address:Level 1, 186-190 Willis St, TeAro, Wellington 6011."));

        map.addMarker(new MarkerOptions().position(new LatLng(-41.221449, 174.807159))
                .title("Work and Income.")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_map_marker))
                .snippet("Address:39/33 Johnsonville Rd, Johnsonville,Wellington 6037."));
        return v;
    }

    private void getlocation() {
        gps = new GPSTracke(getActivity());
        // check if GPS enabled
        if (gps.canGetLocation()) {
            latitude = 32.758215;
            longitude = 74.848849;
            // \n is for new line
            Toast.makeText(getActivity(), "Welcome to Angel's-world", Toast.LENGTH_LONG).show();
        } else {
            // can't get location
            // GPS or Network is not enabled
            // Ask user to enable GPS/network in settings
            gps.showSettingsAlert();
        }
    }

    @Override
    public void onResume() {
        mapView.onResume();
        super.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }


}