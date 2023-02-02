package sber.winter.school.sberwinterschool.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sber.winter.school.sberwinterschool.dto.GenericDto;
import sber.winter.school.sberwinterschool.mapper.GenericMapper;
import sber.winter.school.sberwinterschool.model.GenericModel;
import sber.winter.school.sberwinterschool.service.GenericService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public abstract class GenericController<T extends GenericModel, N extends GenericDto> {

  private final GenericService<T> service;
  private final GenericMapper<T, N> mapper;
  protected GenericController(GenericService<T> service, GenericMapper<T, N> mapper) {
    this.service = service;
    this.mapper = mapper;
  }

  @GetMapping("/list")
  public ResponseEntity<List<N>> getAll() {
    return ResponseEntity.ok().body(mapper.toDtos(service.listAll()));
  }

  @GetMapping("/{id}")
  public ResponseEntity<N> getById(@PathVariable Long id) {
    return ResponseEntity.status(HttpStatus.OK).body(mapper.toDto(service.getOne(id)));
  }

  @PostMapping("/create")
  public ResponseEntity<N> create(@RequestBody N object) {
    return ResponseEntity.status(HttpStatus.OK).body(mapper.toDto(service.create(mapper.toEntity(object))));
  }

  @PutMapping("/{id}")
  public ResponseEntity<N> update(@RequestBody N object, @PathVariable Long id) {
    object.setId(id);
    return ResponseEntity.status(HttpStatus.OK).body(mapper.toDto(service.update(mapper.toEntity(object))));
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    service.delete(id);
  }
}
