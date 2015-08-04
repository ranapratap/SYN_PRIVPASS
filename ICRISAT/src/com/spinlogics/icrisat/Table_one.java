package com.spinlogics.icrisat;

import java.text.DecimalFormat;
import java.util.HashMap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Table_one extends Activity{
	

	double total_dm, total_cp, total_me, total_ca, total_p, body_weight;
	double new_dm,new_cp,new_me,new_ca,new_p;
	double bal_dm,bal_cp,bal_me,bal_ca,bal_p;
	
	String tab_id;
	TextView t_dm,t_cp,t_me,t_ca,t_p;
	TextView n_dm,n_cp,n_me,n_ca,n_p;
	TextView b_dm,b_cp,b_me,b_ca,b_p;
	Button next_go;
	static HashMap<String, Double> balance_value=new  HashMap<String, Double>();
			
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.table_one_results);
		
		
		t_dm=(TextView)findViewById(R.id.total_dm);
		t_cp=(TextView)findViewById(R.id.total_cp);
		t_me=(TextView)findViewById(R.id.total_me);
		t_ca=(TextView)findViewById(R.id.total_ca);
		t_p=(TextView)findViewById(R.id.total_p);
		
		n_dm=(TextView)findViewById(R.id.given_dm);
		n_cp=(TextView)findViewById(R.id.given_cp);
		n_me=(TextView)findViewById(R.id.given_me);
		n_ca=(TextView)findViewById(R.id.given_ca);
		n_p=(TextView)findViewById(R.id.given_p);
		
		b_dm=(TextView)findViewById(R.id.balance_dm);
		b_cp=(TextView)findViewById(R.id.balance_cp);
		b_me=(TextView)findViewById(R.id.balance_me);
		b_ca=(TextView)findViewById(R.id.balance_ca);
		b_p=(TextView)findViewById(R.id.balance_p);
		next_go=(Button)findViewById(R.id.next_goo);
		
		next_go.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				startActivity(new Intent(Table_one.this, List_options_table_two.class));
				
			}
		});
		
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			total_dm = extras.getDouble("T_DM");
			total_cp = extras.getDouble("T_CP");
			total_me = extras.getDouble("T_ME");
			total_ca = extras.getDouble("T_CA");
			total_p = extras.getDouble("T_P");
			body_weight = extras.getDouble("BW");
			tab_id= extras.getString("T_ID");
					
			new_dm = extras.getDouble("N_DM");
			new_cp = extras.getDouble("N_CP");
			new_me = extras.getDouble("N_ME");
			new_ca = extras.getDouble("N_CA");
			new_p = extras.getDouble("N_P");
			
		}
		
		t_dm.setText(new DecimalFormat("#.##").format(total_dm)+"");
		t_cp.setText(new DecimalFormat("#.##").format(total_cp)+"");
		t_me.setText(new DecimalFormat("#.##").format(total_me)+"");
		t_ca.setText(new DecimalFormat("#.##").format(total_ca)+"");
		t_p.setText(new DecimalFormat("#.##").format(total_p)+"");

		
		n_dm.setText(new DecimalFormat("#.##").format(new_dm)+"");
		n_cp.setText(new DecimalFormat("#.##").format(new_cp)+"");
		n_me.setText(new DecimalFormat("#.##").format(new_me)+"");
		n_ca.setText(new DecimalFormat("#.##").format(new_ca)+"");
		n_p.setText(new DecimalFormat("#.##").format(new_p)+"");



		
		bal_dm=total_dm-new_dm;
		bal_cp=total_cp-new_cp;
		bal_me=total_me-new_me;
		bal_ca=total_ca-new_ca;
		bal_p=total_p-new_p;
		
		balance_value.put("B_DM", bal_dm);
		balance_value.put("B_CP", bal_cp);
		balance_value.put("B_ME", bal_me);
		balance_value.put("B_CA", bal_ca);
		balance_value.put("B_P", bal_p);

		b_dm.setText(new DecimalFormat("#.##").format(bal_dm)+"");
		b_cp.setText(new DecimalFormat("#.##").format(bal_cp)+"");
		b_me.setText(new DecimalFormat("#.##").format(bal_me)+"");
		b_ca.setText(new DecimalFormat("#.##").format(bal_ca)+"");
		b_p.setText(new DecimalFormat("#.##").format(bal_p)+"");
	}

}
