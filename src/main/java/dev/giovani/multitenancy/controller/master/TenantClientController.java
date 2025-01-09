package dev.giovani.multitenancy.controller.master;

import dev.giovani.multitenancy.domain.master.TenantClient;
import dev.giovani.multitenancy.dto.request.TenantRequest;
import dev.giovani.multitenancy.dto.response.TenantResponse;
import dev.giovani.multitenancy.repository.TenantClientRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tenants")
@AllArgsConstructor
public class TenantClientController {

    TenantClientRepository tenantClientRepository;

    @GetMapping
    public ResponseEntity<?> getAllTenants() {
        List<TenantClient> tenantClientList = tenantClientRepository.findAll();
        return ResponseEntity.ok(tenantClientList);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> createTenant(@RequestBody TenantRequest tenantRequest) {
        TenantClient tenantClient = TenantClient.builder()
                .name(tenantRequest.getName())
                .url(tenantRequest.getUrl())
                .tenantName(tenantRequest.getTenantName())
                .schemaName(tenantRequest.getSchemaName())
                .username(tenantRequest.getUsername())
                .password(tenantRequest.getPassword())
                .build();

        TenantClient savedTenantClient = tenantClientRepository.save(tenantClient);

        TenantResponse response = TenantResponse.builder()
                .id(savedTenantClient.getId())
                .name(savedTenantClient.getName())
                .url(savedTenantClient.getUrl())
                .tenantName(savedTenantClient.getTenantName())
                .schemaName(savedTenantClient.getSchemaName())
                .username(savedTenantClient.getUsername())
                .password(savedTenantClient.getPassword())
                .build();

        return ResponseEntity.ok(response);
    }
}
