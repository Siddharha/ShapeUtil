package in.creativelizard.shapeutil;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Siddhartha on 6/8/2018.
 */

public class CircleView extends View {
    public   float STROKE_SIZE;
    private Context mContext;
    Paint paint ;
    Path path;
    public String draw_color = "#c2c2c2";
    public String fill_back_color = "#c2c2c2";
    public float RADIOUS;
    public Drawable draw_back_img;
    public boolean isFill;

    public CircleView(Context ctx, AttributeSet attrs) {
        super(ctx, attrs);

        TypedArray a = ctx.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.CircleView,
                0, 0);

        try {
            isFill = a.getBoolean(R.styleable.CircleView_feel_color, false);
            draw_color =a.getString(R.styleable.CircleView_src);
            fill_back_color =a.getString(R.styleable.CircleView_feel_back_color);
            draw_back_img =a.getDrawable(R.styleable.CircleView_draw_img_back);
            STROKE_SIZE = a.getFloat(R.styleable.CircleView_stroke_size, 1F);
        } finally {
            a.recycle();
        }

        mContext = ctx;
        setWillNotDraw(false);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        int w = getWidth(), h = getHeight();
        int cPw = w/2, cPh = h/2;
        if(w>h){
            RADIOUS = h/2;
        }else if(w<h) {
            RADIOUS = w/2;
        }else {
            RADIOUS = h/2;
        }
            RADIOUS = RADIOUS - STROKE_SIZE / 2;
            paint.setStrokeWidth(STROKE_SIZE);
        if(draw_color!=null) {
            paint.setColor(Color.parseColor(draw_color));
        }else {
            paint.setColor(Color.parseColor("#c2c2c2"));
        }
        paint.setAntiAlias(true);
        if(isFill) {

            if (draw_back_img!=null){

                paint.setStyle(Paint.Style.STROKE);
                paint.setColor(Color.parseColor(draw_color));
                canvas.drawCircle(cPw, cPh, RADIOUS, paint);

                paint.setStyle(Paint.Style.FILL);
                paint.setColor(Color.BLACK);
                Bitmap original = ((BitmapDrawable)draw_back_img).getBitmap();
                Bitmap mask = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
               Canvas canvas_mask = new Canvas(mask);

                canvas_mask.drawCircle(cPw, cPh, RADIOUS- STROKE_SIZE / 2, paint);

                    Bitmap result = Bitmap.createBitmap(mask.getWidth(), mask.getHeight(), Bitmap.Config.ARGB_8888);
                     Canvas canvas_rslt = new Canvas(result);
                    Paint paint_mask = new Paint(Paint.ANTI_ALIAS_FLAG);
                paint_mask.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
                int centreX = (w - original.getWidth()) / 2;

                int centreY = (h - original.getHeight()) /2;

                canvas_rslt.drawBitmap(original,centreX,centreY,null);
                    canvas_rslt.drawBitmap(mask, 0, 0, paint_mask);
                    paint_mask.setXfermode(null);

                    canvas.drawBitmap(result,0,0,null);



        }else {

                paint.setStyle(Paint.Style.FILL);
                paint.setColor(Color.parseColor(fill_back_color));
                canvas.drawCircle(cPw, cPh, RADIOUS, paint);


                paint.setStyle(Paint.Style.STROKE);
                paint.setColor(Color.parseColor(draw_color));
                canvas.drawCircle(cPw, cPh, RADIOUS, paint);
            }
        }else{
            paint.setStyle(Paint.Style.STROKE);
            canvas.drawCircle(cPw,cPh,RADIOUS,paint);
        }


        /*path = new Path();
        path.setFillType(Path.FillType.EVEN_ODD);
        path.moveTo(0,0);
        path.lineTo(0,h);
        path.lineTo(w,h);
        path.close();*/
        //canvas.drawPath(path, paint);

    }
}