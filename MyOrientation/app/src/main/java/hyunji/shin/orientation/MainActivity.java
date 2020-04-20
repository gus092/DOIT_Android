package hyunji.shin.orientation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String name;
    EditText editText;
    TextView textview2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showToast("onCreate 호출됨");

        textview2 = findViewById(R.id.textView2);
        editText = findViewById(R.id.editText);
        Button button = findViewById(R.id.button);
        if(button != null) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (editText != null) { //화면에서 editText를 찾았다는 뜻
                        name = editText.getText().toString();//화면 가로,세로 전환시 데이터 손실을 막기위한 방법 고안중
                        showToast("사용자 입력값을 name변수에 할당함");
                    }
                }
            });
        }

        if(savedInstanceState != null){
            if(textview2 != null){
                name=savedInstanceState.getString("name");
                textview2.setText(name);

                showToast("값을 복원했습니다 :" + name);
            }
        }
    }

    //액티비티가 메모리에서 없어지는 순간에 이 함수가 없어지면서 지정한 name값이 어딘가 저장됨 -> 이걸 textview2로 복원해 넣을 수 있음
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("name",name);//name안에 들어있는 값을 outState에 넣음
        //bundle은 어떤 데이터를 담아두기 위한 것
    }

    @Override
    protected void onDestroy() { //화면이 메모리에서 없어질 때 호출됨
        super.onDestroy();

        showToast("onDestroy 호출됨");
    }

    public void showToast(String data) {
        Toast.makeText(this, data, Toast.LENGTH_SHORT).show();
    }
}
