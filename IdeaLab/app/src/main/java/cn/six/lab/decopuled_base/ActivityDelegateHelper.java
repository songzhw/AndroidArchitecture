package cn.six.lab.decopuled_base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by songzhw on 2017-01-28
 */

// Composite Pattern
public class ActivityDelegateHelper extends ActivityDelegate {
    public Map<Class<? extends ActivityDelegate>, ActivityDelegate> delegateMap = new HashMap<>();

    public ActivityDelegateHelper(Activity actv) {
        super(actv);
    }

    public void put(ActivityDelegate value){
        delegateMap.put(value.getClass(), value);
    }

    public void remove(Class<? extends ActivityDelegate> key){
        delegateMap.remove(key);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        for(Map.Entry<Class<? extends ActivityDelegate>, ActivityDelegate> item :delegateMap.entrySet()) {
            item.getValue().onCreate(savedInstanceState);
        }
    }

    @Override
    protected void onStart() {
        for(Map.Entry<Class<? extends ActivityDelegate>, ActivityDelegate> item :delegateMap.entrySet()) {
            item.getValue().onStart();
        }
    }

    @Override
    protected void onResume() {
        for(Map.Entry<Class<? extends ActivityDelegate>, ActivityDelegate> item :delegateMap.entrySet()) {
            item.getValue().onResume();
        }
    }

    @Override
    protected void onPause() {
        for(Map.Entry<Class<? extends ActivityDelegate>, ActivityDelegate> item :delegateMap.entrySet()) {
            item.getValue().onPause();
        }
    }

    @Override
    protected void onStop() {
        for(Map.Entry<Class<? extends ActivityDelegate>, ActivityDelegate> item :delegateMap.entrySet()) {
            item.getValue().onStop();
        }
    }

    @Override
    protected void onDestroy() {
        for(Map.Entry<Class<? extends ActivityDelegate>, ActivityDelegate> item :delegateMap.entrySet()) {
            item.getValue().onDestroy();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        for(Map.Entry<Class<? extends ActivityDelegate>, ActivityDelegate> item :delegateMap.entrySet()) {
            item.getValue().onActivityResult(requestCode, resultCode, data);
        }
    }

}
