package navdrawer.test.com.navigationdrawertest.others;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.games.social.Social;

import java.util.HashMap;
import java.util.List;

import navdrawer.test.com.navigationdrawertest.R;


public class ExpandableListAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List<String> expandableListTitle;
    private HashMap<String, List<String>> expandableListDetail;

    public static int Home = 0;
    public static int NGO_List = 1;
    public static int Gallery = 2;
    public static int How_to_Register = 3;
    public static int Feedback = 4;
    public static int Location = 5;
    public static int About = 6;
    public static int Exit = 7;



    public static int Orphanage = 0;
    public static int Old_Age_Home = 1;
    public static int Women_Welfare = 2;
    public static int Blind_Handicapped = 3;
    public static int Social_Welfare= 4;




    public ExpandableListAdapter(Context context, List<String> expandableListTitle,
                                 HashMap<String, List<String>> expandableListDetail) {
        this.context = context;
        this.expandableListTitle = expandableListTitle;
        this.expandableListDetail = expandableListDetail;


    }

    @Override
    public Object getChild(int listPosition, int expandedListPosition) {
        return this.expandableListDetail.get(this.expandableListTitle.get(listPosition))
                .get(expandedListPosition);
    }

    @Override
    public long getChildId(int listPosition, int expandedListPosition) {
        return expandedListPosition;
    }

    @Override
    public View getChildView(int listPosition, final int expandedListPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {
        final String expandedListText = (String) getChild(listPosition, expandedListPosition);
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_item, null);
        }
        TextView expandedListTextView = (TextView) convertView.findViewById(R.id.expandedListItem);
        expandedListTextView.setText(expandedListText);
        return convertView;
    }

    @Override
    public int getChildrenCount(int listPosition) {
        return this.expandableListDetail.get(this.expandableListTitle.get(listPosition))
                .size();
    }

    @Override
    public Object getGroup(int listPosition) {
        return this.expandableListTitle.get(listPosition);
    }

    @Override
    public int getGroupCount() {
        return this.expandableListTitle.size();
    }

    @Override
    public long getGroupId(int listPosition) {
        return listPosition;
    }

    @Override
    public View getGroupView(int listPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String listTitle = (String) getGroup(listPosition);
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_group, null);
        }
        TextView listTitleTextView = (TextView) convertView.findViewById(R.id.listTitle);
        listTitleTextView.setTypeface(null, Typeface.NORMAL);
        listTitleTextView.setText(listTitle);


        TextView listTitleTextArrowView = (TextView) convertView.findViewById(R.id.listTitleArrow);
        listTitleTextArrowView.setTypeface(null, Typeface.NORMAL);
        listTitleTextArrowView.setTypeface(FontManager.getTypeface(context, FontManager.FONTAWESOME));

        // set icons for menu items
        ImageView listTitleTextIconView = (ImageView) convertView.findViewById(R.id.listTitleIcon);
       /* listTitleTextIconView.setTypeface(null, Typeface.NORMAL);
        listTitleTextIconView.setTypeface(FontManager.getTypeface(context, FontManager.FONTAWESOME));
*/
        if (listPosition == Home)
            listTitleTextIconView.setImageResource(R.drawable.ic_launcher_home);
        else if (listPosition == NGO_List)
            listTitleTextIconView.setImageResource(R.drawable.ic_launcher_list);
        else if (listPosition == Gallery)
            listTitleTextIconView.setImageResource(R.drawable.ic_launcher_gallery);
        else if (listPosition == How_to_Register)
            listTitleTextIconView.setImageResource(R.drawable.ic_launcher_register);
        else if (listPosition == Feedback)
            listTitleTextIconView.setImageResource(R.drawable.ic_launcher_feedback);
        else if (listPosition == Location)
            listTitleTextIconView.setImageResource(R.drawable.ic_launcher_map);
        else if (listPosition == About)
            listTitleTextIconView.setImageResource(R.drawable.ic_launcher_about);
        else if (listPosition == Exit)
            listTitleTextIconView.setImageResource(R.drawable.ic_launcher_exit);

        // set arrow icons for relevant items
        if (/*listPosition == ITEM1 || */listPosition == NGO_List) {
            if (!isExpanded)
                listTitleTextArrowView.setText(context.getResources().getString(R.string.fa_chevron_right));
            else
                listTitleTextArrowView.setText(context.getResources().getString(R.string.fa_chevron_down));
        } else {
            listTitleTextArrowView.setText("");

        }
        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int listPosition, int expandedListPosition) {
        return true;
    }

}
