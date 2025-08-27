package com.example.tarefas.controller;

import com.example.tarefas.model.Tarefa;
import com.example.tarefas.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tarefas")
@CrossOrigin(origins = "*")
public class TarefaController {

    @Autowired
    private TarefaRepository tarefaRepository;

    @PostMapping
    public ResponseEntity<Tarefa> criarTarefa(@RequestBody Tarefa tarefa) {
        try {
            Tarefa novaTarefa = tarefaRepository.save(tarefa);
            return new ResponseEntity<>(novaTarefa, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<List<Tarefa>> listarTarefas() {
        try {
            List<Tarefa> tarefas = tarefaRepository.findAll();
            if (tarefas.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(tarefas, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> buscarTarefaPorId(@PathVariable("id") Long id) {
        Optional<Tarefa> tarefaData = tarefaRepository.findById(id);

        if (tarefaData.isPresent()) {
            return new ResponseEntity<>(tarefaData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> atualizarTarefa(@PathVariable("id") Long id, @RequestBody Tarefa tarefa) {
        Optional<Tarefa> tarefaData = tarefaRepository.findById(id);

        if (tarefaData.isPresent()) {
            Tarefa tarefaExistente = tarefaData.get();
            tarefaExistente.setNome(tarefa.getNome());
            tarefaExistente.setDataEntrega(tarefa.getDataEntrega());
            tarefaExistente.setResponsavel(tarefa.getResponsavel());

            return new ResponseEntity<>(tarefaRepository.save(tarefaExistente), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> removerTarefa(@PathVariable("id") Long id) {
        try {
            tarefaRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping
    public ResponseEntity<HttpStatus> removerTodasTarefas() {
        try {
            tarefaRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}