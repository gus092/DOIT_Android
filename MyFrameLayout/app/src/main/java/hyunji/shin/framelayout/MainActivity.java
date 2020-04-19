package hyunji.shin.framelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    ImageView imageView2;

    int imageIndex=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //id를 이용해서 view 를 찾아간다 -> id는 xml파일의 imageview1
        imageView = findViewById(R.id.imageview1);
        imageView2 = findViewById(R.id.imageview2);


    }

    public void onButton1Cliked(View v){
        changeImage();
    }

    public void changeImage(){
        if (imageIndex == 0){
            imageView.setVisibility(View.VISIBLE);
            imageView2.setVisibility(View.INVISIBLE);
            imageIndex = 1;

        }else if (imageIndex ==1){
            imageView.setVisibility(View.INVISIBLE);
            imageView2.setVisibility(View.VISIBLE);
            imageIndex =0;
        }

    }
}
