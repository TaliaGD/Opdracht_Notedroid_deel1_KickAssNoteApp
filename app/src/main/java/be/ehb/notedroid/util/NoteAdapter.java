package be.ehb.notedroid.util;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import be.ehb.notedroid.R;
import be.ehb.notedroid.model.Note;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteViewHolder> {


    class NoteViewHolder extends RecyclerView.ViewHolder {
        final TextView tvTitle;
        final TextView tvDate;
        final Button btnDelete;
        final Button btnAdjust;

        final View.OnClickListener detailListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = getAdapterPosition();
                Bundle data = new Bundle();
                data.putSerializable("passNote", items.get(position));
                Navigation.findNavController(view).navigate(R.id.noteToDetail, data);
            }
        };


        //default constructor zonder parameters

        public NoteViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvDate = itemView.findViewById(R.id.tv_date);
            btnDelete = itemView.findViewById(R.id.btn_delet);
            btnAdjust = itemView.findViewById(R.id.btn_adjust);
            btnAdjust.setOnClickListener(detailListener);
        }

    }


    private ArrayList<Note> items;

    public NoteAdapter() {
        items = new ArrayList<>();
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View card = layoutInflater.inflate(R.layout.note_card, parent, false);

        return new NoteViewHolder(card);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        Note currentNote = items.get(position);
        holder.tvTitle.setText(currentNote.getTitle());
    }


    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addItems(ArrayList<Note> notes) {
        items.clear();
        items.addAll(notes);
    }
}

