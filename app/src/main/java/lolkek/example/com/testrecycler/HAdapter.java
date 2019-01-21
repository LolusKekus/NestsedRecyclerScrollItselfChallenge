package lolkek.example.com.testrecycler;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import java.util.List;

/**
 * Created by lolkek on 19.10.18.
 */

public class HAdapter extends RecyclerView.Adapter<HAdapter.MyHolder> {
    private final static String TAG = HAdapter.class.getName();
    private List<String> dataset;

    public HAdapter(List<String> dataset) {
        this.dataset = dataset;
    }

    public static class MyHolder extends RecyclerView.ViewHolder {

        private TextView tvItemText;
        private FrameLayout flContainer;

        public MyHolder(FrameLayout itemView) {
            super(itemView);
            tvItemText = itemView.findViewById(R.id.tvItemText);
            flContainer = itemView.findViewById(R.id.flContainer);
        }

        public void setOnFocusListener(View.OnFocusChangeListener onFocusListener) {
            flContainer.setOnFocusChangeListener(onFocusListener);
        }

        public void setItemText(String text) {
            if (tvItemText != null) {
                tvItemText.setText(text);
            }

        }

    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        FrameLayout itemView = (FrameLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        return new MyHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final @NonNull MyHolder holder, final int position) {
        holder.setItemText(dataset.get(position));
        holder.setOnFocusListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b) {
                    Log.d(TAG, "onFocusChange: item view focused");
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }
}
