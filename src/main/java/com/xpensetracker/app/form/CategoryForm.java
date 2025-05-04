package com.xpensetracker.app.form;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CategoryForm(@JsonProperty(access =JsonProperty.Access.READ_ONLY) Long id,
                           String name, Long userId, String userName) {
}
