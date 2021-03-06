package com.maxleap.sample.login.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Toast;
/**
 * @author Walking
 */
public class BaseActivity extends AppCompatActivity {

    protected Context mContext;

    public final String TAG = getClass().getSimpleName();

    public static final String TITLE = "title";

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        initTitle();


    }

    public void initTitle() {
        Bundle extras = getIntent().getExtras();
        if (extras != null && extras.containsKey(TITLE)) {
            String string = extras.getString(TITLE);
            setTitle(string);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    public void goNext(String name, Class c) {
        Intent i = new Intent(this, c);
        i.putExtra(BaseActivity.TITLE, name);
        startActivity(i);
    }

    public void showToast(String msg) {

        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();

    }
}
