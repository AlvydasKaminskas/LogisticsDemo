package eu.codeacademy.LogisticsDemo.controllers;

import eu.codeacademy.LogisticsDemo.converters.TruckConverter;
import eu.codeacademy.LogisticsDemo.dto.TruckDTO;
import eu.codeacademy.LogisticsDemo.services.TruckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/drivers/trucks")
@PreAuthorize("hasRole('ADMIN')")
public class TruckController {

    @Autowired
    private TruckService truckService;

    @GetMapping
    public ResponseEntity<List<TruckDTO>> getAllTrucks() {
        List<TruckDTO> truckDTOList = truckService.getAllTruckDTO();
        return ResponseEntity.ok(truckDTOList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TruckDTO> getTruckById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(this.truckService.getTruckDTOById(id));
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Truck by ID: %s not found", id));
        }
    }
        @GetMapping("/searchByModel")
    public ResponseEntity<List<TruckDTO>> getTruckByModel(@RequestParam String model, Pageable pageable) {

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(TruckConverter.toDTOList(truckService.getAllTruckDTOByModel(model, pageable)));
    }

    @PostMapping
    public ResponseEntity<TruckDTO> addTruck(@RequestBody TruckDTO truckDTO) {
        TruckDTO createdTruckDTO = truckService.createTruck(truckDTO);
        return new ResponseEntity<>(createdTruckDTO, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<TruckDTO> updateTruck(@RequestBody TruckDTO truckDTO) {
        try {
            return ResponseEntity.ok(truckService.updateTruck(truckDTO));
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Truck by ID: %s not found", truckDTO.getId()));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTruck(@PathVariable Long id) {
        try {
            this.truckService.deleteTruck(id);
            return ResponseEntity.noContent().build();
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Truck by ID: %s not found", id));
        }
    }
}
