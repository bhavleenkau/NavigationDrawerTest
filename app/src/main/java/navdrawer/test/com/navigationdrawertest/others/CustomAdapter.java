package navdrawer.test.com.navigationdrawertest.others;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.squareup.picasso.Picasso;

import navdrawer.test.com.navigationdrawertest.R;

/**
 * Created by touchstone on 10/24/2016.
 */

public class CustomAdapter extends PagerAdapter {

    public static final String[] images = new String[] {
            // Heavy images
            "http://angelsworld.org.in/Content/images/gallery/gallery-lg1.jpg",
            "http://angelsworld.org.in/Content/images/gallery/gallery-lg2.jpg",
            "http://angelsworld.org.in/Content/images/gallery/gallery-lg3.jpg",
            "http://angelsworld.org.in/Content/images/gallery/gallery-lg4.jpg",
            "http://angelsworld.org.in/Content/images/gallery/gallery-lg5.jpg",
            "http://angelsworld.org.in/Content/images/gallery/gallery-lg6.jpg",
            "http://angelsworld.org.in/Content/images/gallery/gallery-lg7.jpg",
            "http://angelsworld.org.in/Content/images/gallery/gallery-lg8.jpg",
            "http://angelsworld.org.in/Content/images/gallery/gallery-lg19.jpg",
            "http://angelsworld.org.in/Content/images/gallery/gallery-lg10.jpg",
    };
    private Context ctx;
    private LayoutInflater inflater;

    public CustomAdapter(Context ctx){
        this.ctx = ctx;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view ==(LinearLayout)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        inflater = (LayoutInflater)ctx.getSystemService( Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.swipe,container,false);
        ImageView img =(ImageView)v.findViewById(R.id.imageView);

        Picasso.with(ctx).load(images[position]).placeholder( R.drawable.ic_ab_close)
                .error(R.drawable.ic_launcher_about)
                .into(img);
        container.addView(v);
        return v;
    }

    @Override
    public void destroyItem(View container, int position, Object object) {
        container.refreshDrawableState();
    }
}