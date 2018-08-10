package navdrawer.test.com.navigationdrawertest.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import navdrawer.test.com.navigationdrawertest.R;
import navdrawer.test.com.navigationdrawertest.others.Global;

import static java.util.logging.Logger.global;
import static navdrawer.test.com.navigationdrawertest.others.ExpandableListAdapter.Women_Welfare;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Ngo_list.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Ngo_list#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Ngo_list extends Fragment {
    ListView listView;
    List<String> orphanage= new ArrayList();
    List<String> old_age_home= new ArrayList();
    List<String> Women_Welfare= new ArrayList();
    List<String> blind_handicapped= new ArrayList();
    List<String> social_welfare=new ArrayList();
    private Global global;
    private ArrayAdapter adapter;
    private ArrayAdapter listAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate( R.layout.fragment_ngo_list, container, false );


        global = (Global) getActivity().getApplicationContext();
        String nameOfNgo = global.getNameOfNgo();
        listView = (ListView) view.findViewById( R.id.ngo_list);

        //Orphanage NGO list
        orphanage.add( "Career Maker And Information Buruae" );
        orphanage.add( "Damodar Satri Udyog Sanstha" );
        orphanage.add( "Gramin Bal Vikas Kendar" );
        orphanage.add( "Gujjar Desh Charitable Trust" );
        orphanage.add( "Helpline Humanity" );
        orphanage.add( "Iqbal Rural Welfare Society" );
        orphanage.add( "Jan Shikshan Sansthan Jammu" );
        orphanage.add( "Kawa Educational And Welfare Society" );
        orphanage.add( "Model Institute Of Education And Research" );
        orphanage.add( "Natrang" );
        orphanage.add( "Naya Ujjala Society" );
        orphanage.add( "SOS children's village" );
        orphanage.add( "Ved Mandir Bal Niketan" );
        orphanage.add( "Women And Child Development Society" );
        orphanage.add( "Yamini Cultural Society" );

        //Old Age Home NGO list
        old_age_home.add( "Amar Balidan Societytrust" );
        old_age_home.add( "Green Hill Development Society" );
        old_age_home.add( "Indian Democtaric Human Rights Organisation" );
        old_age_home.add( "Indian Red Cross Society" );
        old_age_home.add( "Jammu Gramin Vikas Sanstha" );
        old_age_home.add( "Jammu & Kashmir Confederation Of Voluntary Organziation" );
        old_age_home.add( "Nav Jyoti Balwadi" );
        old_age_home.add( "Panchkarma And Herbal Research Kendra" );
        old_age_home.add( "Sangam Theatre Group" );
        old_age_home.add( "Sankalp A Voluntary Organisation" );
        old_age_home.add( "Secular Mahila Mandal Poonch" );
        old_age_home.add( "Vishaw Jyoti Shishu Niketan" );
        old_age_home.add( "Vishwas A Belief" );
        old_age_home.add( "We Care" );
        old_age_home.add( "Youth Movement For Peace" );

        //Women_Welfare NGO list
        Women_Welfare.add( "Aakar" );
        Women_Welfare.add( "Aar Kay Social welfare Centre" );
        Women_Welfare.add( "All India Citizens National Cousil");
        Women_Welfare.add( "ANSC" );
        Women_Welfare.add( "Damodar Udyog Sattri Sanstha" );
        Women_Welfare.add( "Economically weaker Women Development Society" );
        Women_Welfare.add( "Habans Bhalla" );
        Women_Welfare.add( "Jammu & Kashmir Educational Society" );
        Women_Welfare.add( "Lakshya" );
        Women_Welfare.add( "Lalded Women Welfare Society" );
        Women_Welfare.add( "Nari Pragti Kendra" );
        Women_Welfare.add( "National Development Foundation" );
        Women_Welfare.add( "National Youth Child & Women Empowerment Society" );
        Women_Welfare.add( "Nirwana Academy" );
        Women_Welfare.add( "Sai Baba Soicety" );

        //Blind_Handicapped NGO list
        blind_handicapped.add( "Blind's school roopnagar" );
        blind_handicapped.add( "Destitute & Handicapped" );
        blind_handicapped.add( "Indian National People Welfare Society");
        blind_handicapped.add( "Mother Terresa Shanti Bhawan" );
        blind_handicapped.add( "Residential School for the Blind" );
        blind_handicapped.add( "Roshan Educational Society" );
        blind_handicapped.add( "SCHOOL FOR HEARING HANDICAPPED" );
        blind_handicapped.add( "SCST & Backword Classes Dev. Cor. Ltd." );
        blind_handicapped.add( "Shaheed E Azam Bhagat Singh Foundation" );

        //Social_Welfare NGO list
        social_welfare.add( "Association For Socio economic & Education & Environmental Reasearch" );
        social_welfare.add( "Bhartiya Lok Sangeet Kala Sansthan" );
        social_welfare.add( "Indian National People Welfare Society");
        social_welfare.add( "Indian Social Organisation" );
        social_welfare.add( "Jammu & Kashmir SAI STAR SOCIETY" );
        social_welfare.add( "Jammu & Kashmir Sanskrit Society" );
        social_welfare.add( "Jammu & Kashmir Welfare Society" );
        social_welfare.add( "Kawa Educational & Welfare Society" );
        social_welfare.add( "Mission Green" );
        social_welfare.add( "Mother India" );
        social_welfare.add( "National Development Foundation" );
        social_welfare.add( "Roshan Educational Society" );
        social_welfare.add( "Rural Artisans Welfare Society" );
        social_welfare.add( "Samajic Enviromental Welfare Association Sewa" );
        social_welfare.add( "Sarthak Help Line Welfare Society" );

        //switch between the cases
        switch (nameOfNgo) {
            case "orphanage":
                adapter = new ArrayAdapter( getActivity().getApplicationContext(), android.R.layout.simple_list_item_1,orphanage);
                setListAdapter( adapter );
                break;
            case "old_age_home":
                adapter = new ArrayAdapter( getActivity().getApplicationContext(), android.R.layout.simple_list_item_1,old_age_home);
                setListAdapter( adapter );
                break;
            case "women welfare":
                adapter = new ArrayAdapter( getActivity().getApplicationContext(), android.R.layout.simple_list_item_1,Women_Welfare);
                setListAdapter( adapter );
                break;
            case "blind_handicapped":
                adapter = new ArrayAdapter( getActivity().getApplicationContext(), android.R.layout.simple_list_item_1,blind_handicapped);
                setListAdapter( adapter );
                break;
            case "social welfare":
                adapter = new ArrayAdapter( getActivity().getApplicationContext(), android.R.layout.simple_list_item_1,social_welfare);
                setListAdapter( adapter );
                break;


        } return view;}

    public void setListAdapter(ArrayAdapter listAdapter) {
        this.listAdapter = listAdapter;
        listView.setAdapter(adapter);



    }
}
