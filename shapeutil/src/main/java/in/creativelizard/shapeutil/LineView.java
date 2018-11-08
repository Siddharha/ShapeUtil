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
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

/**
 * Created by Siddhartha on 6/8/2018.
 */

public class LineView extends View {
    public float LN_PROGRESS;
    public   float STROKE_SIZE;
    public float ANIMATION_TO = 0;
    private Context mContext;
    Paint paint ;
    public String draw_color;

    public LineView(Context ctx, AttributeSet attrs) {
        super(ctx, attrs);
        TypedArray a = ctx.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.LineView,
                0, 0);

        try {
            draw_color =a.getString(R.styleable.LineView_ln_color);
            STROKE_SIZE = a.getFloat(R.styleable.LineView_ln_stroke, -1F);
            LN_PROGRESS = a.getFloat(R.styleable.LineView_ln_progress, 0F);
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
            paint.setStrokeWidth(STROKE_SIZE);
        if(draw_color!=null) {
            paint.setColor(Color.parseColor(draw_color));
        }else {
            paint.setColor(Color.parseColor("#c2c2c2"));
        }
        paint.setAntiAlias(true);


                paint.setStyle(Paint.Style.FILL_AND_STROKE);
                paint.setColor(Color.parseColor(draw_color));

        float toGO = (LN_PROGRESS/100) * w;
                if(LN_PROGRESS>0) {
                    canvas.drawLine(ANIMATION_TO, (h / 2), toGO, (h / 2), paint);
                }else {
                    canvas.drawLine(ANIMATION_TO, (h / 2), w, (h / 2), paint);
                }

       /* Path path = new Path();
        path.setFillType(Path.FillType.EVEN_ODD);
        path.moveTo(0,0);
        path.lineTo(0,h);
        path.lineTo(w,h);
        path.close();
        canvas.drawPath(path, paint);*/

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // Try for a width based on our minimum
        int minw = getPaddingLeft() + getPaddingRight() + getSuggestedMinimumWidth();
        int w = resolveSizeAndState(minw, widthMeasureSpec, 1);

        // Whatever the width ends up being, ask for a height that would let the pie
        // get as big as it can
        int minh = getPaddingLeft() + getPaddingRight() + getSuggestedMinimumHeight();
        int h = resolveSizeAndState(minh + (int)STROKE_SIZE, heightMeasureSpec, 1);

        setMeasuredDimension(w,h);
    }
}