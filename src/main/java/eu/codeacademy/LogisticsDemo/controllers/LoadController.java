package eu.codeacademy.LogisticsDemo.controllers;

import eu.codeacademy.LogisticsDemo.dto.DriverDTO;
import eu.codeacademy.LogisticsDemo.dto.LoadDTO;
import eu.codeacademy.LogisticsDemo.services.LoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/loads")
public class LoadController {
    @Autowired
    private LoadService loadService;

    @GetMapping
    public ResponseEntity<List<LoadDTO>> getAllLoads() {
        List<LoadDTO> loadDTOList = loadService.getAllLoadsDTO();
        return  ResponseEntity.ok(loadDTOList);
    }
    @GetMapping("/{id}")
    public ResponseEntity<LoadDTO> getLoadById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(this.loadService.getLoadDTOById(id));
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,  String.format("Load by ID: %s not found", id));
        }
    }

    @PostMapping
    public ResponseEntity<LoadDTO> addLoad(@RequestBody LoadDTO loadDTO) {
        LoadDTO createdLoadDTO = loadService.createLoad(loadDTO);
        return new ResponseEntity<>(createdLoadDTO, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<LoadDTO> updateDriver(@RequestBody LoadDTO loadDTO) {
        try {
            return ResponseEntity.ok(loadService.updateLoad(loadDTO));
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }
    @DeleteMapping("/{id}")
//    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteLoad(@PathVariable Long id) {
        try {
            this.loadService.deleteLoad(id);
            return ResponseEntity.noContent().build();
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }


}
