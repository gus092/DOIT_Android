package hyunji.shin.myparcealble;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        //이 시점에서 main에서 보낸 intent를 받게됨
        Intent intent = getIntent();
        processIntent(intent); //이안에서 처리한다
    }

    public void processIntent(Intent intent){ //
        if(intent != null){
            Bundle bundle = intent.getExtras(); //그안에 있는 bundle객체로 가져오는 중
            SimpleData data = bundle.getParcelable("data"); //getParcable라는 인터페이스로 참조하고 있기 때문에+data라는 키를 가진 data가져옴
            if(data !=null){
                Toast.makeText(this, "전달받은 객체 : "+ data.code , Toast.LENGTH_LONG).show();
            }
        }
    }
}
