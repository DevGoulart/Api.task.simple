package com.kaua.api.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.util.Objects;
import java.util.UUID;

@Embeddable
public record TaskId(@Column(name = "id")
                     UUID value) {

    public TaskId {
        Objects.requireNonNull(value, "O id da task não pode ser nulo");
    }

    public static TaskId newId() {
        return new TaskId(UUID.randomUUID());
    }
}