package navdrawer.test.com.navigationdrawertest.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import navdrawer.test.com.navigationdrawertest.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Galleryfragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Galleryfragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Galleryfragment extends Fragment {

    View view;
    Adapter adapter;

    private void setupViewPager(ViewPager viewPager) {


///Here we have to pass ChildFragmentManager instead of FragmentManager.
   adapter = new Adapter(getChildFragmentManager());
                adapter.addFragment(new Images(), "Images");
        adapter.addFragment(new Videos(), "Videos");
        viewPager.setAdapter(adapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_galleryfragment, container, false);
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this, view);
        final ViewPager viewPager = ButterKnife.findById(view, R.id.viewpagergallery);
        setupViewPager(viewPager);
        TabLayout tabLayout = ButterKnife.findById(view, R.id.tabsgallery);
        tabLayout.setupWithViewPager(viewPager);
        return view;
    }
    static class Adapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragments = new ArrayList<>();
        private final List<String> mFragmentTitles = new ArrayList<>();

        public Adapter(android.support.v4.app.FragmentManager fm) {
            super(fm);
        }

        public void addFragment(Fragment fragment, String title) {
            mFragments.add(fragment);
            mFragmentTitles.add(title);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitles.get(position);
        }
    }
}