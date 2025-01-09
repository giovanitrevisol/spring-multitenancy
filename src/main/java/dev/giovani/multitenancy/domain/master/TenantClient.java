package dev.giovani.multitenancy.domain.master;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "tenant_client")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TenantClient {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "tenant_name")
    private String tenantName;

    @Column(name = "schema_name")
    private String schemaName;

    @Column(name = "url")
    private String url;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

}
