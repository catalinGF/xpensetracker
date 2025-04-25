package com.xpensetracker.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CategoryDTO(@JsonProperty(access =JsonProperty.Access.READ_ONLY) long id,
                          String name) {
}
