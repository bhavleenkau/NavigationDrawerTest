package navdrawer.test.com.navigationdrawertest;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ComingsoonFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ComingsoonFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ComingsoonFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_comingsoon, container, false);

       return view;
    }
}
