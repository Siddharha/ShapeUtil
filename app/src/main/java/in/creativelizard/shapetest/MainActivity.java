package in.creativelizard.shapetest;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import in.creativelizard.shapeutil.CircleView;

public class MainActivity extends AppCompatActivity {

    private CircleView imgPerson;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgPerson = findViewById(R.id.imgPerson);

        final ImageView imageView = new ImageView(this
        );
        Picasso.get().load("https://lh3.googleusercontent.com/" +
                "cuU3I9olUCLZnj6UEdgAs9QbEWGgVNauEMsWMnYB5s2IC6BAqMX7JcMkV" +
                "-59dCstDw=s180").into(imageView,new com.squareup.picasso.Callback() {
            @Override
            public void onSuccess() {
                BitmapDrawable drawable = (BitmapDrawable) imageView.getDrawable();
                Bitmap bitmap = drawable.getBitmap();

                imgPerson.fill_back_color = "#c2c2c2";
                imgPerson.draw_back_img_bmp = bitmap;
            }

            @Override
            public void onError(Exception ex) {

            }
        });


    }
}
