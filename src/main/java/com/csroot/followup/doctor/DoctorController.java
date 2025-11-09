package com.csroot.followup.doctor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors/api")
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    /**
     * POST /doctors/login
     * Authentification médecin
     */
    @PostMapping("/login")
    public ResponseEntity<DoctorDTO> login(@RequestBody LoginRequest request) {
        try {
            DoctorDTO doctor = doctorService.authenticate(request);
            return ResponseEntity.ok(doctor);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    /**
     * POST /doctors
     * Créer un nouveau médecin (inscription)
     */
    @PostMapping
    public ResponseEntity<DoctorDTO> create(@RequestBody CreateDoctorRequest request) {
        DoctorDTO doctor = doctorService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(doctor);
    }

    /**
     * GET /doctors/{id}
     * Récupérer un médecin par ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<DoctorDTO> findById(@PathVariable Long id) {
        DoctorDTO doctor = doctorService.findById(id);
        return ResponseEntity.ok(doctor);
    }

    /**
     * GET /doctors
     * Récupérer tous les médecins
     */
    @GetMapping
    public ResponseEntity<List<DoctorDTO>> findAll() {
        List<DoctorDTO> doctors = doctorService.findAll();
        return ResponseEntity.ok(doctors);
    }

    /**
     * PUT /doctors/{id}
     * Mettre à jour un médecin
     */
    @PutMapping("/{id}")
    public ResponseEntity<DoctorDTO> update(
            @PathVariable Long id,
            @RequestBody UpdateDoctorRequest request
    ) {
        DoctorDTO doctor = doctorService.update(id, request);
        return ResponseEntity.ok(doctor);
    }

    /**
     * DELETE /doctors/{id}
     * Supprimer un médecin
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        doctorService.delete(id);
        return ResponseEntity.noContent().build();
    }
}