package com.example.myapplication_;
import android.os.BatteryManager;
import 	android.content.IntentFilter;
import android.app.AlertDialog;
import android.widget.Toast;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.Context;
public class MyBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

//if(intent.getAction().equalsIgnoreCase("android.bluetooth.device.action.ACL_CONNECTED")){
//if(intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED)){
if(intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED) || intent.getAction().equals("android.intent.action.TIME_SET")){
	/*
	            Intent i = new Intent(context, MainActivity.class);
		                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				            context.startActivity(i);
					    */
	    MainActivity MainActivity2 = new MainActivity();
	    MainActivity2.bluetoothactivation(context);

context.startService(new Intent(context, MyService.class));


/*
BroadcastReceiver batteryLevelReceiver = new BroadcastReceiver(){
    @Override
    public void onReceive(Context context2, Intent intent2){
        int level = intent2.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
        int scale = intent2.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
        float batteryPct = level/(float)scale;       
Toast.makeText(context2, String.valueOf(batteryPct),Toast.LENGTH_LONG).show();
    }
};

IntentFilter batteryLevelFilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
context.registerReceiver(batteryLevelReceiver, batteryLevelFilter);
*/
// until it succeeds or throws an exception.
/*
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage("Do you want to exit ?");
        builder.create().show();
*/
/*
Toast.makeText(context,
                               "This a toast message",
                               Toast.LENGTH_LONG)
                    .show();
*/
					            }

	    /*
	         Intent myIntent = new Intent(context, MainActivity.class);
		        myIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			       context.startActivity(myIntent);
			       */
	 /*   MainActivity MainActivity2 = new MainActivity();
	    MainActivity2.bluetoothactivation();
	    */
    }
}
