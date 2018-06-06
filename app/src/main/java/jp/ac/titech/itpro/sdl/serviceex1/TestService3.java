package jp.ac.titech.itpro.sdl.serviceex1;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class TestService3 extends IntentService {
    private final static String TAG = "TestService3";
    public final static String EXTRA_MYARG = "MYARG";
    public final static String ACTION_ANSWER = "BROADCASTING";
    public final static String EXTRA_ANSWER = "Hello.";

    TestService3() {
        super(TAG);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d(TAG, "onHandleIntent in " + Thread.currentThread());
        Log.d(TAG, "myarg = " + intent.getStringExtra(EXTRA_MYARG));
        try {
            Thread.sleep(5000);
            Intent broadcastIntent = new Intent(); // 送信用インテントの作成
            broadcastIntent.setAction("MAIN_ACTION"); // アクションをセット
            broadcastIntent.putExtra("message", "Hello. This is an Intent!"); // その他返値データをセット
            sendBroadcast(broadcastIntent); // ブロードキャスト送信
            Log.d(TAG, "Sended the Intent.");
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate in " + Thread.currentThread());
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy in " + Thread.currentThread());
        super.onDestroy();
    }
}

