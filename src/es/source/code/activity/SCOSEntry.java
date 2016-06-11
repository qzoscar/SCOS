package es.source.code.activity;

import com.zen.scos.R;

import android.app.Activity;
import android.content.Intent;
import android.location.GpsStatus.Listener;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;

public class SCOSEntry extends Activity {

	private GestureDetector detector;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.entry);
        detector = new GestureDetector(this, 
        		new SimpleOnGestureListener(){
        	//¼àÌýÊÖÊÆ»¬¶¯
        	@Override
        	public boolean onFling(MotionEvent e1, MotionEvent e2,
        			float velocityX, float velocityY) {
        		if(e1.getRawX()-e2.getRawX()>200){
        			nextPage();
        			return true;
        		}
        		return super.onFling(e1, e2, velocityX, velocityY);
        	}
        });
        
        
    }
    
    
    public void nextPage(){	
    	Intent intent = new Intent("scos.intent.action.SCOSMAIN");
    	intent.addCategory("scos.intent.category.SCOSLAUNCHER");
    	intent.putExtra("message", "FromEntry");
    	startActivity(intent);
  
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
    	detector.onTouchEvent(event);
    	return super.onTouchEvent(event);
    }
}
