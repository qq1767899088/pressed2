package com.example.myapplication_;
import android.media.MediaPlayer;
//import com.googlecode.tesseract.android.TessBaseAPI;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import java.util.List;
import java.util.concurrent.Executors;
import android.bluetooth.BluetoothHidDeviceAppSdpSettings;
import android.bluetooth.BluetoothHidDeviceAppQosSettings;
//import android.bluetooth.BluetoothAdapter;
//import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHidDevice;
//import android.bluetooth.BluetoothProfile;
//import android.os.Bundle;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/*
import android.os.Environment;
import java.util.Map;
import java.util.HashMap;
import java.lang.Float;
import java.lang.Double;
import java.util.ArrayList;
import java.util.Arrays;
import org.opencv.core.CvType;
import org.opencv.core.Rect;
import org.opencv.android.Utils;
import org.opencv.core.Core; 
import org.opencv.core.Mat;  
import org.opencv.imgcodecs.Imgcodecs;
import java.lang.IllegalArgumentException;
import org.tensorflow.lite.InterpreterApi;
import org.tensorflow.lite.InterpreterApi.Options.TfLiteRuntime;
//import com.google.android.play.core.tasks.Task;
import java.io.FileInputStream;
import android.content.res.AssetFileDescriptor;
import org.tensorflow.lite.Interpreter;
*/
///import java.io.FileInputStream;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import android.widget.TextView;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.widget.LinearLayout;
import android.view.Gravity;
import android.view.WindowManager;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import android.content.BroadcastReceiver;
import org.commonmark.node.Node;
import android.text.Spanned;
import  io.noties.markwon.Markwon;
import androidx.core.content.ContextCompat;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.content.SharedPreferences;
import android.provider.Settings;
import android.net.Uri;
import java.net.Socket;
import 	org.json.JSONObject;
import android.os.AsyncTask;
import 	java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.BufferedOutputStream;
import 	java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.lang.reflect.InvocationTargetException;
import android.bluetooth.BluetoothProfile;
import android.content.Context;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.Class;

import android.os.Message;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.DataOutputStream;
import android.os.Handler;
import android.widget.Toast;
import android.app.AlertDialog;
import android.bluetooth.BluetoothSocket;

import android.util.Log;
import 	java.io.IOException;
import java.util.UUID;
import java.util.Set;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothServerSocket;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.app.ActivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.graphics.BitmapFactory;

import com.example.myapplication_.databinding.ActivityMainBinding;
import android.bluetooth.BluetoothManager;
import android.bluetooth.BluetoothDevice;

//11
public class MainActivity extends AppCompatActivity {
BluetoothProfile proxy2; 
Method connectMethod;
//Interpreter interpreter;

	

// Create a list of maps called myAllDevices
List<Map<String, String>> myAllDevices = new ArrayList<>();



// Create a string list called myAllDevices
///List<String> myAllDevices = new ArrayList<>();

int deviceIndex = 0;
Context myctx;
String globalMsg;
Method mBTPanConnect = null;
BluetoothDevice device2;
Class<?> noparams[] = {};
Object instance = null;
    Method setTetheringOn = null;
    Method isTetheringOn = null;
    Object mutex = new Object();
   public static Handler mHandler;
   private ConnectedThread mConnectedThread;
   private ConnectedThread2 mConnectedThread2;
private SocketDataReceiver socketDataReceiver;
   private interface MessageConstants {
       public static final int MESSAGE_READ = 0;
       public static final int MESSAGE_WRITE = 1;
       public static final int MESSAGE_TOAST = 2;

       // ... (Add other message types here as needed.)
   }
     String hint = "00";
         private static final String TAG = "MyActivity";
//22
public static void sudo(String...strings) {
    try{
        Process su = Runtime.getRuntime().exec("su");
        DataOutputStream outputStream = new DataOutputStream(su.getOutputStream());

        for (String s : strings) {
            outputStream.writeBytes(s+"\n");
            outputStream.flush();
        }

        outputStream.writeBytes("exit\n");
        outputStream.flush();
        try {
            su.waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        outputStream.close();
    }catch(IOException e){
        e.printStackTrace();
    }
}

//117
private class SocketDataReceiver extends BroadcastReceiver
    {
        @Override
        public void onReceive(Context context, Intent intent) {
            // intent contains your socket data,
globalMsg = intent.getStringExtra(MyService.SOCKET_DATA_IDENTIFIER);
int indicator = intent.getIntExtra("indicator",9);
if(indicator > 1)
{
try {
//    JSONObject jsonObject = new JSONObject(globalMsg);
JSONArray jsonArray = new JSONArray(globalMsg);
    //use jsonObject as needed
//MainActivity4Kt.setContent(binding.brutal,Integer.toString(1) + jsonArray.getJSONObject(0).getString("description"));
MainActivity4Kt.setContent(binding.brutal, globalMsg,indicator);
//MainActivity4Kt.setContent3(binding.brutal, jsonArray.getJSONObject(0).getString("description"));
} catch (JSONException e) {
    e.printStackTrace();
}

return;
}
MainActivity4Kt.setContent(binding.brutal,Integer.toString(indicator) + globalMsg);
//setContentJava(binding.brutal,globalMsg);
            // get data from intent using SocketThread.SOCKET_DATA_IDENTIFIER
        }
    }

private class HTTPReqTask extends AsyncTask<Void, Void, Void> {
String operation;
public HTTPReqTask(String operation2){
operation = operation2;
}
    @Override
    protected Void doInBackground(Void... params) {
        HttpURLConnection urlConnection = null;

        try {
            URL url = new URL("https://wtuih.com/nobel.php");
            urlConnection = (HttpURLConnection) url.openConnection();

JSONObject postData = new JSONObject();
            postData.put("name", "morpheus");
            postData.put("operation", operation);

            urlConnection.setRequestProperty("Content-Type", "application/json");
            urlConnection.setRequestMethod("POST");
            urlConnection.setDoOutput(true);
            urlConnection.setDoInput(true);
            urlConnection.setChunkedStreamingMode(0);

            OutputStream out = new BufferedOutputStream(urlConnection.getOutputStream());
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
                    out, "UTF-8"));
            writer.write(postData.toString());
            writer.flush();
            int code = urlConnection.getResponseCode();
            if (code !=  200) {
                throw new IOException("Invalid response from server: " + code);
            }

byte[] mmBuffer = new byte[1024];
                 int  numBytes = urlConnection.getInputStream().read(mmBuffer);
		   String mmBuffer2 = new String(mmBuffer,0,numBytes);
                   Message readMsg = mHandler.obtainMessage(
                           MessageConstants.MESSAGE_READ, numBytes, -1,
                           mmBuffer2);
                   readMsg.sendToTarget();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }

        return null;
    }
}
public class BTPanServiceListener implements BluetoothProfile.ServiceListener {

        private final Context context;

        public BTPanServiceListener(final Context context) {
            this.context = context;
        }

        @Override
        public void onServiceConnected(final int profile,
                                       final BluetoothProfile proxy) {
proxy2 = proxy;
//          Toast.makeText(context, "e",Toast.LENGTH_LONG).show();
            //Some code must be here or the compiler will optimize away this callback.
try {
Log.d("bluetoothpanTesting0926","0");
            connectMethod = proxy.getClass().getDeclaredMethod("connect", BluetoothDevice.class);
Log.d("bluetoothpanTesting0926","1");
Handler handler = new Handler();
handler.postDelayed(new Runnable()
{
    @Override
    public void run()
    {
 //         Toast.makeText(context, "e3",Toast.LENGTH_LONG).show();
    }
}, 2000);
SharedPreferences sharedPreferences = context.getSharedPreferences("myprefs",context.MODE_PRIVATE);
        String deviceAddress = sharedPreferences.getString("deviceAddress", "");
BluetoothAdapter btAdapter = BluetoothAdapter.getDefaultAdapter();
        if(!btAdapter.isEnabled())
            btAdapter.enable();

        Set<BluetoothDevice> pairedDevices = btAdapter.getBondedDevices();

        for(BluetoothDevice d : pairedDevices)
            if(d.getAddress().equalsIgnoreCase(deviceAddress))
                device2 = d;
handler.postDelayed(new Runnable()
{
    @Override
    public void run()
    {
          Toast.makeText(context,
                               deviceAddress,
                               Toast.LENGTH_LONG)
                    .show();
    }
}, 4000);
            if(!((Boolean) connectMethod.invoke(proxy, device2))){
                Log.e("MyApp", "Unable to start connection");
handler.postDelayed(new Runnable()
{
    @Override
    public void run()
    {
          Toast.makeText(context, "e1",Toast.LENGTH_LONG).show();
    }
}, 6000);
            }
        } catch (Exception e) {
            Log.e("MyApp", "Unable to reflect android.bluetooth.BluetoothPan", e);
        }

try {
hint = " nowval";
Log.d("bluetoothpanTesting0926","10");
            boolean nowVal = ((Boolean) proxy.getClass().getMethod("isTetheringOn", new Class[0]).invoke(proxy, new Object[0])).booleanValue();
            if (nowVal) {
hint = " nowval1";
Log.d("bluetoothpanTesting0926","11");
                //proxy.getClass().getMethod("setBluetoothTethering", new Class[]{Boolean.TYPE}).invoke(proxy, new Object[]{Boolean.valueOf(false)});
Log.d("bluetoothpanTesting0926","12");

hint = " nowval11";
            } else {
hint = " nowval2";
Log.d("bluetoothpanTesting0926","13");
                Method tetheringMethod = proxy.getClass().getMethod("setBluetoothTethering", new Class[]{Boolean.TYPE});
Log.d("bluetoothpanTesting0926","14");
tetheringMethod.invoke(proxy, new Object[]{Boolean.valueOf(true)});
Log.d("bluetoothpanTesting0926","15");
hint = " nowval22";
            }
}
         catch (Exception e) {
            e.printStackTrace();
Log.d("bluetoothpanTesting0926","myTetheringException",e);
        }
/*
catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
*/
        }

        @Override
        public void onServiceDisconnected(final int profile) {
        }
    }
private class ConnectThread extends Thread {
   private final BluetoothSocket mmSocket;
   private final BluetoothDevice mmDevice;
		    BluetoothManager bluetoothManager = getSystemService(BluetoothManager.class);
		    BluetoothAdapter bluetoothAdapter = bluetoothManager.getAdapter();

   public ConnectThread(BluetoothDevice device) {
       // Use a temporary object that is later assigned to mmSocket
       // because mmSocket is final.
       BluetoothSocket tmp = null;
       mmDevice = device;
       hint = "c1";
       try {
        hint = "c2";
           // Get a BluetoothSocket to connect with the given BluetoothDevice.
           // MY_UUID is the app's UUID string, also used in the server code.
           UUID uuid = UUID.fromString("f05280d2-9df5-4a07-87e0-c428a66ca5da");
           tmp = device.createRfcommSocketToServiceRecord(uuid);
       } catch (IOException e) {
           Log.e(TAG, "Socket's create() method failed", e);
       }
       hint = "c3";
       mmSocket = tmp;
   }

   public void run() {
       // Cancel discovery because it otherwise slows down the connection.
       bluetoothAdapter.cancelDiscovery();

       try {
           hint = "c4";
           // Connect to the remote device through the socket. This call blocks
           // until it succeeds or throws an exception.
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Do you want to exit ?");
        builder.create().show();
           mmSocket.connect();
          hint = "c5";
               Log.d(TAG, "wtuih bluetooth connect success");
       } catch (IOException connectException) {
           // Unable to connect; close the socket and return.
               Log.d(TAG, "wtuih bluetooth connect catch");
           try {
               mmSocket.close();
           } catch (IOException closeException) {
               Log.e(TAG, "Could not close the client socket", closeException);
           }
           return;
       }

       // The connection attempt succeeded. Perform work associated with
       // the connection in a separate thread.
MyService.blSocket = mmSocket;
        Intent intent = new Intent(MyService.SOCKET_DATA_RECEIVED);
        //intent.putExtra(SOCKET_DATA_IDENTIFIER, Integer.toString(check) +"+"+Integer.toString(globalI) + mmBuffer2); // store data in your intent
        intent.putExtra(MyService.SOCKET_DATA_IDENTIFIER, "mmBuffer2"); // store data in your intent
        //intent.putExtra(SOCKET_DATA_IDENTIFIER, Integer.toString(isData) + mmBuffer2); // store data in your intent
        intent.putExtra("indicator", 18); // store data in your intent
        //intent.putExtra(SOCKET_DATA_IDENTIFIER,  mmBuffer2); // store data in your intent
       // intent.putExtra(SOCKET_DATA_IDENTIFIER, Integer.toString(numBytes)); // store data in your intent
        // send data to registered receivers
        LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);

/*
	//33
       mConnectedThread = new ConnectedThread(mmSocket);
       mConnectedThread.start();
       //manageMyConnectedSocket(mmSocket);
*/
   }

   // Closes the client socket and causes the thread to finish.
   public void cancel() {
       try {
           mmSocket.close();
       } catch (IOException e) {
           Log.e(TAG, "Could not close the client socket", e);
       }
   }
}

//33
private class AcceptThread extends Thread {
   private final BluetoothServerSocket mmServerSocket;

		    BluetoothManager bluetoothManager = getSystemService(BluetoothManager.class);
		    BluetoothAdapter bluetoothAdapter = bluetoothManager.getAdapter();
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
   public AcceptThread() {
       // Use a temporary object that is later assigned to mmServerSocket
       // because mmServerSocket is final.
       BluetoothServerSocket tmp = null;
        builder.setMessage("1");
        builder.create().show();
        hint = "1";
       try {
           // MY_UUID is the app's UUID string, also used by the client code.
           UUID uuid = UUID.fromString("f05280d2-9df5-4a07-87e0-c428a66ca5da");
           tmp = bluetoothAdapter.listenUsingRfcommWithServiceRecord("NAME", uuid);
        builder.setMessage("2");
        builder.create().show();
          hint = "2";
       } catch (IOException e) {
           Log.e(TAG, "Socket's listen() method failed", e);
       }
       mmServerSocket = tmp;
   }

   public void run() {
       BluetoothSocket socket = null;
       // Keep listening until exception occurs or a socket is returned.
       hint = "3";
       while (true) {
           try {
               hint = "6";
               socket = mmServerSocket.accept();
               hint = "5";
           } catch (IOException e) {
               Log.e(TAG, "Socket's accept() method failed", e);
               break;
           }

           if (socket != null) {
               // A connection was accepted. Perform work associated with
               // the connection in a separate thread.
	//88
               Log.d(TAG, "wtuih bluetooth accept success");
MyService.blSocket = socket;
        Intent intent = new Intent(MyService.SOCKET_DATA_RECEIVED);
        //intent.putExtra(SOCKET_DATA_IDENTIFIER, Integer.toString(check) +"+"+Integer.toString(globalI) + mmBuffer2); // store data in your intent
        intent.putExtra(MyService.SOCKET_DATA_IDENTIFIER, "mmBuffer2"); // store data in your intent
        //intent.putExtra(SOCKET_DATA_IDENTIFIER, Integer.toString(isData) + mmBuffer2); // store data in your intent
        intent.putExtra("indicator", 18); // store data in your intent
        //intent.putExtra(SOCKET_DATA_IDENTIFIER,  mmBuffer2); // store data in your intent
       // intent.putExtra(SOCKET_DATA_IDENTIFIER, Integer.toString(numBytes)); // store data in your intent
        // send data to registered receivers
        LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);


/*
       mConnectedThread = new ConnectedThread(socket);
       mConnectedThread.start();
           //    manageMyConnectedSocket(socket);
       hint = "4";
*/
       try {
           mmServerSocket.close();
       } catch (IOException e) {
           Log.e(TAG, "Could not close the connect socket", e);
       }
               break;
           }
       }
   }

   // Closes the connect socket and causes the thread to finish.
   public void cancel() {
       try {
           mmServerSocket.close();
       } catch (IOException e) {
           Log.e(TAG, "Could not close the connect socket", e);
       }
   }
}

public void bluetoothactivation2(Context context2){

          Toast.makeText(context2,
                               "This a toast message",
                               Toast.LENGTH_LONG)
                    .show();
	}

public boolean foregroundServiceRunning(){
    ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
    for(ActivityManager.RunningServiceInfo service: activityManager.getRunningServices(Integer.MAX_VALUE)) {
/*
          Toast.makeText(getApplicationContext(),
                               "This a toast message",
                               Toast.LENGTH_LONG)
                    .show();
*/
        if(MyService.class.getName().equals(service.service.getClassName())) {
          Toast.makeText(getApplicationContext(),
                               "his a toast message",
                               Toast.LENGTH_LONG)
                    .show();
            return true;
        }
    }
    return false;
}

public void bluetoothactivation(Context context3){

String sClassName = "android.bluetooth.BluetoothPan";
Class<?> classBluetoothPan = null;

        try {

            classBluetoothPan = Class.forName(sClassName);
Log.d("bluetoothTetheringTurnOnWtuih","1");

//mBTPanConnect = classBluetoothPan.getDeclaredMethod("connect", BluetoothDevice.class);
Log.d("bluetoothTetheringTurnOnWtuih","4");
Constructor<?>[] constructors = classBluetoothPan.getDeclaredConstructors();
for (Constructor<?> constructor : constructors) {
    StringBuilder constructorSignature = new StringBuilder();
    constructorSignature.append(constructor.getName()).append("(");
    Class<?>[] parameterTypes = constructor.getParameterTypes();
    for (int i = 0; i < parameterTypes.length; i++) {
        constructorSignature.append(parameterTypes[i].getName());
        if (i < parameterTypes.length - 1) {
            constructorSignature.append(", ");
        }
    }
    constructorSignature.append(")");
//    System.out.println(constructorSignature);
Log.d("bluetoothTetheringTurnOnWtuih",constructorSignature.toString());
}
            Constructor<?> ctor = classBluetoothPan.getDeclaredConstructor(Context.class, BluetoothProfile.ServiceListener.class);
            //Constructor<?> ctor = classBluetoothPan.getDeclaredConstructor(Context.class, BluetoothProfile.ServiceListener.class,BluetoothAdapter.class);
Log.d("bluetoothTetheringTurnOnWtuih","6");
            ctor.setAccessible(true);
            //  Set Tethering ON
            Class[] paramSet = new Class[1];
            paramSet[0] = boolean.class;

Log.d("bluetoothTetheringTurnOnWtuih","3");
            synchronized (mutex) {
/*
                setTetheringOn = classBluetoothPan.getDeclaredMethod("setBluetoothTethering", paramSet);
Log.d("bluetoothTetheringTurnOnWtuih","5");
                isTetheringOn = classBluetoothPan.getDeclaredMethod("isTetheringOn", noparams);
Log.d("bluetoothTetheringTurnOnWtuih","2");
BluetoothAdapter btAdapter = BluetoothAdapter.getDefaultAdapter();
setTetheringOn.invoke(btAdapter, true);
*/
/*
BluetoothAdapter btAdapter = BluetoothAdapter.getDefaultAdapter();
                instance = ctor.newInstance(context3, new BTPanServiceListener(context3),btAdapter);
*/
                instance = ctor.newInstance(context3, new BTPanServiceListener(context3));
Log.d("bluetoothTetheringTurnOnWtuih","6");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
Log.d("bluetoothTetheringTurnOnWtuih","2",e);
        } catch (Exception e) {
            e.printStackTrace();
Log.d("bluetoothTetheringTurnOnWtuih","3",e);
        }

}

//44
   private BluetoothDevice pairedDevice1;
	private final static int REQUEST_ENABLE_BT = 1;
    int score = 0;
    // Used to load the 'myapplication_' library on application startup.
    static {
        System.loadLibrary("myapplication_");
    }

//private MappedByteBuffer loadModelFile() throws IOException
/*
private MappedByteBuffer loadModelFile()
{
AssetFileDescriptor assetFileDescriptor;
try{
assetFileDescriptor = this.getAssets().openFd("saranIto.tflite");
if(assetFileDescriptor == null){
}
FileInputStream fileInputStream = new FileInputStream(assetFileDescriptor.getFileDescriptor());
FileChannel fileChannel = fileInputStream.getChannel();

long startOffset = assetFileDescriptor.getStartOffset();
long len = assetFileDescriptor.getLength();

return fileChannel.map(FileChannel.MapMode.READ_ONLY,startOffset,len);
}catch(Exception e){

          Toast.makeText(getApplicationContext(),
                               "This a toast message",
                               Toast.LENGTH_LONG)
                    .show();
return null;
}
}
*/
public static int argmax(float[] a) {
        float re = a[0];
        int arg = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i] > re) {
                re = a[i];
                arg = i;
            }
        }
        return arg;
    }
public static int[] classify(float[][] a){
int[] b = new int[a.length];
        for (int i = 0; i < a.length; i++) {
b[i] = argmax(a[i]);

        }
return b;

}
public void setContentJava(TextView u,String v){

}
public class EditTextHistoryDatabaseHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "edit_text_history_db";
    private static final int DB_VERSION = 1;

    private static final String TABLE_NAME = "edit_text_history";
    private static final String COL_ID = "_id";
    private static final String COL_ENTRY = "entry";

    public EditTextHistoryDatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableSql = "CREATE TABLE " + TABLE_NAME + " (" +
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_ENTRY + " TEXT NOT NULL)";
        db.execSQL(createTableSql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // not used
    }
}

@Override
public void onBackPressed() {
    // Do nothing
}


/*
public class BluetoothMouse extends BluetoothHidDevice.Callback {

    private BluetoothAdapter mAdapter = BluetoothAdapter.getDefaultAdapter();
    private BluetoothHidDevice mHidDevice;

    private static final byte[] REPORT_DESCRIPTOR = new byte[] {
            (byte) 0x05, (byte) 0x01,         // Usage Page (Generic Desktop)
            (byte) 0x09, (byte) 0x02,         // Usage (Mouse)
            (byte) 0xA1, (byte) 0x01,         // Collection (Application)
            (byte) 0x09, (byte) 0x01,         //   Usage (Pointer)
            (byte) 0xA1, (byte) 0x00,         //   Collection (Physical)
            (byte) 0x05, (byte) 0x09,         //     Usage Page (Buttons)
            (byte) 0x19, (byte) 0x01,         //     Usage Minimum (01)
            (byte) 0x29, (byte) 0x03,         //     Usage Maximum (03)
            (byte) 0x15, (byte) 0x00,         //     Logical Minimum (0)
            (byte) 0x25, (byte) 0x01,         //     Logical Maximum (1)
            (byte) 0x95, (byte) 0x03,         //     Report Count (3)
            (byte) 0x75, (byte) 0x01,         //     Report Size (1)
            (byte) 0x81, (byte) 0x02,         //     Input (Data,Var,Abs,No Wrap,Linear,Preferred State,No Null Position)
            (byte) 0x95, (byte) 0x01,         //     Report Count (1)
            (byte) 0x75, (byte) 0x05,         //     Report Size (5)
            (byte) 0x81, (byte) 0x03,         //     Input (Const,Var,Abs,No Wrap,Linear,Preferred State,No Null Position)
            (byte) 0x05, (byte) 0x01,         //     Usage Page (Generic Desktop)
            (byte) 0x09, (byte) 0x30,         //     Usage (X)
            (byte) 0x09, (byte) 0x31,         //     Usage (Y)
            (byte) 0x15, (byte) 0x81,         //     Logical Minimum (-127)
            (byte) 0x25, (byte) 0x7F,         //     Logical Maximum (127)
            (byte) 0x75, (byte) 0x08,         //     Report Size (8)
            (byte) 0x95, (byte) 0x02,         //     Report Count (2)
            (byte) 0x81, (byte) 0x06,         //     Input (Data,Var,Rel,No Wrap,Linear,Preferred State,No Null Position)
            (byte) 0xC0,                       //   End Collection
            (byte) 0xC0                        // End Collection
    };

    public void start() {
        Bundle config = new Bundle();
        config.putByteArray(BluetoothHidDevice.EXTRA_REPORT_DESCRIPTOR, REPORT_DESCRIPTOR);
        config.putInt(BluetoothHidDevice.EXTRA_PROFILE_CONNECTION_STATE, BluetoothProfile.STATE_CONNECTED);
        mHidDevice = mAdapter.getProfileProxy(context, this, BluetoothProfile.HID_DEVICE);
        mHidDevice.registerApp(config, null);
    }

    public void stop() {
        if (mHidDevice != null) {
            mHidDevice.unregisterApp();
            mAdapter.closeProfileProxy(BluetoothProfile.HID_DEVICE, mHidDevice);
            mHidDevice = null;
        }
    }

    @Override
    public void onAppStatusChanged(BluetoothDevice pluggedDevice, boolean registered) {
        if (!registered) {
            // stop the mouse device
            stop();
        }
    }

    @Override
    public void onConnectionStateChanged(BluetoothDevice device, int state) {
        if (state != BluetoothProfile.STATE_CONNECTED) {
            // stop the mouse device
            stop();
        }
    }
}
*/

    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
myctx = this;
/*
Task<Void> initializeTask = TfLite.initialize(this);
initializeTask.addOnSuccessListener(a -> {
    interpreter = InterpreterApi.create(modelBuffer,
      new InterpreterApi.Options().setRuntime(TfLiteRuntime.FROM_SYSTEM_ONLY));
  })
  .addOnFailureListener(e -> {
    Log.e("Interpreter", String.format("Cannot initialize interpreter: %s",
          e.getMessage()));
  });
*/
//55
if(!foregroundServiceRunning()) {
          Toast.makeText(getApplicationContext(),
                               "is a toast message",
                               Toast.LENGTH_LONG)
                    .show();
try {
ContextCompat.startForegroundService(this,new Intent(this, MyService.class));
} catch (Exception e) {                                        
          e.printStackTrace();      
          Toast.makeText(this, "iiii",Toast.LENGTH_LONG).show();    
                 }
}
MainActivity4Kt.setContent(binding.brutal,"1specialCharming");
/*
try{
Thread.sleep(2000);
}catch(Exception e2){}
*/
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
MainActivity4Kt.setContent(binding.brutal,"1specialCharming stunning");
}},200);
        TextView tv = binding.score;
        tv.setText(stringFromJNI());
final Markwon markwon = Markwon.create(this);
new HTTPReqTask("retrieve").execute();
mHandler = new Handler() {
public void handleMessage(Message msg) {
  switch (msg.what) {
//case 1:
    
    case 2: {
//99
      String data = (String) msg.obj;
      tv.setText((String)msg.obj);
}
    case 0: {
//99
  //    String data = (String) msg.obj;
      //tv.setText((String)msg.obj);
MainActivity4Kt.setContent(binding.brutal,(String)msg.obj);
// obtain an instance of Markwon

// set markdown
//markwon.setMarkdown(tv, (String)msg.obj);
/*
final Node node = markwon.parse((String)msg.obj);

// create styled text from parsed Node
final Spanned markdown = markwon.render(node);

// use it on a TextView
markwon.setParsedMarkdown(tv, markdown);
*/

// or a Toast
	}
	}
     }
	};
//55
        // Example of a call to a native method
//aa

try{
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if(! Settings.canDrawOverlays(this)) {
                Log.i(TAG, "[startSystemAlertWindowPermission] requesting system alert window permission.");
                startActivity(new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION, Uri.parse("package:"+getPackageName())));
            }
        }
    }catch (Exception e){
        Log.e(TAG, "[startSystemAlertWindowPermission] error:", e);
    }
		   // bluetoothactivation(getApplicationContext());
        Button bt6 = binding.addscore2;
        bt6.setOnClickListener(new View.OnClickListener(){ 
            @Override
            public void onClick(View puppet){

            	    score++;
            	    tv.setText(String.valueOf(score));
if(proxy2 != null){
try{
connectMethod.invoke(proxy2, device2);
}catch(Throwable e){
}
return;
}
		    bluetoothactivation(getApplicationContext());

               }
            });	
//aa
        Button bt = binding.addscore;
        bt.setOnClickListener(new View.OnClickListener(){ 
            @Override
            public void onClick(View puppet){

            	    score++;
            	    tv.setText(String.valueOf(score));
	String str = "hi";
/*
      Imgcodecs imageCodecs = new Imgcodecs(); 
     
      //Reading the Image from the file  
try{
        String file4 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + new StringBuilder("/ssgf3").append(".jpg").toString();
        //File file3 = new File(file2);
      Mat dest2 = imageCodecs.imread(file4);
      //Mat dest2 = imageCodecs.imread(file4,Imgcodecs.IMREAD_UNCHANGED);
//(x,y),(x2,y2)=(77,230), (1328,1481)
int x = 77;int y = 230;int x2 = 1328;int y2 =1481;
float l = (x2-x)/36;int l2 = (int)(2*l);
ArrayList<float[]> myArray = new ArrayList<float[]>();
//double[][][][][] fuck = new double[19][19][69][69][3];
float[][][][][] fuck = new float[19][19][69][69][3];
Mat m = new Mat();
for (int ii = 0;ii < 19;ii++){
for (int ii2 = 0;ii2 < 19;ii2++){
Rect roiRect = new Rect(x+(int)((ii2*2-1)*(x2-x)/36),y+(int)((ii*2-1)*(x2-x)/36),l2+1,l2+1);
Mat dest33 = new Mat(dest2,roiRect);
float[] dest3 = new float[(l2+1)*(l2+1)*3];
//dest33.get(0,0,dest3);
for (int t =0;t<69;t++){
for (int t2 =0;t2<69;t2++){
for (int t3 =0;t3<3;t3++){
fuck[ii][ii2][t][t2][t3]=(float)dest33.get(t2,t)[t3]/255;
//fuck[ii][ii2][t][t2][t3]=dest3[t3+t2*73+t*73*73];

}
}
}
//dest2.get(x+(int)(ii2*2*l-l),y+(int)(ii*2*l-l),dest3);
//myArray.add(dest3);
m.push_back(dest33);
}

}
//Mat m2 = m.reshape(0,73*19);
float[][][][] fuck2 = new float[1][69][69][3];
fuck2[0] = fuck[0][0];
//float[] output = new float[3];
float[][] output = new float[19][3];
//float[][] output = new float[1][3];
//Map<Integer, Object> outputs = new HashMap<>();
            Map<String, Object> outputs = new HashMap<>();

interpreter = new Interpreter(loadModelFile());
Map<String, Object> inputs = new HashMap<>();
            inputs.put("conv2d_input", fuck2);

            //outputs.put(0, output);
            //outputs.put("dense_1", output);

            //interpreter.runSignature(inputs, outputs, "serving_default");
//interpreter = new Interpreter(loadModelFile(),null);
//interpreter.run(fuck2, output);
//interpreter.run(fuck[0][0], output);
//interpreter.runForMultipleInputsOutputs(fuck[0][0], outputs);
//interpreter.runForMultipleInputsOutputs(fuck, outputs);
//interpreter.runForMultipleInputsOutputs(fuck2, outputs);
//interpreter.runForMultipleInputsOutputs(fuck[0], outputs);
//interpreter.runForMultipleInputsOutputs(fuck[0], output);
interpreter.run(fuck[9], output);
//interpreter.run(myArray.toArray(new <float[][][]>[0])[0], output);
//interpreter.run(myArray.toArray(new float[19][19][73][73][3])[0], output);
            	    //tv.setText( Float.toString(((float[])outputs.get("dense_1"))[0]));
            	    tv.setText( Float.toString(output[0][0])+
                            " "+Float.toString(output[0][1])+" "+Float.toString(output[0][2]));
tv.setText(Arrays.toString(classify(output)));
        String file2 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + new StringBuilder("qwer").append(".png").toString();
      imageCodecs.imwrite(file2,m);
}catch(Throwable e){
          Toast.makeText(getApplicationContext(),
                               e.getMessage(),
                               Toast.LENGTH_LONG)
                    .show();
}
*/

String entry2 = binding.edittext.getText().toString();
if(entry2.equals("battery2")){
try{
//the next line is neccessary,comment out for debug
	mConnectedThread.write(entry2.getBytes("UTF-8"));
                   Log.d(TAG, "wtuih write" + entry2);
	//mConnectedThread2.write("seine".getBytes("UTF-8"));
return;
        } catch (Exception e) {
            e.printStackTrace();
        }
}
Thread thread = new Thread(new Runnable() {

    @Override
    public void run() {
        try  {
if ( false){
               Message writtenMsg = mHandler.obtainMessage(
                       0, -1, -1, "hell");
               writtenMsg.sendToTarget();
       mConnectedThread2 = new ConnectedThread2(MyService.socket4);
       mConnectedThread2.start();
}else{
String entry = binding.edittext.getText().toString();
if(binding.toggle.isChecked()){
int inputNumber = Integer.parseInt(binding.bounty.getText().toString());
if(entry.equals("file2")){
Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT_TREE);
/*
Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
intent.addCategory(Intent.CATEGORY_OPENABLE);
    intent.setType("video/mp4");
*/
Log.d("20231014","1");
startActivityForResult(intent, inputNumber);
return;

}
if(entry.equals("device2")){
deviceIndex = inputNumber;
tv.setText(myAllDevices.get(deviceIndex).get("name"));
SharedPreferences.Editor editor = getSharedPreferences("myprefs",getApplicationContext().MODE_PRIVATE).edit();
editor.putString("deviceAddress2", myAllDevices.get(deviceIndex).get("address"));
editor.commit();
return;
}
if(entry.equals("wtuih")){
MyService.socketsIndex = inputNumber;

}
try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("entry", entry);
            jsonObject.put("inputNumber", inputNumber);
int x = 50;int y = 300;
            jsonObject.put("x", x);
            jsonObject.put("y", y);

            String jsonString = jsonObject.toString();
            Log.d("JSON String", jsonString);
	MyService.mConnectedThread2.write(jsonString.getBytes("UTF-8"),2);
            
        } catch (JSONException e) {
            e.printStackTrace();
        }

return;
}
if(entry.equals("mouse2")){

try {
            JSONObject jsonObject = new JSONObject();
//            jsonObject.put("entry", entry);
  //          jsonObject.put("inputNumber", inputNumber);
int x = 50;int y = 300;
            jsonObject.put("x", x);
            jsonObject.put("y", y);

            String jsonString = jsonObject.toString();
            Log.d("JSON String", jsonString);
	MyService.blConnectedThread.write(jsonString.getBytes("UTF-8"),4);
            
        } catch (JSONException e) {
            e.printStackTrace();
        }
return;
}
if(entry.equals("respawn2")){
        Intent intent = new Intent(MyService.SOCKET_DATA_RECEIVED);
        intent.putExtra(MyService.SOCKET_DATA_IDENTIFIER, "mmBuffer2"); // store data in your intent
        intent.putExtra("indicator", 17); // store data in your intent
        // send data to registered receivers
        LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);
return;
}
if(entry.equals("copy2")){
Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT_TREE);
/*
Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
intent.addCategory(Intent.CATEGORY_OPENABLE);
    intent.setType("video/mp4");
*/
Log.d("20231014","1");
startActivityForResult(intent, 15);
return;

}
if(entry.equals("unmute2")){
MyService.goMode = false;

}
if(entry.equals("mute2")){
MyService.goMode = true;

}
if(entry.equals("remote2")){
int inputNumber = Integer.parseInt(binding.bounty.getText().toString());
MyService.socketsIndex = inputNumber;

}
if(entry.equals("wtuih2")){
        EditTextHistoryDatabaseHelper dbHelper = new EditTextHistoryDatabaseHelper(MainActivity.this);
        // retrieve all entries from the database
        SQLiteDatabase readDb = dbHelper.getReadableDatabase();
        Cursor cursor = readDb.query(EditTextHistoryDatabaseHelper.TABLE_NAME,
                new String[]{EditTextHistoryDatabaseHelper.COL_ENTRY},
                null,
                null,
                null,
                null,
                EditTextHistoryDatabaseHelper.COL_ID + " DESC");

        // create a StringBuilder object to hold the text to display in the TextView
        StringBuilder stringBuilder = new StringBuilder();

        // loop through the cursor and append each text to the StringBuilder
        while (cursor.moveToNext()) {
            String historyText = cursor.getString(cursor.getColumnIndexOrThrow(EditTextHistoryDatabaseHelper.COL_ENTRY));
            stringBuilder.append(historyText).append("<br>");
        }

        // close the cursor and database connection
        cursor.close();
        readDb.close();

        // set the text of the TextView to the contents of the StringBuilder
MainActivity4Kt.setContent(binding.brutal,"1"+stringBuilder.toString());

return;
}
	MyService.mConnectedThread2.write(binding.edittext.getText().toString().getBytes("UTF-8"));
if(entry.equals("wtuih")){return;}
            //editTextHistory.add(entry);
            //editText.setText("");

            // save the history to the database
            EditTextHistoryDatabaseHelper dbHelper = new EditTextHistoryDatabaseHelper(MainActivity.this);
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(EditTextHistoryDatabaseHelper.COL_ENTRY, entry);
            db.insert(EditTextHistoryDatabaseHelper.TABLE_NAME, null, values);
            db.close();

}
//MyService.socket4.getOutputStream().write("seine".getBytes("UTF-8")); // or UTF-8 or any other applicable encoding...
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
});

thread.start();
//new HTTPReqTask("accumulate").execute();
               }

            });	
        Button bt5 = binding.bluetooth4;
        bt5.setOnClickListener(new View.OnClickListener(){ 
            @Override
            public void onClick(View puppet){
            	    tv.setText(hint);
          Toast.makeText(getApplicationContext(),
                               "This a toast message",
                               Toast.LENGTH_LONG)
                    .show();
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Do you want to exit ?");
        builder.create().show();

/*
//sudo("echo \"1\" > /sys/class/power_supply/battery/input_suspend");
IntentFilter ifilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
Intent batteryStatus = registerReceiver(null, ifilter);

int level = batteryStatus.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
int scale = batteryStatus.getIntExtra(BatteryManager.EXTRA_SCALE, -1);

float batteryPct = level / (float)scale;

//return (int)(batteryPct*100);
          Toast.makeText(getApplicationContext(), String.valueOf(batteryPct),Toast.LENGTH_LONG).show();

Intent gameActivity = new Intent(MainActivity.this, MainActivity4.class);
startActivity(gameActivity);
*/
final BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
//BluetoothHidDevice mBluetoothHidDevice =
//        new BluetoothHidDevice();
BluetoothHidDevice mBluetoothHidDevice;

HidUtils.registerApp(myctx);
        //HidConsts.reporters(myctx);


	    }
	});
        Button bt4 = binding.bluetooth3;
        bt4.setOnClickListener(new View.OnClickListener(){ 
            @Override
            public void onClick(View puppet){
        if(MyService.socketDataReceiver == null){
          Toast.makeText(myctx, "socketDataReceiver null",Toast.LENGTH_LONG).show();
return;
}
        //String deviceAddress = myAllDevices.get(deviceIndex).get("address");
SharedPreferences sharedPreferences = getSharedPreferences("myprefs",Context.MODE_PRIVATE);
        String deviceAddress = sharedPreferences.getString("deviceAddress2", "");
BluetoothAdapter btAdapter = BluetoothAdapter.getDefaultAdapter();
        if(!btAdapter.isEnabled())
            btAdapter.enable();

        Set<BluetoothDevice> pairedDevices = btAdapter.getBondedDevices();

        for(BluetoothDevice d : pairedDevices)
            if(d.getAddress().equalsIgnoreCase(deviceAddress))
                pairedDevice1 = d;
              ConnectThread cclient = new ConnectThread(pairedDevice1);
              cclient.run();
/*
Thread thread = new Thread(new Runnable() {

    @Override
    public void run() {
        try  {
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
});

thread.start();
*/
Thread thread = new Thread(new Runnable() {

    @Override
    public void run() {
        try  {
   //         Socket socket = new Socket("202.5.19.254",32007);
//MyService.socket4 = socket;
/*
            DataOutputStream DOS = new 
            DataOutputStream(socket.getOutputStream());
            DOS.writeUTF("seine");
*/
/*
OutputStreamWriter osw =new OutputStreamWriter(socket.getOutputStream(), "UTF-8");
        osw.write("seine", 0, "seine".length());
*/
//20231009
/*
       mConnectedThread2 = new ConnectedThread2(MyService.socket4);
       mConnectedThread2.start();
//	mConnectedThread2.write("seine".getBytes("UTF-8"));
*/
//socket.getOutputStream().write("your string".getBytes("UTF-8")); // or UTF-8 or any other applicable encoding...
/*
byte[] bytesarray = new byte[1024];
int num = socket.getInputStream().read(bytesarray);
tv.setText(new String(bytesarray,0,num);
*/
//            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
});

thread.start();
	    }
	});
        Button bt3 = binding.bluetooth2;
        bt3.setOnClickListener(new View.OnClickListener(){ 
            @Override
            public void onClick(View puppet){
        if(MyService.socketDataReceiver == null){
          Toast.makeText(myctx, "socketDataReceiver null",Toast.LENGTH_LONG).show();
return;
}
              AcceptThread sserver = new AcceptThread();
              sserver.start();
	    }
	});
        Button bt2 = binding.bluetooth;
        bt2.setOnClickListener(new View.OnClickListener(){ 
            @Override
            public void onClick(View puppet){

            	    score--;
            	    tv.setText(String.valueOf(score));
		    BluetoothManager bluetoothManager = getSystemService(BluetoothManager.class);
		    BluetoothAdapter bluetoothAdapter = bluetoothManager.getAdapter();
		    if (bluetoothAdapter == null) {
			      // Device doesn't support Bluetooth
			       }
		    if (!bluetoothAdapter.isEnabled()) {
			      Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
			        startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
		    }
		    Set<BluetoothDevice> pairedDevices = bluetoothAdapter.getBondedDevices();

		    if (pairedDevices.size() > 0) {
			       // There are paired devices. Get the name and address of each paired device.
			           for (BluetoothDevice device : pairedDevices) {
					device2 = device;
                                          pairedDevice1 = device;
			                  String deviceName = device.getName();
			                         String deviceAddress = device.getAddress(); // MAC address
// Add strings to the list
//myAllDevices.add(deviceAddress);
// Create a map for each device and add it to the list
Map<String, String> phone = new HashMap<>();
phone.put("name", deviceName);
phone.put("address", deviceAddress);
myAllDevices.add(phone);
SharedPreferences.Editor editor = getSharedPreferences("myprefs",getApplicationContext().MODE_PRIVATE).edit();
editor.putString("deviceAddress", deviceAddress);
editor.commit();

            	    tv.setText(deviceName);
			                            }
			                            }
               }

            });	
    }
//77
   private class ConnectedThread2 extends Thread {
       private final Socket mmSocket;
       private final InputStream mmInStream;
       private final OutputStream mmOutStream;
       private byte[] mmBuffer; // mmBuffer store for the stream

	//44
       public ConnectedThread2(Socket socket) {
           mmSocket = socket;
           InputStream tmpIn = null;
           OutputStream tmpOut = null;

           // Get the input and output streams; using temp objects because
           // member streams are final.
           try {
socket.setReceiveBufferSize(1024*1024);
               tmpIn =new BufferedInputStream(socket.getInputStream());
           } catch (IOException e) {
               Log.e(TAG, "Error occurred when creating input stream", e);
           }
           try {
               tmpOut = socket.getOutputStream();
           } catch (IOException e) {
               Log.e(TAG, "Error occurred when creating output stream", e);
           }

           mmInStream = tmpIn;
           mmOutStream = tmpOut;
       }

       public void run() {
           mmBuffer = new byte[10240];
           int numBytes; // bytes returned from read()

           // Keep listening to the InputStream until an exception occurs.
           while (true) {
               try {
                   // Read from the InputStream.
                   numBytes = mmInStream.read(mmBuffer);
		   String mmBuffer2 = new String(mmBuffer,0,numBytes);
                   // Send the obtained bytes to the UI activity.
                   Message readMsg = mHandler.obtainMessage(
                           MessageConstants.MESSAGE_READ, numBytes, -1,
                           mmBuffer2);
                   readMsg.sendToTarget();
               } catch (IOException e) {
                   Log.d(TAG, "Input stream was disconnected", e);
                   Message readMsg2 = mHandler.obtainMessage(
                           MessageConstants.MESSAGE_READ, -1, -1,
                           "mmBuffer2");
                   readMsg2.sendToTarget();
                   break;
               }
           }
       }

       // Call this from the main activity to send data to the remote device.
       public synchronized void write(byte[] bytes) {
           try {
               mmOutStream.write(bytes);

               // Share the sent message with the UI activity.
               Message writtenMsg = mHandler.obtainMessage(
                       MessageConstants.MESSAGE_WRITE, -1, -1, new String(bytes));
               writtenMsg.sendToTarget();
           } catch (IOException e) {
               Log.e(TAG, "Error occurred when sending data", e);

               // Send a failure message back to the activity.
               Message writeErrorMsg =
                       mHandler.obtainMessage(MessageConstants.MESSAGE_TOAST);
               Bundle bundle = new Bundle();
               bundle.putString("toast",
                       "Couldn't send data to the other device");
               writeErrorMsg.setData(bundle);
               mHandler.sendMessage(writeErrorMsg);
           }
       }

       // Call this method from the main activity to shut down the connection.
       public void cancel() {
           try {
               mmSocket.close();
           } catch (IOException e) {
               Log.e(TAG, "Could not close the connect socket", e);
           }
       }
   }
   private class ConnectedThread extends Thread {
       private final BluetoothSocket mmSocket;
       private final InputStream mmInStream;
       private final OutputStream mmOutStream;
       private byte[] mmBuffer; // mmBuffer store for the stream

	//44
       public ConnectedThread(BluetoothSocket socket) {
           mmSocket = socket;
           InputStream tmpIn = null;
           OutputStream tmpOut = null;

           // Get the input and output streams; using temp objects because
           // member streams are final.
           try {
               tmpIn = socket.getInputStream();
           } catch (IOException e) {
               Log.e(TAG, "Error occurred when creating input stream", e);
           }
           try {
               tmpOut = socket.getOutputStream();
           } catch (IOException e) {
               Log.e(TAG, "Error occurred when creating output stream", e);
           }

           mmInStream = tmpIn;
           mmOutStream = tmpOut;
       }

       public void run() {
           mmBuffer = new byte[1024];
           int numBytes; // bytes returned from read()

           // Keep listening to the InputStream until an exception occurs.
           while (true) {
               try {
                   // Read from the InputStream.
Log.d(TAG,"wtuih 1connectedthread get inputstream ");
                   numBytes = mmInStream.read(mmBuffer);
Log.d(TAG,"2wtuih connectedthread get inputstream ");
		   String mmBuffer2 = new String(mmBuffer,0,numBytes);
                   // Send the obtained bytes to the UI activity.
if (mmBuffer2.equals("battery2")){
                   Log.d(TAG, "if true");
write(MyService.battery2.getBytes());
continue;
}
                   Log.d(TAG, "wtuih battery"+mmBuffer2);
                   Message readMsg = mHandler.obtainMessage(
                           2, numBytes, -1,
                           mmBuffer2);
                   readMsg.sendToTarget();
               } catch (Throwable e) {
Log.d(TAG,"3wtuih connectedthread get inputstream ");
                   Log.d(TAG, "wtuih Input stream was disconnected", e);
                   break;
               }
           }
       }

       // Call this from the main activity to send data to the remote device.
       public void write(byte[] bytes) {
           try {
               mmOutStream.write(bytes);

               // Share the sent message with the UI activity.
               Message writtenMsg = mHandler.obtainMessage(
                       MessageConstants.MESSAGE_WRITE, -1, -1, new String(bytes));
               writtenMsg.sendToTarget();
           } catch (IOException e) {
               Log.e(TAG, "Error occurred when sending data", e);

               // Send a failure message back to the activity.
               Message writeErrorMsg =
                       mHandler.obtainMessage(MessageConstants.MESSAGE_TOAST);
               Bundle bundle = new Bundle();
               bundle.putString("toast",
                       "Couldn't send data to the other device");
               writeErrorMsg.setData(bundle);
               mHandler.sendMessage(writeErrorMsg);
           }
       }

       // Call this method from the main activity to shut down the connection.
       public void cancel() {
           try {
               mmSocket.close();
           } catch (IOException e) {
               Log.e(TAG, "Could not close the connect socket", e);
           }
       }
   }
//77
@Override
public void onActivityResult(int requestCode, int resultCode,
        Intent resultData) {
    if (requestCode > 10
            && resultCode == RESULT_OK) {
        // The result data contains a URI for the document or directory that
        // the user selected.
        Uri uri = null;
        if (resultData != null) {
            MyService.uri = resultData.getData();
            // Perform operations on the document using its URI.
        Intent intent = new Intent(MyService.SOCKET_DATA_RECEIVED);
        intent.putExtra(MyService.SOCKET_DATA_IDENTIFIER, "mmBuffer2"); // store data in your intent
        intent.putExtra("indicator", requestCode); // store data in your intent
        // send data to registered receivers
        LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);
        }
    }
}


    @Override
    protected void onResume() {
        super.onResume();
        //binding = ActivityMainBinding.inflate(getLayoutInflater());
//MainActivity4Kt.setContent(binding.brutal,globalMsg);

        socketDataReceiver = new SocketDataReceiver();
        LocalBroadcastManager.getInstance(this).registerReceiver(
                socketDataReceiver, new IntentFilter(MyService.SOCKET_DATA_RECEIVED));


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
           this.setTaskDescription(
               new ActivityManager.TaskDescription(
                   "KEY_STATE_PRESSED2"  //or null for default title
           ) ); 
       }
    
    }
    /**
     * A native method that is implemented by the 'myapplication_' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
    @Override
    protected void onPause() {
        super.onPause();
}
@Override
public void onSaveInstanceState(Bundle savedInstanceState) {
  super.onSaveInstanceState(savedInstanceState);
  // Save UI state changes to the savedInstanceState.
  // This bundle will be passed to onCreate if the process is
  // killed and restarted.
  savedInstanceState.putBoolean("MyBoolean", true);
  savedInstanceState.putDouble("myDouble", 1.9);
  savedInstanceState.putInt("MyInt", 1);
  savedInstanceState.putString("MyString", globalMsg);
  // etc.
}
@Override
public void onRestoreInstanceState(Bundle savedInstanceState) {
  super.onRestoreInstanceState(savedInstanceState);
  // Restore UI state from the savedInstanceState.
  // This bundle has also been passed to onCreate.
  boolean myBoolean = savedInstanceState.getBoolean("MyBoolean");
  double myDouble = savedInstanceState.getDouble("myDouble");
  int myInt = savedInstanceState.getInt("MyInt");
  globalMsg = savedInstanceState.getString("MyString");
}
}

//66
/*public class MyBluetoothService {
   private static final String TAG = "MY_APP_DEBUG_TAG";
   private Handler handler; // handler that gets info from Bluetooth service

   // Defines several constants used when transmitting messages between the
   // service and the UI.

}*/
//66
//77
