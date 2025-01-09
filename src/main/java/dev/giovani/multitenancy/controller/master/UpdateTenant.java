package dev.giovani.multitenancy.controller.master;

import dev.giovani.multitenancy.service.UpdateTenantService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/update-tenants")
@AllArgsConstructor
public class UpdateTenant {

    private UpdateTenantService updateTenantService;

    @PutMapping
    public ResponseEntity<?> updateTenant() {
        updateTenantService.updateTenant();
        return ResponseEntity.ok("Success");
    }

    @PostMapping("/create-database")
    public ResponseEntity<?> createNewDatabase() {
        updateTenantService.createDatabases();
        return ResponseEntity.ok("Success");
    }

    @PostMapping("/create-schema")
    public ResponseEntity<?> createNewSchema() {
        updateTenantService.createSchema();
        return ResponseEntity.ok("Success");
    }
}
