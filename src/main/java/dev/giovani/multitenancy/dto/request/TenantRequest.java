package dev.giovani.multitenancy.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TenantRequest {

    private String name;
    private String url;
    private String tenantName;
    private String schemaName;
    private String username;
    private String password;

}
