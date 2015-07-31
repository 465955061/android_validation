package com.example.android_validation;

import com.jifeng.compant.VActivity;
import com.jifeng.compant.VEditText;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class MainActivity extends VActivity implements OnClickListener{
	VEditText editText1,editText2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		editText1=(VEditText) findViewById(R.id.vedit);
		editText2=(VEditText)findViewById(R.id.vedit2);
		addList(editText1);
		addList(editText2);
//		SimpleDateFormat format=new SimpleDateFormat("HH:mm");
//		Date date = null;
//		try {
//			date = format.parse("12:12");
//			
//			Log.i("date", date.getTime()+"");
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		

		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.button1:
			v.setFocusable(false);
			if (fromvalidate()) {
				Toast.makeText(this, "表单验证成功", 1000).show();
			}
			
			break;

		default:
			break;
		}
	}
}
