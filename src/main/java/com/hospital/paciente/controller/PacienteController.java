package com.hospital.paciente.controller;

import com.hospital.paciente.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping("/api/v1/pacientes")
    public ResponseEntity<?> listarPacientes() {
        return ResponseEntity.status(200).body(pacienteService.findAll());
    }
}
