package hyunji.shin.callintent;
//part2 chapter04-05
//intent 다르게도 이용하기

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:010-1000-1000"));
                //startActivity(intent);
                // startActivity는 시스템으로 요청하게 됨
                //안드로이드OS안에 있는 액티비티 매니저가 이 정보를 받게 됨.


                /*Component를 이용해서 intent 띄우기
                Intent intent =new Intent();
                //액티비티를 가리킬때 컴포넌트라고도 가리킬 수 있음
                ComponentName name   = new ComponentName("org.hyunji.shin.callintent","org.hyunji.shin.callintent.MenuActivity");
                //패키지 이름까지 다 써야함! + Menu 액티비티로 가라!
                intent.setComponent(name);
                startActivityForResult(intent,101);
                */


            }
        });
    }
}
