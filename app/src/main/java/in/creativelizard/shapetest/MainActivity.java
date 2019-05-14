package in.creativelizard.shapetest;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import in.creativelizard.shapeutil.CircleView;
import in.creativelizard.shapeutil.ShapeImageView;

public class MainActivity extends AppCompatActivity {

    private CircleView imgPerson;
    //private ShapeImageView siMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgPerson = findViewById(R.id.imgPerson);
        //siMain = findViewById(R.id.siMain);
      //  imgPerson.setImageCircleImageResources(R.drawable.person);
       // imgPerson.setImageShapeImageResources(R.drawable.person);
       // siMain.setImageShapeImageResources(R.drawable.person);
        loadImage();

    }

    private void loadImage() {
         Target target = new Target() {
            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                imgPerson.setImageCircleImageBitmap(bitmap);
               // siMain.setShapeImageBitmap(bitmap);

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
