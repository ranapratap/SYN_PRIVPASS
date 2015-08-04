package com.spinlogics.icrisat;

public class Calculations {
	public static int type=2;
	
	public static double Body_weight(int girth)
	{
		double body_weght=(5.011*girth)-481.1;
		
		return body_weght;
	}
	
	
	// Maintenance Constants .....
	
	// constants DM..
	
	static final  double DM_PROD_COW =0.063;
	static final  double DM_PROD_COW_PLUS=0.259;
	
	static final  double DM_PROD_BUFF=0.06321;
	static final  double DM_PROD_BUFF_PLUS=0.2946;
	
	
	//Constants Cp
	static final double CP_MAIN_BOTH=0.784;
	static final double CP_MAIN_BOTH_PLUSE=115.6;
	
	static final int CP_PROD_COW=96;
	static final int CP_PROD_BUFF=124;
	
// constants ME.. 0.09166 x b. wt. (kg) + 12.13
	
	static final double ME_MAIN_BOTH=0.09166;
	static final double ME_MAIN_BOTH_PLUS=12.13;
	
	
	//(0.6192 x butter fat % + 2.536)  x milk yield (kg)
	static final double ME_PROD_COW=0.6192;
	static final double ME_PROD_COW_PLUSE=2.536;
	
	//(0.6156 x butter fat % + 2.923) x milk yield (kg)
	
	static final double ME_PROD_BUFF=0.6156;
	static final double ME_PROD_BUFF_PLUS=2.923;
	
	
	// 0.0455 x b. wt. -  0.0549
	
	static final double CA_MAIN_BOTH=0.0455;
	static final double CA_MAIN_BOTH_PLUSE=0.0549;
	
	
	//3.2 x  milk yield (kg) -
	static final double CA_PROD_COW=3.2;
	static final double CA_PROD_BUFF=4.8  ;
			
	//0.02 x b. wt. (kg)
	static final double P_MAIN_BOTH=0.02;
	static final double P_PROD_BOTH=1.8;
		
	
	
	public static double CAL_DM(double bw)
	{
		return 0.0216*bw;
		
	}
	public static double CAL_DM(double butter_fat,double milk_yeld,boolean flag)
	{
	/*	0.063 x butter fat % + ) x milk yield (kg)*/
		double result;
		if(flag)//cow
			result=(DM_PROD_COW*butter_fat+DM_PROD_COW_PLUS)*milk_yeld;
			else // bufflow 
				result=(DM_PROD_BUFF*butter_fat+DM_PROD_BUFF_PLUS)*milk_yeld;
		
		return result;
	}

	public static double CAL_CP(double b_wegt)
	{
	return (CP_MAIN_BOTH*b_wegt+CP_MAIN_BOTH_PLUSE);
	}
	public static double CAL_CP(double milk_yelt,boolean flag)
	{
		if(flag)
			return CP_PROD_COW*milk_yelt;
			//96 x milk yield (kg)
		else
			//124 x milk yield (kg)
			return CP_PROD_BUFF*milk_yelt;
		
	}
	
	
	public static double CAL_ME(double b_wt)
	{
		//0.09166 x b. wt. (kg) + 12.13
		
		return (ME_MAIN_BOTH*b_wt)+ME_MAIN_BOTH_PLUS;
	}
	
	
	public static double  CAL_ME(double butter_fat,double milk_yield,boolean flag)
	{
		if(flag)
		//(0.6192 x butter fat % + 2.536)  x milk yield (kg)
			return ((ME_PROD_COW*butter_fat)+ME_PROD_COW_PLUSE)*milk_yield;
		else
			return ((ME_PROD_BUFF*butter_fat)+ME_PROD_BUFF_PLUS)*milk_yield;
	}
	
	public static double CAL_CA(double b_wt)
	{
		//0.0455 x b. wt. -  0.0549
		return (CA_MAIN_BOTH*b_wt)-CA_MAIN_BOTH_PLUSE;
	}
	
	public static double CAL_CA(double milk_yeld ,boolean flag)
	{//3.2 x  milk yield (kg)
		if(flag)
			return CA_PROD_COW*milk_yeld;
		else
			return CA_PROD_BUFF*milk_yeld;
		
	}
	public static double CAL_P(double b_wt )
	{
		//0.02 x b. wt. (kg)
		return P_MAIN_BOTH*b_wt;
		
	}
	
	
	public static double CAL_PP(double milk_yield)
	{
		return P_PROD_BOTH*milk_yield;
	}

	
	
	
	
	// Given calculation here 
	
	
	
	public static double New_DM(double omr,double bw)
	{
		return ((-6.1+(0.57*omr))*bw)/1000;
		
	}
	public static double New_CP(double dm,double cp)
	{
		return dm*10*cp;
	}
	
	public static double New_ME(double dm,double me)
	{
		return dm*me;
	}
	public static double New_CA(double dm,double ca)
	{
		return dm*10*ca;
	}
	
	public static double New_p(double dm,double p)
	{
		return dm*10*p;
	}

}
