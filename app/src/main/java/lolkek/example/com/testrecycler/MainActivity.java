package lolkek.example.com.testrecycler;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView vRecyclerView;
    int hItemsCount = 100;
    int vItemsCount = 1000;
    Context context;
    private static final String TAG = MainActivity.class.getSimpleName();

    List<String> hDataset;
    List<Integer> vDataset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        hDataset = new ArrayList<>();
        for (int i=0; i<hItemsCount; i++) {
            hDataset.add(String.format("lolKek Cheburek %d", i));
        }

        vDataset = new ArrayList<>();
        for (int i=0; i<vItemsCount; i++) {
            vDataset.add(i);
        }

        vRecyclerView = (RecyclerView) findViewById(R.id.vRecyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        vRecyclerView.setLayoutManager(layoutManager);
        vRecyclerView.setAdapter(new VAdapter(vDataset, hDataset, context, vRecyclerView.getWidth()));
        vRecyclerView.setNestedScrollingEnabled(false);

    }

}
