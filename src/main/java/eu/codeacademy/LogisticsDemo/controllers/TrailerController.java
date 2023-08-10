package eu.codeacademy.LogisticsDemo.controllers;

import eu.codeacademy.LogisticsDemo.dto.LoadDTO;
import eu.codeacademy.LogisticsDemo.dto.TrailerDTO;

import eu.codeacademy.LogisticsDemo.services.TrailerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/trailers")
public class TrailerController {

    @Autowired
    private TrailerService trailerService;

    @GetMapping
    public ResponseEntity<List<TrailerDTO>> getAllTrailers() {
        List<TrailerDTO> trailerDTOList = trailerService.getAllTrailerDTO();
        return  ResponseEntity.ok(trailerDTOList);
    }
    @GetMapping("/{id}")
    public ResponseEntity<TrailerDTO> getTrailerById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(this.trailerService.getTrailerDTOById(id));
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,  String.format("Trailer by ID: %s not found", id));
        }
    }

    @PostMapping
    public ResponseEntity<TrailerDTO> addTrailer(@RequestBody TrailerDTO trailerDTO) {
        TrailerDTO createdTrailerDTO = trailerService.createTrailer(trailerDTO);
        return new ResponseEntity<>(createdTrailerDTO, HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<TrailerDTO> updateTrailer(@RequestBody TrailerDTO trailerDTO) {
        try {
            return ResponseEntity.ok(trailerService.updateTrailer(trailerDTO));
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Trailer by ID: %s not found", trailerDTO.getId()));
        }
    }
    @DeleteMapping("/{id}")
//    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteTrailer(@PathVariable Long id) {
        try {
            this.trailerService.deleteTrailer(id);
            return ResponseEntity.noContent().build();
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Trailer by ID: %s not found", id));
        }
    }




}
