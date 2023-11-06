package org.egor.study.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(setterPrefix = "with")
public class AuthRecord {
    private String permission;
    private boolean access;
    private String description;
    private boolean summary;
}
