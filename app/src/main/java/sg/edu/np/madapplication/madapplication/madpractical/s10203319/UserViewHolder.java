package sg.edu.np.madapplication.madapplication.madpractical.s10203319;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

public class UserViewHolder extends RecyclerView.ViewHolder {
    TextView name;
    TextView description;
    ImageView prof;

    public UserViewHolder(View itemView){
        super(itemView);
        name = itemView.findViewById(R.id.NameViewHolder);
        description = itemView.findViewById(R.id.DescViewHolder);
        prof = itemView.findViewById(R.id.ProfilePicViewHolder);
    }
}
