package in.creativelizard.shapeutil;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
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

public class ShapeImageView extends View {
    private Context mContext;
    Paint paint ;
    public int feel_type;
    public Bitmap draw_back_img_bmp;
    public String fill_back_color = "#c2c2c2";
    public Drawable draw_back_img,draw_back_img_mask;
    private Canvas mCanvas,canvas_rslt;
    private Bitmap original, mask;

    public ShapeImageView(Context ctx, AttributeSet attrs) {
        super(ctx, attrs);

        TypedArray a = ctx.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.ShapeImageView,
                0, 0);

        try {
            fill_back_color =a.getString(R.styleable.ShapeImageView_sm_feel_back_color);
            draw_back_img =a.getDrawable(R.styleable.ShapeImageView_sm_draw_img_back);
            draw_back_img_mask = a.getDrawable(R.styleable.ShapeImageView_sm_draw_img_mask);
            feel_type = a.getInteger(R.styleable.ShapeImageView_sm_feel_type, 1);
        } finally {
            a.recycle();
        }

        mContext = ctx;
        setWillNotDraw(false);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        mCanvas = canvas;
        int w = getWidth(), h = getHeight();
        paint.setAntiAlias(true);
        try {
            draw_back_img_bmp = ((BitmapDrawable) draw_back_img).getBitmap();
        }catch (NullPointerException e){
            //
        }
        if (draw_back_img!=null){
            original = draw_back_img_bmp;
            mask = ((BitmapDrawable) draw_back_img_mask).getBitmap();
            switch (feel_type){
                case 0:
                    original = Bitmap.createScaledBitmap(original, w, h, false);
                    mask = Bitmap.createScaledBitmap(mask, w, h, false);
                    break;
                case 1:
                    //original = Bitmap.createScaledBitmap(original, w, h, false);
                    break;
                case 2:
                    if(w>h){
                        original = Bitmap.createScaledBitmap(original, h, h, false);
                        mask = Bitmap.createScaledBitmap(mask, h, h, false);
                    }else if(w<h){
                        original = Bitmap.createScaledBitmap(original, w, w, false);
                        mask = Bitmap.createScaledBitmap(mask, w, w, false);
                    }else {
                        original = Bitmap.createScaledBitmap(original, w, h, false);
                        mask = Bitmap.createScaledBitmap(mask, w, h, false);
                    }
                    break;
            }


                 //Canvas canvas_mask = new Canvas(mask);
                int centreX = (w - original.getWidth()) / 2;

                int centreY = (h - original.getHeight()) / 2;

                int centreX_mask = (original.getWidth() - mask.getWidth()) / 2;

                int centreY_mask = (original.getHeight() - mask.getHeight()) / 2;
                if(draw_back_img_mask!=null) {



                    //canvas_mask.drawBitmap(mask, centreX, centreY, null);

                    Bitmap result = Bitmap.createBitmap(original.getWidth(), original.getHeight(), Bitmap.Config.ARGB_8888);
                     canvas_rslt = new Canvas(result);
                    Paint paint_mask = new Paint(Paint.ANTI_ALIAS_FLAG);
                    paint_mask.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));


                    canvas_rslt.drawBitmap(original, 0, 0, null);
                    canvas_rslt.drawBitmap(mask, centreX_mask, centreY_mask, paint_mask);
                    paint_mask.setXfermode(null);

                    canvas.drawBitmap(result, centreX, centreY, null);
                }


        }else {

               // paint.setStyle(Paint.Style.FILL);
                //paint.setColor(Color.parseColor(fill_back_color));
                //canvas.drawCircle(cPw, cPh, RADIOUS, paint);


               /* paint.setStyle(Paint.Style.STROKE);
                paint.setColor(Color.parseColor(draw_color));
                canvas.drawCircle(cPw, cPh, RADIOUS, paint);*/
               canvas.drawColor(Color.parseColor(fill_back_color));
            }



        /*path = new Path();
        path.setFillType(Path.FillType.EVEN_ODD);
        path.moveTo(0,0);
        path.lineTo(0,h);
        path.lineTo(w,h);
        path.close();*/
        //canvas.drawPath(path, paint);

    }

    public void setImageShapeImageResources(int drawable){
        try {
            draw_back_img_bmp = ((BitmapDrawable)getResources().getDrawable(drawable)).getBitmap();
            /*canvas_rslt.setBitmap(draw_back_img_bmp);*/
            invalidate();
        }catch (NullPointerException e){
            //
        }
    }

    public void setShapeImageBitmap(Bitmap bitmap){
        try {
            draw_back_img_bmp =bitmap;
            canvas_rslt.setBitmap(draw_back_img_bmp);
            invalidate();
        }catch (NullPointerException e){
            //
        }
    }
}