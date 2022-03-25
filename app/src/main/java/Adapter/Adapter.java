package Adapter;

import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myrecycler.R;
import com.example.myrecycler.Item;

import java.util.ArrayList;

import Listener.onClickListeners;

public abstract class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private RecyclerView rv_moh;
    private Context context;
    private ArrayList<Item> Items;
    onClickListeners on;


    public Adapter(Context context, ArrayList<Item> Items, onClickListeners on) {
        this.rv_moh = rv_moh;
        this.context = context;
        this.Items = Items;
        this.on = on;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.my_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        Item item = Items.get(position);
        holder.name.setText("mohammed");
        holder.phone.setText("0598230691");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                on.onItemCLickListener(item);
            }
        });

    }

    @Override
    public int getItemCount() {
        return Items.size();
    }

    public abstract void onItemCLickListener(Item item);

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView phone;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name =itemView.findViewById(R.id.tv_name);
            phone =itemView.findViewById(R.id.tv_phone);

        }
    }
}
