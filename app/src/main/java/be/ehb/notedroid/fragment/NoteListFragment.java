package be.ehb.notedroid.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import be.ehb.notedroid.R;
import be.ehb.notedroid.model.Note;
import be.ehb.notedroid.model.NoteViewModel;
import be.ehb.notedroid.util.NoteAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class NoteListFragment extends Fragment {


   private NoteAdapter adapter;
    public NoteListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_note_list, container, false);

        //verwijzing naar UI
        RecyclerView rvNotes = rootView.findViewById(R.id.rv_notes);


        //opvullenrecycler (lijst)
        rvNotes.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));

        //adapter
        adapter = new NoteAdapter();
        rvNotes.setAdapter(adapter);

        //verwijzing naar ViewModel (hier staat alle data)
        NoteViewModel model = new ViewModelProvider(this).get(NoteViewModel.class);
        model.getNotes().observe(getViewLifecycleOwner(), new Observer<ArrayList<Note>>() {
            @Override
            public void onChanged(ArrayList<Note> notes) {
                adapter.addItems(notes);
                adapter.notifyDataSetChanged();
            }

        });
        return rootView;
    }

}
