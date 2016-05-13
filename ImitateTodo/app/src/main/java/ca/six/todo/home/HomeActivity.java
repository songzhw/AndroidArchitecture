package ca.six.todo.home;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

import ca.six.todo.R;
import ca.six.todo.model.Task;
import ca.six.util.L;

// TODO generic to make presenter follow the Activity's life cycle
public class HomeActivity extends AppCompatActivity {
    private HomePresenter presenter;
    private RecyclerView rv;
    private HomeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        rv = (RecyclerView) findViewById(R.id.rvHome);
        rv.setLayoutManager( new LinearLayoutManager(this));
        adapter = new HomeAdapter();
        rv.setAdapter(this.adapter);

        presenter = new HomePresenter(this);
        presenter.getTasks();
    }

    public void showTasks(List<Task> tasks) {
        adapter.data = tasks;
        adapter.notifyDataSetChanged();
        L.d(" size = "+tasks.size());
    }
}
