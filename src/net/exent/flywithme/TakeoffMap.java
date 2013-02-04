package net.exent.flywithme;

import java.util.HashMap;
import java.util.Map;

import net.exent.flywithme.data.Takeoff;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.Marker;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class TakeoffMap extends Fragment implements OnInfoWindowClickListener {
    public interface TakeoffMapListener {
        void showTakeoffDetails(Takeoff takeoff);
    }

    private static View view;
    private TakeoffMapListener callback;
    private GoogleMap map;
    private Map<Marker, Takeoff> takeoffMarkers = new HashMap<Marker, Takeoff>();

    public void onInfoWindowClick(Marker marker) {
        Log.d("TakeoffMap", "onInfoWindowClick(" + marker + ")");
        Takeoff takeoff = takeoffMarkers.get(marker);

        /* tell main activity to show takeoff details */
        callback.showTakeoffDetails(takeoff);
    }

    @Override
    public void onAttach(Activity activity) {
        Log.d("TakeoffMap", "onAttach(" + activity + ")");
        super.onAttach(activity);
        callback = (TakeoffMapListener) activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d("TakeoffMap", "onCreateView(" + inflater + ", " + container + ", " + savedInstanceState + ")");
        if (view != null) {
            ViewGroup parent = (ViewGroup) view.getParent();
            if (parent != null)
                parent.removeView(view);
        }
        try {
            view = inflater.inflate(R.layout.takeoff_map, container, false);
        } catch (InflateException e) {
            /* map is already there, just return view as it is */
        }
        return view;
    }

    @Override
    public void onStart() {
        Log.d("TakeoffMap", "onStart()");
        super.onStart();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        Log.d("TakeoffMap", "onSaveInstanceState(" + outState + ")");
        super.onSaveInstanceState(outState);
    }

    private void initMap() {
        if (map != null) {
            map = ((SupportMapFragment) getFragmentManager().findFragmentById(R.id.takeoffMapFragment)).getMap();
            drawMap();
        }
    }

    private void drawMap() {
        if (map == null)
            return;
        /* TODO: draw markers and stuff */
    }
}