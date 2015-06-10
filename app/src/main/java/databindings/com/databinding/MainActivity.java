package databindings.com.databinding;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import databindings.com.databinding.adapters.BindingAdapter;
import databindings.com.databinding.databinding.ActivityMainBinding;
import databindings.com.databinding.models.User;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        final User user = new User();
        user.setFirstName("Andrei");
        user.setLastName("Boleac");
        User user1 = new User();
        user1.setFirstName("Vasile");
        user1.setLastName("Cotofana");
        User user2 = new User();
        user2.setFirstName("Ion");
        user2.setLastName("");
        List<User> usersList = new ArrayList<>();
        usersList.add(user);
        usersList.add(user1);
        usersList.add(user2);
        BindingAdapter bindingAdapter = new BindingAdapter(usersList, this);
        binding.listView.setAdapter(bindingAdapter);
        binding.setTest(user);
        binding.changeValue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.setLastName("Obama");
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
