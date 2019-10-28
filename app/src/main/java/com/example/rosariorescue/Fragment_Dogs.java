package com.example.rosariorescue;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Fragment_Dogs extends Fragment implements AnimalAdapter.OnAnimalCardListener {

    View v;
    private RecyclerView myRecyclerView;

    private List<Animal> AnimalsList;
    private AnimalAdapter animalAdapter;

    public Fragment_Dogs() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_dogs, container, false);

        myRecyclerView = v.findViewById(R.id.recycler_view_dogs);
        animalAdapter = new AnimalAdapter(getContext(), AnimalsList, this);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        myRecyclerView.setAdapter(animalAdapter);

        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AnimalsList = new ArrayList<>();

        prepareAlbums();
    }

    private void prepareAlbums() {
        int[] covers = new int[]{
                R.drawable.dog1,
                R.drawable.dog2,
                R.drawable.dog3,
                R.drawable.dog4,
                R.drawable.dog5,
                R.drawable.dog6};

        Animal a = new Animal("30-09-19", 13, covers[0], "Test Description", 1);
        AnimalsList.add(a);

        a = new Animal("29-09-19", 8, covers[1], "Test Description", 1);
        AnimalsList.add(a);

        a = new Animal("28-09-19", 11, covers[2], "Test Description", 1);
        AnimalsList.add(a);

        a = new Animal("12-09-19", 13, covers[3], "Test Description", 1);
        AnimalsList.add(a);

        a = new Animal("03-09-19", 8, covers[4], "Test Description", 1);
        AnimalsList.add(a);

        a = new Animal("18-09-19", 11, covers[5], "Test Description", 1);
        AnimalsList.add(a);

    }

    @Override
    public void onAnimalCardClick(int position) {
        Intent intent = new Intent(getContext(), AnimalFullDescription.class);
        intent.putExtra("animal_position", position);
        intent.putExtra("animal_type", "dogs");
        getContext().startActivity(intent);
    }
}
