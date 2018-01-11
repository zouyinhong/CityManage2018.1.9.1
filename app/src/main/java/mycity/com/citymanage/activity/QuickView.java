package mycity.com.citymanage.activity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import mycity.com.citymanage.R;

/**
 * Created by Administrator on 2017/12/28.
 */

public class QuickView extends View {
    private static final String TAG = "QuickView";

    private String[] indexArr = {"A", "B", "C", "D", "E", "F", "G", "H",
            "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U",
            "V", "W", "X", "Y", "Z"};
    private Paint paint;
    private float cellHeight;
    private int currentIndex;
    private OnTextChangeListener mOnTextChangeListener;

    public QuickView(Context context) {
        this(context, null);
    }

    public QuickView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public QuickView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.BLUE);
        /**通过dimens设置文字的规格*/
        paint.setTextSize(getResources().getDimensionPixelSize(R.dimen.font_12));
        paint.setTextAlign(Paint.Align.CENTER);

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        cellHeight = getMeasuredHeight() * 1f / indexArr.length;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i = 0; i < indexArr.length; ++i) {

            float x = getMeasuredWidth() / 2;
            float y = cellHeight / 2 + cellHeight * i + getTextHeight(indexArr[i]) / 2;
            paint.setColor(i==currentIndex?Color.WHITE:Color.BLACK);
            canvas.drawText(indexArr[i], x, y, paint);
        }

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:

                int index= (int) (event.getY()/cellHeight);
                if(currentIndex!=index){
                    if(index>=0&&index<indexArr.length){
                        Log.i(TAG, "onTouchEvent: "+indexArr[index]);
                        if(mOnTextChangeListener!=null){
                            mOnTextChangeListener.textChange(indexArr[index]);
                        }

                    }
                    currentIndex=index;
                }
                break;
            case MotionEvent.ACTION_UP:
                currentIndex = -1;
                break;
        }
        invalidate();
        return true;
    }

    private float getTextHeight(String s) {
        /**
         * start end 表示的是文字的起始位置，如果文字有一大串，表示从第start个到end个
         * bounds 文字的举行边框
         */
        Rect bounds = new Rect();
        paint.getTextBounds(s, 0, s.length(), bounds);
        return bounds.height();
    }

    public void setOnTextChangeListener(OnTextChangeListener mOnTextChangeListener) {
        this.mOnTextChangeListener = mOnTextChangeListener;
    }

    public  interface OnTextChangeListener {

        void textChange(String text);
    }
}