package hyunji.shin.orientation2;
//part2.chpater03-10~11
//방향이 전환되어도 activity가 종료되지 않게 처리 중
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //방향이 전환됐을 때 호출해주는 함수
    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);//newConfig안에 그 정보가 담김

        if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {//가로방향이면
            showToast("가로방향임");
        }else if(newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            showToast("세로방향임");
        }
    }
    public void showToast(String data){
        Toast.makeText(this,data,Toast.LENGTH_SHORT).show();
    }
}
