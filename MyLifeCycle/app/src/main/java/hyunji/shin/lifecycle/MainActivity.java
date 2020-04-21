package hyunji.shin.lifecycle;
//chpater 04-07
//task 관련 :  Preference 사용하기
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText =  findViewById(R.id.editText);


        Log.d("Main","OnCreate 호출됨"); //메모리가 만들어 질 때 시점
    }

    @Override
    protected void onStart() { //액티비티가 시작되는 시점
        super.onStart();
        Log.d("Main","onStart 호출됨");
    }

    @Override
    protected void onResume() { //화면이 보여지기 바로 전 시점 + 전화끝나고 다시 보여지게 될 때 호출됨 (이 시점에서 복원해야함)
        super.onResume();

        loadState(); //여기서 SharedPreferences에 저장된 값을 보여주므로 앱이 비정상 종료하더라도 정보가 그대로 유지됨
        Log.d("Main","OnResume 호출됨");
    }


    @Override
    protected void onStop() { //종료되는 순서1
        super.onStop();
        Log.d("Main","OnStop 호출됨");
    }

    @Override
    protected void onPause() { //종료되는 순서2 + 갑자기 전화가 올 때 자동호출됨 (이 시점에서 저장)
        super.onPause();

        saveState();
        Log.d("Main","OnPasuse 호출됨");
    }

    @Override
    protected void onDestroy() { //종료되는 순서3
        super.onDestroy();
        Log.d("Main","OnDestroy 호출됨");
    }

    public void saveState(){
        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE );//참조하기
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("name", editText.getText().toString()); //name이라는 이름으로 해서  사용자가 입력한 입력정보를 가져올 수 있음
        editor.commit(); //저장함 -->이때 파일 형태로 저장되므로, 단말 내부에. 따라서 앱이 종료되더라도 계속 유지가 됨
    }

    public void loadState(){
        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE ); //참조하기
        if(pref != null){
            String name =pref.getString("name", "여기는 Default값");
            editText.setText(name);
        }
    }
}
