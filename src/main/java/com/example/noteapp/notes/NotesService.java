package com.example.noteapp.notes;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotesService {
    NotesRepository notesRepository;

    public NotesService(NotesRepository notesRepository) {
        this.notesRepository = notesRepository;
    }

    public List<Notes> getNotes() {
        return notesRepository.findAll();
    }

    public void addNotes(Notes notes) {
        notesRepository.save(notes);
    }

    public void deletenote(Long noteId) {
        boolean checkpresent = notesRepository.existsById(noteId);
        if (checkpresent) {
            notesRepository.deleteById(noteId);
        } else {
            throw new IllegalStateException("note id doesn't exists");
        }

    }

    public void updatenotes(Notes notes, Long noteId) {
        boolean checkId = notesRepository.existsById(noteId);
        if (checkId) {
            notes.setNoteId(noteId);
            notesRepository.save(notes);
        } else {
            throw new IllegalStateException("note id doesn't exists");
        }
    }
}
