package com.NoteApp.Note.NoteController;

import com.NoteApp.Note.NoteModel.Note;
import com.NoteApp.Note.NoteService.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
public class NoteController {

    @Autowired
    NoteService service;

    @GetMapping("/")
    public String getStart(){
        return  "redirect:/notes";
    }
    @GetMapping("/notes")
    public String getAllNotes(Model model){
        List<Note> noteList = service.findAll();
        model.addAttribute("Notes" , noteList);
        return  "index";
    }

    @GetMapping("/notes/new")
    public String createNoteObj(Model model){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH.mm");
        LocalTime time1 = LocalTime.now().minusHours(12);
        String noteTime = time1.format(dateTimeFormatter);
        model.addAttribute("noteObj" , new Note(0,null,null, LocalDate.now(),noteTime));
        return "note_form";
    }

    @PostMapping("/save")
    public String saveNoteObj(Note note, RedirectAttributes redirectAttributes){
        service.newNote(note);
        redirectAttributes.addFlashAttribute("message","Saved");
        return "redirect:/notes";
    }

    @PostMapping("/update")
    public String updateNoteObj(Note note, RedirectAttributes redirectAttributes){
        service.newNote(note);
        redirectAttributes.addFlashAttribute("message","Updated");
        return "redirect:/notes";
    }

    @GetMapping("/delete/{id}")
    public String deleteNote(@PathVariable(name = "id") int id,RedirectAttributes redirectAttributes){
        service.deleteNote(id);
        redirectAttributes.addFlashAttribute("message","Deleted");
        return "redirect:/notes";
    }

    @GetMapping("/edit/{id}")
    public String getNoteByID(@PathVariable(name = "id") int id, Model model){
        model.addAttribute("tempNote" , service.getNoteById(id));
        return "update_form";
    }
}
