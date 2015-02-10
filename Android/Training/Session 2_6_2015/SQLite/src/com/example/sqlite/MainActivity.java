package com.example.sqlite;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	
	EditText name,id;
	
	Button save,search;
	UsersDBHelper u ;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        u = new UsersDBHelper(getApplicationContext());
        save = (Button) findViewById(R.id.saveButton);
        search = (Button) findViewById(R.id.searchButton);
        name = (EditText) findViewById(R.id.userName);
        id = (EditText) findViewById(R.id.userId);
        save.setOnClickListener(this);
        search.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		int vid = v.getId();
		
		if(vid == R.id.saveButton){
			u.addUser(new User(Integer.parseInt(id.getText().toString()), name.getText().toString()));
			
		}
		
		else{
			System.out.println("Here");
			User user = u.getUser(Integer.parseInt(id.getText().toString()));
			Toast.makeText(getApplicationContext(), user.getName(), Toast.LENGTH_LONG).show();
			
		}
	}
    
}
