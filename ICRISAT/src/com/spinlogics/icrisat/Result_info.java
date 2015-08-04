package com.spinlogics.icrisat;

import java.text.DecimalFormat;

import com.spinlogics.icrisat_db.Opretion_icrisat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class Result_info extends Activity {
	
	Pothana anila_type;
	
	TextView main_dm,main_cp,main_me,main_ca,main_p;
	TextView prod_dm,prod_cp,prod_me,prod_ca,prod_p;
	
	TextView alle_dm,alle_cp,alle_me,alle_ca,alle_p;
	
	TextView total_dm,total_cp,total_me,total_ca,total_p;
	
	int g_val,m_val,b_val,l_val;
	
	Button next_go;
	double body_wieght;
	boolean falg;
	private Opretion_icrisat inser_vals;
	

	double total_dm_val,total_cp_val,total_ca_val,total_p_val,total_me_val;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.result_calculate);
		inser_vals=new Opretion_icrisat(Result_info.this);
		next_go=(Button)findViewById(R.id.next_goo);
		next_go.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				inser_vals.open();
				if(!inser_vals.check_records_T_ONE())
				{
					Log.v("------->","Inserting");
					inser_vals.INSERT_TABLE1(
							"1", 
							"Greengrass", 
							"30", 
							"9", 
							"9", 
							"0.1", 
							"0.2", 
							"60");
					inser_vals.INSERT_TABLE1(
							"1.5",
							"CO-1", 
							"25", 
							"8", 
							"9", 
							"0.1",
							"0.2", 
							"55");
					inser_vals.INSERT_TABLE1(
							"1.5",
							"Sorghum Forage",
							"30", 
							"8",
							"9", 
							"0.1", 
							"0.2", 
							"60");
					inser_vals.INSERT_TABLE1(
							"5", 
							"Paddy straw", 
							"90", 
							"4", 
							"6.5", 
							"0.1", 
							"0.1", 
							"45");
				}
			if(!inser_vals.check_records_T_TWO())
			{
				Log.v("------->","Inserting");
				inser_vals.INSERT_TABLE2(
						"12", 
						"Maize",
						"90", 
						"9.4", 
						"12.9", 
						"0.02", 
						"0.027");
				inser_vals.INSERT_TABLE2(
						"32.5", 
						"Soy DC",
						"90", 
						"44", 
						"11.8", 
						"0.29", 
						"0.64");
				inser_vals.INSERT_TABLE2(
						"18", 
						"Rape DOC",
						"90",
						"35",
						"10.3", 
						"0.58", 
						"0.82");	
				inser_vals.INSERT_TABLE2(
						"17.6", 
						"Cotton seed",
						"90", 
						"20", 
						"11.7", 
						"0.17", 
						"0.6");
				inser_vals.INSERT_TABLE2(
						"16", 
						"Cotton seed cake",
						"90", 
						"26", 
						"10.6", 
						"0.18", 
						"0.72");
				inser_vals.INSERT_TABLE2(
						"22", 
						"Decort Cotton cake",
						"90", 
						"36", 
						"10.9", 
						"0.18", 
						"0.72");
				inser_vals.INSERT_TABLE2(
						"15", 
						"Rice polish",
						"14.6", 
						"12.1", 
						"12.9", 
						"0.05", 
						"1.29");
				inser_vals.INSERT_TABLE2(
						"34", 
						"DGNC",
						"90", 
						"36.2", 
						"10.6",
						"0.16", 
						"0.55");
				inser_vals.INSERT_TABLE2(
						"27", 
						"Til cake",
						"90", 
						"30", 
						"11.8", 
						"1.88", 
						"1.29");
				inser_vals.INSERT_TABLE2(
						"22.5", 
						"DDGS (Rice)DORB",
						"45", 
						"11.5", 
						"12.9", 
						"0.06", 
						"0.2");
				inser_vals.INSERT_TABLE2(
						"11", 
						"DORB",
						"90", 
						"14", 
						"9.8", 
						"0.34", 
						"1.09");
			}
				Intent i = new Intent(getApplicationContext(), List_values_table_one.class);
				i.putExtra("BW",body_wieght);
				i.putExtra("T_DM",total_dm_val);
				i.putExtra("T_CP",total_cp_val);
				i.putExtra("T_ME",total_me_val);
				i.putExtra("T_CA",total_ca_val);
				i.putExtra("T_P",total_p_val);
				startActivity(i);
				
				
				
			}
		});
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			g_val = extras.getInt("G");
			m_val = extras.getInt("M");
			b_val = extras.getInt("B");
			l_val = extras.getInt("L");
			if(Calculations.type==0)
				
				falg=true;
			else if(Calculations.type==1)
				falg=false;
			
		}
		// maintenance
		body_wieght=Calculations.Body_weight(g_val);
		
		anila_type=(Pothana)findViewById(R.id.animal_type);
		main_dm=(TextView)findViewById(R.id.main_dm);
		main_cp=(TextView)findViewById(R.id.main_cp);
		main_me=(TextView)findViewById(R.id.main_me);
		main_ca=(TextView)findViewById(R.id.main_ca);
		main_p=(TextView)findViewById(R.id.main_p);
		
		//values here
		
		main_dm.setText(new DecimalFormat("#.##").format(Calculations.CAL_DM(body_wieght))+"");
		main_cp.setText(new DecimalFormat("#.##").format(Calculations.CAL_CP(body_wieght))+"");
		main_me.setText(new DecimalFormat("#.##").format(Calculations.CAL_ME(body_wieght))+"");
		main_ca.setText(new DecimalFormat("#.##").format(Calculations.CAL_CA(body_wieght))+"");
		main_p.setText(new DecimalFormat("#.##").format(Calculations.CAL_P(body_wieght))+"");
		
		//production
		prod_dm=(TextView)findViewById(R.id.prod_dm);
		prod_cp=(TextView)findViewById(R.id.prod_cp);
		prod_me=(TextView)findViewById(R.id.prod_me);
		prod_ca=(TextView)findViewById(R.id.prod_ca);
		prod_p=(TextView)findViewById(R.id.prod_p);
		
		
		//values here..
		prod_dm.setText(new DecimalFormat("#.##").format(Calculations.CAL_DM(b_val, m_val, falg))+"");
		prod_cp.setText(new DecimalFormat("#.##").format(Calculations.CAL_CP(m_val, falg))+"");
		prod_me.setText(new DecimalFormat("#.##").format(Calculations.CAL_ME(b_val, m_val, falg))+"");
		prod_ca.setText(new DecimalFormat("#.##").format(Calculations.CAL_CA(m_val, falg))+"");
		prod_p.setText(new DecimalFormat("#.##").format(Calculations.CAL_PP(m_val))+"");
		
		//allowance  
		
		alle_dm=(TextView)findViewById(R.id.alle_dm);
		alle_cp=(TextView)findViewById(R.id.alle_cp);
		alle_me=(TextView)findViewById(R.id.alle_me);
		alle_ca=(TextView)findViewById(R.id.alle_ca);
		alle_p=(TextView)findViewById(R.id.alle_p);
		
		//values here 

		if(falg)
			anila_type.setText(R.string.cow);
		else
				anila_type.setText(R.string.buff);
		

		if(falg)
		{

			if(l_val==1)
			{
				//20% extra over maintenance 

				
				alle_dm.setText(new DecimalFormat("#.##").format((0.02*Calculations.CAL_DM(body_wieght)+Calculations.CAL_DM(body_wieght)))+"");
				alle_cp.setText(new DecimalFormat("#.##").format(((0.02*Calculations.CAL_CP(body_wieght)+Calculations.CAL_CP(body_wieght))))+"");
				alle_me.setText(new DecimalFormat("#.##").format((0.02*Calculations.CAL_ME(body_wieght)+Calculations.CAL_ME(body_wieght)))+"");
				alle_ca.setText(new DecimalFormat("#.##").format(((0.02*Calculations.CAL_CA(body_wieght)+Calculations.CAL_CA(body_wieght))))+"");
				alle_p.setText(new DecimalFormat("#.##").format((0.02*Calculations.CAL_P(body_wieght)+Calculations.CAL_P(body_wieght)))+"");
				
			}else if(l_val==2)
			{
				//new DecimalFormat("#.##").format(dblVar);

				alle_dm.setText(new DecimalFormat("#.##").format((0.01*Calculations.CAL_DM(body_wieght)+Calculations.CAL_DM(body_wieght)))+"");
				alle_cp.setText(new DecimalFormat("#.##").format((0.01*Calculations.CAL_CP(body_wieght)+Calculations.CAL_CP(body_wieght)))+"");
				alle_me.setText(new DecimalFormat("#.##").format((0.01*Calculations.CAL_ME(body_wieght)+Calculations.CAL_ME(body_wieght)))+"");
				alle_ca.setText(new DecimalFormat("#.##").format((0.01*Calculations.CAL_CA(body_wieght)+Calculations.CAL_CA(body_wieght)))+"");
				alle_p.setText(new DecimalFormat("#.##").format((0.01*Calculations.CAL_P(body_wieght)+Calculations.CAL_P(body_wieght)))+"");
			}else
			{

				alle_dm.setText(new DecimalFormat("#.##").format((0.0))+"");
				alle_cp.setText(new DecimalFormat("#.##").format((0.0))+"");
				alle_me.setText(new DecimalFormat("#.##").format((0.0))+"");
				alle_ca.setText(new DecimalFormat("#.##").format((0.0))+"");
				alle_p.setText(new DecimalFormat("#.##").format((0.0))+"");
		
			}
		}else
		{

			if(l_val==1)
			{
				alle_dm.setText(new DecimalFormat("#.##").format((0.02*Calculations.CAL_DM(body_wieght)+Calculations.CAL_DM(body_wieght)))+"");
				alle_cp.setText(new DecimalFormat("#.##").format(((0.02*Calculations.CAL_CP(body_wieght)+Calculations.CAL_CP(body_wieght))))+"");
				alle_me.setText(new DecimalFormat("#.##").format((0.02*Calculations.CAL_ME(body_wieght)+Calculations.CAL_ME(body_wieght)))+"");
				alle_ca.setText(new DecimalFormat("#.##").format(((0.02*Calculations.CAL_CA(body_wieght)+Calculations.CAL_CA(body_wieght))))+"");
				alle_p.setText(new DecimalFormat("#.##").format((0.02*Calculations.CAL_P(body_wieght)+Calculations.CAL_P(body_wieght)))+"");

				
			}else  if(l_val==2)
			{
				alle_dm.setText(new DecimalFormat("#.##").format((0.01*Calculations.CAL_DM(body_wieght)+Calculations.CAL_DM(body_wieght)))+"");
				alle_cp.setText(new DecimalFormat("#.##").format((0.01*Calculations.CAL_CP(body_wieght)+Calculations.CAL_CP(body_wieght)))+"");
				alle_me.setText(new DecimalFormat("#.##").format((0.01*Calculations.CAL_ME(body_wieght)+Calculations.CAL_ME(body_wieght)))+"");
				alle_ca.setText(new DecimalFormat("#.##").format((0.01*Calculations.CAL_CA(body_wieght)+Calculations.CAL_CA(body_wieght)))+"");
				alle_p.setText(new DecimalFormat("#.##").format((0.01*Calculations.CAL_P(body_wieght)+Calculations.CAL_P(body_wieght)))+"");
	
				
			}else
			{

				alle_dm.setText(new DecimalFormat("#.##").format((0.0))+"");
				alle_cp.setText(new DecimalFormat("#.##").format((0.0))+"");
				alle_me.setText(new DecimalFormat("#.##").format((0.0))+"");
				alle_ca.setText(new DecimalFormat("#.##").format((0.0))+"");
				alle_p.setText(new DecimalFormat("#.##").format((0.0))+"");
		
			}
			
		}
		
		
		
		//total 
		
		total_dm=(TextView)findViewById(R.id.total_dm);
		total_cp=(TextView)findViewById(R.id.total_cp);
		total_me=(TextView)findViewById(R.id.total_me);
		total_ca=(TextView)findViewById(R.id.total_ca);
		total_p=(TextView)findViewById(R.id.total_p);
		
		 total_dm_val=Double.parseDouble(main_dm.getText().toString().trim())+Double.parseDouble(prod_dm.getText().toString())+Double.parseDouble(alle_dm.getText().toString());
		 total_cp_val=Double.parseDouble(main_cp.getText().toString().trim())+Double.parseDouble(prod_cp.getText().toString())+Double.parseDouble(alle_cp.getText().toString());
		 total_ca_val=Double.parseDouble(main_ca.getText().toString().trim())+Double.parseDouble(prod_ca.getText().toString())+Double.parseDouble(alle_ca.getText().toString());
		 total_p_val=Double.parseDouble(main_p.getText().toString().trim())+Double.parseDouble(prod_p.getText().toString())+Double.parseDouble(alle_p.getText().toString());
		 total_me_val=Double.parseDouble(main_me.getText().toString().trim())+Double.parseDouble(prod_me.getText().toString())+Double.parseDouble(alle_me.getText().toString());
		
		
		total_dm.setText(new DecimalFormat("#.##").format(total_dm_val)+"");
		total_cp.setText(new DecimalFormat("#.##").format(total_cp_val)+"");
		total_me.setText(new DecimalFormat("#.##").format(total_me_val)+"");
		total_ca.setText(new DecimalFormat("#.##").format(total_ca_val)+"");
		total_p.setText(new DecimalFormat("#.##").format(total_p_val)+"");
		
		
		
	}

}
