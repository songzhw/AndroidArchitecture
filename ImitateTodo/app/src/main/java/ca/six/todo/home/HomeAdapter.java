package ca.six.todo.home;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

import ca.six.todo.R;
import ca.six.todo.model.Task;

/**
 * Created by songzhw on 2016-05-12.
 */
public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {
    public List<Task> data;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home, null);
        ViewHolder holder = new ViewHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if(data != null && data.size() > position){
            Task task = data.get(position);
            holder.cbComplete.setChecked(task.isCompleted);
            holder.tvTask.setText(task.content);
        }
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public CheckBox cbComplete;
        public TextView tvTask;

        public ViewHolder(View itemView) {
            super(itemView);
            tvTask = (TextView) itemView.findViewById(R.id.tvTask);
            cbComplete = (CheckBox) itemView.findViewById(R.id.cbComplete);
        }
    }
}
