package es.source.code.activity;

import com.zen.scos.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainScreen extends Activity {
	Button button_order;
	Button button_check;
	Button button_log;
	Button button_help;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mainscreen);
		button_order = (Button) findViewById(R.id.button_order);
		button_check = (Button) findViewById(R.id.button_check);
		button_log = (Button) findViewById(R.id.button_log);
		button_help = (Button) findViewById(R.id.button_help);
		Intent intent = getIntent();
		String message = intent.getStringExtra("message");
		if(!message.equals("FromEntry")){
			//如果相等，则正常显示当前屏幕；如果不相等，则隐藏导航项：点菜，查看订单。
			button_check.setVisibility(View.GONE);
			button_order.setVisibility(View.GONE);
		}
		button_log.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				LoginPage();
			}
		});
	}
	
	void LoginPage(){
		Intent intent2 = new Intent(MainScreen.this,LoginOrRegister.class);
		startActivityForResult(intent2, 1);
	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		switch (requestCode) {
		case 1:
			if(resultCode==RESULT_OK){
				String returndataString = data.getStringExtra("message2");
				if(returndataString.equals("LoginSuccess")){
					button_check.setVisibility(View.VISIBLE);
					button_order.setVisibility(View.VISIBLE);
				}
			}
			break;

		default:
		
		}
	}
	
}
