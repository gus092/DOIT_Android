package hyunji.shin.toast;
//part2.chapter03-11
//Toast 위치 바꾸기
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        //toast위치 바꾸기 -> toast객체를 통해서 setGravity
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //.show()를 안붙이고 객체만 만듦
                Toast toastView = Toast.makeText(getApplicationContext(),"토스트메세지 입니다.",Toast.LENGTH_SHORT);
                toastView.setGravity(Gravity.TOP|Gravity.LEFT,200,800); //왼쪽위를 기준으로 하고, x,y 값얼마나 떨어져서 하는가
                toastView.show();
            }
        });
    }
}
