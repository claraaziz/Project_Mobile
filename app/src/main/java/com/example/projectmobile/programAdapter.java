package com.example.projectmobile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class programAdapter extends RecyclerView.Adapter<programAdapter.MyViewHolder> {
    private onRecyclerViewClickListener listener;
    public interface onRecyclerViewClickListener {

        void onItemClick(int position);
    }
    public void onRecyclerViewClickListener (onRecyclerViewClickListener listener){
        this.listener=listener;
    }


    Context context;
    ArrayList<ClassesModel> classesModels;

    public programAdapter(Context context, ArrayList<ClassesModel> classesModels) {
        this.context = context;
        this.classesModels = classesModels;

    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //this is where you inflate your layout (giving a look to our rows)the number of items you want to display
        LayoutInflater inflater = LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.recycler_view_row,parent,false);
        return new MyViewHolder(view,listener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        //assigning values to the views we created  in the recycler_view_row
        //based on the position of the recycler view
        holder.txtview.setText(classesModels.get(position).getName());
        holder.img.setImageResource(classesModels.get(position).getImage());


    }

    @Override
    public int getItemCount() {
        //recycler view just wants to know
        return classesModels.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder{
        //grabbing the views from recycler_view_row layout file
        //like in the onCreate method
        TextView txtview;
        ImageView img;
        public MyViewHolder(@NonNull View itemView,onRecyclerViewClickListener listener) {
            super(itemView);
            txtview=itemView.findViewById(R.id.txtview);
            img=itemView.findViewById(R.id.img);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null && getAdapterPosition() != RecyclerView.NO_POSITION){
                        listener.onItemClick(getAdapterPosition());

                    }
                }
            });


        }
    }
}
