package com.security.notes.repository;

import com.security.notes.models.NoteModal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<NoteModal, Long> {
    List<NoteModal> findByOwnerUserName(String ownerUserName);
}
