package com.security.notes.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class NoteModal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Lob
    private String content;
    private String ownerUserName;
}
