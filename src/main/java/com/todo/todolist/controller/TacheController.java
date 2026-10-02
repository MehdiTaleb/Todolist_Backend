package com.todo.todolist.controller;

import java.util.List;

import com.todo.todolist.entity.Tache;
import com.todo.todolist.repository.TacheRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/taches")
@CrossOrigin(origins = "http://localhost:4200")
public class TacheController {

    private final TacheRepository repository;

    public TacheController(TacheRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Tache> lister() {
        return repository.findAll();
    }

    @PostMapping
    public Tache ajouter(@RequestBody Tache tache) {
        return repository.save(tache);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tache> modifier(@PathVariable Long id, @RequestBody Tache tache) {
        return repository.findById(id)
                .map(existante -> {
                    existante.setTitre(tache.getTitre());
                    existante.setTerminee(tache.isTerminee());
                    return ResponseEntity.ok(repository.save(existante));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimer(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}