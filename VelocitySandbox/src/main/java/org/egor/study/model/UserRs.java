package org.egor.study.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
@Builder(setterPrefix = "with")
public class UserRs {
    private String dummyName;
    private String dummyNumber;
    private Set<String> dummyRoles;
    private Set<String> permissions;
    private Set<String> rawPermissions;
    private List<AuthRecord> records;
}
