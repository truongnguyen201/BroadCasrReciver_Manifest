package topica.edu.vn.broadcasrreciver_manifest;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.ConnectivityManager;
import android.net.Uri;

import androidx.core.app.NotificationCompat;

public class InternetReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        ConnectivityManager connectivityManager= (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if(connectivityManager.getActiveNetworkInfo()!=null)
        {
                xuLiMoThongBao(context);
        }
    }

    private void xuLiMoThongBao(Context context) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
                .setSmallIcon(R.drawable.alarm)
                .setContentTitle("Có thông Báo")
                .setContentText("Mới có bản cập nhật verson mới");

        Intent resultIntent = new Intent(context, MainActivity.class);

        PendingIntent resulPendingIntent=PendingIntent.getActivity(context,0,
                resultIntent,PendingIntent.FLAG_CANCEL_CURRENT);
        builder.setContentIntent(resulPendingIntent);
        Uri uri= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        builder.setSound(uri);

        NotificationManager manager= (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(114,builder.build());
    }
}
