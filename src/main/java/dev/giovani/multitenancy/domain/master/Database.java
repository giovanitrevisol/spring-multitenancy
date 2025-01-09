package dev.giovani.multitenancy.domain.master;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "database")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Database {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "executed")
    private Boolean executed;
}
