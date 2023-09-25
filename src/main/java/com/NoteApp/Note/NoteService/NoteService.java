package com.NoteApp.Note.NoteService;

import com.NoteApp.Note.NoteModel.Note;
import com.NoteApp.Note.NoteRepository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class NoteService {
    @Autowired
    NoteRepository noteRepository;

    public List<Note> findAll(){
        return noteRepository.findAll();
    }

    public void newNote(Note note){
        noteRepository.save(note);
    }
    public void deleteNote(Integer id){
        noteRepository.deleteById(id);
    }

    public Note getNoteById(int id){
        Note tempNote = noteRepository.findById(id).get();
        return tempNote;
    }
}
