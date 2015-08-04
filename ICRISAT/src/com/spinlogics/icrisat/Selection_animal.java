package com.spinlogics.icrisat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;

public class Selection_animal extends Activity{
	
ImageView cow,buffalo;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.start_screen);
		cow=(ImageView)findViewById(R.id.start_cow);
		buffalo=(ImageView)findViewById(R.id.start_buffalo);
		cow.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Calculations.type=0;
				startActivity(new Intent(Selection_animal.this, Form_filling.class));
				
			}
		});
		buffalo.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Calculations.type=1;
				startActivity(new Intent(Selection_animal.this, Form_filling.class));
			}
		});
	}
	@Override
		protected void onDestroy() {
		Calculations.type=2;
			super.onDestroy();
		}

}
