package kai.tan.com.testscroll.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Scroller;

/**
 * 六种滑动view方式
 * Created by Administrator on 2017/7/17.
 */

public class CustomView extends View {

    private Scroller mScroller;
    private int lastX;
    private int lastY;

    public CustomView(Context context) {
        super(context);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mScroller = new Scroller(context);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        Log.d("Tag", "Left:" + getLeft() + "Top:" + getTop() + "Right:" + getRight() + "Bottom:" + getBottom());

        int x = (int) event.getX();
        int y = (int) event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                //记录按下是的位置
                lastX = x;
                lastY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                //计算相对于按下时的位置的偏移量
                int offsetX = x - lastX;
                int offsetY = y - lastY;

                //重新layout
                layout(getLeft() + offsetX, getTop() + offsetY, getRight() + offsetX, getBottom() + offsetY);

                //改变偏移量
//                offsetLeftAndRight(offsetX);
//                offsetTopAndBottom(offsetY);

                //改变布局参数
//                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getLayoutParams();
//                layoutParams.leftMargin = getLeft() + offsetX;
//                layoutParams.topMargin = getTop() + offsetY;
//                setLayoutParams(layoutParams);

                //上面几种方式 left top right bottom 属性值发生了改变

                //scrollBy
//                ((View) getParent()).scrollBy(-offsetX, -offsetY);
                break;
        }
        return true;
    }

    public void smoothScrollTo(int destX, int destY) {

        int scrollX = getScrollX();
        int delta = destX - scrollX;
        //通过提供起始点、移动距离和滚动持续时间来滚动
        mScroller.startScroll(scrollX, 0, delta, 0, 4000);
        invalidate();

    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        if(mScroller.computeScrollOffset()) {
            Log.d("Tag", "currx:" + mScroller.getCurrX() + "curry:" + mScroller.getCurrY());
            ((View)getParent()).scrollTo(mScroller.getCurrX(),mScroller.getCurrY());
            invalidate();
        }
    }
}
