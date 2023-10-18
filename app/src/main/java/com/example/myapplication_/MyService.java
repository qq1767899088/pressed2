package com.example.myapplication_;
import java.io.FileDescriptor;
//import com.googlecode.tesseract.android.TessBaseAPI;
import android.graphics.BitmapFactory;
import androidx.documentfile.provider.DocumentFile;
import android.os.ParcelFileDescriptor;
import android.content.ContentResolver;
import android.bluetooth.BluetoothSocket;
import java.util.concurrent.ScheduledFuture;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONException;
import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHidDevice;
import android.bluetooth.BluetoothHidDeviceAppSdpSettings;
import android.bluetooth.BluetoothProfile;

import java.util.concurrent.Executors;

import org.json.JSONObject;
import android.content.SharedPreferences;
import java.io.BufferedOutputStream;
import java.io.BufferedInputStream;
import android.widget.CheckBox;
import android.content.DialogInterface;
import android.app.AlertDialog;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import org.opencv.imgproc.Imgproc;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.lang.Float;
import org.opencv.imgcodecs.Imgcodecs;
import java.util.ArrayList;
import org.opencv.core.CvType;
import org.opencv.core.Rect;
import java.io.StringWriter;
import java.io.PrintWriter;
import org.opencv.core.Core; 
import org.opencv.core.Mat;  
import org.opencv.imgcodecs.Imgcodecs;
import android.content.res.AssetFileDescriptor;
import org.tensorflow.lite.Interpreter;
import java.io.FileInputStream;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import android.hardware.display.VirtualDisplay;
import android.media.projection.MediaProjection;
import android.util.SparseIntArray;
import android.media.projection.MediaProjectionManager;
import java.io.FileOutputStream;
import android.graphics.Bitmap;
import java.util.Date;
import android.graphics.ImageFormat;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import android.media.ImageReader;
import android.media.Image;
import java.util.Random;
import 	java.io.File;
import android.hardware.display.DisplayManager;
import java.io.IOException;
import androidx.core.app.ActivityCompat;
import android.os.Environment;
import java.util.List;
import 	android.app.Activity;
import android.media.projection.MediaProjectionManager;
import java.io.FileOutputStream;
import android.graphics.Bitmap;
import java.util.Date;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.os.Build;
import android.os.IBinder;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.widget.TextView;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.widget.LinearLayout;
import android.view.Gravity;
import android.view.WindowManager;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.concurrent.TimeUnit;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import java.net.Socket;
import android.os.Build;
import android.app.Notification;
import androidx.core.app.NotificationCompat;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.net.Uri;
import android.os.Environment;
import 	java.io.File;
import android.media.MediaPlayer;
import 	android.os.PowerManager;
import android.os.Handler;
import android.os.Looper;
import android.os.IBinder;
import android.util.Log;
import android.app.Service;
import android.os.BatteryManager;
import 	android.content.IntentFilter;
import android.app.AlertDialog;
import android.widget.Toast;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.Context;
public class MyService extends Service {

    public static volatile String ip3 = "66.103.221.156";
    public static volatile String ip2 = "23.95.61.29";
    public static volatile Bitmap image2;
public static volatile Uri uri;
public static volatile BluetoothSocket blSocket;
public static volatile boolean goMode = false;
public static volatile boolean sending = false;
public static volatile ScheduledFuture<?> scheduledFuture;

public static volatile boolean started = false;
    public static volatile int mySide = 0xFF000000;
public static volatile boolean myTurn = true;
public static volatile boolean _connected = false;
    public static int socketsIndex = 0;
         private static final String TAG = "myserviceTag";
static BluetoothProfile bluetoothProfile;
    public static volatile BluetoothDevice mDevice;
    public static volatile BluetoothHidDevice mHidDevice;

public static byte[] Descriptor = new byte[] {
        (byte) 0x05, (byte) 0x01, (byte) 0x09, (byte) 0x02, (byte) 0xa1, (byte) 0x01, (byte) 0x09, (byte) 0x01,
        (byte) 0xa1, (byte) 0x00, (byte) 0x85, (byte) 0x01, (byte) 0x05, (byte) 0x09, (byte) 0x19, (byte) 0x01,
        (byte) 0x29, (byte) 0x03, (byte) 0x15, (byte) 0x00, (byte) 0x25, (byte) 0x01, (byte) 0x95, (byte) 0x03,
        (byte) 0x75, (byte) 0x01, (byte) 0x81, (byte) 0x02, (byte) 0x95, (byte) 0x01, (byte) 0x75, (byte) 0x05,
        (byte) 0x81, (byte) 0x03, (byte) 0x05, (byte) 0x01, (byte) 0x09, (byte) 0x30, (byte) 0x09, (byte) 0x31,
        (byte) 0x09, (byte) 0x38, (byte) 0x16,(byte) 0x01, (byte) 0x80, (byte) 0x26, (byte) 0xff, (byte) 0x7f, (byte) 0x75, (byte) 0x10,
        (byte) 0x95, (byte) 0x03, (byte) 0x81, (byte) 0x06, (byte) 0xc0, (byte) 0xc0, (byte) 0x05, (byte) 0x01,
        (byte) 0x09, (byte) 0x06, (byte) 0xa1, (byte) 0x01, (byte) 0x85, (byte) 0x02, (byte) 0x05, (byte) 0x07,
        (byte) 0x19, (byte) 0xE0, (byte) 0x29, (byte) 0xE7, (byte) 0x15, (byte) 0x00, (byte) 0x25, (byte) 0x01,
        (byte) 0x75, (byte) 0x01, (byte) 0x95, (byte) 0x08, (byte) 0x81, (byte) 0x02, (byte) 0x95, (byte) 0x01,
        (byte) 0x75, (byte) 0x08, (byte) 0x15, (byte) 0x00, (byte) 0x25, (byte) 0x65, (byte) 0x19, (byte) 0x00,
        (byte) 0x29, (byte) 0x65, (byte) 0x81, (byte) 0x00, (byte) 0x05, (byte) 0x08, (byte) 0x95, (byte) 0x05,
        (byte) 0x75, (byte) 0x01, (byte) 0x19, (byte) 0x01, (byte) 0x29, (byte) 0x05, (byte) 0x91, (byte) 0x02,
        (byte) 0x95, (byte) 0x01, (byte) 0x75, (byte) 0x03, (byte) 0x91, (byte) 0x03, (byte) 0xc0
    };
    public static volatile String battery2 = "battery not updated yet" ;
    public static volatile Boolean meta = false ;
    public static volatile String connectstate ="solife==woman?";
    public static volatile String heartbeat2 ="pussy";
SharedPreferences sharedPreferences;
SharedPreferences.Editor editor;
private static final Object lock = new Object();
Button bt5;
Boolean isWhite = true;
static String[] colors ={"w"," ","b"};
TextView myTextView;
CheckBox modifier;
public static SocketDataReceiver socketDataReceiver;
Interpreter interpreter;
    public static volatile Socket sc;
    public static volatile String ge ="oh";
    public static Bitmap bitmap0;
  public static volatile ImageReader mImageReader;
    private static final int videoTime = 5000;
    private static final int REQUEST_CODE = 1000;
    private static final int REQUEST_PERMISSION = 1000;
    private static final SparseIntArray ORIENTATION = new SparseIntArray();
    private MediaProjectionManager mediaProjectionManager;
    public MediaProjection mediaProjection;
    private VirtualDisplay virtualDisplay;
    public static int mScreenDensity;
    public static int DISPLAY_WIDTH = 720;
    public static int DISPLAY_HEIGHT = 1280;
public static Intent data0 = null;  //declaration
public static Context myctx;
    public static final String SOCKET_DATA_RECEIVED = "com.your.package.SOCKET_DATA_RECEIVED";
    public static final String SOCKET_DATA_IDENTIFIER = "com.your.package.SOCKET_DATA";
   public static ConnectedThread blConnectedThread;
   public static ConnectedThread2 mConnectedThread2;
   public static ConnectedThread2 mConnectedThread3;
public static Socket socket4;
    //private String TAG = this.getClass().getSimpleName();
            IntentFilter filter1=new IntentFilter();
int isSuspended;
PowerManager.WakeLock wakeLock;
private static final int TIME_DELAY = 4000;
private static long lastToastShowTime = 0;
private static long lastPlayTime = 0;
TimeoutChecker checker ;
    volatile long lastMessageTimestamp;
volatile int isConnecting = 0;
volatile int globalI = 0;

 class TimeoutChecker implements Runnable {

    // timeout is set to 10 seconds
    final long    timeout = TimeUnit.SECONDS.toMillis(20);
    // note the use of volatile to make sure the update to this variable thread-safe
Context ctx;

    public TimeoutChecker(Context ctx) {
   //     this.lastMessageTimestamp = ts;
this.ctx = ctx
;
    }

//118
    @Override
    public void run() {
if (!goMode){
/*
String eMsg= "noToasError";
               try{
 Toast.makeText(myctx,"your   message",Toast.LENGTH_LONG).show();
               }catch(Exception e){
                  Log.e("TOAST_NOT_SHOWED", "Toast not showed: " + "msg", e);
eMsg = e.getMessage();
               }
        Intent intent = new Intent(SOCKET_DATA_RECEIVED);
        intent.putExtra(SOCKET_DATA_IDENTIFIER, "idleCheck"+eMsg); // store data in your intent
       // intent.putExtra(SOCKET_DATA_IDENTIFIER, Integer.toString(numBytes)); // store data in your intent
        // send data to registered receivers
        LocalBroadcastManager.getInstance(myctx).sendBroadcast(intent);
*/
        if (isConnecting != 1 && (System.currentTimeMillis() - lastMessageTimestamp) > timeout) {
            System.out.println("timeout!");
//118
Thread thread = new Thread(new Runnable() {        
 @Override                                  
public void run() {
isConnecting = 1;
           byte[] mmBuffer = new byte[1024];
           int numBytes = 0; // bytes returned from read()
while(true){
        try  { 
	globalI++;
        //Intent intent = new Intent(SOCKET_DATA_RECEIVED);
        //intent.putExtra(SOCKET_DATA_IDENTIFIER, "2connecting"+Integer.toString(globalI)); // store data in your intent
        connectstate = "2connecting"+Integer.toString(globalI);
       // intent.putExtra(SOCKET_DATA_IDENTIFIER, Integer.toString(numBytes)); // store data in your intent
        // send data to registered receivers
        //LocalBroadcastManager.getInstance(myctx).sendBroadcast(intent);
//socket4.close();
try{
if(socket4 != null){
socket4.close();
}
}catch(Throwable t){
                   Log.e(TAG, "socket4.close throwable", t);
}
socket4 = null;
socket4 = new Socket(ip2,32007);
socket4.setKeepAlive(true);
/*
while(!socket4.isConnected()){
Log.d(TAG, "socket4 not connected");
Thread.sleep(200);
}
*/
//socket4.getOutputStream().write("isConnected".getBytes("UTF-8"));
InputStream mmInStream =socket4.getInputStream();
//if(mmInStream.read(mmBuffer,0,4)==-1){
Thread.sleep(2000);
try{
if(mmInStream.read(mmBuffer,0,4)==-1){
Thread.sleep(20000);
continue;
}
        } catch (Exception ee) {                                
                  ee.printStackTrace();
                                                                        }
//}
mmInStream.read(mmBuffer,0,4);
int k = ByteBuffer.wrap(mmBuffer).order(ByteOrder.BIG_ENDIAN).getInt();
/*
     while (k > 0) {
numBytes = mmInStream.read(mmBuffer);
k = k - numBytes;
      }
*/
int length = k; // read the length of the message
byte[] message = new byte[length];
int bytesRead = 0;

while (bytesRead < length) {
     numBytes = mmInStream.read(message, bytesRead, length - bytesRead);
    if (numBytes == -1) {
        // end of stream reached before entire message could be read
        break;
    }
    bytesRead += numBytes;
}

//socket4.setSoTimeout(2000);
       mConnectedThread2 = new ConnectedThread2(MyService.socket4);
       mConnectedThread2.start();
        connectstate = "2connected"+Integer.toString(globalI);
/*
synchronized (lock) {
        intent.putExtra(SOCKET_DATA_IDENTIFIER, "2connected"+Integer.toString(globalI)); // store data in your intent
       // intent.putExtra(SOCKET_DATA_IDENTIFIER, Integer.toString(numBytes)); // store data in your intent
        // send data to registered receivers
        LocalBroadcastManager.getInstance(myctx).sendBroadcast(intent);
}
*/
break;
        } 
/*
catch (IOException e) {   
try{
Thread.sleep(20000);
continue;
        } catch (Exception ee) {                                
                  ee.printStackTrace();
                                                                        }
        }       
*/
         catch (Exception e) {   
try{
Thread.sleep(20000);
continue;
        } catch (Exception ee) {                                
                  ee.printStackTrace();
                                                                        }
        }       
}

lastMessageTimestamp = System.currentTimeMillis();
isConnecting = 0;
  }
});                                                                  
thread.start();
        }
/*
try{
Thread.sleep(20000);
        } catch (Exception e) {                                                  e.printStackTrace();
                                                                        }
*/
//ii
}
    }
}

class SocketThread implements Runnable
{
    static final String SOCKET_DATA_RECEIVED = "com.your.package.SOCKET_DATA_RECEIVED";
    static final String SOCKET_DATA_IDENTIFIER = "com.your.package.SOCKET_DATA";
    private Context context;

    SocketThread(Context c) {
        context = c.getApplicationContext();
    }

    @Override
    public void run() { // code running in your thread
        // fetch data from socket ...
        Intent intent = new Intent(SOCKET_DATA_RECEIVED);
        intent.putExtra(SOCKET_DATA_IDENTIFIER, "data"); // store data in your intent
        // send data to registered receivers
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
        // your code ...
    }
}

   public class ConnectedThread extends Thread {
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
           int numBytes = 0; // bytes returned from read()

           // Keep listening to the InputStream until an exception occurs.
           while (true) {
               try {
Log.d("start read","ohhh");
//globalI++;
//TimeUnit.SECONDS.sleep(15);
//Thread.sleep(15000);
//int check = mmInStream.read(mmBuffer,0,4);
          //Toast.makeText(MyService.myctx,Integer.toString(check),Toast.LENGTH_LONG).show();
/*
if(mmSocket.isClosed()){
break;
}
*/
int check = mmInStream.read(mmBuffer,0,4);
if(check == -1){
//debug,handle reconnnect
Log.d(TAG, "check == -1");
break;
}
int isData = ByteBuffer.wrap(mmBuffer).order(ByteOrder.BIG_ENDIAN).getInt();
mmInStream.read(mmBuffer,0,4);
//mmInStream.read(mmBuffer,0,4);
int k = ByteBuffer.wrap(mmBuffer).order(ByteOrder.BIG_ENDIAN).getInt();
/*
      StringBuilder sb = new StringBuilder();
byte[] allByteArray = new byte[k];

ByteBuffer buff = ByteBuffer.wrap(allByteArray);

     while (k > 0) {
numBytes = mmInStream.read(mmBuffer);
k = k - numBytes;
//         sb.append(new String(mmBuffer,0,numBytes));
buff.put(mmBuffer,0,numBytes);
      }
*/
int length = k; // read the length of the message
byte[] message = new byte[length];
int bytesRead = 0;

while (bytesRead < length) {
     numBytes = mmInStream.read(message, bytesRead, length - bytesRead);
    if (numBytes == -1) {
        // end of stream reached before entire message could be read
        break;
    }
    bytesRead += numBytes;
}

if (bytesRead == length) {
    // entire message has been read successfully
    // process the message here
} else {
    // incomplete message received
    // handle the error here
}

//lastMessageTimestamp = System.currentTimeMillis();
                   // Read from the InputStream.
//byte[] combined = buff.array();
byte[] combined = message;
//numBytes = mmInStream.read(mmBuffer);
//		   String mmBuffer2 = new String(mmBuffer,0,numBytes);
		   String mmBuffer2 = new String(combined);
//		   String mmBuffer2 = sb.toString();
                   // Send the obtained bytes to the UI activity.
if(isData == 0){
heartbeat2=Integer.toString(isData) + mmBuffer2;
continue;
}
else if(isData == 4){
    JSONObject jsonObject = new JSONObject(mmBuffer2);
/*
            jsonObject.put("battery", battery2);
            String jsonString = jsonObject.toString();
            Log.d("wtuih JSON String", jsonString);
	write(jsonString.getBytes("UTF-8"),5);
    JSONObject jsonObject2 = new JSONObject(jsonObject.getString("data"));
*/
            Log.d("checkpoint", "get x,y");
int x2 = jsonObject.getInt("x");
int y2 = jsonObject.getInt("y");
/*
Thread thread = new Thread(new Runnable() {

    @Override
    public void run() {
}});
thread.start();
*/

try {
short x = (short) x2;
short y = (short) (y2-36);
            Log.d("wtuih JSON String", x + "  " + y);
/*
mHidDevice.sendReport(mDevice, (byte) 0x01, new byte[]{0,(byte)(x & 0xff),(byte)((x>>8) & 0xff),(byte)(y & 0xff),(byte)((y >>8) & 0xff), 0,0});
Thread.sleep(200);
mHidDevice.sendReport(mDevice, (byte) 0x01, new byte[]{1,0,0,0,0, 0,0});
Thread.sleep(200);
mHidDevice.sendReport(mDevice, (byte) 0x01, new byte[]{0,0,0,0,0, 0,0});
Thread.sleep(200);
mHidDevice.sendReport(mDevice, (byte) 0x01, new byte[]{1,0,0,0,0, 0,0});
Thread.sleep(200);
mHidDevice.sendReport(mDevice, (byte) 0x01, new byte[]{0,0,0,0,0, 0,0});
Thread.sleep(200);
x = (short)-x;y=(short)-y;
mHidDevice.sendReport(mDevice, (byte) 0x01, new byte[]{0,(byte)(x & 0xff),(byte)((x>>8) & 0xff),(byte)(y & 0xff),(byte)((y >>8) & 0xff), 0,0});
*/


enqueue((byte) 0x01, new byte[]{0,0,0,0,0, 0,0});
enqueue((byte) 0x01, new byte[]{0,(byte)(x & 0xff),(byte)((x>>8) & 0xff),(byte)(y & 0xff),(byte)((y >>8) & 0xff), 0,0});
enqueue((byte) 0x01, new byte[]{1,0,0,0,0, 0,0});
enqueue((byte) 0x01, new byte[]{0,0,0,0,0, 0,0});
enqueue((byte) 0x01, new byte[]{1,0,0,0,0, 0,0});
enqueue((byte) 0x01, new byte[]{0,0,0,0,0, 0,0});
x = (short)-x;y=(short)-y;
enqueue((byte) 0x01, new byte[]{0,(byte)(x & 0xff),(byte)((x>>8) & 0xff),(byte)(y & 0xff),(byte)((y >>8) & 0xff), 0,0});
}catch(Throwable e){
            Log.e("wtuih JSON String", e.getMessage()+"  zzzsendreport");
}
continue;
}
synchronized (lock) {
        Intent intent = new Intent(SOCKET_DATA_RECEIVED);
        //intent.putExtra(SOCKET_DATA_IDENTIFIER, Integer.toString(check) +"+"+Integer.toString(globalI) + mmBuffer2); // store data in your intent
        intent.putExtra(SOCKET_DATA_IDENTIFIER, mmBuffer2); // store data in your intent
        //intent.putExtra(SOCKET_DATA_IDENTIFIER, Integer.toString(isData) + mmBuffer2); // store data in your intent
        intent.putExtra("indicator", isData); // store data in your intent
        //intent.putExtra(SOCKET_DATA_IDENTIFIER,  mmBuffer2); // store data in your intent
       // intent.putExtra(SOCKET_DATA_IDENTIFIER, Integer.toString(numBytes)); // store data in your intent
        // send data to registered receivers
        LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);
}
/*
*/
               //} catch (IOException | InterruptedException e ) {
               } catch (Throwable e ) {
               //} catch (IOException e ) {
                   //Log.d(TAG, "catch throwable of while ture loop of run of connectedThread2", e);
                   Log.e(TAG, "catch throwable of while ture loop of run of connectedThread2", e);
          //Toast.makeText(MyService.myctx,":e:"+ e.getMessage(),Toast.LENGTH_LONG).show();
break;
//return;
               }
           }
       }
/*
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
*/

       public synchronized void write(byte[] bytes) {
write(bytes,1);
}
       public synchronized void write(byte[] bytes,int b ) {
           try {
byte[] byteArray2 = ByteBuffer.allocate(bytes.length+8).putInt(b).putInt(bytes.length).put(bytes).array();
               mmOutStream.write(byteArray2);
               mmOutStream.flush();

               // Share the sent message with the UI activity.
           } catch (Throwable e) {
           //} catch (IOException e) {
               Log.e(TAG, "Error occurred when sending data", e);
          //Toast.makeText(MyService.myctx,":e:"+ e.getMessage(),Toast.LENGTH_LONG).show();

               // Send a failure message back to the activity.
           }
       }
       // Call this from the main activity to send data to the remote device.
/*
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
*/

       // Call this method from the main activity to shut down the connection.
       public void cancel() {
           try {
               mmSocket.close();
           } catch (IOException e) {
               Log.e(TAG, "Could not close the connect socket", e);
           }
       }
   }

//10062023
   public class ConnectedThread2 extends Thread {
       private  Socket mmSocket;
       private  InputStream mmInStream;
       private  OutputStream mmOutStream;
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
               //tmpIn = socket.getInputStream();
           } catch (IOException e) {
               Log.e(TAG, "Error occurred when creating input stream", e);
           }
           try {
               //tmpOut = socket.getOutputStream();
socket.setSendBufferSize(1024*1024);
               tmpOut = new BufferedOutputStream(socket.getOutputStream());
           } catch (IOException e) {
               Log.e(TAG, "Error occurred when creating output stream", e);
           }

           mmInStream = tmpIn;
           mmOutStream = tmpOut;
       }

       public void run() {
           mmBuffer = new byte[1024];
           int numBytes = 0; // bytes returned from read()

           // Keep listening to the InputStream until an exception occurs.
           while (true) {
               try {
globalI++;
//TimeUnit.SECONDS.sleep(15);
//Thread.sleep(15000);
//int check = mmInStream.read(mmBuffer,0,4);
          //Toast.makeText(MyService.myctx,Integer.toString(check),Toast.LENGTH_LONG).show();
/*
if(mmSocket.isClosed()){
break;
}
*/
int check = mmInStream.read(mmBuffer,0,4);
if(check == -1){
//debug,handle reconnnect
Log.d(TAG, "check == -1");
break;
}
int isData = ByteBuffer.wrap(mmBuffer).order(ByteOrder.BIG_ENDIAN).getInt();
mmInStream.read(mmBuffer,0,4);
//mmInStream.read(mmBuffer,0,4);
int k = ByteBuffer.wrap(mmBuffer).order(ByteOrder.BIG_ENDIAN).getInt();
/*
      StringBuilder sb = new StringBuilder();
byte[] allByteArray = new byte[k];

ByteBuffer buff = ByteBuffer.wrap(allByteArray);

     while (k > 0) {
numBytes = mmInStream.read(mmBuffer);
k = k - numBytes;
//         sb.append(new String(mmBuffer,0,numBytes));
buff.put(mmBuffer,0,numBytes);
      }
*/
int length = k; // read the length of the message
byte[] message = new byte[length];
int bytesRead = 0;

while (bytesRead < length) {
     numBytes = mmInStream.read(message, bytesRead, length - bytesRead);
    if (numBytes == -1) {
        // end of stream reached before entire message could be read
        break;
    }
    bytesRead += numBytes;
}

if (bytesRead == length) {
    // entire message has been read successfully
    // process the message here
} else {
    // incomplete message received
    // handle the error here
}

lastMessageTimestamp = System.currentTimeMillis();
                   // Read from the InputStream.
//byte[] combined = buff.array();
byte[] combined = message;
//numBytes = mmInStream.read(mmBuffer);
//		   String mmBuffer2 = new String(mmBuffer,0,numBytes);
		   String mmBuffer2 = new String(combined);
//		   String mmBuffer2 = sb.toString();
                   // Send the obtained bytes to the UI activity.
if(isData == 0){
heartbeat2=Integer.toString(isData) + mmBuffer2;
continue;
}
else if(isData == 4){
    JSONObject jsonObject = new JSONObject(mmBuffer2);
            jsonObject.put("battery", battery2);
            String jsonString = jsonObject.toString();
            Log.d("wtuih JSON String", jsonString);
	write(jsonString.getBytes("UTF-8"),5);
    JSONObject jsonObject2 = new JSONObject(jsonObject.getString("data"));
int x2 = jsonObject2.getInt("x");
int y2 = jsonObject2.getInt("y");
/*
Thread thread = new Thread(new Runnable() {

    @Override
    public void run() {
}});
thread.start();
*/

try {
short x = (short) x2;
short y = (short) (y2-36);
            Log.d("wtuih JSON String", x + "  " + y);
/*
mHidDevice.sendReport(mDevice, (byte) 0x01, new byte[]{0,(byte)(x & 0xff),(byte)((x>>8) & 0xff),(byte)(y & 0xff),(byte)((y >>8) & 0xff), 0,0});
Thread.sleep(200);
mHidDevice.sendReport(mDevice, (byte) 0x01, new byte[]{1,0,0,0,0, 0,0});
Thread.sleep(200);
mHidDevice.sendReport(mDevice, (byte) 0x01, new byte[]{0,0,0,0,0, 0,0});
Thread.sleep(200);
mHidDevice.sendReport(mDevice, (byte) 0x01, new byte[]{1,0,0,0,0, 0,0});
Thread.sleep(200);
mHidDevice.sendReport(mDevice, (byte) 0x01, new byte[]{0,0,0,0,0, 0,0});
Thread.sleep(200);
x = (short)-x;y=(short)-y;
mHidDevice.sendReport(mDevice, (byte) 0x01, new byte[]{0,(byte)(x & 0xff),(byte)((x>>8) & 0xff),(byte)(y & 0xff),(byte)((y >>8) & 0xff), 0,0});
*/


enqueue((byte) 0x01, new byte[]{0,(byte)(x & 0xff),(byte)((x>>8) & 0xff),(byte)(y & 0xff),(byte)((y >>8) & 0xff), 0,0});
enqueue((byte) 0x01, new byte[]{1,0,0,0,0, 0,0});
enqueue((byte) 0x01, new byte[]{0,0,0,0,0, 0,0});
enqueue((byte) 0x01, new byte[]{1,0,0,0,0, 0,0});
enqueue((byte) 0x01, new byte[]{0,0,0,0,0, 0,0});
x = (short)-x;y=(short)-y;
enqueue((byte) 0x01, new byte[]{0,(byte)(x & 0xff),(byte)((x>>8) & 0xff),(byte)(y & 0xff),(byte)((y >>8) & 0xff), 0,0});
}catch(Throwable e){
            Log.e("wtuih JSON String", e.getMessage()+"  zzzsendreport");
}
continue;
}
synchronized (lock) {
        Intent intent = new Intent(SOCKET_DATA_RECEIVED);
        //intent.putExtra(SOCKET_DATA_IDENTIFIER, Integer.toString(check) +"+"+Integer.toString(globalI) + mmBuffer2); // store data in your intent
        intent.putExtra(SOCKET_DATA_IDENTIFIER, mmBuffer2); // store data in your intent
        //intent.putExtra(SOCKET_DATA_IDENTIFIER, Integer.toString(isData) + mmBuffer2); // store data in your intent
        intent.putExtra("indicator", isData); // store data in your intent
        //intent.putExtra(SOCKET_DATA_IDENTIFIER,  mmBuffer2); // store data in your intent
       // intent.putExtra(SOCKET_DATA_IDENTIFIER, Integer.toString(numBytes)); // store data in your intent
        // send data to registered receivers
        LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);
}
/*
*/
               //} catch (IOException | InterruptedException e ) {
               } catch (Throwable e ) {
               //} catch (IOException e ) {
                   //Log.d(TAG, "catch throwable of while ture loop of run of connectedThread2", e);
                   Log.e(TAG, "catch throwable of while ture loop of run of connectedThread2", e);
          //Toast.makeText(MyService.myctx,":e:"+ e.getMessage(),Toast.LENGTH_LONG).show();
try{
Thread.sleep(1000);
//debug,mmsocket not guaranted not null
try{
mmSocket.close();
}catch(Throwable t){
                   Log.e(TAG, "mmSocket.close throwable", t);
}
mmSocket = null;
mmSocket = new Socket(ip2,32007);
mmSocket.setKeepAlive(true);
mmSocket.setReceiveBufferSize(1024*1024);
               mmInStream =new BufferedInputStream(mmSocket.getInputStream());
               mmOutStream = new BufferedOutputStream(mmSocket.getOutputStream());
continue;
}catch(Throwable ee){
                   break;
}
//return;
               }
           }
       }

       // Call this from the main activity to send data to the remote device.
       public synchronized void write(byte[] bytes) {
write(bytes,1);
}
       public synchronized void write(byte[] bytes,int b ) {
           try {
byte[] byteArray2 = ByteBuffer.allocate(bytes.length+8).putInt(b).putInt(bytes.length).put(bytes).array();
               mmOutStream.write(byteArray2);
               mmOutStream.flush();

               // Share the sent message with the UI activity.
           } catch (Throwable e) {
           //} catch (IOException e) {
               Log.e(TAG, "Error occurred when sending data", e);
          //Toast.makeText(MyService.myctx,":e:"+ e.getMessage(),Toast.LENGTH_LONG).show();

               // Send a failure message back to the activity.
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

void playAudio(Context context2){
String root = context2.getExternalFilesDir(null).getAbsolutePath();
File myDir = new File(root + "/" + context2.getResources().getString(R.string.app_name) + "_share");
    myDir.mkdirs();
            Log.e("getExternalFirDir 20231014", root);
String fileName = "123.mp3";
 String baseDir = Environment.getExternalStorageDirectory().getAbsolutePath();
 String pathDir = baseDir + "/aaa/bbb/";

 File f = new File(pathDir + File.separator + fileName);
MediaPlayer mpintro;

/*
    try {
Log.d("20231014",uri.toString()+ "/123.mp3"+Uri.parse(Environment.getExternalStorageDirectory().getPath()+ "/Music/123.mp3").toString());
mpintro = MediaPlayer.create(context2, Uri.parse(uri.toString()+ "/123.mp3"));
//mpintro = MediaPlayer.create(context2, Uri.parse(Environment.getExternalStorageDirectory().getPath()+ "/Music/123.mp3"));
mpintro.setLooping(false);
        mpintro.start();
*/
Uri musicUri = Uri.parse(uri.toString() + "/123.mp3");
ContentResolver contentResolver = context2.getContentResolver();
DocumentFile pickedDir = DocumentFile.fromTreeUri(context2, uri);

// Find the specific file within the directory
DocumentFile file = pickedDir.findFile("123.mp3");
if (file != null) {
    try {
       // ContentResolver contentResolver = context.getContentResolver();
        
        // Get the real file path from the file URI
        String filePath = file.getUri().getPath();

        // Open a file descriptor for the file
        ParcelFileDescriptor fileDescriptor = contentResolver.openFileDescriptor(file.getUri(), "r");
Log.d("20231014",file.getUri().toString()+filePath);

        // Create a MediaPlayer instance and set the data source
        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setDataSource(fileDescriptor.getFileDescriptor());

        // Prepare and start playback
        mediaPlayer.prepare();
        mediaPlayer.start();

        // Release resources when finished playing (optional)
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mediaPlayer.release();
            }
        });
    } catch (Throwable e) {
        e.printStackTrace();
            Log.e("play 123.mp3 Throwable20231014", e.getMessage());
Toast.makeText(context2, baseDir + File.separator + fileName,Toast.LENGTH_LONG).show();
    }
}
}

public static void showToast(final String msg, final Context ctx){
    final long pastTime = System.currentTimeMillis() - lastToastShowTime;
    if(pastTime > TIME_DELAY ){

        Toast.makeText(ctx, msg, Toast.LENGTH_LONG).show();
        lastToastShowTime = System.currentTimeMillis();

     }else{
        final long delay = TIME_DELAY - pastTime;
        lastToastShowTime = System.currentTimeMillis() + delay;
Handler handler = new Handler();
        handler.postDelayed(new Runnable(){

            @Override
            public void run() {
               try{
                  Toast.makeText(ctx, msg, Toast.LENGTH_LONG).show();
               }catch(Exception e){
                  Log.e("TOAST_NOT_SHOWED", "Toast not showed: " + msg, e);
               }

            }

       } , delay);

    }
}

private void takeScreenshot() {
/*
    Date now = new Date();
    android.text.format.DateFormat.format("yyyy-MM-dd_hh:mm:ss", now);

    try {
        // image naming and path  to include sd card  appending name you choose for file
        String mPath = Environment.getExternalStorageDirectory().toString() + "/" + now + ".jpg";

        // create bitmap screen capture
        View v1 = getWindow().getDecorView().getRootView();
        v1.setDrawingCacheEnabled(true);
        Bitmap bitmap = Bitmap.createBitmap(v1.getDrawingCache());
        v1.setDrawingCacheEnabled(false);

        File imageFile = new File(mPath);

        FileOutputStream outputStream = new FileOutputStream(imageFile);
        int quality = 100;
        bitmap.compress(Bitmap.CompressFormat.JPEG, quality, outputStream);
        outputStream.flush();
        outputStream.close();

    } catch (Throwable e) {
        // Several error may come out with file handling or DOM
        e.printStackTrace();
    }
*/
}


private ViewGroup floatView;
private ViewGroup floatView2;
    private int LAYOUT_TYPE;
    private WindowManager.LayoutParams floatWindowLayoutParam;
    private WindowManager.LayoutParams floatWindowLayoutParam2;
    private WindowManager windowManager;
private Button maximizeBtn;
  
    // As FloatingWindowGFG inherits Service class, 
    // it actually overrides the onBind method

private MappedByteBuffer loadModelFile() throws IOException
{
AssetFileDescriptor assetFileDescriptor = this.getAssets().openFd("embrace73.tflite");
FileInputStream fileInputStream = new FileInputStream(assetFileDescriptor.getFileDescriptor());
FileChannel fileChannel = fileInputStream.getChannel();

long startOffset = assetFileDescriptor.getStartOffset();
long len = assetFileDescriptor.getLength();

return fileChannel.map(FileChannel.MapMode.READ_ONLY,startOffset,len);
}
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
public static String classify(float[][] a){
String[] vertexX ={"a","b","c","d","e","f","g","h","j","k","l","m","n","o","p","q","r","s","t"};
String[] vertexY ={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19"};
String b = "set_position";
        for (int i = 0; i < 19; i++) {
        for (int j = 0; j < 19; j++) {
int state = argmax(a[i*19+j]);
if (state != 1){
b=b.concat(" "+colors[state]+" "+vertexX[j]+vertexY[i]);

}
}
        }
return b;

}
public static int[] classify2(float[][] a){
int[] b = new int[a.length];
        for (int i = 0; i < a.length; i++) {
b[i] = argmax(a[i]);

        }
return b;

}
private class SocketDataReceiver extends BroadcastReceiver
    {
String[] vertexX ={"a","b","c","d","e","f","g","h","j","k","l","m","n","o","p","q","r","s","t"};
Map<String,Integer> outputs = new HashMap<>();
public SocketDataReceiver(){
for(int i =0;i < 19;i++){
outputs.put(vertexX[i],i);
}
}
        @Override
        public void onReceive(Context context, Intent intent) {
            // intent contains your socket data,
String globalMsg = intent.getStringExtra(MyService.SOCKET_DATA_IDENTIFIER);
int katago = intent.getIntExtra("indicator",0);
//if(true)
//if(globalMsg.length()>3)
if(katago == 13){
Log.d("20231014","11");
Thread thread = new Thread(new Runnable() {

    @Override
    public void run() {
/*
try{
// Create TessBaseAPI instance (this internally creates the native Tesseract instance)
TessBaseAPI tess = new TessBaseAPI();

// Given path must contain subdirectory `tessdata` where are `*.traineddata` language files
// The path must be directly readable by the app
//String dataPath = new File(context.getExternalFilesDir(null), "tesseract").getAbsolutePath();
String dataPath = context.getExternalFilesDir(null).getAbsolutePath();

// Initialize API for specified language
// (can be called multiple times during Tesseract lifetime)
if (!tess.init(dataPath, "eng")) { // could be multiple languages, like "eng+deu+fra"
    // Error initializing Tesseract (wrong/inaccessible data path or not existing language file(s))
    // Release the native Tesseract instance
    tess.recycle();
    return;
}

// Load the image (file path, Bitmap, Pix...)
// (can be called multiple times during Tesseract lifetime)
tess.setImage(image2);

// Start the recognition (if not done for this image yet) and retrieve the result
// (can be called multiple times during Tesseract lifetime)
String text = tess.getUTF8Text();
Log.d("20231014",text);
//text = tess.getUTF8Text();
//Log.d("20231014",text);

// Release the native Tesseract instance when you don't want to use it anymore
// After this call, no method can be called on this TessBaseAPI instance
tess.recycle();

}catch(Throwable e){
Log.e("20231014",e.getMessage());
}
*/
}
});
thread.start();
Log.d("20231014","111");
return;
}
if(katago == 16){
Log.d("20231014","11");
playAudio(myctx);

Log.d("20231014","111");
return;
}
if(katago == 14){
try {
DocumentFile pickedDir = DocumentFile.fromTreeUri(myctx, uri);

// Find the specific file within the directory
DocumentFile file = pickedDir.findFile("123.png");
    ContentResolver contentResolver = getContentResolver();
    ParcelFileDescriptor parcelFileDescriptor = contentResolver.openFileDescriptor(file.getUri(), "r");

    if (parcelFileDescriptor != null) {
FileDescriptor fileDescriptor = parcelFileDescriptor.getFileDescriptor();
        // Convert the file descriptor to a FileInputStream
/*
        FileInputStream inputStream = new FileInputStream(fileDescriptor);

        // Decode the input stream into a Bitmap
        image2 = BitmapFactory.decodeStream(inputStream);

        // Close the input stream
        inputStream.close();
*/
image2 = BitmapFactory.decodeFileDescriptor(fileDescriptor);

        // Now you have the bitmap for further processing

        // You can now perform any required operations on the bitmap
    }

    // Close the file descriptor
    //parcelFileDescriptor.close();
    //fileDescriptor.close();
} catch (IOException e) {
    e.printStackTrace();
    // Handle any exceptions that occurred during the process
}
return;
}
if(katago == 12){
Log.d("20231014","11");
Uri treeUri = uri;// obtained URI from ACTION_OPEN_DOCUMENT_TREE intent

// Create a new directory "abc" within the external files directory
File abcDirectory = new File(context.getExternalFilesDir(null), "tessdata");
boolean isDirectoryCreated = abcDirectory.mkdir();
DocumentFile pickedDir = DocumentFile.fromTreeUri(myctx, uri);

// Find the specific file within the directory
DocumentFile file = pickedDir.findFile("123.png");

//if (isDirectoryCreated) {
    Uri fileUri =file.getUri(); // URI of the specific file, in this case, 123.mp3

    try {
        // Create an InputStream from the fileUri
        InputStream inputStream = context.getContentResolver().openInputStream(fileUri);
        
        // Create an OutputStream to the destination file
        File destinationFile = new File(abcDirectory, "123.png");
        OutputStream outputStream = new FileOutputStream(destinationFile);

        // Copy the InputStream to the OutputStream
        byte[] buffer = new byte[8192];
        int bytesRead;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }

        // Flush and close the streams
        outputStream.flush();
        outputStream.close();
        inputStream.close();

        // File copied successfully
    } catch (IOException e) {
        e.printStackTrace();
        // Handle any exceptions that occurred during the file copy process
    }
//}
if (abcDirectory.exists() && abcDirectory.isDirectory()) {
    // Get an array of files within the directory
    File[] files = abcDirectory.listFiles();

    // Check if any files exist within the directory
    if (files != null && files.length > 0) {
        // Log each file
        for (File file2 : files) {
            Log.d("Files1014", "File name: " + file2.getName());
            Log.d("Files1014", "File path: " + file2.getAbsolutePath());
            Log.d("Files1014", "File size: " + String.valueOf(file2.length()));
        }
    } else {
        Log.d("Files1014", "No files found in the ABC directory");
    }
} else {
    Log.d("Directory1014", "ABC directory does not exist");
}

Log.d("20231014","111");
return;
}
if(katago == 15){
Log.d("20231014","11");
Uri treeUri = uri;// obtained URI from ACTION_OPEN_DOCUMENT_TREE intent

// Create a new directory "abc" within the external files directory
File abcDirectory = new File(context.getExternalFilesDir(null), "tessdata");
boolean isDirectoryCreated = abcDirectory.mkdir();
DocumentFile pickedDir = DocumentFile.fromTreeUri(myctx, uri);

// Find the specific file within the directory
DocumentFile file = pickedDir.findFile("eng.traineddata");

//if (isDirectoryCreated) {
    Uri fileUri =file.getUri(); // URI of the specific file, in this case, 123.mp3

    try {
        // Create an InputStream from the fileUri
        InputStream inputStream = context.getContentResolver().openInputStream(fileUri);
        
        // Create an OutputStream to the destination file
        File destinationFile = new File(abcDirectory, "eng.traineddata");
        OutputStream outputStream = new FileOutputStream(destinationFile);

        // Copy the InputStream to the OutputStream
        byte[] buffer = new byte[8192];
        int bytesRead;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }

        // Flush and close the streams
        outputStream.flush();
        outputStream.close();
        inputStream.close();

        // File copied successfully
    } catch (IOException e) {
        e.printStackTrace();
        // Handle any exceptions that occurred during the file copy process
    }
//}
if (abcDirectory.exists() && abcDirectory.isDirectory()) {
    // Get an array of files within the directory
    File[] files = abcDirectory.listFiles();

    // Check if any files exist within the directory
    if (files != null && files.length > 0) {
        // Log each file
        for (File file2 : files) {
            Log.d("Files1014", "File name: " + file2.getName());
            Log.d("Files1014", "File path: " + file2.getAbsolutePath());
            Log.d("Files1014", "File size: " + String.valueOf(file2.length()));
        }
    } else {
        Log.d("Files1014", "No files found in the ABC directory");
    }
} else {
    Log.d("Directory1014", "ABC directory does not exist");
}

Log.d("20231014","111");
return;
}
if(katago == 16){
Log.d("20231014","11");
playAudio(myctx);

Log.d("20231014","111");
return;
}
if(katago == 17){
        windowManager.addView(floatView, floatWindowLayoutParam);
        windowManager.addView(floatView2, floatWindowLayoutParam2);

return;
}
if(katago == 18){
 Toast.makeText(myctx,"launch blConnectedThread",Toast.LENGTH_LONG).show();
Log.d("broadcast 1006","18");
blConnectedThread = new ConnectedThread(blSocket);
blConnectedThread.start();

return;
}
if(katago != 19)
return;
int w=outputs.get(globalMsg.substring(0,1).toLowerCase());
int h=Integer.parseInt(globalMsg.substring(1))-1;

myTextView.setText(globalMsg);
int x = w*73+43-1404/2;
int y = h*73+243-1872/2+43;
                        floatWindowLayoutParam2.x = (int) (x);
                        floatWindowLayoutParam2.y = (int) (y);
  
                        // updated parameter is applied to the WindowManager
                        windowManager.updateViewLayout(floatView2, floatWindowLayoutParam2);
//MainActivity4Kt.setContent(binding.brutal,globalMsg);
            // get data from intent using SocketThread.SOCKET_DATA_IDENTIFIER
Thread thread = new Thread(new Runnable() {

    @Override
    public void run() {

try {
/*
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("entry", "wtuih");
            jsonObject.put("inputNumber", socketsIndex);
            jsonObject.put("x", x);
            jsonObject.put("y", y);

            String jsonString = jsonObject.toString();
            Log.d("JSON String", jsonString);
	MyService.mConnectedThread2.write(jsonString.getBytes("UTF-8"),2);
*/
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("x", x);
            jsonObject.put("y", y);

            String jsonString = jsonObject.toString();
            Log.d("JSON String", jsonString);
	MyService.blConnectedThread.write(jsonString.getBytes("UTF-8"),4);
//MyService.myTurn = true;
            
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("test myTurn postdelay", e.getMessage());
        }
}});
thread.start();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
MyService.myTurn = true;}},4000);

        }
    }

//0913
public static BluetoothProfile.ServiceListener mProfileServiceListener = new BluetoothProfile.ServiceListener() {
        @Override
        public void onServiceDisconnected(int profile) {
            Log.e("TAG", "hid onServiceDisconnected");
            if (profile == BluetoothProfile.HID_DEVICE) {
                mHidDevice.unregisterApp();
            }
        }

        @SuppressLint("NewApi")
        @Override
        public void onServiceConnected(int profile, BluetoothProfile proxy) {
            Log.e("TAG", "hid onServiceConnected");
            //bluetoothProfile = proxy;
            if (profile == BluetoothProfile.HID_DEVICE) {
                mHidDevice = (BluetoothHidDevice) proxy;
                HidConsts.HidDevice = mHidDevice;
                BluetoothHidDeviceAppSdpSettings sdp = new BluetoothHidDeviceAppSdpSettings("HidConsts.NAME", "HidConsts.DESCRIPTION", "HidConsts.PROVIDER", BluetoothHidDevice.SUBCLASS1_COMBO, Descriptor);
                mHidDevice.registerApp(sdp, null, null, Executors.newCachedThreadPool(), mCallback);
            }
        }
    };

public static final BluetoothHidDevice.Callback mCallback = new BluetoothHidDevice.Callback() {
        @Override
        public void onAppStatusChanged(BluetoothDevice pluggedDevice, boolean registered) {
            Log.e(TAG, "onAppStatusChanged: " + registered);
            //isRegister = registered;
        }

        @Override
        public void onConnectionStateChanged(BluetoothDevice device, int state) {
            Log.e(TAG, "onConnectionStateChanged:" + state);
            if (state == BluetoothProfile.STATE_DISCONNECTED) {
_connected = false;
/*
                HidUtils.isConnected(false);
                if (connectionStateChangeListener != null) {
                    connectionStateChangeListener.onDisConnected();
                    mDevice = null;
                }
*/
                    mDevice = null;
            Log.e(TAG, "bluetooth disconnected");
            } else if (state == BluetoothProfile.STATE_CONNECTED) {
_connected = true;
 //               HidUtils.isConnected(true);
                mDevice = device;
byteQueue.clear();
            Log.e(TAG, "bluetooth connected");
/*
                if (connectionStateChangeListener != null) {
                    connectionStateChangeListener.onConnected();
                }
*/
            } else if (state == BluetoothProfile.STATE_CONNECTING) {
            Log.e(TAG, "bluetooth connecting");
/*
                if (connectionStateChangeListener != null) {
                    connectionStateChangeListener.onConnecting();
                }
*/
            }
        }
    };
//public class ByteQueueExample {
    private class ByteData {
        private final byte singleByte;
        private final byte[] byteArray;
        
        public ByteData(byte singleByte, byte[] byteArray) {
            this.singleByte = singleByte;
            this.byteArray = byteArray;
        }

        public byte getSingleByte() {
            return singleByte;
        }

        public byte[] getByteArray() {
            return byteArray;
        }
    }

    private static Queue<ByteData> byteQueue = new ConcurrentLinkedQueue<>();

    public void enqueue(byte singleByte, byte[] byteArray) {
        byteQueue.add(new ByteData(singleByte, byteArray));
    }

    public ByteData dequeue() {
        return byteQueue.poll();
    }
//}



            public void onClick2(Image image2) {
try{
if (MyService.data0 == null) {
    Log.d("TAG", "basicSetup: Asking permission again");
    //open app again
Intent dialogIntent = new Intent(MyService.this, myScreenshot.class);
      dialogIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
      startActivity(dialogIntent);
} else {
    Log.d("TAG", "basicSetup: Getting permission for the object");
    //readPermissionObject();
if (mediaProjection == null){
Log.e("bt3 1004","test005");
mImageReader = ImageReader.newInstance( DISPLAY_WIDTH, DISPLAY_HEIGHT, PixelFormat.RGBA_8888, 2);
Intent data1 =(Intent)data0.clone();
mediaProjectionManager  = (MediaProjectionManager) getSystemService(Context.MEDIA_PROJECTION_SERVICE);
        mediaProjection = mediaProjectionManager.getMediaProjection(Activity.RESULT_OK,data1);
        virtualDisplay = mediaProjection.createVirtualDisplay("MainActivity", DISPLAY_WIDTH, DISPLAY_HEIGHT, mScreenDensity, DisplayManager.VIRTUAL_DISPLAY_FLAG_AUTO_MIRROR,
                mImageReader.getSurface(), null, null);
}
Log.e("bt3 1004","test001");
Image image = image2;
//Image image = null;
try{
//image = mImageReader.acquireLatestImage();
if (image == null){
 //Toast.makeText(MyService.myctx,"image == null",Toast.LENGTH_LONG).show();
Log.e("bt3 1004","test003");
return;
}
}catch(Throwable e){
 //Toast.makeText(MyService.myctx,"nullhi",Toast.LENGTH_LONG).show();
Log.e("bt3 1005",e.getMessage());
return;
//            myScreenshot.this.stopService(new Intent(myScreenshot.this, MyService.class));
}
Log.e("bt3 1004","test002");
myTurn = false;
final Image.Plane[] planes = image.getPlanes();
final ByteBuffer buffer = planes[0].getBuffer();
int offset = 0;
int pixelStride = planes[0].getPixelStride();
int rowStride = planes[0].getRowStride();
int rowPadding = rowStride - pixelStride * DISPLAY_WIDTH;
byte[] data = new byte[buffer.capacity()];
((ByteBuffer) buffer.duplicate().clear()).get(data);
//Mat mat = new Mat(DISPLAY_WIDTH+rowPadding/pixelStride,DISPLAY_HEIGHT, CvType.CV_8UC4);
Mat mat = new Mat(DISPLAY_HEIGHT,DISPLAY_WIDTH+rowPadding/pixelStride, CvType.CV_8UC4);
mat.put(0, 0, data);
Mat dst_mat = new Mat();
//Imgproc.cvtColor(grayO.get(0), dst_mat, Imgproc.COLOR_BGRA2BGR);
Rect roiRect2 = new Rect(0,0,DISPLAY_WIDTH,DISPLAY_HEIGHT);
Mat mat3 = new Mat(mat,roiRect2);
Imgproc.cvtColor(mat3, dst_mat, Imgproc.COLOR_RGBA2BGR);
//Imgproc.cvtColor(mat3, dst_mat, Imgproc.COLOR_RGBA2RGB);

// create bitmap
//Bitmap bmp = Bitmap.createBitmap(DISPLAY_WIDTH+rowPadding/pixelStride,DISPLAY_HEIGHT, Bitmap.Config.ARGB_8888);
//bmp.copyPixelsFromBuffer(buffer);
//image.close();
//return dst_mat;
      Imgcodecs imageCodecs = new Imgcodecs(); 
 //Toast.makeText(MyService.myctx,"hi",Toast.LENGTH_LONG).show();
        String file4 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + new StringBuilder("/ssgf3").append(".jpg").toString();
        //File file3 = new File(file2);
      //Mat dest2 = imageCodecs.imread(file4);
      Mat dest333 = imageCodecs.imread(file4);
      Mat dest2 = new Mat();
dst_mat.convertTo(dest2, CvType.CV_32FC3, 1.0/255, 0);
//dst_mat.convertTo(dest2, CvType.CV_32FC3);
//dest333.convertTo(dest2, CvType.CV_32FC3);
//dest333.convertTo(dest2, CvType.CV_32FC3, 1.0/255, 0);
      //Mat dest2 = mat;
      //Mat dest2 = imageCodecs.imread(file4,Imgcodecs.IMREAD_UNCHANGED);
//(x,y),(x2,y2)=(77,230), (1328,1481)
//int x = 77;int y = 230;int x2 = 1328;int y2 =1481;
int x = 43;int y = 243;int x2 = 1360;int y2 =1560;
float l = (x2-x)/36;int l2 = (int)(2*l);
ArrayList<float[]> myArray = new ArrayList<float[]>();
//double[][][][][] fuck = new double[19][19][l2][l2][3];
float[][][][][] fuck = new float[1][19*19][l2][l2][3];
ByteBuffer vbb = ByteBuffer.allocateDirect(19*19*l2*l2*3 * 4); 
vbb.order(ByteOrder.nativeOrder());    // use the device hardware's native byte order
FloatBuffer input = vbb.asFloatBuffer();
//FloatBuffer input = FloatBuffer.allocate(19*19*l2*l2*3);
float[] saran =new float[19*1*l2*l2*3];
//Mat m = new Mat();
for (int ii = 0;ii < 19;ii++){
for (int ii2 = 0;ii2 < 19;ii2++){
Rect roiRect = new Rect(x+(int)((ii2*2-1)*(x2-x)/36),y+(int)((ii*2-1)*(x2-x)/36),l2,l2);
//Rect roiRect = new Rect(x+(int)((ii2*2-1)*(x2-x)/36),y+(int)((ii*2-1)*(x2-x)/36),l2+1,l2+1);
Mat dest33 = new Mat(dest2,roiRect);
float[] dest3 = new float[l2*l2*3];
//float[] dest3 = new float[(l2+1)*(l2+1)*3];
//dest33.put(0,0,dest3);
//maybe you only get pixels of one point,so it is wrong here
dest33.get(0,0,dest3);
input.put(dest3);
//dest2.get(x+(int)(ii2*2*l-l),y+(int)(ii*2*l-l),dest3);
//myArray.add(dest3);
//m.push_back(dest33);
}

}
//Mat m2 = m.reshape(0,73*19);
//float[][][][] fuck2 = new float[1][l2][l2][3];
//fuck2[0] = fuck[0][0];
//float[] output = new float[3];
//float[][] output = new float[19][3];
float[][] output = new float[19*19][3];
//float[][] output = new float[1][3];
//Map<Integer, Object> outputs = new HashMap<>();
            Map<String, Object> outputs = new HashMap<>();

//Map<String, Object> inputs = new HashMap<>();
  //          inputs.put("conv2d_input", fuck2);

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
interpreter.resizeInput(0, new int[]{19*19,l2,l2,3});
interpreter.allocateTensors();
//do i need set the buffer possition
input.position(0);
interpreter.run(input, output);
//interpreter.run(fuck[0], output);
//interpreter.run(myArray.toArray(new <float[][][]>[0])[0], output);
//interpreter.run(myArray.toArray(new float[19][19][73][73][3])[0], output);
            	    //tv.setText( Float.toString(((float[])outputs.get("dense_1"))[0]));
//tv.setText(Arrays.toString(classify(output)));

 //Toast.makeText(MyService.myctx,classify(output),Toast.LENGTH_LONG).show();
 //Toast.makeText(MyService.myctx,Arrays.toString(classify(output))+Arrays.toString(output[10]),Toast.LENGTH_LONG).show();
byte[] byteArray = classify(output).getBytes("UTF-8");
//byte[] byteArray = Arrays.toString(classify(output)).getBytes("UTF-8");
byte[] byteArray2 = ByteBuffer.allocate(byteArray.length+4).putInt(byteArray.length).put(byteArray).array();
Thread thread = new Thread(new Runnable() {
    public void run() {
        // do something...              
mConnectedThread3.write(byteArray2);
    }
});
thread.start();

// create bitmap

}
}catch(Throwable e){
data0 = null;
Log.e("bt3 1004",e.getMessage());
StringWriter errors = new StringWriter();
e.printStackTrace(new PrintWriter(errors));
//return errors.toString();
/*
          Toast.makeText(MyService.myctx,
                              errors.toString()+":e:"+ e.getMessage(),
                               Toast.LENGTH_LONG)
                    .show();
*/
try{
}catch(Exception ei){}
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "imagereaderToMatError.txt");
        try {
            FileOutputStream out = new FileOutputStream(file);
out.write( (errors.toString()+":e:" +e.getMessage()).getBytes());
            out.close();
        } catch (Exception ei) {
            e.printStackTrace();
} finally {
            //out.flush();
            //out.close();
}
}
//takeScreenshot();
//MainActivity4Kt.screenshot();
            }

ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
//Timer myTimer = new Timer();
Runnable myTask = new Runnable() {
            @Override
            public void run() {
if(!myTurn){return;}
Image image = null;
try{
image = mImageReader.acquireLatestImage();
if (image == null){
 //Toast.makeText(MyService.myctx,"image == null",Toast.LENGTH_LONG).show();
return;
}
}catch(Exception e){
 //Toast.makeText(MyService.myctx,"nullhi",Toast.LENGTH_LONG).show();
return;
//            myScreenshot.this.stopService(new Intent(myScreenshot.this, MyService.class));
}
final Image.Plane[] planes = image.getPlanes();
final ByteBuffer buffer = planes[0].getBuffer();
int pixelStride = planes[0].getPixelStride();
int rowStride = planes[0].getRowStride();
int rowPadding = rowStride - pixelStride * DISPLAY_WIDTH;
int x = 704;
int y = 87;
int offset = y * rowStride + x * pixelStride;
int pixel = 0;

// Check if the pixel lies within the image bounds
if (offset >= 0 && offset < buffer.capacity()) {
    // Ensure the buffer is in read mode
    buffer.rewind();
    buffer.position(offset);

    // Retrieve the color channels
    int red = buffer.get() & 0xFF;
    int green = buffer.get() & 0xFF;
    int blue = buffer.get() & 0xFF;

    // Construct the pixel value with alpha set to 255 (fully opaque)
    pixel = 0xFF000000 | (red << 16) | (green << 8) | blue;
}
String colorHex = String.format("0x%06X", pixel);
 //Toast.makeText(MyService.myctx,"colorHex of pixel at x,y : "+ colorHex,Toast.LENGTH_LONG).show();
            Log.d("bt3", "colorHex of pixel at x,y : "+ colorHex);
if(pixel == mySide){
            Log.d("bt3", "you can play now : "+ colorHex);
try{
//bt2.performClick();
onClick2(image);
}catch(Throwable e){
Log.e("bt3 1003",e.getMessage());
}
}
image.close();

            }
        };

    @Override
    public void onCreate() {
super.onCreate();
 // the height and width of the floating window is set depending on this
        DisplayMetrics metrics = getApplicationContext().getResources().getDisplayMetrics();
        int width = metrics.widthPixels;
        int height = metrics.heightPixels;
  
        // To obtain a WindowManager of a different Display,
        // we need a Context for that display, so WINDOW_SERVICE is used
        windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
  
        // A LayoutInflater instance is created to retrieve the 
        // LayoutInflater for the floating_layout xml
        LayoutInflater inflater = (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
          
        // inflate a new view hierarchy from the floating_layout xml
        floatView = (ViewGroup) inflater.inflate(R.layout.myfloat, null);
        floatView2 = (ViewGroup) inflater.inflate(R.layout.mmyfloat, null);
  
        // The Buttons and the EditText are connected with
        // the corresponding component id used in floating_layout xml file
        // Just like MainActivity, the text written 
        // in Maximized will stay
        // WindowManager.LayoutParams takes a lot of parameters to set the
        // the parameters of the layout. One of them is Layout_type.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // If API Level is more than 26, we need TYPE_APPLICATION_OVERLAY
            LAYOUT_TYPE = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY;
        } else {
            // If API Level is lesser than 26, then we can 
            // use TYPE_SYSTEM_ERROR,
            // TYPE_SYSTEM_OVERLAY, TYPE_PHONE, TYPE_PRIORITY_PHONE.
            // But these are all
            // deprecated in API 26 and later. Here TYPE_TOAST works best.
            LAYOUT_TYPE = WindowManager.LayoutParams.TYPE_SYSTEM_ALERT;
            //LAYOUT_TYPE = WindowManager.LayoutParams.TYPE_TOAST;
        }
floatWindowLayoutParam2 = new WindowManager.LayoutParams(
72,
72,
    //WindowManager.LayoutParams.WRAP_CONTENT,
    //WindowManager.LayoutParams.WRAP_CONTENT,
    //WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY,
                LAYOUT_TYPE,
    WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE | 
WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE |
WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN, 
PixelFormat.TRANSLUCENT);
floatWindowLayoutParam = new WindowManager.LayoutParams(
                (int) (width * (0.6f)),
                //(int) (width * (0.3f)),
                (int) (height * (0.1f)),
                LAYOUT_TYPE,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
 //               WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE|WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM,
                PixelFormat.TRANSLUCENT
        );
  
        // The Gravity of the Floating Window is set. 
        // The Window will appear in the center of the screen
        //floatWindowLayoutParam.gravity = Gravity.CENTER;
        //floatWindowLayoutParam.gravity = Gravity.END | Gravity.TOP;
        floatWindowLayoutParam.gravity = Gravity.TOP;
          
        // X and Y value of the window is set
        floatWindowLayoutParam.x = 0;
        floatWindowLayoutParam.y = 0;
  
        // The ViewGroup that inflates the floating_layout.xml is
        // added to the WindowManager with all the parameters
        windowManager.addView(floatView, floatWindowLayoutParam);
        windowManager.addView(floatView2, floatWindowLayoutParam2);
maximizeBtn = floatView.findViewById(R.id.addscore);
Button bt2 = floatView.findViewById(R.id.addscore2);
Button bt3 = floatView.findViewById(R.id.bluetooth);
Button bt4 = floatView.findViewById(R.id.bluetooth2);
bt5 = floatView2.findViewById(R.id.locationHint);
myTextView = floatView.findViewById(R.id.score);
modifier = floatView.findViewById(R.id.edittext);
  
floatView.setOnTouchListener(new View.OnTouchListener() {
            final WindowManager.LayoutParams floatWindowLayoutUpdateParam = floatWindowLayoutParam;
            double x;
            double y;
            double px;
            double py;
  
            @Override
            public boolean onTouch(View v, MotionEvent event) {
  
                switch (event.getAction()) {
                    // When the window will be touched, 
                    // the x and y position of that position
                    // will be retrieved
                    case MotionEvent.ACTION_DOWN:
                        x = floatWindowLayoutUpdateParam.x;
                        y = floatWindowLayoutUpdateParam.y;
                          
                        // returns the original raw X 
                        // coordinate of this event
                        px = event.getRawX();
                          
                        // returns the original raw Y 
                        // coordinate of this event
                        py = event.getRawY();
                        break;
                    // When the window will be dragged around, 
                    // it will update the x, y of the Window Layout Parameter
                    case MotionEvent.ACTION_MOVE:
                        floatWindowLayoutUpdateParam.x = (int) ((x + event.getRawX()) - px);
                        floatWindowLayoutUpdateParam.y = (int) ((y + event.getRawY()) - py);
  
                        // updated parameter is applied to the WindowManager
                        windowManager.updateViewLayout(floatView, floatWindowLayoutUpdateParam);
                        break;
                }
                return false;
            }
        });

        // The button that helps to maximize the app
maximizeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
try{
if(!modifier.isChecked()){
BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
            bluetoothAdapter.setName("Peripheral MK2");
            bluetoothAdapter.getProfileProxy(myctx, mProfileServiceListener, BluetoothProfile.HID_DEVICE);

  new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
if(sending){return;}
sending = true;
if(_connected){
                ByteData report = dequeue();
                if (report != null) {
//0924
try{
if(!mHidDevice.sendReport(mDevice,report.getSingleByte(),report.getByteArray())){
Log.d("sendreport","return false");
}
}catch(Throwable e){
Log.e("sendReport",e.getMessage());
}
}
                }
sending = false;
            }
        }, 0, 200);
//0913
return;
}
/*
//new AlertDialog.Builder(myctx)
new AlertDialog.Builder(floatView.getContext())
.setTitle("Title")
.setMessage("Do you really want to whatever?")
//.setIcon(android.R.drawable.ic_dialog_alert)
.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

    public void onClick(DialogInterface dialog, int whichButton) {
     //   Toast.makeText(myctx, "Yaay", Toast.LENGTH_SHORT).show();
return;
    }})
 .setNegativeButton(android.R.string.no, null).show();
*/
if(mediaProjection != null){
mediaProjection.stop();
virtualDisplay.release();
mediaProjection = null;
}
                // stopSelf() method is used to stop the service if
                // it was previously started
                //stopSelf();
                  
                // The window is removed from the screen
                windowManager.removeView(floatView);
                windowManager.removeView(floatView2);
}catch(Throwable e){
data0 = null;
StringWriter errors = new StringWriter();
e.printStackTrace(new PrintWriter(errors));
//return errors.toString();
          Toast.makeText(MyService.myctx,
                              errors.toString()+":e:"+ e.getMessage(),
                               Toast.LENGTH_LONG)
                    .show();
try{
/*
PrintWriter out = new PrintWriter(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) +"filename.txt");
out.println(errors.toString()+":e:" e.getMessage());
*/
}catch(Exception ei){}
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "imagereaderToMatError.txt");
        try {
            FileOutputStream out = new FileOutputStream(file);
out.write( (errors.toString()+":e:" +e.getMessage()).getBytes());
            out.close();
        } catch (Exception ei) {
            e.printStackTrace();
} finally {
            //out.flush();
            //out.close();
}
}
            }
        });
bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
String[] colors2 ={"b"," ","w"};
String[] colors3 ={"w"," ","b"};
isWhite = !isWhite;
colors = isWhite?colors3:colors2;
String whichColor = isWhite?"white now":"black now";
mySide = isWhite?0xFFFFFFFF:0xFF000000;
//if(isWhite) bt5.setBackgroundColor(0xffffff);else bt5.setBackgroundColor(0x00000);

          Toast.makeText(MyService.myctx,
                              ge+whichColor,
                               9000)
                    .show();

}
});
bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
if(modifier.isChecked()){
if(!started){
myTurn = true;
 Toast.makeText(MyService.myctx,"start monitoring",Toast.LENGTH_LONG).show();
scheduledFuture = executor.scheduleAtFixedRate(myTask, 0, 2000, TimeUnit.MILLISECONDS);


  //myTimer.scheduleAtFixedRate(myTask, 0, 2000);
started = true;
}else{
//myTask.cancel();
//myTimer.cancel();
 Toast.makeText(MyService.myctx,"stop monitoring",Toast.LENGTH_LONG).show();
scheduledFuture.cancel(true);
started = false;
}
            Log.e(TAG, "sendReport2");
/*
mHidDevice.sendReport(mDevice, (byte) 0x01, new byte[]{1, 0, 0, 0});
mHidDevice.sendReport(mDevice, (byte) 0x01, new byte[]{0, 0, 0, 0});
*/

return;
//0913
}
        if(socketDataReceiver == null){
        socketDataReceiver = new SocketDataReceiver();
        LocalBroadcastManager.getInstance(myctx).registerReceiver(
                socketDataReceiver, new IntentFilter(MyService.SOCKET_DATA_RECEIVED));
}
Thread thread = new Thread(new Runnable() {                                                                                                   @Override                                                            public void run() {
try{
Interpreter.Options options = new Interpreter.Options();
    options.setNumThreads(4);
interpreter = new Interpreter(loadModelFile(),options);
MyService.sc = new Socket(ip3,22223);
//MyService.sc = new Socket(ip2,40081);
       mConnectedThread3 = new ConnectedThread2(MyService.sc);
       mConnectedThread3.start();
}catch(Exception e){
}

}
});

thread.start();
}
});
bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
if(modifier.isChecked()){
            Log.e(TAG, "sendReport");
try{
//mHidDevice.sendReport(mDevice, (byte) 0x01, new byte[]{0,(byte)0xff,(byte)0x01,(byte)0xff, (byte)0x01, 0,0});
short x = -440;
short y = -358;
            //Log.d("wtuih JSON String", x + "  " + y);
//mHidDevice.sendReport(mDevice, (byte) 0x01, new byte[]{0,(byte)(x & 0xff),(byte)((x>>8) & 0xff),(byte)(y & 0xff),(byte)((y >>8) & 0xff), 0,0});
/*
mHidDevice.sendReport(mDevice, (byte) 0x01, new byte[]{0,(byte)(x & 0xff),(byte)((x>>8) & 0xff),(byte)(y & 0xff),(byte)((y >>8) & 0xff), 0,0});
Thread.sleep(200);
mHidDevice.sendReport(mDevice, (byte) 0x01, new byte[]{1,0,0,0,0, 0,0});
Thread.sleep(200);
mHidDevice.sendReport(mDevice, (byte) 0x01, new byte[]{0,0,0,0,0, 0,0});
Thread.sleep(200);
mHidDevice.sendReport(mDevice, (byte) 0x01, new byte[]{1,0,0,0,0, 0,0});
Thread.sleep(200);
mHidDevice.sendReport(mDevice, (byte) 0x01, new byte[]{0,0,0,0,0, 0,0});
Thread.sleep(200);
x =(short)-x;y=(short)-y;
mHidDevice.sendReport(mDevice, (byte) 0x01, new byte[]{0,(byte)(x & 0xff),(byte)((x>>8) & 0xff),(byte)(y & 0xff),(byte)((y >>8) & 0xff), 0,0});
*/
enqueue((byte) 0x01, new byte[]{0,(byte)(x & 0xff),(byte)((x>>8) & 0xff),(byte)(y & 0xff),(byte)((y >>8) & 0xff), 0,0});
enqueue((byte) 0x01, new byte[]{1,0,0,0,0, 0,0});
enqueue((byte) 0x01, new byte[]{0,0,0,0,0, 0,0});
enqueue((byte) 0x01, new byte[]{1,0,0,0,0, 0,0});
enqueue((byte) 0x01, new byte[]{0,0,0,0,0, 0,0});
x = (short)-x;y=(short)-y;
enqueue((byte) 0x01, new byte[]{0,(byte)(x & 0xff),(byte)((x>>8) & 0xff),(byte)(y & 0xff),(byte)((y >>8) & 0xff), 0,0});
}catch(Throwable e){
            Log.e("wtuih JSON String", e.getMessage()+"  zzzsendreport");
}
return;
//0913
}
try{
if (MyService.data0 == null) {
//if (true) {
    Log.d("TAG", "basicSetup: Asking permission again");
    //open app again
Intent dialogIntent = new Intent(MyService.this, myScreenshot.class);
      dialogIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
      startActivity(dialogIntent);
} else {
    Log.d("TAG", "basicSetup: Getting permission for the object");
    //readPermissionObject();
/*
Intent data1 =(Intent)data0.clone();
myScreenshot msh = new myScreenshot();
msh.init2();
msh.launch(Activity.RESULT_OK,data1);
*/
/*
Intent data1 =(Intent)data0.clone();
myScreenshot msh = new myScreenshot(data1);
msh.getPathScreenShot2("yyy");
*/
if (mediaProjection == null){
mImageReader = ImageReader.newInstance( DISPLAY_WIDTH, DISPLAY_HEIGHT, PixelFormat.RGBA_8888, 2);
Intent data1 =(Intent)data0.clone();
mediaProjectionManager  = (MediaProjectionManager) getSystemService(Context.MEDIA_PROJECTION_SERVICE);
        mediaProjection = mediaProjectionManager.getMediaProjection(Activity.RESULT_OK,data1);
        virtualDisplay = mediaProjection.createVirtualDisplay("MainActivity", DISPLAY_WIDTH, DISPLAY_HEIGHT, mScreenDensity, DisplayManager.VIRTUAL_DISPLAY_FLAG_AUTO_MIRROR,
                mImageReader.getSurface(), null, null);
}
/*
                        floatWindowLayoutParam2.x = 900;
                        floatWindowLayoutParam2.y = 900;
  
                        // updated parameter is applied to the WindowManager
                        windowManager.updateViewLayout(floatView2, floatWindowLayoutParam2);
*/
Image image = null;
try{
image = mImageReader.acquireLatestImage();
if (image == null){
 Toast.makeText(MyService.myctx,"image == null",Toast.LENGTH_LONG).show();
return;
}
}catch(Exception e){
 Toast.makeText(MyService.myctx,"nullhi",Toast.LENGTH_LONG).show();
return;
//            myScreenshot.this.stopService(new Intent(myScreenshot.this, MyService.class));
}
myTurn = false;
final Image.Plane[] planes = image.getPlanes();
final ByteBuffer buffer = planes[0].getBuffer();
int offset = 0;
int pixelStride = planes[0].getPixelStride();
int rowStride = planes[0].getRowStride();
int rowPadding = rowStride - pixelStride * DISPLAY_WIDTH;
byte[] data = new byte[buffer.capacity()];
((ByteBuffer) buffer.duplicate().clear()).get(data);
//Mat mat = new Mat(DISPLAY_WIDTH+rowPadding/pixelStride,DISPLAY_HEIGHT, CvType.CV_8UC4);
Mat mat = new Mat(DISPLAY_HEIGHT,DISPLAY_WIDTH+rowPadding/pixelStride, CvType.CV_8UC4);
mat.put(0, 0, data);
/*
//Mat mat2 = new Mat(DISPLAY_WIDTH+rowPadding/pixelStride,DISPLAY_HEIGHT, CvType.CV_8UC4);
//Mat mat2 = new Mat(DISPLAY_WIDTH,DISPLAY_HEIGHT, CvType.CV_8UC4);
Mat mat2 = new Mat(DISPLAY_HEIGHT,DISPLAY_WIDTH+rowPadding/pixelStride, CvType.CV_8UC4);
int ch[]={2,0,1,1,0,2,3,3};
//int ch[]={3,0,0,1,1,2,2,3};
List<Mat> grayO=new ArrayList<Mat>();
        List<Mat> timing1=new ArrayList<Mat>();
        timing1.add(0,mat);
        grayO.add(0,mat2);

            MatOfInt fromto = new MatOfInt(ch);
            Core.mixChannels(timing1, grayO, fromto); // Getting Exception here
*/
Mat dst_mat = new Mat();
//Imgproc.cvtColor(grayO.get(0), dst_mat, Imgproc.COLOR_BGRA2BGR);
Rect roiRect2 = new Rect(0,0,DISPLAY_WIDTH,DISPLAY_HEIGHT);
Mat mat3 = new Mat(mat,roiRect2);
Imgproc.cvtColor(mat3, dst_mat, Imgproc.COLOR_RGBA2BGR);
//Imgproc.cvtColor(mat3, dst_mat, Imgproc.COLOR_RGBA2RGB);

// create bitmap
//Bitmap bmp = Bitmap.createBitmap(DISPLAY_WIDTH+rowPadding/pixelStride,DISPLAY_HEIGHT, Bitmap.Config.ARGB_8888);
//bmp.copyPixelsFromBuffer(buffer);
image.close();
//return dst_mat;
      Imgcodecs imageCodecs = new Imgcodecs(); 
 Toast.makeText(MyService.myctx,"hi",Toast.LENGTH_LONG).show();
//try{
        String file4 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + new StringBuilder("/ssgf3").append(".jpg").toString();
        //File file3 = new File(file2);
      //Mat dest2 = imageCodecs.imread(file4);
      Mat dest333 = imageCodecs.imread(file4);
      Mat dest2 = new Mat();
dst_mat.convertTo(dest2, CvType.CV_32FC3, 1.0/255, 0);
//dst_mat.convertTo(dest2, CvType.CV_32FC3);
//dest333.convertTo(dest2, CvType.CV_32FC3);
//dest333.convertTo(dest2, CvType.CV_32FC3, 1.0/255, 0);
      //Mat dest2 = mat;
      //Mat dest2 = imageCodecs.imread(file4,Imgcodecs.IMREAD_UNCHANGED);
//(x,y),(x2,y2)=(77,230), (1328,1481)
//int x = 77;int y = 230;int x2 = 1328;int y2 =1481;
int x = 43;int y = 243;int x2 = 1360;int y2 =1560;
float l = (x2-x)/36;int l2 = (int)(2*l);
ArrayList<float[]> myArray = new ArrayList<float[]>();
//double[][][][][] fuck = new double[19][19][l2][l2][3];
float[][][][][] fuck = new float[1][19*19][l2][l2][3];
ByteBuffer vbb = ByteBuffer.allocateDirect(19*19*l2*l2*3 * 4); 
vbb.order(ByteOrder.nativeOrder());    // use the device hardware's native byte order
FloatBuffer input = vbb.asFloatBuffer();
//FloatBuffer input = FloatBuffer.allocate(19*19*l2*l2*3);
float[] saran =new float[19*1*l2*l2*3];
//Mat m = new Mat();
for (int ii = 0;ii < 19;ii++){
for (int ii2 = 0;ii2 < 19;ii2++){
Rect roiRect = new Rect(x+(int)((ii2*2-1)*(x2-x)/36),y+(int)((ii*2-1)*(x2-x)/36),l2,l2);
//Rect roiRect = new Rect(x+(int)((ii2*2-1)*(x2-x)/36),y+(int)((ii*2-1)*(x2-x)/36),l2+1,l2+1);
Mat dest33 = new Mat(dest2,roiRect);
float[] dest3 = new float[l2*l2*3];
//float[] dest3 = new float[(l2+1)*(l2+1)*3];
//dest33.put(0,0,dest3);
//maybe you only get pixels of one point,so it is wrong here
dest33.get(0,0,dest3);
input.put(dest3);
/*
for (int t =0;t<l2;t++){
for (int t2 =0;t2<l2;t2++){
for (int t3 =0;t3<3;t3++){
fuck[ii][ii2][t][t2][t3]=dest33.get(t2,t)[t3];
//fuck[ii][ii2][t][t2][t3]=(float)dest33.get(t2,t)[t3]/255;
//fuck[ii][ii2][t][t2][t3]=dest3[t3+t2*73+t*73*73];

}
}
}
*/
//dest2.get(x+(int)(ii2*2*l-l),y+(int)(ii*2*l-l),dest3);
//myArray.add(dest3);
//m.push_back(dest33);
}

}
/*
for (int ii = 0;ii < 19;ii++){
for (int ii2 = 0;ii2 < 19;ii2++){
for (int t =0;t<l2;t++){
for (int t2 =0;t2<l2;t2++){
for (int t3 =0;t3<3;t3++){
fuck[0][ii*19+ii2][t][t2][t3]=input.get(t3+t2*3+t*l2*3+ii2*3*l2*l2+ii2*3*l2*l2*19);
}
}
}
}

}
*/
//Mat m2 = m.reshape(0,73*19);
//float[][][][] fuck2 = new float[1][l2][l2][3];
//fuck2[0] = fuck[0][0];
//float[] output = new float[3];
//float[][] output = new float[19][3];
float[][] output = new float[19*19][3];
//float[][] output = new float[1][3];
//Map<Integer, Object> outputs = new HashMap<>();
            Map<String, Object> outputs = new HashMap<>();

//Map<String, Object> inputs = new HashMap<>();
  //          inputs.put("conv2d_input", fuck2);

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
interpreter.resizeInput(0, new int[]{19*19,l2,l2,3});
interpreter.allocateTensors();
//do i need set the buffer possition
input.position(0);
interpreter.run(input, output);
//interpreter.run(fuck[0], output);
//interpreter.run(myArray.toArray(new <float[][][]>[0])[0], output);
//interpreter.run(myArray.toArray(new float[19][19][73][73][3])[0], output);
            	    //tv.setText( Float.toString(((float[])outputs.get("dense_1"))[0]));
//tv.setText(Arrays.toString(classify(output)));
/*
OutputStream out2 = photoSocket.getOutputStream();
//DataOutputStream dos = new DataOutputStream(out);

byte[] byteArray2 = ByteBuffer.allocate(byteArray.length+4).putInt(byteArray.length).put(byteArray).array();
//byte[] byteArray2 = ByteBuffer.wrap(byteArray).order(ByteOrder.BIG_ENDIAN).putInt(byteArray.length,0).array();
//dos.writeInt(byteArray.length);
out2.write(byteArray2);
*/

 Toast.makeText(MyService.myctx,classify(output),Toast.LENGTH_LONG).show();
 //Toast.makeText(MyService.myctx,Arrays.toString(classify(output))+Arrays.toString(output[10]),Toast.LENGTH_LONG).show();
byte[] byteArray = classify(output).getBytes("UTF-8");
//byte[] byteArray = Arrays.toString(classify(output)).getBytes("UTF-8");
byte[] byteArray2 = ByteBuffer.allocate(byteArray.length+4).putInt(byteArray.length).put(byteArray).array();
Thread thread = new Thread(new Runnable() {
    public void run() {
        // do something...              
mConnectedThread3.write(byteArray2);
    }
});
thread.start();

/*
float[] data2 = input.array();
Mat mat4 = new Mat(l2*19, l2, CvType.CV_32FC3);
mat4.put(0, 0, data2);
        String file2 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + new StringBuilder("qwer").append(".png").toString();
      imageCodecs.imwrite(file2,mat4);
*/
// create bitmap
/*
Bitmap bmp = Bitmap.createBitmap(DISPLAY_WIDTH+rowPadding/pixelStride,DISPLAY_HEIGHT, Bitmap.Config.ARGB_8888);
bmp.copyPixelsFromBuffer(buffer);
image.close();
*/
/*
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
        String myPath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + new StringBuilder("/screenshot").append(".bmp").toString();

        File myDir = new File(myPath);
        myDir.mkdirs();
        Random generator = new Random();
        int n = 10000;
        n = generator.nextInt(n);
        String fname = "Image-" + n+"-"+Integer.toString(DISPLAY_HEIGHT)+"-"+Integer.toString(DISPLAY_WIDTH) + ".jpg";
        File file = new File(myDir, fname);
        Log.i("TAG", "" + myDir);
        //if (myDir.exists())
          //  myDir.delete();
        try {
            FileOutputStream out = new FileOutputStream(file);
            bmp.compress(Bitmap.CompressFormat.JPEG, 90, out);
            out.flush();
            out.close();
        } catch (Exception e) {
            //myScreenshot.this.stopService(new Intent(myScreenshot.this, MyService.class));
            e.printStackTrace();
        }
                    }
                }, 5000);
*/

}
}catch(Throwable e){
data0 = null;
StringWriter errors = new StringWriter();
e.printStackTrace(new PrintWriter(errors));
//return errors.toString();
          Toast.makeText(MyService.myctx,
                              errors.toString()+":e:"+ e.getMessage(),
                               Toast.LENGTH_LONG)
                    .show();
try{
/*
PrintWriter out = new PrintWriter(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) +"filename.txt");
out.println(errors.toString()+":e:" e.getMessage());
*/
}catch(Exception ei){}
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "imagereaderToMatError.txt");
        try {
            FileOutputStream out = new FileOutputStream(file);
out.write( (errors.toString()+":e:" +e.getMessage()).getBytes());
            out.close();
        } catch (Exception ei) {
            e.printStackTrace();
} finally {
            //out.flush();
            //out.close();
}
}
//takeScreenshot();
//MainActivity4Kt.screenshot();
            }
        });
  
myctx = this;
        if(socketDataReceiver == null){
        socketDataReceiver = new SocketDataReceiver();
        LocalBroadcastManager.getInstance(myctx).registerReceiver(
                socketDataReceiver, new IntentFilter(MyService.SOCKET_DATA_RECEIVED));
}
Thread thread = new Thread(new Runnable() {                                                                                                   @Override                                                            public void run() {
        try  {                                                       
socket4 = new Socket(ip2,32007);
socket4.setKeepAlive(true);
//socket4.setSoTimeout(6000);
       mConnectedThread2 = new ConnectedThread2(MyService.socket4);
       mConnectedThread2.start();
lastMessageTimestamp = System.currentTimeMillis();
        } catch (Exception e) {                                                  e.printStackTrace();
        }                                                                }
});                                                                  
thread.start();
//118
        Log.d(TAG, "Inside onCreate() API");
/*
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);
            mBuilder.setSmallIcon(R.drawable.ic_launcher);
            mBuilder.setContentTitle("Notification Alert, Click Me!");
            mBuilder.setContentText("Hi, This is Android Notification Detail!");
            NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

            // notificationID allows you to update the notification later on.
            mNotificationManager.notify(100, mBuilder.build());
            startForeground(100, mBuilder.mNotification);
*/
//isSuspended = 0;
sharedPreferences = myctx.getSharedPreferences("myprefs",Context.MODE_PRIVATE);
editor = sharedPreferences.edit();
//SharedPreferences.Editor editor = myctx.getSharedPreferences("myprefs",Context.MODE_PRIVATE).edit();
        isSuspended = sharedPreferences.getInt("isSuspended", 0);
//Toast.makeText(this, "vStringii",Toast.LENGTH_LONG).show();
            IntentFilter filter2=new IntentFilter();
            filter2.addAction(Intent.ACTION_POWER_CONNECTED);
            filter2.addAction(Intent.ACTION_POWER_DISCONNECTED);
            //filter1.addAction(Intent.ACTION_INPUT_METHOD_CHANGED);
            filter1.addAction(Intent.ACTION_BATTERY_CHANGED);
            registerReceiver(myBroadcastReceiver,filter1);
            registerReceiver(myBroadcastReceiver2,filter2);
 //       }
    }


    @Override
    public int onStartCommand(Intent resultIntent, int resultCode, int startId) {
        Log.d(TAG, "inside onStartCommand() API");
//118
ScheduledExecutorService ses = Executors.newScheduledThreadPool(5);
checker = new TimeoutChecker(getApplicationContext());
//new Thread (checker, "Thread 1").start();
  // schedule the task to run on every 1 second.
  ses.scheduleAtFixedRate(checker, 20, 20,TimeUnit.SECONDS);
/*
        return startId;
*/
/*
Handler handler = new Handler(Looper.getMainLooper());
handler.post(new Runnable(){
@Override
public void run(){
 Toast.makeText(getApplicationContext(),"your   message",Toast.LENGTH_LONG).show();
 }
});
*/
//Toast.makeText(this, "vString",Toast.LENGTH_LONG).show();
   //     return startId;
try {
final String CHANNELID = "Foreground Service ID";
if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
     NotificationChannel channel = new NotificationChannel(
             CHANNELID,
             CHANNELID,
             NotificationManager.IMPORTANCE_LOW
     );

     getSystemService(NotificationManager.class).createNotificationChannel(channel);
     Notification.Builder notification = new Notification.Builder(this, CHANNELID)
             .setContentText("Service is running")
             .setContentTitle("Service enabled")
             .setSmallIcon(R.mipmap.ic_launcher5);
     startForeground(1001, notification.build());
}else{
     NotificationCompat.Builder notification = new NotificationCompat.Builder(this)
             .setContentText("Service is running")
             .setContentTitle("Service enabled")
             .setSmallIcon(R.mipmap.ic_launcher5);
     startForeground(1001, notification.build());
}

    } catch (Exception e) {
        e.printStackTrace();
Toast.makeText(this, "ii",Toast.LENGTH_LONG).show();
    }
     return super.onStartCommand( resultIntent, resultCode, startId);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
Log.d(TAG, "inside onDestroy() API");
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO Auto-generated method stub
        return null;
    }

       BroadcastReceiver myBroadcastReceiver2 =new BroadcastReceiver() {
            @Override
            public void onReceive(Context context2, Intent intent2) {
                // call your method
if(intent2.getAction() == Intent.ACTION_POWER_CONNECTED) {
        //Toast.makeText(context2, "isCharging:  + true", Toast.LENGTH_LONG).show();
showToast("isCharging true",context2);
      //      registerReceiver(myBroadcastReceiver,filter1);
/*
PowerManager powerManager = (PowerManager) getSystemService(POWER_SERVICE);
wakeLock = powerManager.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK,
        "MyApp::MyWakelockTag");
wakeLock.acquire();
*/
playAudio(context2);
    } else if(intent2.getAction() == Intent.ACTION_POWER_DISCONNECTED){
       // Toast.makeText(context2, "isCharging:  + false", Toast.LENGTH_LONG).show();
showToast("isCharging false",context2);
           // unregisterReceiver(myBroadcastReceiver);
//wakeLock.release();
    }
            }
        };
       BroadcastReceiver myBroadcastReceiver =new BroadcastReceiver() {
            @Override
            public void onReceive(Context context2, Intent intent2) {
                // call your method
//Intent intent2 = registerReceiver(null, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
        int level = intent2.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
        int scale = intent2.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
int temp = intent2.getIntExtra(BatteryManager.EXTRA_TEMPERATURE, -1);
        float batteryPct = level/(float)scale;       
//Toast.makeText(context2, String.valueOf(batteryPct),Toast.LENGTH_LONG).show();
battery2 = String.valueOf(batteryPct) + " " + String.valueOf(temp);
showToast(String.valueOf(batteryPct),context2);
if(isSuspended == 0 && Float.compare(batteryPct, 0.80f) >= 0 ){
MainActivity.sudo("echo \"1\" > /sys/class/power_supply/battery/input_suspend");
isSuspended = 1;
editor.putInt("isSuspended", 1);
editor.commit();
Toast.makeText(context2, "checked",Toast.LENGTH_LONG).show();
}
else if(isSuspended == 1 && Float.compare(batteryPct, 0.60f) <= 0 ){
MainActivity.sudo("echo \"0\" > /sys/class/power_supply/battery/input_suspend");
isSuspended = 0;
editor.putInt("isSuspended", 0);
editor.commit();
Toast.makeText(context2, "unchecked",Toast.LENGTH_LONG).show();
}
if(Float.compare(batteryPct, 0.15f) <= 0){
    final long pastTime = System.currentTimeMillis() - lastPlayTime;
    if(pastTime > 3600000L ){

        lastPlayTime = System.currentTimeMillis();
playAudio(context2);

     }
}
            }
        };
}
