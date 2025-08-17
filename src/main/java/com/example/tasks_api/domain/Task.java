package com.example.tasks_api.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.time.Instant;

@Document(collection = "tasks")
public class Task {
    @Id
    private String id;

    @NotBlank @Size(max = 140) private String title;
    @Size(max = 1000) private String description;
    private boolean done;
    private Instant createdAt;

}
