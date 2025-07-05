package com.api.bookstore_ql.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record BookInput(@NotBlank String title, @NotBlank String publisher, @NotNull Long authorId) {
}
