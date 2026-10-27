package com.security.notes.impl;

import com.security.notes.models.NoteModal;
import com.security.notes.repository.NoteRepository;
import com.security.notes.services.NotesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NotesServiceImpl implements NotesService {

    private final NoteRepository noteRepository;

    @Override
    public NoteModal createNote(String username, String content) {
        NoteModal note = new NoteModal();
        note.setContent(content);
        note.setOwnerUserName(username);
        return noteRepository.save(note);
    }

    @Override
    public NoteModal updateNote(Long noteId, String content, String username) {
        NoteModal note = noteRepository.findById(noteId)
                .orElseThrow(() -> new RuntimeException("Note not found"));
        if (!note.getOwnerUserName().equals(username)) {
            throw new RuntimeException("Not allowed to update this note");
        }
        note.setContent(content);
        return noteRepository.save(note);
    }

    @Override
    public void deleteNote(Long noteId, String username) {
        NoteModal note = noteRepository.findById(noteId)
                .orElseThrow(() -> new RuntimeException("Note not found"));
        if (!note.getOwnerUserName().equals(username)) {
            throw new RuntimeException("Not allowed to delete this note");
        }
        noteRepository.delete(note);
    }

    @Override
    public List<NoteModal> getNotesForUser(String username) {
        return noteRepository.findByOwnerUserName(username);
    }
}
