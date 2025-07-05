package com.api.bookstore_ql.dtos;

import jakarta.validation.constraints.NotBlank;

public record AuthorInput(@NotBlank String name) {
}
