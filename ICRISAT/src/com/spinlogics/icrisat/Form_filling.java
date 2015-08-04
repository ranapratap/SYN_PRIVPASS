package com.spinlogics.icrisat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Form_filling extends Activity {
	
	EditText girth,milk_yield,butter_per,lactations;
	
	Button submit_here;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub

		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.form_fill_app);
		girth=(EditText)findViewById(R.id.one_val);
		milk_yield=(EditText)findViewById(R.id.two_val);
		butter_per=(EditText)findViewById(R.id.three_val);
		lactations=(EditText)findViewById(R.id.four_val);
		
		submit_here=(Button)findViewById(R.id.submit);
		
		submit_here.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				
				
				if(		  !girth.getText().toString().trim().equalsIgnoreCase("")
						&&!milk_yield.getText().toString().trim().equalsIgnoreCase("")
						&&!butter_per.getText().toString().trim().equalsIgnoreCase("")
						&&!lactations.getText().toString().trim().equalsIgnoreCase(""))
				{

					int girth_val=Integer.parseInt(girth.getText().toString().trim());
					int milk_val=Integer.parseInt(milk_yield.getText().toString().trim());
					int butter_val=Integer.parseInt(butter_per.getText().toString().trim());
					int lact_val=Integer.parseInt(lactations.getText().toString().trim());
					
					Intent i = new Intent(getApplicationContext(), Result_info.class);
					i.putExtra("G",girth_val);
					i.putExtra("M",milk_val);
					i.putExtra("B",butter_val);
					i.putExtra("L",lact_val);
					startActivity(i);
					
					
				}else
					Toast.makeText(Form_filling.this, "అన్ని క్షేత్రాలను ఇవ్వండి", Toast.LENGTH_LONG).show();
			}
		});
		
	
	}

}
