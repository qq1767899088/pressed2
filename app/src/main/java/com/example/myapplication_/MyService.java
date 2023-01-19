package com.example.myapplication_;
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
Context myctx;
    static final String SOCKET_DATA_RECEIVED = "com.your.package.SOCKET_DATA_RECEIVED";
    static final String SOCKET_DATA_IDENTIFIER = "com.your.package.SOCKET_DATA";
   public static ConnectedThread2 mConnectedThread2;
public static Socket socket4;
    private String TAG = this.getClass().getSimpleName();
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
if (true){
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
while(true){
        try  { 
socket4.close();
socket4 = new Socket("202.5.19.254",32007);
socket4.setKeepAlive(true);
//socket4.setSoTimeout(2000);
       mConnectedThread2 = new ConnectedThread2(MyService.socket4);
       mConnectedThread2.start();
break;
        } catch (IOException e) {   
try{
Thread.sleep(20000);
continue;
        } catch (Exception ee) {                                
                  ee.printStackTrace();
                                                                        }
        }       
         catch (Exception e) {   
e.printStackTrace();
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

   public class ConnectedThread2 extends Thread {
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
globalI++;
//TimeUnit.SECONDS.sleep(15);
//Thread.sleep(15000);
int check = mmInStream.read(mmBuffer,0,4);
if(check == -1){
break;
}
int isData = ByteBuffer.wrap(mmBuffer).order(ByteOrder.BIG_ENDIAN).getInt();
/*
*/
mmInStream.read(mmBuffer,0,4);
//mmInStream.read(mmBuffer,0,4);
int k = ByteBuffer.wrap(mmBuffer).order(ByteOrder.BIG_ENDIAN).getInt();
      StringBuilder sb = new StringBuilder();
byte[] allByteArray = new byte[k];

ByteBuffer buff = ByteBuffer.wrap(allByteArray);

     while (k > 0) {
numBytes = mmInStream.read(mmBuffer);
k = k - numBytes;
//         sb.append(new String(mmBuffer,0,numBytes));
buff.put(mmBuffer,0,numBytes);
      }
lastMessageTimestamp = System.currentTimeMillis();
if(isData != 1){
continue;
}
                   // Read from the InputStream.
byte[] combined = buff.array();
//numBytes = mmInStream.read(mmBuffer);
//		   String mmBuffer2 = new String(mmBuffer,0,numBytes);
		   String mmBuffer2 = new String(combined);
//		   String mmBuffer2 = sb.toString();
                   // Send the obtained bytes to the UI activity.
        Intent intent = new Intent(SOCKET_DATA_RECEIVED);
        intent.putExtra(SOCKET_DATA_IDENTIFIER, Integer.toString(check) +"+"+Integer.toString(globalI) + mmBuffer2); // store data in your intent
       // intent.putExtra(SOCKET_DATA_IDENTIFIER, Integer.toString(numBytes)); // store data in your intent
        // send data to registered receivers
        LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);
               //} catch (IOException | InterruptedException e ) {
               } catch (IOException e ) {
                   Log.d(TAG, "Input stream was disconnected", e);
                  // break;
//return;
               }
           }
       }

       // Call this from the main activity to send data to the remote device.
       public void write(byte[] bytes) {
           try {
               mmOutStream.write(bytes);

               // Share the sent message with the UI activity.
           } catch (IOException e) {
               Log.e(TAG, "Error occurred when sending data", e);

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
String fileName = "123.mp3";
 String baseDir = Environment.getExternalStorageDirectory().getAbsolutePath();
 String pathDir = baseDir + "/aaa/bbb/";

 File f = new File(pathDir + File.separator + fileName);
MediaPlayer mpintro;

    try {
mpintro = MediaPlayer.create(context2, Uri.parse(Environment.getExternalStorageDirectory().getPath()+ "/123.mp3"));
mpintro.setLooping(false);
        mpintro.start();
    } catch (Exception e) {
        e.printStackTrace();
Toast.makeText(context2, baseDir + File.separator + fileName,Toast.LENGTH_LONG).show();
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

    @Override
    public void onCreate() {
myctx = this;
Thread thread = new Thread(new Runnable() {                                                                                                   @Override                                                            public void run() {
        try  {                                                       
socket4 = new Socket("202.5.19.254",32007);
socket4.setKeepAlive(true);
//socket4.setSoTimeout(2000);
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
isSuspended = 0;
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
PowerManager powerManager = (PowerManager) getSystemService(POWER_SERVICE);
wakeLock = powerManager.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK,
        "MyApp::MyWakelockTag");
wakeLock.acquire();
playAudio(context2);
    } else if(intent2.getAction() == Intent.ACTION_POWER_DISCONNECTED){
       // Toast.makeText(context2, "isCharging:  + false", Toast.LENGTH_LONG).show();
showToast("isCharging false",context2);
           // unregisterReceiver(myBroadcastReceiver);
wakeLock.release();
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
        float batteryPct = level/(float)scale;       
//Toast.makeText(context2, String.valueOf(batteryPct),Toast.LENGTH_LONG).show();
showToast(String.valueOf(batteryPct),context2);
if(isSuspended == 0 && Float.compare(batteryPct, 0.80f) >= 0 ){
MainActivity.sudo("echo \"1\" > /sys/class/power_supply/battery/input_suspend");
isSuspended = 1;
Toast.makeText(context2, "checked",Toast.LENGTH_LONG).show();
}
else if(isSuspended == 1 && Float.compare(batteryPct, 0.60f) <= 0 ){
MainActivity.sudo("echo \"0\" > /sys/class/power_supply/battery/input_suspend");
isSuspended = 0;
Toast.makeText(context2, "unchecked",Toast.LENGTH_LONG).show();
}
if(Float.compare(batteryPct, 0.15f) <= 0){
    final long pastTime = System.currentTimeMillis() - lastPlayTime;
    if(pastTime > 600000L ){

        lastPlayTime = System.currentTimeMillis();
playAudio(context2);

     }
}
            }
        };
}
