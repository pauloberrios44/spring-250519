package com.hospital.paciente.controller;

import com.hospital.paciente.model.Paciente;
import com.hospital.paciente.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping("/pacientes")
    public ResponseEntity<?> listarPacientes() {

        return ResponseEntity.status(200).body(pacienteService.findAll());
    }

    @GetMapping("/paciente/{id}")
    public ResponseEntity<?> buscarPaciente(@PathVariable Integer id) {
        Paciente paciente = pacienteService.findById(id);

        if (paciente == null) {
            return ResponseEntity.status(404).body("Paciente no encontrado");
        }

        return ResponseEntity.status(200).body(paciente);
    }

    @DeleteMapping("/paciente/{id}")
    public ResponseEntity<?> eliminarPaciente(@PathVariable Integer id) {
        pacienteService.delete(id);

        return ResponseEntity.status(200).body("Paciente eliminado");
    }

    @PostMapping("/paciente")
    public ResponseEntity<?> guardarPaciente(@RequestBody Paciente paciente) {
        Paciente pacienteGuardado = pacienteService.save(paciente);
        return ResponseEntity.status(201).body(pacienteGuardado);
    }
}
