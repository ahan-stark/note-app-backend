package com.example.noteapp.notes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class NotesController {
    NotesService notesService;

    @Autowired
    public NotesController(NotesService notesService) {
        this.notesService = notesService;
    }

    @GetMapping("/showNotes")
    public List<Notes> note_details() {
        return notesService.getNotes();
    }

    @PostMapping("/addNotes")
    public void add(@RequestBody Notes notes) {
        notesService.addNotes(notes);
    }

    @DeleteMapping(value = "/{noteId}")
    public void deleteNote(@PathVariable("noteId") Long noteId) {
        notesService.deletenote(noteId);
    }

    @PutMapping(value = "/put/{noteId}")
    public void updateContents(@PathVariable("noteId") Long noteId, @RequestBody Notes notes) {
        notesService.updatenotes(notes, noteId);
    }
}
