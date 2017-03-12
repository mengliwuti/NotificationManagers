package zdsoft.com.notificationmanager;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
    private Button send_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        send_btn= (Button) findViewById(R.id.sent_but);
        send_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationManager notificationManager= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                Notification notification=new Notification(R.mipmap.ic_launcher,"This is ticker text",System.currentTimeMillis());
//                notification.flags=Notification.FLAG_AUTO_CANCEL;
//                PendingIntent.FLAG_UPDATE_CURRENT
                Intent intent=new Intent(MainActivity.this,NotificationActivity.class);
//                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_NEW_TASK);
                PendingIntent pendingIntent=PendingIntent.getActivity(MainActivity.this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
                Notification.Builder builder = new Notification.Builder(MainActivity.this)
                        .setAutoCancel(true)
                        .setContentTitle("title")
                        .setContentText("describe")
                        .setContentIntent(pendingIntent)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setWhen(System.currentTimeMillis())
                        .setOngoing(true);
                notification=builder.getNotification();
                notificationManager.notify(1,notification);



                // TODO: 2017/3/12


//    Notification.Builder builder1 = new Notification.Builder(NotificationActivity.this);
//    builder1.setSmallIcon(R.drawable.advise2); //设置图标
//    builder1.setTicker("显示第二个通知");
//    builder1.setContentTitle("通知"); //设置标题
//    builder1.setContentText("点击查看详细内容"); //消息内容
//    builder1.setWhen(System.currentTimeMillis()); //发送时间
//    builder1.setDefaults(Notification.DEFAULT_ALL); //设置默认的提示音，振动方式，灯光
//    builder1.setAutoCancel(true);//打开程序后图标消失
//                Intent intent =new Intent (MainActivity.this,NotificationActivity.class);
//                PendingIntent pendingIntent =PendingIntent.getActivity(MainActivity.this, 0, intent, 0);
//    builder1.setContentIntent(pendingIntent);
//    Notification notification1 = builder1.build();
//    notificationManager.notify(124, notification1); // 通过通知管理器发送通知




//                Notification notification=new Notification(R.mipmap.ic_launcher,"This is ticker text",System.currentTimeMillis());
//                Intent intent =new Intent (MainActivity.this,NotificationActivity.class);
//                PendingIntent pendingIntent =PendingIntent.getActivity(MainActivity.this, 0, intent, 0);
//
//                Notification.Builder builder = new Notification.Builder(MainActivity.this)
//                        .setAutoCancel(true)
//                        .setContentTitle("title")
//                        .setContentText("describe")
//                        .setContentIntent(pendingIntent)
//                        .setSmallIcon(R.mipmap.ic_launcher)
//                        .setWhen(System.currentTimeMillis())
//                        .setOngoing(true);
//                notification=builder.getNotification();
            }
        });
    }
}
