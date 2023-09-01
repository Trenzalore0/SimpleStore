package com.trenzalore.backend;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;


public abstract class ControllerAbstract<Model, Repository extends JpaRepository> {

  @Autowired
  protected Repository repository;

  @GetMapping
  public ResponseEntity<List<Model>> index() {
    return ResponseEntity.ok(repository.findAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Model> getById(@PathVariable String id) {
    Optional<Model> obj = repository.findById(id);
    if (obj.isPresent()) {
      return ResponseEntity.ok(obj.get());
    }
    return ResponseEntity.notFound().build();
  }

  public abstract ResponseEntity<Model> create(@RequestBody Model newObj, UriComponentsBuilder ucb);

  public abstract ResponseEntity<Model> update(@RequestBody Model obj, UriComponentsBuilder ucb);


}
