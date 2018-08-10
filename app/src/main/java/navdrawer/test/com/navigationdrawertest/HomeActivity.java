package navdrawer.test.com.navigationdrawertest;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import com.flaviofaria.kenburnsview.KenBurnsView;
import com.flaviofaria.kenburnsview.RandomTransitionGenerator;

import java.util.ArrayList;
import java.util.List;

import navdrawer.test.com.navigationdrawertest.fragment.Feedback;
import navdrawer.test.com.navigationdrawertest.fragment.Images;
import navdrawer.test.com.navigationdrawertest.fragment.NavigationDrawerFragment;
import navdrawer.test.com.navigationdrawertest.fragment.WebviewFragment;
import navdrawer.test.com.navigationdrawertest.others.LoadImageTask;

import static navdrawer.test.com.navigationdrawertest.R.id.fab4;
import static navdrawer.test.com.navigationdrawertest.R.id.kenimage;
import static navdrawer.test.com.navigationdrawertest.R.id.scrollable;
import static navdrawer.test.com.navigationdrawertest.SplashActivity.IMAGE_URL;


public class HomeActivity extends FragmentActivity implements NavigationDrawerFragment.NavigationDrawerCallbacks, LoadImageTask.Listener {
    private NavigationDrawerFragment mNavigationDrawerFragment;
    private CharSequence mTitle;
    private DrawerLayout mDrawerLayout;
    private Boolean isFabOpen = false;
    private FloatingActionButton fab, fb, google, youtube, twitter;
    private Animation fab_open, fab_close, rotate_forward, rotate_backward;
    public static final String IMAGE_URL = "https://biblesociety.org.nz/wp-content/uploads/2017/06/bannerimage_1100x400px-815x355.jpg";
    public static final String IMAGE_URL1 = "http://24kerala.com/wp-content/uploads/2018/02/donate-orphan-child-in-india.jpg";
    public static final String IMAGE_URL2 = "https://static1.squarespace.com/static/5a1ca087692ebeb0ea5a3696/t/5a2157ee8165f51b7dca12d9/1512134641163/Orphans-Aid-International-New-Zealand-India-Romania-Russia-Uganda-Nepal-Donate-Help-Volunteer-Sue-van-Schreven-24.jpg?format=1500w";
    public static final String IMAGE_URL3 = "https://static1.squarespace.com/static/5a1ca087692ebeb0ea5a3696/t/5a1f86caf9619aaae9847885/1512027775363/Project-Images_Uganda-Orphans-Aid-International-New-Zealand-India-Romania-Russia-Uganda-Nepal-Donate-Help-Volunteer-Sue-van-Schreven.jpg";
    public static final String IMAGE_URL4 = "http://vectorconcepts.com/wp-content/uploads/2016/02/THE-ORPHANS.jpg";
    public static final String IMAGE_URL5 = "https://spy.nzherald.co.nz/media/66803/gettyimages-482373158_640x320-jpg.jpg?mode=crop&width=675&height=379&quality=80&scale=both";
    private KenBurnsView kenBurnsView;
    private boolean isPlay = true;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature( Window.FEATURE_NO_TITLE );
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        fab = (FloatingActionButton) findViewById( R.id.fab );
        fb = (FloatingActionButton) findViewById( R.id.fab1 );
        google = (FloatingActionButton) findViewById( R.id.fab2 );
        youtube = (FloatingActionButton) findViewById( R.id.fab3 );
        twitter = (FloatingActionButton) findViewById( fab4 );
        fab_open = AnimationUtils.loadAnimation( getApplicationContext(), R.anim.fab_open );
        fab_close = AnimationUtils.loadAnimation( getApplicationContext(), R.anim.fab_close );
        rotate_forward = AnimationUtils.loadAnimation( getApplicationContext(), R.anim.rotate_forward );
        rotate_backward = AnimationUtils.loadAnimation( getApplicationContext(), R.anim.rotate_backward );
        Window window = getWindow();
        // clear FLAG_TRANSLUCENT_STATUS flag:
        window.clearFlags( WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS );
        // add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        window.addFlags( WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS );
        // finally change the color
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor( getResources().getColor( R.color.colorPrimaryDark ) );
        }
        viewPager = (ViewPager) findViewById( R.id.viewpager );
        setupViewPager( viewPager );
        tabLayout = (TabLayout) findViewById( R.id.tabs );
        tabLayout.setupWithViewPager( viewPager );
        tabLayout.setTabMode( TabLayout.MODE_SCROLLABLE );
        tabLayout.setTabTextColors( ColorStateList.valueOf( getResources().getColor( R.color.lightblack )) );
        // Set up the drawer.
        mNavigationDrawerFragment = (NavigationDrawerFragment) getSupportFragmentManager().findFragmentById( R.id.navigation_drawer );
        mTitle = getTitle();
        mNavigationDrawerFragment.setUp( R.id.navigation_drawer, (DrawerLayout) findViewById( R.id.main_layout ) );

        toolbar = (Toolbar) findViewById( R.id.toolbar );
        //setSupportActionBar( toolbar );
        setTitle( "Home" );
        mDrawerLayout = (DrawerLayout) findViewById( R.id.main_layout );
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle( this, mDrawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close );
        mDrawerLayout.setDrawerListener( toggle );
        toggle.syncState();
        //kenburn
        kenBurnsView = (KenBurnsView) findViewById( R.id.kenimage );
        AccelerateDecelerateInterpolator ACCELERATE_DECELERATE = new AccelerateDecelerateInterpolator();
        RandomTransitionGenerator generator = new RandomTransitionGenerator( 3000, ACCELERATE_DECELERATE );
        kenBurnsView.setTransitionGenerator( generator ); //set new transition on kenburns view
        new LoadImageTask( this ).execute( IMAGE_URL );
        fab.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animateFAB();
            }
        } );
        fb.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.facebook.com/Angels-World-159969984398878/";
                Intent i = new Intent( Intent.ACTION_VIEW );
                i.setData( Uri.parse( url ) );
                startActivity( i );
                Log.d( "Sahil", "Facebook" );
            }
        } );
        google.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url2 = "https://plus.google.com/104813184532389345588/";
                Intent i2 = new Intent( Intent.ACTION_VIEW );
                i2.setData( Uri.parse( url2 ) );
                startActivity( i2 );
                Log.d( "Sahil", "Google+" );
            }
        } );
        youtube.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url3 = "https://www.youtube.com/channel/UCqBud94c6Nx8DE-Uf6q93WQ/";
                Intent i3 = new Intent( Intent.ACTION_VIEW );
                i3.setData( Uri.parse( url3 ) );
                startActivity( i3 );
                Log.d( "Sahil", "You tube" );
            }
        } );
        twitter.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url4 = "https://twitter.com/Angelsworld311E/";
                Intent i4 = new Intent( Intent.ACTION_VIEW );
                i4.setData( Uri.parse( url4 ) );
                startActivity( i4 );
                Log.d( "Sahil", "Twitter" );
            }
        } );
    }

    @Override
    public void onImageLoaded(Bitmap bitmap) {
        kenBurnsView.setImageBitmap( bitmap );
    }

    @Override
    public void onError() {
        Toast.makeText( this, "Error Loading Image !", Toast.LENGTH_SHORT ).show();
    }

    public void animateFAB() {
        if (isFabOpen) {
            fab.startAnimation( rotate_backward );
            fb.startAnimation( fab_close );
            google.startAnimation( fab_close );
            youtube.startAnimation( fab_close );
            twitter.startAnimation( fab_close );
            fb.setClickable( false );
            google.setClickable( false );
            youtube.setClickable( false );
            twitter.setClickable( false );
            isFabOpen = false;
            Log.d( "Sahil", "close" );
        } else {
            fab.startAnimation( rotate_forward );
            fb.startAnimation( fab_open );
            google.startAnimation( fab_open );
            youtube.startAnimation( fab_open );
            twitter.startAnimation( fab_open );
            fb.setClickable( true );
            google.setClickable( true );
            youtube.setClickable( true );
            twitter.setClickable( true );
            isFabOpen = true;
            Log.d( "Sahil", "open" );
        }
    }

    @Override
    public void onBackPressed() {
        // TODO Auto-generated method stub
        //super.onBackPressed();
        openQuitDialog();
    }

    private void openQuitDialog() {
        AlertDialog.Builder quitDialog = new AlertDialog.Builder( HomeActivity.this );
        quitDialog.setTitle( "Confirm to Quit?" );
        quitDialog.setPositiveButton( "OK, Quit!", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                finish();
            }
        } );
        quitDialog.setNegativeButton( "NO", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
            }
        } );
        quitDialog.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate( R.menu.menu_main, menu );
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.Search) {
            startActivity( new Intent( Intent.ACTION_VIEW ).setData( Uri.parse( "http://www.ngosindia.com/resources/ngo_registration.php" ) ) );
            return true;
        }
        return super.onOptionsItemSelected( item );
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter( getSupportFragmentManager() );
        adapter.addFragment( new ComingsoonFragment(), "GERNAL" );
        adapter.addFragment( new ComingsoonFragment(), "Feedback" );


        viewPager.setAdapter( adapter );

        viewPager.addOnPageChangeListener( new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                               switch (position) {
                    case 0:
                        new LoadImageTask( HomeActivity.this ).execute( IMAGE_URL );
                        break;
                    case 1:
                        new LoadImageTask( HomeActivity.this ).execute( IMAGE_URL1 );
                        break;
                    case 2:
                        new LoadImageTask( HomeActivity.this ).execute( IMAGE_URL2 );
                        break;
                    case 3:
                        new LoadImageTask( HomeActivity.this ).execute( IMAGE_URL3 );
                        break;
                    case 4:
                        new LoadImageTask( HomeActivity.this ).execute( IMAGE_URL4 );
                        break;
                    case 5:
                        new LoadImageTask( HomeActivity.this ).execute( IMAGE_URL5 );
                        break;
                }
            }
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        } );
    }
    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super( manager );

        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get( position );
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add( fragment );
            mFragmentTitleList.add( title );
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get( position );
        }
    }
}
