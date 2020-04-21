package hyunji.shin.myparcealble;

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
                finish();
            }
        });

        //이 시점에서 main에서 보낸 intent를 받게됨
        Intent intent = getIntent();
        processIntent(intent); //이안에서 처리한다
    }

    public void processIntent(Intent intent){ //

    }
}
