package com.example.wctm.ui.faculty;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.wctm.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class facultyFragment extends Fragment {

    private RecyclerView btechDepartment, mtechDepartment, bcaDepartment, mcaDepartment, bbaDepartment, mbaDepartment, diplomaDepartment;
    private LinearLayout btechNOData, mtechNoDaat, bcaNoData, mcaNoData, bbaNoData, mbaNoData, diplomaNoData;
    private ArrayList<TeacherData> list1, list2, list3, list4, list5, list6, list7;

    private DatabaseReference reference, dbRef;
    private TeacherAdapter adapter;





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_faculty, container, false);

        btechNOData = view.findViewById(R.id.btechNoData);
        mtechNoDaat = view.findViewById(R.id.mtechNoData);
        bcaNoData= view.findViewById(R.id.bcaNoData);
        mcaNoData= view.findViewById(R.id.mcaNoData);
        bbaNoData= view.findViewById(R.id.bbaNoData);
        mbaNoData= view.findViewById(R.id.mbaNoData);
        diplomaNoData= view.findViewById(R.id.diplomaNoData);

        btechDepartment = view.findViewById(R.id.btechDepartment);
        mtechDepartment = view.findViewById(R.id.mtechDepartment);
        bcaDepartment = view.findViewById(R.id.bcaDepartment);
        mcaDepartment = view.findViewById(R.id.mcaDepartment);
        bbaDepartment = view.findViewById(R.id.bbaDepartment);
        mbaDepartment = view.findViewById(R.id.mbaDepartment);
        diplomaDepartment= view.findViewById(R.id.diplomaDepartment);



        reference = FirebaseDatabase.getInstance().getReference().child("teacher");

        btechDepartment();
        mtechDepartment();
        bcaDepartment();
        mcaDepartment();
        bbaDepartment();
        mbaDepartment();
        diplomaDepartment();
      return view;
    }

    private void btechDepartment() {

        dbRef = reference.child("Btech"); //have to update

        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list1 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    btechNOData.setVisibility(View.VISIBLE);
                    btechDepartment.setVisibility(View.GONE);
                }
                else {
                    btechNOData.setVisibility(View.GONE);
                    btechDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list1.add(data);
                    }
                    btechDepartment.setHasFixedSize(true);
                    btechDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list1, getContext());
                    btechDepartment.setAdapter(adapter);
                    adapter.notifyDataSetChanged();

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void mtechDepartment() {
        dbRef = reference.child("Mtech");
        //have to update
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list2 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    mtechNoDaat.setVisibility(View.VISIBLE);
                    mtechDepartment.setVisibility(View.GONE);
                }
                else {
                    mtechNoDaat.setVisibility(View.GONE);
                    mtechDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list2.add(data);
                    }
                    mtechDepartment.setHasFixedSize(true);
                    mtechDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list2,getContext());
                    mtechDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void bcaDepartment() {
        dbRef = reference.child("Bca"); //have to update
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list3 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    bcaNoData.setVisibility(View.VISIBLE);
                    bcaDepartment.setVisibility(View.GONE);
                }
                else {
                    bcaNoData.setVisibility(View.GONE);
                    bcaDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list3.add(data);
                    }
                    bcaDepartment.setHasFixedSize(true);
                    bcaDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list3,getContext());
                    bcaDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void mcaDepartment() {
        dbRef = reference.child("Mca"); //have to update
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list4 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    mcaNoData.setVisibility(View.VISIBLE);
                    mcaDepartment.setVisibility(View.GONE);
                }
                else {
                    mcaNoData.setVisibility(View.GONE);
                    mcaDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list4.add(data);
                    }
                    mcaDepartment.setHasFixedSize(true);
                    mcaDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list4,getContext());
                    mcaDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void bbaDepartment() {
        dbRef = reference.child("Bba"); //have to update
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list5 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    bbaNoData.setVisibility(View.VISIBLE);
                    bbaDepartment.setVisibility(View.GONE);
                }
                else {
                    bbaNoData.setVisibility(View.GONE);
                    bbaDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list5.add(data);
                    }
                    bbaDepartment.setHasFixedSize(true);
                    bbaDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list5,getContext());
                    bbaDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void mbaDepartment() {
        dbRef= reference.child("Mba"); //have to update
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list6 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    mbaNoData.setVisibility(View.VISIBLE);
                    mbaDepartment.setVisibility(View.GONE);
                }
                else {
                    mbaNoData.setVisibility(View.GONE);
                    mbaDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list6.add(data);
                    }
                    mbaDepartment.setHasFixedSize(true);
                    mbaDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list6,getContext());
                    mbaDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void diplomaDepartment() {
        dbRef = reference.child("Diploma"); //have to update
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list7 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    diplomaNoData.setVisibility(View.VISIBLE);
                    diplomaDepartment.setVisibility(View.GONE);
                }
                else {
                    diplomaNoData.setVisibility(View.GONE);
                    diplomaDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list7.add(data);
                    }
                    diplomaDepartment.setHasFixedSize(true);
                    diplomaDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list7,getContext());
                    diplomaDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

}