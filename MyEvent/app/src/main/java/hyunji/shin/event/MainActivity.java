package hyunji.shin.event;
//Doit강의 part2.chapter03-07

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;

    GestureDetector detector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        View view = findViewById(R.id.view);
        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) { // 눌린상태,눌려서 유지된상태,뗀 상태를 motionevent객체로 넘겨줌
                int action = event.getAction(); //정수로 넘겨줌

                float curX = event.getX();
                float curY = event.getY();

                if (action == MotionEvent.ACTION_DOWN) { //Action_Down이면 손가락이 '눌린상태'를 말함
                    println("손가락 눌림: " + curX + "," + curY);
                } else if (action == MotionEvent.ACTION_MOVE) {
                    println("손가락 움직임: " + curX + "," + curY);
                } else if (action == MotionEvent.ACTION_UP) {
                    println("손가락 뗌: " + curX + "," + curY);
                }
                return true;
            }
        });

        detector = new GestureDetector(this, new GestureDetector.OnGestureListener() {
            @Override
            public boolean onDown(MotionEvent motionEvent) {
                println("onDown 호출됨");
                return true;
            }

            @Override
            public void onShowPress(MotionEvent motionEvent) {

            }

            @Override
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                return false;
            }

            @Override
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
                return false;
            }

            @Override
            public void onLongPress(MotionEvent motionEvent) {
                println("onLongPress 호출됨");
            }

            @Override
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
                //v들은 속도임
                println("onFling 호출됨" + v + ',' + v1);
                return true;
            }
        });

        View view2 = findViewById(R.id.view2);
        view2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                detector.onTouchEvent(event); //전달받은 event를 detector에게로 호출해서 위임해줌
                return true;
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) { //키가 눌렸을 때 자동으로 호출됨 어떤키가 눌렸는지 알려줌
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            println("시스템[BACK]버튼이 눌렸어요.");
            return true; //리턴 true를 하게되면 그 '이후의 동작'이 취소된다.즉, 화면종료가 취소되서 안됨
        }
        return false;
    }

    public void println(String data) {
        textView.append(data + "\n");
    }
}
