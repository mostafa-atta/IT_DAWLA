package com.example.registerationsystem;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends Activity{
   // make variable of TextView type
	TextView tv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		// connect to the layout of this page
		setContentView(R.layout.secondpage);
		// declare variable to take the name from the first page 
		Bundle extras= getIntent().getExtras();
		// take the name into string
		String name = extras.getString("Name");
		// set the variable for the textview in this page
		tv = (TextView) findViewById(R.id.textView6);
		// set text into the text view
		tv.setText("Hello " + name);
		
	}
		
}