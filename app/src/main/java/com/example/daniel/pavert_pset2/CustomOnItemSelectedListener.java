package com.example.daniel.pavert_pset2;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

/**
 * Created by Daniel on 12/09/2017.
 */

public class CustomOnItemSelectedListener implements AdapterView.OnItemSelectedListener {

    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        Toast.makeText(parent.getContext(),
                "OnItemSelectedListener : " + parent.getItemAtPosition(pos).toString(),
                Toast.LENGTH_SHORT).show();
        //// TODO: 12/09/2017 Fix this shit
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

}
