package be.ehb.notedroid.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import be.ehb.notedroid.R;
import be.ehb.notedroid.model.Note;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {


    public DetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);

        TextView titleEt = rootView.findViewById(R.id.et_title);
        TextView contentEt = rootView.findViewById(R.id.et_content);

        Bundle data = getArguments();
        if(data != null){
            if (data.containsKey("passedNote")){
                Note note = (Note) data.getSerializable("passedNote");
                titleEt.setText(note.getTitle());
                contentEt.setText(note.getContent());


            }
        }

        // Inflate the layout for this fragment
        return rootView;
    }

}
