package ca.six.bindingdemo.tmp;


import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ca.six.bindingdemo.BR;
import ca.six.bindingdemo.R;
import ca.six.bindingdemo.databinding.ActivityBindingDemoSimpleBinding;
import ca.six.bindingdemo.tmp.rv.TmpItem;
import ca.six.bindingdemo.view.OneBindingAdapter;

/**
 * Created by songzhw on 2017-02-18
 */

public class Binding01Activity extends Activity {

    private Binding01ViewModel vm;
    private ActivityBindingDemoSimpleBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_binding_demo_simple);

        vm = new Binding01ViewModel(binding);

        initRecyclerView();
    }

    private void initRecyclerView() {
        List<TmpItem> data = new ArrayList<>();
        for(int i = 0 ; i < 18; i++){
            data.add(new TmpItem("item [ "+i+" ]", i+10));
        }

        OneBindingAdapter<TmpItem> adapter = new OneBindingAdapter<>(this, R.layout.item_rv, BR.item, data);
        RecyclerView rv = binding.rvBindingDemo;
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(adapter);

    }
}
