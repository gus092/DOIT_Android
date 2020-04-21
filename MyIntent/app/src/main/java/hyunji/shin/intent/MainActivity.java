package hyunji.shin.intent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

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
                startActivityForResult(intent, 101);
                //Menu에게 101코드를 보내고 다시 돌아올 때도 Menu에게 101을 받음
            }
        });
    }

    //on으로 시작하는 메소드는, 우리가 호출하는게 아니라 어느 시점이 오면 자동으로 호출됨
    //얜, Menu에서 Main으로 돌아올 때 자동으로 호출됨
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) { //101,-1이 넘어옴
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 101) { //101로 넘어온건 Menu액티비티를 통해 받은 것
            if(data != null ){
                String name = data.getStringExtra("name");//아까Menu에서intent.putExtra 로 넣은 값을 꺼낼 수 있음
                if (name != null){
                    Toast.makeText(this,"응답으로 받은 DATA :"+name , Toast.LENGTH_LONG).show();
                }
            }
        }
    }
}
