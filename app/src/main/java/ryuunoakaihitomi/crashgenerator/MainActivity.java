package ryuunoakaihitomi.crashgenerator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this,"Generate a CRASH without Dev Tools.\nGithub @ryuunoakaihitomi",Toast.LENGTH_LONG).show();
        findViewById(R.id.FC1).setOnClickListener(this);
        findViewById(R.id.FC2).setOnClickListener(this);
        findViewById(R.id.ANR).setOnClickListener(this);
    }

    public native void nativeCrash();

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.FC1:
                throw new Error("You call me.");
            case R.id.FC2:
                nativeCrash();
                break;
            case R.id.ANR:
                final int ANR_TIME = 20 * 1000;
                try {
                    Thread.sleep(ANR_TIME);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
    }
}
