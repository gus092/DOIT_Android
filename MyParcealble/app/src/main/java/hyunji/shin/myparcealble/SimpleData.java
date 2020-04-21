package hyunji.shin.myparcealble;

import android.os.Parcel;
import android.os.Parcelable;

public class SimpleData implements Parcelable {
    int code;
    String message;

    public SimpleData(int code, String message){  //생성자 만들어주기
        this.code= code;
        this.message = message;
    }

    public SimpleData (Parcel src){//생성자 함수 자체가 parceable이라는 같은 타입의 다른 객체를 받는 경우
        code = src.readInt();
        message = src.readString();
    }

    public static final Parcelable.Creator CREATOR =  new Parcelable.Creator(){ //parcel로 SimpleData를 만들때 필요한 함수
        public SimpleData createFromParcel(Parcel in){ //parcelable 형태로 만들기 위한 코드다!
            return new SimpleData(in); //simpledata객체를 만들 때 parcel안에 들어있는 걸로 만들겠다.
        }
        public SimpleData[] newArray(int size){
            return new SimpleData[size];
        }
    };
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest , int flags) {
        dest.writeInt(code);
        dest.writeString(message);

    }
}
