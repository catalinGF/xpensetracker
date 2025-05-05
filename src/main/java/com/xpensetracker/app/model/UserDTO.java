package com.xpensetracker.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

public record UserDTO(@JsonProperty(access = JsonProperty.Access.READ_ONLY) Long id,
                      String name,
                      String email,
                      @Schema(hidden = true)
                      Boolean hasCategories
) {

}
