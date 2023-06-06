package com.example.wctm.ui.about;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.wctm.R;

import java.util.ArrayList;
import java.util.List;

public class aboutFragment extends Fragment {
 private ViewPager viewPager;
 private BranchAdapter adapter;
 private List<CourseModel> list;
    private ImageView map;



    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_about, container, false);

        list = new ArrayList<>();
        list.add(new CourseModel(R.drawable.ic_book, "Btech","WCTM provide a 4 year Bachelor of Technology in Department of Computer Science And Others Mechanical, Automation Engineering,Mechanical Engineering,Civil Engineering"));
        list.add(new CourseModel(R.drawable.ic_book, "Mtech", "Masters of Technology is a 2-year regular course at WCTM. We provide specialization in various domains include Civil Engineering, Artificial Intelligence and Data Science, Computer Science Engineering, Mechanical Engineering, Civil Engineering"));
        list.add(new CourseModel(R.drawable.ic_book, "Bba","For equipping the world class business leaders BBA has become a fairly popular course of study. It is an astute choice for aspiring business professionals as a stepping stone towards their journey of becoming business leaders that not only shape their future but also the economy of a country." ));
        list.add(new CourseModel(R.drawable.ic_book, "Mba", "The full time MBA/BBA (Masters of Business Administration) program is focused on Management Systems and is designed to be completed in two years."));
        list.add(new CourseModel(R.drawable.ic_book, "Bca", "Department of Computer Application envisions imparting high eminence skills in software Development to excel in Software Industry and to train the students to develop the soft skills with global standards and enhance their knowledge in Information Technology."));
        list.add(new CourseModel(R.drawable.ic_book, "Mca", "2 years course where students are expected to gain a comprehensive knowledge and experience of how computer applications can provide solutions through application software, web/internet based solution and its enabled service."));
        list.add(new CourseModel(R.drawable.ic_book, "Diploma", "Diploma in agriculture engineering is a three-year program offered by Haryana. The program plays an important role in increasing the production and productivity of crops, thereby, increasing the income of farmers." ));

        adapter= new BranchAdapter(getContext(), list);

        viewPager = view.findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);

        map = view.findViewById(R.id.map);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMap();
            }
        });

       return view;
    }
        private void openMap() {
            Uri uri = Uri.parse("geo:0, 0?q=world college of technology and management");
            Intent intent  = new Intent(Intent.ACTION_VIEW, uri);
            intent.setPackage("com.google.android.apps.maps");
            startActivity(intent);

        }
}