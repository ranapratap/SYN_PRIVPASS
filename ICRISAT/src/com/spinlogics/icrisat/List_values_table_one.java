package com.spinlogics.icrisat;

import java.util.ArrayList;
import java.util.HashMap;

import com.spinlogics.icrisat_db.ICRISAT;
import com.spinlogics.icrisat_db.Opretion_icrisat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;

public class List_values_table_one extends Activity {
	private ArrayList<HashMap<String, String>> list_of_tab1;
	Opretion_icrisat op_obj;
	private LinearLayout names_layout;
	double total_dm, total_cp, total_me, total_ca, total_p, body_weight;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			total_dm = extras.getDouble("T_DM");
			total_cp = extras.getDouble("T_CP");
			total_me = extras.getDouble("T_ME");
			total_ca = extras.getDouble("T_CA");
			total_p = extras.getDouble("T_P");
			body_weight = extras.getDouble("BW");

		}

		list_of_tab1 = new ArrayList<HashMap<String, String>>();
		op_obj = new Opretion_icrisat(List_values_table_one.this);
		setContentView(R.layout.names_in_tab1);
		names_layout = (LinearLayout) findViewById(R.id.rel_name_list);
		op_obj.open();
		list_of_tab1 = op_obj.GET_TABBLE_ONE();
		for (int i = 0; i < list_of_tab1.size(); i++) {

			Button myButton = new Button(List_values_table_one.this);
			myButton.setText(list_of_tab1.get(i).get(ICRISAT.T1_NAME));
			myButton.setId(i);
			LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT,
					LayoutParams.WRAP_CONTENT);
			myButton.setLayoutParams(lp);
			myButton.setGravity(Gravity.CENTER);
			names_layout.addView(myButton);
			myButton.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {

					
					
					
					double N_DM=Calculations.New_DM(Double.parseDouble(list_of_tab1.get(v.getId()).get(ICRISAT.T1_OMD)), body_weight);
					
					double N_CP=Calculations.New_CP(N_DM, Double.parseDouble(list_of_tab1.get(v.getId()).get(ICRISAT.T1_CP)));
					
					double N_ME=Calculations.New_ME(N_DM, Double.parseDouble(list_of_tab1.get(v.getId()).get(ICRISAT.T1_ME)));
					
					double N_CA=Calculations.New_CA(N_DM, Double.parseDouble(list_of_tab1.get(v.getId()).get(ICRISAT.T1_CA)));
					
					double N_P=Calculations.New_p(N_DM, Double.parseDouble(list_of_tab1.get(v.getId()).get(ICRISAT.T1_P)));
					
					Intent i = new Intent(getApplicationContext(), Table_one.class);
					i.putExtra("BW",body_weight);
					
					i.putExtra("T_DM",total_dm);
					i.putExtra("T_CP",total_cp);
					i.putExtra("T_ME",total_me);
					i.putExtra("T_CA",total_ca);
					i.putExtra("T_P",total_p);

					i.putExtra("N_DM",N_DM);
					i.putExtra("N_CP",N_CP);
					i.putExtra("N_ME",N_ME);
					i.putExtra("N_CA",N_CA);
					i.putExtra("N_P",N_P);
					
					i.putExtra("T_ID",v.getId());
					startActivity(i);
					
				}
			});

		}

	}

}
