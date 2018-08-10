package navdrawer.test.com.navigationdrawertest.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import navdrawer.test.com.navigationdrawertest.R;
import navdrawer.test.com.navigationdrawertest.others.CustomAdapter;


public class Pinchtozoomfragment extends AppCompatActivity {


    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.fragment_pinchtozoomfragment );

        toolbar = (Toolbar) findViewById( R.id.toolbar );
        setSupportActionBar( toolbar );
        getSupportActionBar().setTitle("Images");


        int position = getIntent().getIntExtra( "position", 0 );

        ViewPager viewPager = (ViewPager) findViewById( R.id.view_pager );
        CustomAdapter adapter = new CustomAdapter( this );
        viewPager.setAdapter( adapter );
        viewPager.setCurrentItem( position );
    }


}
