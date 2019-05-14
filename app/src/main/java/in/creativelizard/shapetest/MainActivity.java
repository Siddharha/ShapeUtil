package in.creativelizard.shapetest;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import in.creativelizard.shapeutil.CircleView;

public class MainActivity extends AppCompatActivity {

    private CircleView imgPerson;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgPerson = findViewById(R.id.imgPerson);
        //imgPerson.setImageCircleImageResources(R.drawable.person);
       // imgPerson.setImageCircleImageResources(R.drawable.person);
        loadImage();

    }

    private void loadImage() {
         Target target = new Target() {
            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                imgPerson.setImageCircleImageBitmap(bitmap);

            }

            @Override
            public void onBitmapFailed(Exception e, Drawable errorDrawable) {

            }


            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable) {
            }
        };

        Picasso.get()
                .load("https://images.pexels.com/users/avatars/2659/pixabay-617.png?w=256&h=256&fit=crop&crop=faces")
                .into(target);
    }
}
