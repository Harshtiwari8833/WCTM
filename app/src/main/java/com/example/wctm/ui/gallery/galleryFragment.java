package com.example.wctm.ui.gallery;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.wctm.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class galleryFragment extends Fragment {

RecyclerView convoRecycler, otherRecycler;
GalleryAdapter adapter;
   DatabaseReference refernce;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_gallery, container, false);


        convoRecycler = view.findViewById(R.id.convoRecycler);
        otherRecycler = view.findViewById(R.id.otherRecycler);
        refernce = FirebaseDatabase.getInstance().getReference().child("gallery");
        getConvoImage();
        getOtherImage();

        return view;
    }

    private void getOtherImage() {

        refernce.child("Other Events").addValueEventListener(new ValueEventListener() {
            List<String> imageList = new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
               for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                   String data = (String) snapshot.getValue();
                   imageList.add(data);
               }

               adapter = new GalleryAdapter(getContext(), imageList);
               otherRecycler.setLayoutManager(new GridLayoutManager(getContext(),3));
               otherRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getConvoImage() {
        refernce.child("Convocation").addValueEventListener(new ValueEventListener() {
        List<String> imageList = new ArrayList<>();
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                String data = (String) snapshot.getValue();
                imageList.add(data);
            }

            adapter = new GalleryAdapter(getContext(), imageList);
            convoRecycler.setLayoutManager(new GridLayoutManager(getContext(),3));
           convoRecycler.setAdapter(adapter);
        }

        @Override
        public void onCancelled(@NonNull DatabaseError error) {
            Toast.makeText(getContext(), "something went wrong", Toast.LENGTH_SHORT).show();
        }
    });

    }
}