package dev.giovani.multitenancy.controller.master;

import dev.giovani.multitenancy.domain.master.Database;
import dev.giovani.multitenancy.domain.master.TenantClient;
import dev.giovani.multitenancy.dto.request.TenantRequest;
import dev.giovani.multitenancy.dto.response.TenantResponse;
import dev.giovani.multitenancy.repository.DatabaseRepository;
import dev.giovani.multitenancy.repository.TenantClientRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/database")
@AllArgsConstructor
public class DatabaseController {

    DatabaseRepository databaseRepository;

    @GetMapping
    public ResponseEntity<?> getAllDatabases() {
        List<Database> databaseList = databaseRepository.findAll();
        return ResponseEntity.ok(databaseList);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> createDatabase(@RequestBody String name) {

        Database database = new Database();
        database.setName(name);
        database.setExecuted(false);

        return ResponseEntity.ok(databaseRepository.save(database));
    }
}
