package navdrawer.test.com.navigationdrawertest.others;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class ExpandableListDataPump {
    public static HashMap<String, List<String>> getData() {
        LinkedHashMap<String, List<String>> expandableListDetail = new LinkedHashMap<String, List<String>>();

        List<String> home = new ArrayList<String>();

        List<String> ngo_list = new ArrayList<String>();
        ngo_list.add("Orphanage.");
        ngo_list.add("Old Age Home.");
        ngo_list.add("Women Welfare.");
        ngo_list.add("Blind/Handicapped Org.");
        ngo_list.add("Social Welfare & Education.");

        List<String> gallery = new ArrayList<String>();
        List<String> how_to_register = new ArrayList<String>();
        List<String> feedback = new ArrayList<String>();
        List<String> location = new ArrayList<String>();
        List<String> about = new ArrayList<String>();
        List<String> exit = new ArrayList<String>();


        expandableListDetail.put("Home", home);
        expandableListDetail.put("NGO-LIST", ngo_list);
        expandableListDetail.put("Gallery", gallery);
        expandableListDetail.put("How-to-Registration", how_to_register);
        expandableListDetail.put("Feedback", feedback);
        expandableListDetail.put("Location", location);
        expandableListDetail.put("About", about);
        expandableListDetail.put("Exit", exit);

        return expandableListDetail;
    }
}
