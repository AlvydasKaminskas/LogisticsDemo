package eu.codeacademy.LogisticsDemo.controllers;

import eu.codeacademy.LogisticsDemo.dto.DispatchDTO;
import eu.codeacademy.LogisticsDemo.services.DispatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;

import java.util.List;


@RestController
@RequestMapping("/dispatch")
public class DispatchController {

    @Autowired
    private DispatchService dispatchService;

    @GetMapping
    public ResponseEntity<List<DispatchDTO>> getAllDispatches() {
        List<DispatchDTO> dispatchDTOs = dispatchService.getAllDispatchesDTO();
        return new ResponseEntity<>(dispatchDTOs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DispatchDTO> getDispatchById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(dispatchService.getDispatchDTOById(id));
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<DispatchDTO> addDispatch(@RequestBody DispatchDTO dispatchDTO) {
        DispatchDTO createdDispatchDTO = dispatchService.createDispatch(dispatchDTO);
        return new ResponseEntity<>(createdDispatchDTO, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<DispatchDTO> updateDispatch(@RequestBody DispatchDTO dispatchDTO) {
        try {
            return ResponseEntity.ok(dispatchService.updateDispatch(dispatchDTO));
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDispatch(@PathVariable Long id) {
        try {
            this.dispatchService.deleteDispatch(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

}
