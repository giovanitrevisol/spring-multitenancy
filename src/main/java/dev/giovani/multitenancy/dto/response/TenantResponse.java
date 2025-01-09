package dev.giovani.multitenancy.dto.response;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
public class TenantResponse {

    private Long id;
    private String url;
    private String name;
    private String tenantName;
    private String schemaName;
    private String username;
    private String password;
}
