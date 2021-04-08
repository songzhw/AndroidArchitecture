package ca.six.todo.view.rv;

import android.support.v7.widget.RecyclerView;
import android.view.View;

// RecyclerView.ViewHolder是一个abstract类， 所以这里创建一个子类很有重要
public class OneBindingViewHolder extends RecyclerView.ViewHolder {

    public OneBindingViewHolder(View itemView) {
        super(itemView);
    }
}