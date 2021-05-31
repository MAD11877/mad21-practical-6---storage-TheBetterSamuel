package sg.edu.np.madapplication.madapplication.madpractical.s10203319;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserListAdapter extends RecyclerView.Adapter<UserViewHolder> {
    ArrayList<User> userList;
    Context context;

    public UserListAdapter(ArrayList<User> uL, Context c){
        userList = uL;
        context = c;
    }

    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View item = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.user_view_holder, parent, false
        );
        return new UserViewHolder(item);
    }

    public void onBindViewHolder(UserViewHolder holder, int position){
        User u = userList.get(position);
        holder.name.setText(u.name);
        holder.description.setText(u.description);

        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        builder.setTitle("Profile");
        builder.setMessage("MADness");
        builder.setCancelable(true);
        builder.setNegativeButton("CANCEL",null);
        builder.setPositiveButton("VIEW", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int id){
                Intent redirect = new Intent(context, MainActivity.class);
                redirect.putExtra("Key", position);
                context.startActivity(redirect);
            }
        });

        holder.prof.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AlertDialog alert = builder.create();
                alert.show();
            }
        });
    }

    public int getItemCount(){
        return userList.size();
    }
}
