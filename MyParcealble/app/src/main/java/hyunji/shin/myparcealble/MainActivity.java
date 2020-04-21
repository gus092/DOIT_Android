package hyunji.shin.myparcealble;
//part02 chapter04-06
//intent에 객체를 넣어서 전달하기
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
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
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                SimpleData data = new SimpleData(200,"OK"); //숫자와 글자가 들어간 객체를 만듦
                intent.putExtra("data",data); //만든 객체를 intent에 담아
                startActivity(intent); //시스템에 보냄
            }
        });
    }
}
