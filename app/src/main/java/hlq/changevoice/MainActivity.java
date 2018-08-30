package hlq.changevoice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.fmod.FMOD;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import hlq.utils.ChangeUtils;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    private ExecutorService fixedThreadPool;
    private PlayerThread playerThread;
    private String path = "file:///android_asset/hensen.mp3";
    private int type;

    private Button zhengchang,dashu,jingsong,kongling,gaoguao,luoli;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        zhengchang = findViewById(R.id.yuansheng);
        dashu = findViewById(R.id.dashu);
        jingsong = findViewById(R.id.jingsong);
        kongling = findViewById(R.id.kongling);
        gaoguao = findViewById(R.id.gaoguai);
        luoli = findViewById(R.id.luoli);
        fixedThreadPool = Executors.newFixedThreadPool(1);
        FMOD.init(this);
    }

    class PlayerThread implements Runnable {
        @Override
        public void run() {
            ChangeUtils.change(path, type);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.yuansheng:
                type = ChangeUtils.zhengchang;
                break;
            case  R.id.luoli:
                type = ChangeUtils.luoli;
                break;
            case  R.id.dashu:
                type = ChangeUtils.dashu;
                break;
            case  R.id.gaoguai:
                type = ChangeUtils.gaoguai;
                break;
            case  R.id.jingsong:
                type = ChangeUtils.jingsong;
                break;
            case  R.id.kongling:
                type = ChangeUtils.kongling;
                break;
        }
        playerThread = new PlayerThread();
        fixedThreadPool.execute(playerThread);
    }
}
