package com.example.myrecycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

import Adapter.Adapter;
import Listener.onClickListeners;

public class MainActivity extends AppCompatActivity {
    private static final String CHANNEL_ID = "555";
    private ArrayList<Item> Items;
    private RecyclerView rv_moh;
    private RecyclerView.Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv_moh= findViewById(R.id.rv_mo);
        rv_moh.setHasFixedSize(true);
        rv_moh.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<Item>Items=new ArrayList<>();
        Items.add(new Item("mohammed","0598230691"));
        Items.add(new Item("yosef","0598230691"));
        Items.add(new Item("ali","0598230691"));
        Items.add(new Item("osama","0598230691"));
        Items.add(new Item("ahmad","0598230691"));
        Items.add(new Item("ahmad","0598230691"));
        Items.add(new Item("ahmad","0598230691"));
        Adapter adapter = new Adapter(getApplicationContext(), Items, new onClickListeners() {
            @Override
            public void onItemCLickListener(Item item) {
                ShowNotification(item.getName(), item.getPhone());
            }
        }) {
            @Override
            public void onItemCLickListener(Item item) {

            }
        };



        rv_moh.setAdapter(adapter);

    }
    public void ShowNotification(String name,String num){
        Intent intent=new Intent(getApplicationContext(),MainActivity.class);
        PendingIntent pendingIntent=PendingIntent.getActivity(getApplicationContext(),0,intent,0);

        NotificationCompat.Builder noBuilder=new NotificationCompat.Builder(MainActivity.this,CHANNEL_ID);
        noBuilder.setSmallIcon(R.drawable.ic_baseline_notifications_24)
                .setContentTitle(name)
                .setContentIntent(pendingIntent)
                .setContentText(num);
        NotificationManagerCompat notificationManagerCompat=NotificationManagerCompat.from(getApplicationContext());
        NotificationManager notificationManager = (NotificationManager) getSystemService(getApplicationContext().NOTIFICATION_SERVICE);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel=
            new NotificationChannel(CHANNEL_ID,"Name", NotificationManager.IMPORTANCE_DEFAULT);
            notificationManager.createNotificationChannel(notificationChannel);
        }
        notificationManagerCompat.notify(15,noBuilder.build());



    }
}