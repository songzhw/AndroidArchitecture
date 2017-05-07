package ca.six.clean.biz.add;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import ca.six.clean.R;
import ca.six.clean.domain.gateway.FakeEntityGateway;
import ca.six.clean.domain.usecase.AddTweetUseCase;

public class AddTweetActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    private CheckBox cb;
    private EditText et;
    private FloatingActionButton fab;
    private AddTweetPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_tweet);

        AddTweetUseCase useCase = new AddTweetUseCase(new FakeEntityGateway());
        presenter = new AddTweetPresenter(useCase);

        cb = (CheckBox) findViewById(R.id.cbAddTweet);
        cb.setOnCheckedChangeListener(this);
        et = (EditText) findViewById(R.id.etAddTweet);
        et.addTextChangedListener(textWatcher);
        fab = (FloatingActionButton) findViewById(R.id.fabAddTweet);
        fab.setOnClickListener(this);
    }

    private TextWatcher textWatcher = new TextWatcher() {
        @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
        @Override public void onTextChanged(CharSequence s, int start, int before, int count) { }
        @Override public void afterTextChanged(Editable s) {

        }
    };

    @Override
    public void onClick(View v) {
        presenter.save(et.getText().toString(), cb.isChecked());
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

    }
}
