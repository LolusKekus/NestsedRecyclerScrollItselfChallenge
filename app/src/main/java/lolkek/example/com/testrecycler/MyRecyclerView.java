package lolkek.example.com.testrecycler;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by lolkek on 24.01.19.
 */

public class MyRecyclerView extends RecyclerView {

    View lastFocused;
    public MyRecyclerView(Context context) {
        super(context);
    }

    public MyRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    /**
     * Возможное решение как побороть прокрутку горизонтального ресайклера когда по вертикали скочишь.
     * @param focused
     * @param direction
     * @return
     */
    @Override
    public View focusSearch(View focused, int direction) {
        View view = super.focusSearch(focused, direction);

        if (view instanceof MyRecyclerView) {
            int position = ((LinearLayoutManager)((MyRecyclerView) view).getLayoutManager()).findFirstVisibleItemPosition();
            view = ((MyRecyclerView) view).getLayoutManager().findViewByPosition(position);
        }

        return view;
    }
}
