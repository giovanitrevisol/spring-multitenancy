package dev.giovani.multitenancy.domain.master;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "schema")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Schema {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "database_name")
    private String databaseName;

    @Column(name = "schema_name")
    private String schemaName;

    @Column(name = "executed")
    private Boolean executed;
}
