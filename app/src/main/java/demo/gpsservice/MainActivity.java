package demo.gpsservice;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button stop,start;
    TextView cordinates;
    private BroadcastReceiver broadcastReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start=findViewById(R.id.start);
        stop=findViewById(R.id.stop);
        cordinates=findViewById(R.id.showlocation);

      if(!runtime_permission()){
          enablethebutton();
      }
    }

    private void enablethebutton() {
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),GpsService.class);
                startService(i);
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),GpsService.class);
                stopService(i);
            }
        });
    }

    private Boolean runtime_permission() {
        if (Build.VERSION.SDK_INT >= 23 && ContextCompat.checkSelfPermission(this, Manifest.
                permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(this, Manifest.
                permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.ACCESS_COARSE_LOCATION},100);
        return  true;
        }
        return  false;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode==100){
            if(grantResults[0]==PackageManager.PERMISSION_GRANTED && grantResults[1]==PackageManager.PERMISSION_GRANTED){
                enablethebutton();
            }else{
                runtime_permission();
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(broadcastReceiver==null){
            broadcastReceiver=new BroadcastReceiver() {
                @Override
                public void onReceive(Context context, Intent intent) {

                    cordinates.append("\n"+intent.getExtras().get("Cordinates"));
                }
            };
            registerReceiver(broadcastReceiver,new IntentFilter("location"));
        }
    }

    @Override
    protected void onDestroy() { //To disable Memory Leaks
        super.onDestroy();
        if (broadcastReceiver!=null){
            unregisterReceiver(broadcastReceiver);
        }
    }
}
