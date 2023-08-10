package eu.codeacademy.LogisticsDemo.controllers;

import eu.codeacademy.LogisticsDemo.dto.DispatchDTO;
import eu.codeacademy.LogisticsDemo.dto.DriverDTO;
import eu.codeacademy.LogisticsDemo.services.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/drivers")
public class DriverController {
    @Autowired
    private DriverService driverService;

    @GetMapping//veikia bet negauda trk trl id
    public ResponseEntity<List<DriverDTO>> getAllDrivers() {
        List<DriverDTO> driverDTOS = driverService.getAllDriversDTO();
        return  ResponseEntity.ok(driverDTOS);
    }
    @GetMapping("/{id}")
    public ResponseEntity<DriverDTO> getDriverById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(driverService.getDriverDTOById(id));
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }
    @PostMapping
    public ResponseEntity<DriverDTO> addDispatch(@RequestBody DriverDTO driverDTO) {
        DriverDTO createdDriverDTO = driverService.createDriver(driverDTO);
        return new ResponseEntity<>(createdDriverDTO, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<DriverDTO> updateDriver(@RequestBody DriverDTO driverDTO) {
        try {
            return ResponseEntity.ok(driverService.updateDriver(driverDTO));
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }
    @DeleteMapping("/{id}")
//    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteDriver(@PathVariable Long id) {
        try {
            this.driverService.deleteDriver(id);
            return ResponseEntity.noContent().build();
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }


}
