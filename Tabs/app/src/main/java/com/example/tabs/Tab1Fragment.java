package com.example.tabs;


import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * A simple {@link Fragment} subclass.
 */
public class Tab1Fragment extends Fragment {

   // String[] users = new String[] { "Suresh","Rohini","Trishika","Praveen","Sateesh","Madhav" };
   ArrayList<String> users = new ArrayList<String>(Arrays.asList("John"));
    public Tab1Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        //return inflater.inflate(R.layout.fragment_tab1, container, false);
        View view = inflater.inflate(R.layout.fragment_tab1, container, false);
       ListView lv= (ListView)view.findViewById(R.id.list);
        lv.setAdapter(new ArrayAdapter<String>(getActivity(), R.layout.activity_urgent_item,R.id.itemUrgent , users));
      //  updateList();
        return view;

    }
    public void addUser(View v){

        EditText newUser = (EditText) getView().findViewById(R.id.addItem);

        // users.add(newUser.getText().toString());

        DBHelper dbH = new DBHelper(getActivity());

        boolean result = dbH.addUser(newUser.getText().toString());

        updateList();
    }
    public void updateList(){



        ListView lv = (ListView)getView().findViewById(R.id.list);
        ArrayList<String> userDataFromDB = new ArrayList<>();

        DBHelper dbH = new DBHelper(getActivity());

        Cursor data = dbH.getData();

        while(data.moveToNext()){

            userDataFromDB.add(data.getString(1));

        }
        lv.setAdapter(new ArrayAdapter<String>(getActivity(), R.layout.activity_urgent_item,R.id.itemUrgent , userDataFromDB));
}



}
