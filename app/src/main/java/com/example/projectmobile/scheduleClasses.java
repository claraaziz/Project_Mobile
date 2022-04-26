package com.example.projectmobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.projectmobile.R;

import java.util.ArrayList;

public class scheduleClasses extends AppCompatActivity {
    ArrayList<ClassesModel> classesModels = new ArrayList<>();
    int[] classesImages={R.drawable.yoga,R.drawable.hiit,R.drawable.box, R.drawable.zumba,R.drawable.fitness};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scedule_classes);

        RecyclerView recyclerView=findViewById(R.id.mRecyclerView);

        steUpClassesModels();

        programAdapter adapter=new programAdapter(this,classesModels);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter.onRecyclerViewClickListener(new programAdapter.onRecyclerViewClickListener() {
            @Override
            public void onItemClick(int position) {
//                Toast.makeText(MainActivity.this, "position" +  position,Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(scheduleClasses.this,classesDescription.class);
                intent.putExtra("containerINTENT",classesModels.get(position).getName());
                intent.putExtra("contentINTENT",classesModels.get(position).getDescription());
                intent.putExtra("imageINTENT",classesModels.get(position).getImage());
                startActivity(intent);


            }
        });
    }
    private void steUpClassesModels(){
        String[] classesNames=getResources().getStringArray(R.array.classes_names);
        String[] classesDescriptions=getResources().getStringArray(R.array.descriptions);
        for(int i =0;i<classesNames.length;i++){
            classesModels.add(new ClassesModel(classesNames[i],classesDescriptions[i],classesImages[i]));

        }
    }




                    //////////NAVBAR//////////
//    public void ongohome(View view) {
//        Intent i =new Intent(this,HomeActivity.class);
//    }
//
//    public void ongogym(View view) {
//        Intent i =new Intent(this,Workout1.class);
//
//    }
//
//    public void ongosession(View view) {
//        Intent i =new Intent(this,scheduleClasses.class);
//    }
//
//    public void ongoprofile(View view) {
//        Intent i =new Intent(this,ProfileActivity.class);
//    }

}