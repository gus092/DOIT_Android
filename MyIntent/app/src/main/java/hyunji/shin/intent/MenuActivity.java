package hyunji.shin.intent;
//part2 chapter 04-03
//intent로 화면간 전환
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent();
                intent.putExtra("name","mike");//putExtra:intent를 통해서 다른 액티비티에 정보를 전달할 수 잇음
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
