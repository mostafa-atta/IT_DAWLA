package com.example.registerationsystem;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View.OnClickListener;
import android.view.View;

public class MainActivity extends Activity implements OnClickListener{
	// declare variables from EditText type
	EditText name,pass,email,phone,age;
	// declare variable from Button type
	Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // connect to the layout to show the interface
        setContentView(R.layout.registration);
        // take the input in my variables
        name =(EditText) findViewById(R.id.editView1);
        email =(EditText) findViewById(R.id.editView2);
        pass =(EditText) findViewById(R.id.editView3);
        age =(EditText) findViewById(R.id.editView4);
        phone =(EditText) findViewById(R.id.editView5);
        submit=(Button)  findViewById(R.id.ButtonView1);
        submit.setOnClickListener(this);
    }
    @Override
	public void onClick(View v) {
    	// take the input into strings to check on them
    	String name1 = name.getText().toString();
		String email1 = email.getText().toString();
		String password1 = pass.getText().toString();
		String age1 = age.getText().toString();
		String phone1 = phone.getText().toString();
		// declare variables from boolean type for my checks
		boolean ch=false,di=false,a1=false,a2=false,bage=true,bphone=true;
		// loop on password to check it
		for (int i = 0 ; i < password1.length() ; i++)
		{
			// make sure that Password contain digits
			if(Character.isDigit(password1.charAt(i)))
		    {
		    	di = true;
		    }
			// make sure that Password contain letters 
			if(Character.isLetter(password1.charAt(i)))
		    {
		    	ch = true;
		    }
			// if it contain both letters and digits go out the loop
			if (ch&&di)
		        break;
		}
		// loop on E-mail to check it
		for (int i = 0 ; i < email1.length() ; i++)
		{
			// make sure that Email contain '@' letter and it is not the first char
			if (email1.charAt(i) == '@'&&i!=0)
			    a1=true;
			// make sure that E-mail contain '.' letter and it is not the last char
			if(a1 && email1.charAt(i) == '.' && i!= email1.length()-1)
			a2 = true;
			// if it contain both '@' and '.' in right positions go out the loop 
			if(a1&&a2)
			break;
		}
		// loop on age to check it
		for (int i = 0 ; i < age1.length() ; i++)
		{
		    // check if it contain any thing not digit
			if(!Character.isDigit(age1.charAt(i)))
		    {
		        bage=false;
		        break;
		    }
		}
		// loop on Phone to check it
		for (int i = 0 ; i < phone1.length() ; i++)
		{
			// check if it contain any thing not digit
		    if(!Character.isDigit(phone1.charAt(i)))
		    {
		        bphone=false;
		        break;
		    }
		}
		// print error massage if name not entered
		if(name1.length() < 1)
			Toast.makeText(getApplicationContext(), "Name is not correct !!! ", Toast.LENGTH_LONG).show();
		// print error massage if Password length less than 8
		else if (password1.length() < 8)
			Toast.makeText(getApplicationContext(), "Pass is not correct !!! ", Toast.LENGTH_LONG).show();			
		// print error massage if Password didn't contain digits or letters 
		else if(!ch || !di)
			Toast.makeText(getApplicationContext(), "Pass is not correct !!! ", Toast.LENGTH_LONG).show();	
		// print error massage if E-mail didn't contain '@' or '.' in the right positions
		else if(!a1 || !a2)
		Toast.makeText(getApplicationContext(), "E-mail is not correct !!! ", Toast.LENGTH_LONG).show();
		// print error massage if Age length greater than 2 or has any thing nor digit
		else if(!bage || age1.length() > 2 )
		    Toast.makeText(getApplicationContext(), "Age is not correct !!! ", Toast.LENGTH_LONG).show();
		// print error massage if Phone contain any thing not digits
		else if(!bphone)
		    Toast.makeText(getApplicationContext(), "Phone is not correct !!! ", Toast.LENGTH_LONG).show();
		// if all things is right go to the next page
		else
		{
			// go to the next page
			Intent intent = new Intent(this, SecondActivity.class);  
		    // send name to the next page
			intent.putExtra("Name", name1);
			// start the second page
			startActivity(intent); 
		}
    }
}

