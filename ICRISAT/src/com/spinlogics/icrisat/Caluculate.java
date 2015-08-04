package com.spinlogics.icrisat;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import com.spinlogics.icrisat_db.Options_selected;

import android.R.array;




public class Caluculate {
	
	 static double min_price_intially=1000.0000;
	
	

	
	
	
/*	
	global min_price = 1000000 (some large value)

			array items ()

			function calculate(index_of_item, cost, nutrients_array)
		{
				
				curitem = item with index_of_item in array of items
				for(i=0;i<10;i++){
					consider i number of curitem
					if (cost + i*(cost_of_curitem)) > min_price
						return ;
					else {
						calculate the nutrients satisfied using this addition
						if(nutrients > desire) // no use using this item more items in the present configuration
							return ;
						else if( nutrients as per requirement){
							min_price = cost + i*(cost_of_curitem)
							return ;
						}
						else if(nutrients are less){
							calulate(index_of_item + 1, cost + i*(cost_of_curitem), updated_nutrients_array)
						}  
					}
				}
			}
	
	[7.86,1583.4,133.75,14.41,29.11]
			
	[90/100,26,10.6,0.18,0.72]*/

			//call : function(0, 0, initial_nutrients)
			
			
			
/*			public static double  MINIMUM_COST_PRICE(double cost,HashMap<String,Double>balance_vales ,ArrayList<Options_selected> comp)
			{
		ArrayList<Options_selected> list_compare=comp;
		HashMap<String, Double>blance_values = balance_vales;
		double min_price=0;
		
		boolean f_dm=false,f_cp=false,f_me=false,f_ca=false,f_p=false;
	
			
	
			balance_value.put("B_DM", bal_dm);
			balance_value.put("B_CP", bal_cp);
			balance_value.put("B_ME", bal_me);
			balance_value.put("B_CA", bal_ca);
			balance_value.put("B_P", bal_p);
		
		
		
		
		
		for(int i=0;i<list_compare.size();i++)
		{
			
			
			
					
			if(blance_values.get("B_DM")<Double.parseDouble(list_compare.get(i).getOptions_dm()))	
			{
				
				f_dm=true;
			}else
			{
				
				double new_dm=blance_values.get("B_DM")-Double.parseDouble(list_compare.get(i).getOptions_dm());
				list_compare.get(i).setOptions_dm(new_dm+"");//("C_DM", new_dm);
				MINIMUM_COST_PRICE(min_price, balance_vales, list_compare);
			}
			if(blance_values.get("B_CP")<Double.parseDouble(list_compare.get(i).getOptions_cp()))
			{
				f_cp=true;
				
			}else
			{

				double new_dm=blance_values.get("B_CP")-Double.parseDouble(list_compare.get(i).getOptions_cp());
				list_compare.put("C_CP", new_dm);
				MINIMUM_COST_PRICE(min_price, balance_vales, list_compare);
				
			}
			if(blance_values.get("B_ME")<Double.parseDouble(list_compare.get(i).getOptions_me()))
			{
				f_me=true;
			}else
			{

				double new_dm=blance_values.get("B_ME")-Double.parseDouble(list_compare.get(i).getOptions_me());
				MINIMUM_COST_PRICE(min_price, balance_vales, list_compare);
			}
			if(blance_values.get("B_CA")<list_compare.get("C_CA"))
			{
			f_ca=true;
			}else
			{

				double new_dm=blance_values.get("B_CA")-list_compare.get("C_CA");
				list_compare.put("C_DM", new_dm);		
				MINIMUM_COST_PRICE(min_price, balance_vales, list_compare);
			}
			if(blance_values.get("B_CA")<list_compare.get("C_CA"))
			{
			f_p=true;
			}else
			{
				double new_dm=blance_values.get("C_P")-list_compare.get("B_P");
				list_compare.put("B_P", new_dm);
				
				MINIMUM_COST_PRICE(min_price, balance_vales, list_compare);
				
			}

	if(f_dm&&f_cp&&f_me&&f_ca&&f_p)
	{
		min_price=cost+min_price*list_compare.get("PRICE");
	}
	
	
			
			
			
		}
		
		


			
		
		
		
		return min_price;
			}*/
			
			
	 
	 public static HashMap<String, Double> Find_min_price(HashMap<String, Double> desired,ArrayList<HashMap<String, Double>> selected)
	 {
		 HashMap<String, Double> min_values=new  HashMap<String, Double>();
		 
		 
		 HashMap<String, Double> desied_values=desired;
		 ArrayList<HashMap<String, Double>> values_selected=selected;
		 Collections.sort(values_selected,new price_compare());  
		
		 
/*		 balance_value.put("B_DM", bal_dm);
			balance_value.put("B_CP", bal_cp);
			balance_value.put("B_ME", bal_me);
			balance_value.put("B_CA", bal_ca);
			balance_value.put("B_P", bal_p);*/
		
		// C_CA
		 	ArrayList<Double> result=new ArrayList<Double>();
		 	if(values_selected.size()>0)
		 		ArrayList<Double> minprice=new ArrayList<Double>();
		 	for(int i=0;i<values_selected.size();i++)
		 	{
		 		
		 		double val_DM=values_selected.get(i).get("C_DM")/desied_values.get("B_DM");
				double val_CP=values_selected.get(i).get("C_CP")/desied_values.get("B_CP");
				double val_ME=values_selected.get(i).get("C_ME")/desied_values.get("B_ME");
				double val_CA=values_selected.get(i).get("C_CA")/desied_values.get("B_CA");
				double val_P=values_selected.get(i).get("C_P")/desied_values.get("B_P");
			
/*				min_values.put("V_DM", val_DM);
				min_values.put("V_CP", val_CP);
				min_values.put("V_ME", val_ME);
				min_values.put("V_CA", val_CA);*/
				
					
				if(values_selected.size()==0)
				{
			 		ArrayList<Double> max_val=new ArrayList<Double>();
					max_val.add(val_DM);
					max_val.add(val_CP);
					max_val.add(val_ME);
					max_val.add(val_CA);
					max_val.add(val_P);
					Collections.sort(max_val);
					minprice.add(max_val.get(max_val.size()-1));

					//	Max_values(val_DM,val_CP,val_ME,val_CA,val_P);
						//storeinarray(maxvalue * respective ingredient price)
				
				}else
				{
					ArrayList<Double> max_val1=new ArrayList<Double>();
					max_val1.add(val_DM);
					max_val1.add(val_CP);
					max_val1.add(val_ME);
					max_val1.add(val_CA);
					max_val1.add(val_P);
					Collections.sort(max_val1);
					minprice.add(max_val1.get(max_val1.size()-1));
					
					
					
					
				}
				
		 	}
		

		 	min of storedarray();
	

		return min_values;
		 
	 }
	 public double Max_values(double vdm,double vcp,double vme,double vp)
	 {
		 
		 
		 
		 
		 
		 
		 
		 return 0.5;
	 }
	 

	static class price_compare implements Comparator
{

	@Override
	public int compare(Object lhs, Object rhs) {
					HashMap<String, Double> val_one=(HashMap<String, Double>)lhs;
		HashMap<String, Double> val_two=(HashMap<String, Double>)rhs;
		
		
		if(val_one.get("PRICE")==val_two.get("PRICE"))
			return 0;
		else if(val_one.get("PRICE")<val_two.get("PRICE"))
			return 1;
		else
			return -1;

			
	}	
	}
			
			
			
			
		
		
		
		
		
			}



