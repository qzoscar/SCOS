package es.source.code.activity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.zen.scos.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginOrRegister extends Activity {
	private Button bt_login;
	private Button bt_back;
	private EditText et_user;
	private EditText et_password;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.loginorregister);
		et_user = (EditText) findViewById(R.id.ET_Username);
		et_password = (EditText) findViewById(R.id.ET_Password);
		bt_login = (Button) findViewById(R.id.bt_login);
		bt_back = (Button) findViewById(R.id.bt_back);
		bt_login.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Login();
				
			}
		});
		bt_back.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				back();
			}
		});
		
	}
	
	public boolean Login() {
		String username = et_user.getText().toString();
		String psw = et_password.getText().toString();
		Pattern pattern = Pattern.compile("^[A-Za-z0-9]+$");
		Matcher matcherusername = pattern.matcher(username);
		Matcher matcherpsw = pattern.matcher(psw);
		if(!matcherusername.matches()||username.equals(null)){
			et_user.setError("输入内容不符合规则");
			return false;
		}
		if(!matcherpsw.matches()||psw.equals(null)){
			et_password.setError("输入内容不符合规则");
			return false;
		}
		Intent intent = new Intent();
		intent.putExtra("message2", "LoginSuccess");
		setResult(RESULT_OK,intent);
		finish();
		return true;
	}
	
	public void back(){
		Intent intent = new Intent();
		intent.putExtra("message3", "Return");
		setResult(RESULT_CANCELED,intent);
		finish();
	}
	
}
