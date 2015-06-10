package databindings.com.databinding.adapters;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

import databindings.com.databinding.R;
import databindings.com.databinding.databinding.ListItemBinding;
import databindings.com.databinding.models.User;

/**
 * Created by andrei on 5/31/2015.
 */
public class BindingAdapter extends BaseAdapter {

    private List<User> usersList;
    private Context context;

    public BindingAdapter(List<User> usersList, Context context) {
        this.usersList = usersList;
        this.context = context;
    }


    @Override
    public int getCount() {
        return usersList.size();
    }

    @Override
    public Object getItem(int position) {
        return usersList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ListItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.list_item, parent, false);
        User user = usersList.get(position);
        binding.setUser(user);

        return binding.getRoot();
    }
}
