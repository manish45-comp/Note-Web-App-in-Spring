package com.NoteApp.Note.NoteRepository;

import com.NoteApp.Note.NoteModel.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.ui.Model;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note ,Integer> {
}
