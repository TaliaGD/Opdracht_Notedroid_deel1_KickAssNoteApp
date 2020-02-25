package be.ehb.notedroid.model;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class NoteViewModel extends ViewModel {

    private MutableLiveData<ArrayList<Note>>notes;
    public MutableLiveData<ArrayList<Note>>getNotes(){
        if(notes == null){
            notes = new MutableLiveData<>();
            loadNotes();
        }
        return notes;
    }

    private void loadNotes(){
        ArrayList<Note> newNotes = new ArrayList<>();

        newNotes.add(new Note("lol","lol"));

        notes.postValue(newNotes);

    }
}
