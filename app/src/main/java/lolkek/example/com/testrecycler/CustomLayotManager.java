package lolkek.example.com.testrecycler;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by lolkek on 23.01.19.
 */

public class CustomLayotManager extends LinearLayoutManager {

    private static final String TAG = CustomLayotManager.class.getSimpleName();
    private int viewCount;

    private float leftMargin;

    private int windowSize;

    public CustomLayotManager(Context context) {
        super(context);
    }

    public CustomLayotManager(Context context, int orientation, boolean reverseLayout) {
        super(context, orientation, reverseLayout);
    }

    public CustomLayotManager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public int getPaddingLeft() {
        return (int)leftMargin;
    }

    @Override
    public int getPaddingRight() {
        return windowSize - windowSize/viewCount + getPaddingLeft();
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public float getLeftMargin() {
        return leftMargin;
    }

    public void setLeftMargin(float leftMargin) {
        this.leftMargin = leftMargin;
    }

    public int getWindowSize() {
        return windowSize;
    }

    public void setWindowSize(int windowSize) {
        this.windowSize = windowSize;
    }

    @Override
    public View onFocusSearchFailed(View focused, int focusDirection, RecyclerView.Recycler recycler, RecyclerView.State state) {
        return super.onFocusSearchFailed(focused, focusDirection, recycler, state);
    }

    @Override
    public boolean onRequestChildFocus(RecyclerView parent, RecyclerView.State state, View child, View focused) {
//        Log.d(TAG, "onRequestChildFocus: findFirstVisibleItemPosition() " + findFirstVisibleItemPosition());
//        parent.scrollToPosition(((CustomLayotManager)parent.getLayoutManager()).findFirstVisibleItemPosition());
        return super.onRequestChildFocus(parent, state, child, focused);
    }
}
