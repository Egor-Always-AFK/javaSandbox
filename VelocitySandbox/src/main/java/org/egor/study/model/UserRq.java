package org.egor.study.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.ws.rs.QueryParam;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRq {
    public static final UserRq DEFAULT = new UserRq(
            "123",
            Set.of("Programmer"));
    @QueryParam("dummy-number")
    private String dummyNumber;
    @QueryParam("role")
    private Set<String> roles;


}
