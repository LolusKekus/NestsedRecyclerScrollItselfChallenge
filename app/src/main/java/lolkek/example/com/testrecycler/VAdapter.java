package lolkek.example.com.testrecycler;

import android.content.Context;
import android.graphics.Point;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by lolkek on 19.10.18.
 */

public class VAdapter extends RecyclerView.Adapter<VAdapter.MyVertHolder> {

    private final static String TAG = VAdapter.class.getName();
    private List<Integer> vDataset;
    private List<String> hDataset;
    public static RecyclerView.RecycledViewPool hRecycledViewPool;
    private static Context context;

    public VAdapter(List<Integer> vDataset, List<String> hDataset) {
        this.vDataset = vDataset;
        this.hDataset = hDataset;
        hRecycledViewPool = new RecyclerView.RecycledViewPool();
    }

    public VAdapter(List<Integer> vDataset, List<String> hDataset, Context context, int windowSize) {
        this(vDataset, hDataset);
        VAdapter.context = context;
    }

    public static class MyVertHolder extends RecyclerView.ViewHolder {
        MyRecyclerView hRecyclerView;

        public MyVertHolder(final View itemView) {
            super(itemView);
            hRecyclerView = itemView.findViewById(R.id.hRecyclerView);
        }

        public void setAdapter(HAdapter adapter) {
            hRecyclerView.setAdapter(adapter);
        }

        public void setLayoutManager(LinearLayoutManager layoutManager) {
            hRecyclerView.setLayoutManager(layoutManager);
        }

        public void setOnFocusChange(View.OnFocusChangeListener l) {
            hRecyclerView.setOnFocusChangeListener(l);
        }
    }

    @NonNull
    @Override
    public MyVertHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: viewType " + viewType);
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.v_item_view, parent, false);
        MyVertHolder holder = new MyVertHolder(itemView);
        holder.setAdapter(new HAdapter(hDataset));
        CustomLayotManager layotManager = new CustomLayotManager(context, LinearLayoutManager.HORIZONTAL, false);
        layotManager.setLeftMargin(20);
        layotManager.setViewCount(5);
        Display display = ((MainActivity)context).getWindowManager().getDefaultDisplay();
        Point point = new Point();
        display.getSize(point);
        layotManager.setWindowSize(point.x);
//        holder.setOnFocusChange(new View.OnFocusChangeListener() {
//            @Override
//            public void onFocusChange(View view, boolean b) {
//                Log.d(TAG, "hRecyclerView.onFocusChange: ");
//                CustomLayotManager layotManager = (CustomLayotManager) ((RecyclerView) view).getLayoutManager();
//                if (b) {
//                    Log.d(TAG, "hRecyclerView.onFocusChange: scroll to");
//
////                    Log.d(TAG, "onFocusSearchFailed: findFirstVisibleItemPosition() " + layotManager.findFirstVisibleItemPosition());
////                    Log.d(TAG, "onFocusSearchFailed: findFirstCompletelyVisibleItemPosition() " + layotManager.findFirstCompletelyVisibleItemPosition());
//                    View tryFocus = layotManager.getChildAt(layotManager.findFirstVisibleItemPosition());
//                    tryFocus.setFocusable(true);
//                    tryFocus.requestFocus();
//
////                    ((RecyclerView)view).scrollToPosition(3);
////                    View view1 = ((RecyclerView) view).getLayoutManager().getChildAt(3);
////                    view1.setFocusable(true);
////                    view1.requestFocus();
//                }
//            }
//        });
//        holder.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        holder.setLayoutManager(layotManager);
        return holder;
    }

    @Override
    public void onBindViewHolder(final @NonNull MyVertHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: findFirstVisibleItemPosition" + ((CustomLayotManager)holder.hRecyclerView.getLayoutManager()).findFirstVisibleItemPosition());
        Log.d(TAG, "onBindViewHolder: findFirstCompletelyVisibleItemPosition" + ((CustomLayotManager)holder.hRecyclerView.getLayoutManager()).findFirstCompletelyVisibleItemPosition());


    }

    @Override
    public int getItemCount() {
        return vDataset.size();
    }


}
