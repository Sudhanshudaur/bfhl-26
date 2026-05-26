package com.bfhl_26_Sudhanshu.bfhl_26.controller;

import com.bfhl_26_Sudhanshu.bfhl_26.dto.BfhlRequest;
import com.bfhl_26_Sudhanshu.bfhl_26.dto.BfhlResponse;
import com.bfhl_26_Sudhanshu.bfhl_26.service.BfhlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/bfhl")
@CrossOrigin(origins = "*")
public class BfhlController {

    private final BfhlService bfhlService;

    @Autowired
    public BfhlController(BfhlService bfhlService) {
        this.bfhlService = bfhlService;
    }

    @PostMapping
    public ResponseEntity<BfhlResponse> process(@RequestBody(required = false) BfhlRequest request) {
        if (request == null) {
            request = new BfhlRequest();
        }
        BfhlResponse response = bfhlService.processData(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> getOperationCode() {
        Map<String, Object> response = new HashMap<>();
        response.put("operation_code", 1);
        return ResponseEntity.ok(response);
    }
}
