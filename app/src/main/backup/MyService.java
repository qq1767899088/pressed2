package com.example.myapplication_;
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
Interpreter interpreter;
    public static volatile Socket sc;
    public static volatile String ge ="oh";
    public static Bitmap bitmap0;
ImageReader mImageReader;
    private static final int videoTime = 5000;
    private static final int REQUEST_CODE = 1000;
    private static final int REQUEST_PERMISSION = 1000;
    private static final SparseIntArray ORIENTATION = new SparseIntArray();
    private MediaProjectionManager mediaProjectionManager;
    private MediaProjection mediaProjection;
    private VirtualDisplay virtualDisplay;
    public static int mScreenDensity;
    public static int DISPLAY_WIDTH = 720;
    public static int DISPLAY_HEIGHT = 1280;
public static Intent data0 = null;  //declaration
public static Context myctx;
    static final String SOCKET_DATA_RECEIVED = "com.your.package.SOCKET_DATA_RECEIVED";
    static final String SOCKET_DATA_IDENTIFIER = "com.your.package.SOCKET_DATA";
   public static ConnectedThread2 mConnectedThread2;
   public static ConnectedThread2 mConnectedThread3;
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
           byte[] mmBuffer = new byte[1024];
           int numBytes = 0; // bytes returned from read()
while(true){
        try  { 
	globalI++;
        Intent intent = new Intent(SOCKET_DATA_RECEIVED);
        intent.putExtra(SOCKET_DATA_IDENTIFIER, "connecting"+Integer.toString(globalI)); // store data in your intent
       // intent.putExtra(SOCKET_DATA_IDENTIFIER, Integer.toString(numBytes)); // store data in your intent
        // send data to registered receivers
        LocalBroadcastManager.getInstance(myctx).sendBroadcast(intent);
socket4.close();
socket4 = null;
socket4 = new Socket("202.5.19.254",32007);
socket4.setKeepAlive(true);
//socket4.getOutputStream().write("isConnected".getBytes("UTF-8"));
InputStream mmInStream =socket4.getInputStream();
if(mmInStream.read(mmBuffer,0,4)==-1){
try{
Thread.sleep(20000);
continue;
        } catch (Exception ee) {                                
                  ee.printStackTrace();
                                                                        }
}
mmInStream.read(mmBuffer,0,4);
int k = ByteBuffer.wrap(mmBuffer).order(ByteOrder.BIG_ENDIAN).getInt();
     while (k > 0) {
numBytes = mmInStream.read(mmBuffer);
k = k - numBytes;
      }

//socket4.setSoTimeout(2000);
       mConnectedThread2 = new ConnectedThread2(MyService.socket4);
       mConnectedThread2.start();
        intent.putExtra(SOCKET_DATA_IDENTIFIER, "connected"+Integer.toString(globalI)); // store data in your intent
       // intent.putExtra(SOCKET_DATA_IDENTIFIER, Integer.toString(numBytes)); // store data in your intent
        // send data to registered receivers
        LocalBroadcastManager.getInstance(myctx).sendBroadcast(intent);
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
        //intent.putExtra(SOCKET_DATA_IDENTIFIER, Integer.toString(check) +"+"+Integer.toString(globalI) + mmBuffer2); // store data in your intent
        intent.putExtra(SOCKET_DATA_IDENTIFIER,  mmBuffer2); // store data in your intent
       // intent.putExtra(SOCKET_DATA_IDENTIFIER, Integer.toString(numBytes)); // store data in your intent
        // send data to registered receivers
        LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);
               //} catch (IOException | InterruptedException e ) {
               } catch (IOException e ) {
                   Log.d(TAG, "Input stream was disconnected", e);
                   break;
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
    private int LAYOUT_TYPE;
    private WindowManager.LayoutParams floatWindowLayoutParam;
    private WindowManager windowManager;
private Button maximizeBtn;
  
    // As FloatingWindowGFG inherits Service class, 
    // it actually overrides the onBind method

private MappedByteBuffer loadModelFile() throws IOException
{
AssetFileDescriptor assetFileDescriptor = this.getAssets().openFd("linear.tflite");
FileInputStream fileInputStream = new FileInputStream(assetFileDescriptor.getFileDescriptor());
FileChannel fileChannel = fileInputStream.getChannel();

long startOffset = assetFileDescriptor.getStartOffset();
long len = assetFileDescriptor.getLength();

return fileChannel.map(FileChannel.MapMode.READ_ONLY,startOffset,len);
}
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
            LAYOUT_TYPE = WindowManager.LayoutParams.TYPE_TOAST;
        }
floatWindowLayoutParam = new WindowManager.LayoutParams(
                (int) (width * (0.3f)),
                (int) (height * (0.1f)),
                LAYOUT_TYPE,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
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
maximizeBtn = floatView.findViewById(R.id.addscore);
Button bt2 = floatView.findViewById(R.id.addscore2);
Button bt3 = floatView.findViewById(R.id.bluetooth);
Button bt4 = floatView.findViewById(R.id.bluetooth2);
  
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
                // stopSelf() method is used to stop the service if
                // it was previously started
                stopSelf();
                  
                // The window is removed from the screen
                windowManager.removeView(floatView);
            }
        });
bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

          Toast.makeText(MyService.myctx,
                              ge,
                               9000)
                    .show();

}
});
bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
Thread thread = new Thread(new Runnable() {                                                                                                   @Override                                                            public void run() {
try{
MyService.sc = new Socket("202.5.19.254",40081);
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
//if (MyService.data0 == null) {
if (true) {
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
mImageReader = ImageReader.newInstance( 1404,1777, PixelFormat.RGBA_8888, 2);
Intent data1 =(Intent)data0.clone();
mediaProjectionManager  = (MediaProjectionManager) getSystemService(Context.MEDIA_PROJECTION_SERVICE);
        mediaProjection = mediaProjectionManager.getMediaProjection(Activity.RESULT_OK,data1);
        mediaProjection.createVirtualDisplay("MainActivity", DISPLAY_WIDTH, DISPLAY_HEIGHT, mScreenDensity, DisplayManager.VIRTUAL_DISPLAY_FLAG_AUTO_MIRROR,
                mImageReader.getSurface(), null, null);
Image image = null;
try{
image = mImageReader.acquireLatestImage();
}catch(Exception e){
//            myScreenshot.this.stopService(new Intent(myScreenshot.this, MyService.class));
}
final Image.Plane[] planes = image.getPlanes();
final ByteBuffer buffer = planes[0].getBuffer();
int offset = 0;
int pixelStride = planes[0].getPixelStride();
int rowStride = planes[0].getRowStride();
int rowPadding = rowStride - pixelStride * DISPLAY_WIDTH;
// create bitmap
Bitmap bmp = Bitmap.createBitmap(DISPLAY_WIDTH+rowPadding/pixelStride,DISPLAY_HEIGHT, Bitmap.Config.ARGB_8888);
bmp.copyPixelsFromBuffer(buffer);
image.close();
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
//takeScreenshot();
//MainActivity4Kt.screenshot();
            }
        });
  
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
    if(pastTime > 3600000L ){

        lastPlayTime = System.currentTimeMillis();
playAudio(context2);

     }
}
            }
        };
}
