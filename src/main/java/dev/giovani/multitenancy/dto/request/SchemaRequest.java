package dev.giovani.multitenancy.dto.request;

import lombok.Data;

@Data
public class SchemaRequest {

    private String schemaName;
    private String databaseName;
}
