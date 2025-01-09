package dev.giovani.multitenancy.controller.master;

import dev.giovani.multitenancy.domain.master.Schema;
import dev.giovani.multitenancy.dto.request.SchemaRequest;
import dev.giovani.multitenancy.repository.SchemaRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schema")
@AllArgsConstructor
public class SchemaController {

    SchemaRepository schemaRepository;

    @GetMapping
    public ResponseEntity<?> getAllSchema() {
        List<Schema> schemaList = schemaRepository.findAll();
        return ResponseEntity.ok(schemaList);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> createSchema(@RequestBody SchemaRequest schemaRequest) {

        Schema schema = new Schema();
        schema.setSchemaName(schemaRequest.getSchemaName());
        schema.setDatabaseName(schemaRequest.getDatabaseName());
        schema.setExecuted(false);
        return ResponseEntity.ok(schemaRepository.save(schema));
    }
}
