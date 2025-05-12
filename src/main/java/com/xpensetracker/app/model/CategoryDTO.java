package com.xpensetracker.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

public record CategoryDTO(@JsonProperty(access =JsonProperty.Access.READ_ONLY) Long id,
                          String name,
                          Long userId,
                          @Schema(hidden = true) String userName,
                          @Schema(hidden = true) Boolean hasExpenses){
}
