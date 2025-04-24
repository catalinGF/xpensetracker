package com.xpensetracker.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record UserDTO(@JsonProperty(access =JsonProperty.Access.READ_ONLY) long id,
                      String name,
                      String email) {

}
