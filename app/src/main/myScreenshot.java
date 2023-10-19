package com.example.myapplication_;
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

    private static final int videoTime = 15000;
    private static final int REQUEST_CODE = 1000;
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

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myfloat);
//Toast.makeText(this, "vStringii",Toast.LENGTH_LONG).show();
        init();
//takeScreenshot();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void init() {
        //Screen tracking Code Started here..............................
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        mScreenDensity = metrics.densityDpi;
        //postWebAPIData = new PostWebAPIData();
        DISPLAY_HEIGHT = metrics.heightPixels;
        DISPLAY_WIDTH = metrics.widthPixels;
            //Toast.makeText(myScreenshot.this, Integer.toString(123)(DISPLAY_HEIGHT), Toast.LENGTH_SHORT).show();

        mediaRecorder = new MediaRecorder();
        mediaProjectionManager = (MediaProjectionManager) getSystemService(Context.MEDIA_PROJECTION_SERVICE);
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
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void toogleScreenShare() {
        initRecorder();
        recordScreen();
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
                    }, 2000);
                }
            }, videoTime);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private VirtualDisplay createVirtualDisplay() {
        return mediaProjection.createVirtualDisplay("MainActivity", DISPLAY_WIDTH, DISPLAY_HEIGHT, mScreenDensity, DisplayManager.VIRTUAL_DISPLAY_FLAG_AUTO_MIRROR,
                mediaRecorder.getSurface(), null, null);
    }

    private void initRecorder() {
        try {
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
        } catch (IOException e) {
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
        Log.d("Livetracking", "Screenshot" + requestCode + "  " + resultCode + " " + data);

        mediaProjectionCallback = new myScreenshot.MediaProjectionCallback();
        mediaProjection = mediaProjectionManager.getMediaProjection(resultCode, data);
        mediaProjection.registerCallback(mediaProjectionCallback, null);
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
                }, 2000);
            }
        }, videoTime);
        ActivityManager am = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        if (am != null) {
            List<ActivityManager.AppTask> tasks = am.getAppTasks();
            if (tasks != null && tasks.size() > 0) {
                Log.d("RemovingApp", "recent");
                tasks.get(0).setExcludeFromRecents(true);
            }
        }
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

