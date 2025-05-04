package com.xpensetracker.app.form;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public record ExpenseForm(@JsonProperty(access = JsonProperty.Access.READ_ONLY) Long id,
                          String description,
                          double amount,
                          @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy") Date date,
                          Long categoryId,
                          Long userId) {

}
