package com.spinlogics.icrisat;

import java.util.ArrayList;
import java.util.HashMap;

import com.spinlogics.icrisat_db.Opretion_icrisat;
import com.spinlogics.icrisat_db.Options_selected;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.TextView;

public class List_options_table_two extends Activity{
	
	ListView options_list;
	Button go_compare;
	Opretion_icrisat opretions;
	ArrayList<Options_selected> selected=new ArrayList<Options_selected>();

	ArrayList<HashMap<String, Double>> list=new ArrayList<HashMap<String,Double>>();
	ArrayList<Double> list_coust_value=new ArrayList<Double>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.name_in_tab2);
		opretions=new Opretion_icrisat(List_options_table_two.this);
		options_list=(ListView)findViewById(R.id.tab2_opt);
		go_compare=(Button)findViewById(R.id.go_for_compare);
		opretions.open();
		ArrayList<Options_selected> opt_list=opretions.GET_TABBLE_TWO();
		if(opt_list.size()>0)
		{

			options_adp adp=new options_adp(opt_list, List_options_table_two.this);
			options_list.setAdapter(adp);
		}
		for(int i=0;i<opt_list.size();i++)
		{
			HashMap<String, Double> map=new HashMap<String, Double>();
			
			map.put("C_DM", Double.parseDouble(opt_list.get(i).getOptions_dm()));
			map.put("C_CP", Double.parseDouble(opt_list.get(i).getOptions_cp()));
			map.put("C_ME", Double.parseDouble(opt_list.get(i).getOptions_me()));
			map.put("C_CA", Double.parseDouble(opt_list.get(i).getOptions_ca()));
			map.put("C_P", Double.parseDouble(opt_list.get(i).getOptiuons_p()));
			map.put("PRICE", Double.parseDouble(opt_list.get(i).getOptions_rate()));
		
			list.add(map);
		}
		go_compare.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				for(int j=0;j<selected.size();j++)
				{

					//MINIMUM_COST_PRICE
					list_coust_value.add(Caluculate.MINIMUM_COST_PRICE(0, Table_one.balance_value, selected));
				}
			
				
				for(int k=0;k<list_coust_value.size();k++)
				Log.v("VALIES ARE", list_coust_value.get(k)+"");
				
				
				
			}
		});
		
		
		
		
	}
	
	class options_adp extends BaseAdapter{

		private ArrayList<Options_selected> list_info;
		Context ctx;
		LayoutInflater inflater;
		public options_adp(ArrayList<Options_selected> info_data,Context ct) {
			// TODO Auto-generated constructor stub
			list_info=info_data;
			ctx=ct;
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return list_info.size();
		}

		@Override
		public Object getItem(int position) {
			
			return null;
		}

		@Override
		public long getItemId(int position) {
			
			return 0;
		}

		@Override
		public View getView(final int position, View convertView, ViewGroup parent) {
			
			
			ViewHolderItem viewHolder;
			if(convertView==null)
			{
				  // inflate the layout
		        LayoutInflater inflater = ((Activity) ctx).getLayoutInflater();
		        convertView = inflater.inflate(R.layout.tab2_item, parent, false);
		         
		        // well set up the ViewHolder
		        viewHolder = new ViewHolderItem();
		        viewHolder.option_name = (TextView) convertView.findViewById(R.id.tab2_opt_name);
		        viewHolder.check_option = (CheckBox) convertView.findViewById(R.id.tab2_check);
		        
		        viewHolder.check_option.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

		            @Override
		            public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {

		            	
		            	
		            	if(isChecked)
		            		selected.add(list_info.get(position));
		            	
		            	else 
		            		selected.remove(list_info.get(position));
		          
		            }
		        }
		     ); 
		         
		        // store the holder with the view.
		        convertView.setTag(viewHolder);
		   
			}else
			{
				 viewHolder = (ViewHolderItem) convertView.getTag();
			}
			 Options_selected objectItem = list_info.get(position);
		     
			    // assign values if the object is not null
			    if(objectItem != null) {
			        // get the TextView from the ViewHolder and then set the text (item name) and tag (item ID) values
			        viewHolder.option_name.setText(objectItem.getOptions_name());
			    }
			
	/*		inflater = (LayoutInflater) ctx
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View rec_view = inflater.inflate(R.layout.bank_item, null);
			
			Regular_textview bank_name=(Regular_textview)rec_view.findViewById(R.id.bank_name);
			bank_name.setText(list_info.get(position).getBank_name());*/
			return convertView;
		}


		


	}
	static class ViewHolderItem {
	    TextView option_name;
	    CheckBox check_option;
	}

}
