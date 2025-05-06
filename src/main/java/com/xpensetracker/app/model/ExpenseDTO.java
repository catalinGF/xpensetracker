package com.xpensetracker.app.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public record ExpenseDTO(@JsonProperty(access = JsonProperty.Access.READ_ONLY) Long id,
                         String description,
                         double amount,
                         @DateTimeFormat(pattern = "yyyy-MM-dd")
                         @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy") Date date,
                         Long categoryId,
                         Long userId) {

}
