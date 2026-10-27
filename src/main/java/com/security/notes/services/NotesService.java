package com.security.notes.services;

import com.security.notes.models.NoteModal;

import java.util.List;

public interface NotesService {

    NoteModal createNote(String username, String content);

    NoteModal updateNote(Long noteId, String content, String username);

    void deleteNote(Long noteId, String username);

    List<NoteModal> getNotesForUser(String username);
}
