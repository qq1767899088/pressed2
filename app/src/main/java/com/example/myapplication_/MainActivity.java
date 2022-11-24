package com.example.myapplication_;
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

	
Method mBTPanConnect = null;
BluetoothDevice device2;
Class<?> noparams[] = {};
Object instance = null;
    Method setTetheringOn = null;
    Method isTetheringOn = null;
    Object mutex = new Object();
   private Handler mHandler;
   private ConnectedThread mConnectedThread;
   private interface MessageConstants {
       public static final int MESSAGE_READ = 0;
       public static final int MESSAGE_WRITE = 1;
       public static final int MESSAGE_TOAST = 2;

       // ... (Add other message types here as needed.)
   }
     String hint = "00";
         private static final String TAG = "MyActivity";
//22
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
            //Some code must be here or the compiler will optimize away this callback.
try {
            Method connectMethod = proxy.getClass().getDeclaredMethod("connect", BluetoothDevice.class);
            if(!((Boolean) connectMethod.invoke(proxy, device2))){
                Log.e("MyApp", "Unable to start connection");
            }
        } catch (Exception e) {
            Log.e("MyApp", "Unable to reflect android.bluetooth.BluetoothPan", e);
        }

try {
hint = " nowval";
            boolean nowVal = ((Boolean) proxy.getClass().getMethod("isTetheringOn", new Class[0]).invoke(proxy, new Object[0])).booleanValue();
            if (nowVal) {
hint = " nowval1";
                proxy.getClass().getMethod("setBluetoothTethering", new Class[]{Boolean.TYPE}).invoke(proxy, new Object[]{Boolean.valueOf(false)});

hint = " nowval11";
            } else {
hint = " nowval2";
                proxy.getClass().getMethod("setBluetoothTethering", new Class[]{Boolean.TYPE}).invoke(proxy, new Object[]{Boolean.valueOf(true)});
hint = " nowval22";
            }
}
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
       } catch (IOException connectException) {
           // Unable to connect; close the socket and return.
           try {
               mmSocket.close();
           } catch (IOException closeException) {
               Log.e(TAG, "Could not close the client socket", closeException);
           }
           return;
       }

       // The connection attempt succeeded. Perform work associated with
       // the connection in a separate thread.
	//33
       mConnectedThread = new ConnectedThread(mmSocket);
       mConnectedThread.start();
       //manageMyConnectedSocket(mmSocket);
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
       mConnectedThread = new ConnectedThread(socket);
       mConnectedThread.start();
           //    manageMyConnectedSocket(socket);
       hint = "4";
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
//44
   private BluetoothDevice pairedDevice1;
	private final static int REQUEST_ENABLE_BT = 1;
    int score = 0;
    // Used to load the 'myapplication_' library on application startup.
    static {
        System.loadLibrary("myapplication_");
    }

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
//55
        TextView tv = binding.score;
        tv.setText(stringFromJNI());
new HTTPReqTask("retrieve").execute();
mHandler = new Handler() {
public void handleMessage(Message msg) {
  switch (msg.what) {
    case 0: {
//99
  //    String data = (String) msg.obj;
      tv.setText((String)msg.obj);
	}
	}
     }
	};
//55
        // Example of a call to a native method
//aa
        Button bt6 = binding.addscore2;
        bt6.setOnClickListener(new View.OnClickListener(){ 
            @Override
            public void onClick(View puppet){

            	    score++;
            	    tv.setText(String.valueOf(score));
String sClassName = "android.bluetooth.BluetoothPan";
Class<?> classBluetoothPan = null;

        try {

            classBluetoothPan = Class.forName(sClassName);

mBTPanConnect = classBluetoothPan.getDeclaredMethod("connect", BluetoothDevice.class);
            Constructor<?> ctor = classBluetoothPan.getDeclaredConstructor(Context.class, BluetoothProfile.ServiceListener.class);
            ctor.setAccessible(true);
            //  Set Tethering ON
            Class[] paramSet = new Class[1];
            paramSet[0] = boolean.class;

            synchronized (mutex) {
                setTetheringOn = classBluetoothPan.getDeclaredMethod("setBluetoothTethering", paramSet);
                isTetheringOn = classBluetoothPan.getDeclaredMethod("isTetheringOn", noparams);
                instance = ctor.newInstance(getApplicationContext(), new BTPanServiceListener(getApplicationContext()));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
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
//	mConnectedThread.write(str.getBytes());
new HTTPReqTask("accumulate").execute();
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
	    }
	});
        Button bt4 = binding.bluetooth3;
        bt4.setOnClickListener(new View.OnClickListener(){ 
            @Override
            public void onClick(View puppet){
              ConnectThread cclient = new ConnectThread(pairedDevice1);
              cclient.run();
	    }
	});
        Button bt3 = binding.bluetooth2;
        bt3.setOnClickListener(new View.OnClickListener(){ 
            @Override
            public void onClick(View puppet){
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
			                         String deviceHardwareAddress = device.getAddress(); // MAC address

            	    tv.setText(deviceName);
			                            }
			                            }
               }

            });	
    }
//77
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
                   numBytes = mmInStream.read(mmBuffer);
		   String mmBuffer2 = new String(mmBuffer,0,numBytes);
                   // Send the obtained bytes to the UI activity.
                   Message readMsg = mHandler.obtainMessage(
                           MessageConstants.MESSAGE_READ, numBytes, -1,
                           mmBuffer2);
                   readMsg.sendToTarget();
               } catch (IOException e) {
                   Log.d(TAG, "Input stream was disconnected", e);
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
                       MessageConstants.MESSAGE_WRITE, -1, -1, mmBuffer);
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
    protected void onResume() {
        super.onResume();
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
