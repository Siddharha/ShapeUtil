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
        imgPerson.setImageCircleImageResources(R.drawable.person);

    }
}
