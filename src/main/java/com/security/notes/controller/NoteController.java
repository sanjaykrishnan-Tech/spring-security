package com.security.notes.controller;

import com.security.notes.models.NoteModal;
import com.security.notes.services.NotesService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
@RequiredArgsConstructor
public class NoteController {

    private final NotesService notesService;

    @PostMapping
    public NoteModal createNote(@RequestBody String content,
                                @AuthenticationPrincipal UserDetails userDetails) {
        return notesService.createNote(userDetails.getUsername(), content);
    }

    @GetMapping
    public List<NoteModal> getUserNotes(@AuthenticationPrincipal UserDetails userDetails) {
        return notesService.getNotesForUser(userDetails.getUsername());
    }

    @PutMapping("/{noteId}")
    public NoteModal updateNote(@PathVariable Long noteId,
                                @RequestBody String content,
                                @AuthenticationPrincipal UserDetails userDetails) {
        return notesService.updateNote(noteId, content, userDetails.getUsername());
    }

    @DeleteMapping("/{noteId}")
    public void deleteNote(@PathVariable Long noteId,
                           @AuthenticationPrincipal UserDetails userDetails) {
        notesService.deleteNote(noteId, userDetails.getUsername());
    }
    @GetMapping("/me")
    public UserDetails me(@AuthenticationPrincipal UserDetails user) {
        return user;
    }
}
