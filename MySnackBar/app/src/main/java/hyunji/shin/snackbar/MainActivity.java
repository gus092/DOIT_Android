package hyunji.shin.snackbar;
//part2.chpater03-12
//스낵바 띄우기 + 알림상자

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //이 View view 파라미터로 전달되는 건 눌려진 '버튼객체'가 전달 됨
                Snackbar.make(v, "스낵바입니다.", Snackbar.LENGTH_LONG).show();
            }
        });

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMessage();
            }
        });
    }

    public void showMessage() {
        //AlertDialog를 설정할 수 있는 객체가 builder 임
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("안내");
        builder.setMessage("종료하시겠습니까?");
        builder.setIcon(android.R.drawable.ic_dialog_alert); //android API에 기본적으로 들어있는 icon이용

        builder.setPositiveButton("예", new DialogInterface.OnClickListener() { //'예'버튼이 눌렸을 때
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(), "예 버튼 눌림", Toast.LENGTH_LONG).show();
            }
        });

        builder.setNegativeButton("아니오", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(), "아니오 버튼 눌림", Toast.LENGTH_LONG).show();
            }
        });

        //빌더를 다 만들고 나면, 빌더 create가능
        AlertDialog dialog = builder.create();
        dialog.show(); //대화상자 보여줌
    }
}
