package com.example.myapplication_;
import android.bluetooth.BluetoothAdapter;
import org.opencv.imgproc.Imgproc;
import org.opencv.core.MatOfInt;
import java.io.StringWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.lang.Float;
import java.lang.Double;
import java.io.FileInputStream;
import android.content.res.AssetFileDescriptor;
import org.tensorflow.lite.Interpreter;
///import java.io.FileInputStream;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import org.opencv.core.CvType;
import org.opencv.core.Rect;
import org.opencv.android.Utils;
import org.opencv.core.Core; 
import org.opencv.core.Mat;  
import org.opencv.imgcodecs.Imgcodecs;
import java.io.ByteArrayOutputStream;
import java.nio.ByteOrder;
import java.nio.ByteBuffer;
import java.io.OutputStream;
import java.io.DataOutputStream;
import java.net.Socket;
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
import android.os.Handler;
import android.widget.Toast;
import android.util.Log;
import android.app.ActivityManager;
import android.content.pm.PackageManager;
import android.media.MediaMetadataRetriever;
import android.Manifest;
import androidx.core.content.ContextCompat;
import android.content.Context;
import android.view.Surface;
import android.content.Intent;
import android.os.Bundle;
import android.media.MediaRecorder;
import androidx.annotation.RequiresApi;
import androidx.annotation.Nullable;
import android.hardware.display.VirtualDisplay;
import android.media.projection.MediaProjection;
import android.util.SparseIntArray;
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
import 	android.app.Activity;

public class myScreenshot extends Activity {
Interpreter interpreter;
int mWidth = 1024;
int mHeight = 1024;
ImageReader mImageReader;
    private static final int videoTime = 1000;
    private static final int rr = 1000;
    private static final int REQUEST_CODE = 1000;
    private static final int REQUEST_DISCOVERABLE = 1001;
    private static final int REQUEST_PERMISSION = 1000;
    private static final SparseIntArray ORIENTATION = new SparseIntArray();
    private MediaProjectionManager mediaProjectionManager;
    private MediaProjection mediaProjection;
    private VirtualDisplay virtualDisplay;
    private myScreenshot.MediaProjectionCallback mediaProjectionCallback;
    private MediaRecorder mediaRecorder;
    //PostWebAPIData postWebAPIData;
    private int mScreenDensity;
    private static int DISPLAY_WIDTH = 720;
    private static int DISPLAY_HEIGHT = 1280;

    static {
        ORIENTATION.append(Surface.ROTATION_0, 90);
        ORIENTATION.append(Surface.ROTATION_90, 0);
        ORIENTATION.append(Surface.ROTATION_180, 270);
        ORIENTATION.append(Surface.ROTATION_270, 180);
    }

    private String screenShotUri = "";

private void takeScreenshot() {
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

//        openScreenshot(imageFile);
    } catch (Throwable e) {
        // Several error may come out with file handling or DOM
        e.printStackTrace();
    }
}

public void launch(int resultCode,Intent data ){

        mediaProjectionCallback = new myScreenshot.MediaProjectionCallback();
        mediaProjection = mediaProjectionManager.getMediaProjection(resultCode, data);
        mediaProjection.registerCallback(mediaProjectionCallback, null);
        virtualDisplay = createVirtualDisplay2();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            getPathScreenShot2(screenShotUri);
                        }
                    }, rr);
}

void sendBitmap(Bitmap bitmap){
}
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
public static int[] classify(float[][] a){
int[] b = new int[a.length];
        for (int i = 0; i < a.length; i++) {
b[i] = argmax(a[i]);

        }
return b;

}

/*
    public myScreenshot(Intent myintent) {
        mScreenDensity = MyService.mScreenDensity;
        DISPLAY_HEIGHT = MyService.DISPLAY_HEIGHT;
        DISPLAY_WIDTH = MyService.DISPLAY_WIDTH;
mImageReader = ImageReader.newInstance( DISPLAY_WIDTH,DISPLAY_HEIGHT, PixelFormat.RGBA_8888, 2);

        mediaProjectionManager = (MediaProjectionManager) getSystemService(Context.MEDIA_PROJECTION_SERVICE);
        mediaProjection = mediaProjectionManager.getMediaProjection(Activity.RESULT_OK, myintent);
        mediaProjection.createVirtualDisplay("fuckMainActivity", DISPLAY_WIDTH, DISPLAY_HEIGHT, mScreenDensity, DisplayManager.VIRTUAL_DISPLAY_FLAG_AUTO_MIRROR,
                mImageReader.getSurface(), null, null);
    }
*/
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.myfloat);
//Toast.makeText(this, "vStringii",Toast.LENGTH_LONG).show();
//mImageReader = ImageReader.newInstance( 1404,1777, PixelFormat.RGBA_8888, 2);
        init();
            startActivityForResult(mediaProjectionManager.createScreenCaptureIntent(), REQUEST_CODE);
Intent discoverableIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
    startActivityForResult(discoverableIntent, REQUEST_DISCOVERABLE);
//takeScreenshot();
    }

    public void init2() {
        //Screen tracking Code Started here..............................
mImageReader = ImageReader.newInstance( 1404,1777, PixelFormat.RGBA_8888, 2);
        mScreenDensity = MyService.mScreenDensity;
        //postWebAPIData = new PostWebAPIData();
        DISPLAY_HEIGHT = MyService.DISPLAY_HEIGHT;
        DISPLAY_WIDTH = MyService.DISPLAY_WIDTH;
        mediaProjectionManager = (MediaProjectionManager) getSystemService(Context.MEDIA_PROJECTION_SERVICE);
            //Toast.makeText(myScreenshot.this, Integer.toString(123)(DISPLAY_HEIGHT), Toast.LENGTH_SHORT).show();

    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void init() {
        //Screen tracking Code Started here..............................
//mImageReader = ImageReader.newInstance( 1404,1777, ImageFormat.JPEG, 2);
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getRealMetrics(metrics);
        mScreenDensity = metrics.densityDpi;
        //postWebAPIData = new PostWebAPIData();
        DISPLAY_HEIGHT = metrics.heightPixels;
        DISPLAY_WIDTH = metrics.widthPixels;
mImageReader = ImageReader.newInstance( DISPLAY_WIDTH,DISPLAY_HEIGHT, PixelFormat.RGBA_8888, 2);
        MyService.mScreenDensity = metrics.densityDpi;
        //postWebAPIData = new PostWebAPIData();
        MyService.DISPLAY_HEIGHT = metrics.heightPixels;
        MyService.DISPLAY_WIDTH = metrics.widthPixels;
            //Toast.makeText(myScreenshot.this, Integer.toString(123)(DISPLAY_HEIGHT), Toast.LENGTH_SHORT).show();

        mediaRecorder = new MediaRecorder();
        mediaProjectionManager = (MediaProjectionManager) getSystemService(Context.MEDIA_PROJECTION_SERVICE);
/*
        if (ContextCompat.checkSelfPermission(myScreenshot.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                + ContextCompat.checkSelfPermission(myScreenshot.this, Manifest.permission.RECORD_AUDIO)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(myScreenshot.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) ||
                    ActivityCompat.shouldShowRequestPermissionRationale(myScreenshot.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            } else {
                ActivityCompat.requestPermissions(myScreenshot.this, new String[]{
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.RECORD_AUDIO
                }, REQUEST_PERMISSION);
            }
        } else {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    toogleScreenShare();
                }
            }, 500);
        }
*/
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void toogleScreenShare() {
        initRecorder();
        recordScreen();
    }


    public void getPathScreenShot2(String filePath) {
/*
        MediaMetadataRetriever med = new MediaMetadataRetriever();

        String myPath2 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + new StringBuilder("/123").append(".mp4").toString();
        med.setDataSource(myPath2);
*/
        //med.setDataSource(filePath);
//Thread thread = new Thread(new Runnable() {                                                                                                   @Override                                                            public void run() {
runOnUiThread(new Runnable() {                                                                                                   @Override                                                            public void run() {
Socket photoSocket =MyService.sc;
//Socket photoSocket =MyService.sc;
try{
/*
        Bitmap bmp = getImage();
MyService.bitmap0 = bmp;
Bitmap bitmap = MyService.bitmap0;
//photoSocket = new Socket("202.5.19.254",40081);
int size = bitmap.getRowBytes() * bitmap.getHeight();
ByteBuffer byteBuffer = ByteBuffer.allocate(size);
bitmap.copyPixelsToBuffer(byteBuffer);
///byte[] byteArray = byteBuffer.array();
byte[] byteArray = byteBuffer.array();
Mat mat = new Mat();    
Bitmap bmp32 = bitmap.copy(Bitmap.Config.ARGB_8888, true);
//Utils.bitmapToMat(bmp32, mat);
Utils.bitmapToMat(bitmap, mat);
Rect myRect = new Rect(60,60,200,200);
Mat dest = new Mat(mat,myRect);
*/
//Loading the OpenCV core library  
     // System.loadLibrary( Core.NATIVE_LIBRARY_NAME ); 
     
      //Instantiating the Imagecodecs class 
      Imgcodecs imageCodecs = new Imgcodecs(); 
 Toast.makeText(MyService.myctx,"hi",Toast.LENGTH_LONG).show();
//try{
        String file4 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + new StringBuilder("/ssgf3").append(".jpg").toString();
        //File file3 = new File(file2);
      //Mat dest2 = imageCodecs.imread(file4);
      Mat dest2 = getImage2();
      //Mat dest2 = mat;
      //Mat dest2 = imageCodecs.imread(file4,Imgcodecs.IMREAD_UNCHANGED);
//(x,y),(x2,y2)=(77,230), (1328,1481)
//int x = 77;int y = 230;int x2 = 1328;int y2 =1481;
int x = 43;int y = 243;int x2 = 1360;int y2 =1560;
float l = (x2-x)/36;int l2 = (int)(2*l);
ArrayList<float[]> myArray = new ArrayList<float[]>();
//double[][][][][] fuck = new double[19][19][l2][l2][3];
float[][][][][] fuck = new float[19][19][l2][l2][3];
//Mat m = new Mat();
for (int ii = 0;ii < 19;ii++){
for (int ii2 = 0;ii2 < 19;ii2++){
Rect roiRect = new Rect(x+(int)((ii2*2-1)*(x2-x)/36),y+(int)((ii*2-1)*(x2-x)/36),l2+1,l2+1);
Mat dest33 = new Mat(dest2,roiRect);
float[] dest3 = new float[(l2+1)*(l2+1)*3];
//dest33.get(0,0,dest3);
for (int t =0;t<l2;t++){
for (int t2 =0;t2<l2;t2++){
for (int t3 =0;t3<3;t3++){
fuck[ii][ii2][t][t2][t3]=(float)dest33.get(t2,t)[t3]/255;
//fuck[ii][ii2][t][t2][t3]=dest3[t3+t2*73+t*73*73];

}
}
}
//dest2.get(x+(int)(ii2*2*l-l),y+(int)(ii*2*l-l),dest3);
//myArray.add(dest3);
//m.push_back(dest33);
}

}
//Mat m2 = m.reshape(0,73*19);
//float[][][][] fuck2 = new float[1][l2][l2][3];
//fuck2[0] = fuck[0][0];
//float[] output = new float[3];
float[][] output = new float[19][3];
//float[][] output = new float[1][3];
//Map<Integer, Object> outputs = new HashMap<>();
            Map<String, Object> outputs = new HashMap<>();

interpreter = new Interpreter(loadModelFile());
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
interpreter.run(fuck[9], output);
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

 Toast.makeText(MyService.myctx,Arrays.toString(classify(output)),Toast.LENGTH_LONG).show();

        String file2 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + new StringBuilder("qwer").append(".png").toString();
   //   imageCodecs.imwrite(file2,m);
      //imageCodecs.imwrite(file2,getImage2());
      //imageCodecs.imwrite(file2,mat);
      //imageCodecs.imwrite(file2,dest2);
/*
}catch(Throwable e){
StringWriter errors = new StringWriter();
e.printStackTrace(new PrintWriter(errors));
//return errors.toString();
          Toast.makeText(MyService.myctx,
                              errors.toString()+":e:" e.getMessage(),
                               Toast.LENGTH_LONG)
                    .show();
}
*/
     
/*
      //Reading the Image from the file  
        String file4 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + new StringBuilder("/sgf3").append(".png").toString();
        //File file3 = new File(file2);
      Mat dest2 = imageCodecs.imread(file4);
      //Mat dest2 = imageCodecs.imread(file4,Imgcodecs.IMREAD_UNCHANGED);
int x = 43;int y = 243;int x2 = 1360;int y2 =1560;
float l = (x2-x)/36;int l2 = (int)(2*l);
ArrayList<float[]> myArray = new ArrayList<float[]>();
//double[][][][][] fuck = new double[19][19][73][73][3];
float[][][][][] fuck = new float[19][19][73][73][3];
Mat m = new Mat();
for (int ii = 0;ii < 19;ii++){
for (int ii2 = 0;ii2 < 19;ii2++){
Rect roiRect = new Rect(x+(int)(ii2*2*l-l),y+(int)(ii*2*l-l),l2+1,l2+1);
Mat dest33 = new Mat(dest2,roiRect);
float[] dest3 = new float[(l2+1)*(l2+1)*3];
//dest33.get(0,0,dest3);
for (int t =0;t<73;t++){
for (int t2 =0;t2<73;t2++){
for (int t3 =0;t3<3;t3++){
fuck[ii][ii2][t][t2][t3]=(float)dest33.get(t2,t)[t3];
//fuck[ii][ii2][t][t2][t3]=dest3[t3+t2*73+t*73*73];

}
}
}
//dest2.get(x+(int)(ii2*2*l-l),y+(int)(ii*2*l-l),dest3);
//myArray.add(dest3);
//m.push_back(dest3);
}

}
//Mat m2 = m.reshape(0,73*19);
//float[] output = new float[3];
float[][] output = new float[19][3];
Map<Integer, Object> outputs = new HashMap<>();

try{
interpreter = new Interpreter(loadModelFile());
//interpreter = new Interpreter(loadModelFile(),null);
//interpreter.run(fuck[0][0], output);
interpreter.runForMultipleInputsOutputs(fuck[0], outputs);
//interpreter.runForMultipleInputsOutputs(fuck[0], output);
//interpreter.run(fuck[0], output);
//interpreter.run(myArray.toArray(new <float[][][]>[0])[0], output);
//interpreter.run(myArray.toArray(new float[19][19][73][73][3])[0], output);
}catch(IllegalArgumentException e){
          Toast.makeText(getApplicationContext(),
                               e.getMessage(),
                               Toast.LENGTH_LONG)
                    .show();
}
        String file2 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + new StringBuilder(Float.toString(((float[])outputs.get(0))[0])).append(".png").toString();
        //String file2 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + new StringBuilder(Float.toString(output[0][0])).append(".png").toString();
        //String file2 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + new StringBuilder(Float.toString(output[1])).append(".png").toString();
        //String file2 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + new StringBuilder(Double.toString(fuck[18][18][18][18][2])).append(".png").toString();
      //imageCodecs.imwrite(file2,m2);
      imageCodecs.imwrite(file2,dest2);
      //imageCodecs.imwrite(file2,myArray.get(189));
*/
/*
ByteArrayOutputStream stream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
                byte[] byteArray = stream.toByteArray();
*/
/*
OutputStream out = photoSocket.getOutputStream();
//DataOutputStream dos = new DataOutputStream(out);

byte[] byteArray2 = ByteBuffer.allocate(byteArray.length+4).putInt(byteArray.length).put(byteArray).array();
//byte[] byteArray2 = ByteBuffer.wrap(byteArray).order(ByteOrder.BIG_ENDIAN).putInt(byteArray.length,0).array();
//dos.writeInt(byteArray.length);
out.write(byteArray2);
*/

//dos.flush();
//dos.close();

//photoSocket.close();
/*
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
sendBitmap(bmp);
            FileOutputStream out = new FileOutputStream(file);
            bmp.compress(Bitmap.CompressFormat.JPEG, 90, out);
            out.flush();
            out.close();
        } catch (Exception e) {
            myScreenshot.this.stopService(new Intent(myScreenshot.this, MyService.class));
            e.printStackTrace();
        }
*/
}catch(Throwable e){
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
//thread.start();

/*
int row = 0, col = 0;
int data[] = {  0, -1, 0, -1, 5, -1, 0, -1, 0 };
Mat img = new Mat( 3, 3, CvType.CV_32S );
img.put( row, col, data );
String file5 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + new StringBuilder("/123123").append(".bmp").toString();
Imgcodecs imageCodecs2 = new Imgcodecs(); 
imageCodecs2.imwrite(file5,img);
*/

        //Bitmap bmp = med.getFrameAtTime(100*1000000);
        //Bitmap bmp = med.getFrameAtTime(100*1000000, MediaMetadataRetriever.OPTION_CLOSEST);
        //postScreenShot(myPath);
    }
    public void getPathScreenShot(String filePath) {
        MediaMetadataRetriever med = new MediaMetadataRetriever();

        String myPath2 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + new StringBuilder("/123").append(".mp4").toString();
        //med.setDataSource(myPath2);
        med.setDataSource(filePath);
        Bitmap bmp = med.getFrameAtTime(5*1000000);
        //Bitmap bmp = med.getFrameAtTime(100*1000000, MediaMetadataRetriever.OPTION_CLOSEST);
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
            myScreenshot.this.stopService(new Intent(myScreenshot.this, MyService.class));
            e.printStackTrace();
        }
        //postScreenShot(myPath);
    }

   
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void recordScreen() {
        if (mediaProjection == null) {
            startActivityForResult(mediaProjectionManager.createScreenCaptureIntent(), REQUEST_CODE);
        } else {
        virtualDisplay = createVirtualDisplay2();
            onBackPressed();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    destroyMediaProjection();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            getPathScreenShot(screenShotUri);
                        }
                    }, rr);
                }
            }, videoTime);
/*
            virtualDisplay = createVirtualDisplay();
            mediaRecorder.start();
            onBackPressed();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    mediaRecorder.stop();
                    mediaRecorder.reset();
                    stopRecordScreen();
                    destroyMediaProjection();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            getPathScreenShot(screenShotUri);
                        }
                    }, rr);
                }
            }, videoTime);
*/
        }
    }

    private Mat getImage2() {
if (mImageReader == null)
{
return null;
}
Image image = null;
try{
image = mImageReader.acquireLatestImage();
}catch(Exception e){
            myScreenshot.this.stopService(new Intent(myScreenshot.this, MyService.class));
}
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
Rect roiRect = new Rect(0,0,DISPLAY_WIDTH,DISPLAY_HEIGHT);
Mat mat3 = new Mat(mat,roiRect);
Imgproc.cvtColor(mat3, dst_mat, Imgproc.COLOR_RGBA2BGR);
//Imgproc.cvtColor(mat3, dst_mat, Imgproc.COLOR_RGBA2RGB);

// create bitmap
//Bitmap bmp = Bitmap.createBitmap(DISPLAY_WIDTH+rowPadding/pixelStride,DISPLAY_HEIGHT, Bitmap.Config.ARGB_8888);
//bmp.copyPixelsFromBuffer(buffer);
image.close();
return dst_mat;
//return mat;
//return grayO.get(0);
    }
    private Bitmap getImage() {
if (mImageReader == null)
{
return null;
}
Image image = null;
try{
image = mImageReader.acquireLatestImage();
}catch(Exception e){
            myScreenshot.this.stopService(new Intent(myScreenshot.this, MyService.class));
}
final Image.Plane[] planes = image.getPlanes();
final ByteBuffer buffer = planes[0].getBuffer();
int offset = 0;
int pixelStride = planes[0].getPixelStride();
int rowStride = planes[0].getRowStride();
int rowPadding = rowStride - pixelStride * DISPLAY_WIDTH;
// create bitmap
Bitmap bmp = Bitmap.createBitmap(DISPLAY_WIDTH+rowPadding/pixelStride,DISPLAY_HEIGHT, Bitmap.Config.ARGB_8888);
//Bitmap bmp = Bitmap.createBitmap(DISPLAY_WIDTH,DISPLAY_HEIGHT, Bitmap.Config.ARGB_8888);
bmp.copyPixelsFromBuffer(buffer);
image.close();
return bmp;
    }
    private VirtualDisplay createVirtualDisplay2() {
        return mediaProjection.createVirtualDisplay("fuckMainActivity", DISPLAY_WIDTH, DISPLAY_HEIGHT, mScreenDensity, DisplayManager.VIRTUAL_DISPLAY_FLAG_AUTO_MIRROR,
                mImageReader.getSurface(), null, null);
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private VirtualDisplay createVirtualDisplay() {
        return mediaProjection.createVirtualDisplay("MainActivity", DISPLAY_WIDTH, DISPLAY_HEIGHT, mScreenDensity, DisplayManager.VIRTUAL_DISPLAY_FLAG_AUTO_MIRROR,
                mediaRecorder.getSurface(), null, null);
    }

    private void initRecorder() {
        try {
/*
            mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
            mediaRecorder.setVideoSource(MediaRecorder.VideoSource.SURFACE);
            mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);

            screenShotUri = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + new StringBuilder("/screenshot").append(".mp4").toString();

            mediaRecorder.setOutputFile(screenShotUri);
            mediaRecorder.setVideoSize(1392, 1760);
            //mediaRecorder.setVideoSize(DISPLAY_WIDTH, DISPLAY_HEIGHT);
            mediaRecorder.setVideoEncoder(MediaRecorder.VideoEncoder.H264);
            mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
            mediaRecorder.setVideoEncodingBitRate(512 * 1000);
            mediaRecorder.setVideoFrameRate(5);

            int rotation = getWindowManager().getDefaultDisplay().getRotation();
            int orientation = ORIENTATION.get(rotation + 90);
            mediaRecorder.setOrientationHint(orientation);
            mediaRecorder.prepare();
*/
            screenShotUri = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + new StringBuilder("/screenshot").append(".mp4").toString();
        } catch (Exception e) {
        //} catch (IOException e) {
            e.printStackTrace();
            Log.d("ExceptionOccured", "" + e.getMessage());
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode != REQUEST_CODE) {
            //stopService(new Intent(this, MyService.class));
            //startService(new Intent(this, MyService.class));
            Toast.makeText(myScreenshot.this, "Unknown Error", Toast.LENGTH_SHORT).show();
            Log.d("Livetracking", "ScreenShot" + requestCode + "  " + resultCode + " " + data);
            return;
        }
        if (resultCode != RESULT_OK) {
            //stopService(new Intent(this, MyService.class));
            //startService(new Intent(this, MyService.class));
            Toast.makeText(myScreenshot.this, "Permission denied" + requestCode, Toast.LENGTH_SHORT).show();
            Log.d("Livetracking", "Screenshot" + requestCode + "  " + resultCode + " " + data);
            return;
        }
MyService.data0 = (Intent) data.clone();
/*
Intent data0 = (Intent) data.clone();
        Log.d("Livetracking", "Screenshot" + requestCode + "  " + resultCode + " " + data);

        mediaProjectionCallback = new myScreenshot.MediaProjectionCallback();
        mediaProjection = mediaProjectionManager.getMediaProjection(resultCode, data0);
        mediaProjection.registerCallback(mediaProjectionCallback, null);
        virtualDisplay = createVirtualDisplay2();
        onBackPressed();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                destroyMediaProjection();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        getPathScreenShot2(screenShotUri);
                    }
                }, rr);
            }
        }, videoTime);
*/
/*
        virtualDisplay = createVirtualDisplay();
        mediaRecorder.start();
        onBackPressed();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mediaRecorder.stop();
                mediaRecorder.reset();
                stopRecordScreen();
                destroyMediaProjection();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        getPathScreenShot(screenShotUri);
                    }
                }, rr);
            }
        }, videoTime);
*/
/*
        ActivityManager am = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        if (am != null) {
            List<ActivityManager.AppTask> tasks = am.getAppTasks();
            if (tasks != null && tasks.size() > 0) {
                Log.d("RemovingApp", "recent");
                tasks.get(0).setExcludeFromRecents(true);
            }
        }
*/
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private class MediaProjectionCallback extends MediaProjection.Callback {
        @Override
        public void onStop() {
            mediaRecorder.stop();
            mediaRecorder.reset();
            mediaProjection = null;
            stopRecordScreen();
            destroyMediaProjection();
            if (mediaProjection != null) {
                destroyMediaProjection();
            }
            super.onStop();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void stopRecordScreen() {
        if (virtualDisplay == null) {
            virtualDisplay.release();
            if (mediaProjection != null) {
                destroyMediaProjection();
            }
            return;

        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void destroyMediaProjection() {
        if (mediaProjection != null) {
            mediaProjection.unregisterCallback(mediaProjectionCallback);
            mediaProjection.stop();
            mediaProjection = null;
        }
    }
}

