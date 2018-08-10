package navdrawer.test.com.navigationdrawertest.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import navdrawer.test.com.navigationdrawertest.R;
import navdrawer.test.com.navigationdrawertest.others.Constants;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Images.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Images#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Images extends Fragment {
    GridView grid;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate( R.layout.fragment_images, container, false );
        grid = (GridView)view.findViewById(R.id.grid);
        grid.setAdapter(new ImageAdapter(getActivity(),Constants.IMAGES));

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(getActivity(),Pinchtozoomfragment.class);
                intent.putExtra("position",position);
                startActivity(intent);
            }
        });

        return view;

    }

    private class ImageAdapter extends BaseAdapter {

        private String[] IMAGE_URLS ;
        private LayoutInflater inflater;
        Context c;

        ImageAdapter(Context context, String[] images) {
            inflater = LayoutInflater.from(context);
            IMAGE_URLS = images;
            c = context;
        }
        @Override
        public int getCount() {
            return IMAGE_URLS.length;
        }
        @Override
        public Object getItem(int position) {
            return null;
        }
        @Override
        public long getItemId(int position) {
            return position;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            final Images.ViewHolder holder;
            View view = convertView;
            if (view == null) {
                view = inflater.inflate(R.layout.item_grid_image, parent, false);
                holder = new Images.ViewHolder();
                assert view != null;
                holder.imageView = (ImageView) view.findViewById(R.id.image);
                holder.progressBar = (ProgressBar) view.findViewById(R.id.progress);
                view.setTag(holder);
            } else {
                holder = (Images.ViewHolder) view.getTag();
            }
            Picasso.with(c).load(IMAGE_URLS[position]).placeholder(R.drawable.ic_ab_close)
                    .error(R.drawable.ic_launcher_about)
                    .fit()
                    .into(holder.imageView, new Callback() {

                        @Override
                        public void onSuccess() {
                            holder.imageView.setVisibility(View.VISIBLE);
                            holder.progressBar.setVisibility(View.INVISIBLE);
                        }

                        @Override
                        public void onError() {
                            holder.progressBar.setVisibility(View.VISIBLE);
                            holder.imageView.setVisibility(View.INVISIBLE);
                        }
                    });

            return view;
        }
    }

    static class ViewHolder {
        ImageView imageView;
        ProgressBar progressBar;
    }
}
