package com.br.jalves.biblioteca.controller;

import com.br.jalves.biblioteca.models.Book;
import com.br.jalves.biblioteca.models.View;
import com.br.jalves.biblioteca.paylod.request.BookPostRequestBody;
import com.br.jalves.biblioteca.paylod.request.BookPutRequestBody;
import com.br.jalves.biblioteca.security.service.BookService;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {

    private final BookService service;


    @GetMapping(path = "/find")
    public ResponseEntity<List<Book>> findBookByName(@RequestParam String name) {
        return ResponseEntity.ok(service.findBookByName(name));
    }

    @PostMapping
    public ResponseEntity<Book> save(@RequestBody @Valid BookPostRequestBody bookPostRequestBody) {
        return new ResponseEntity<>(service.save(bookPostRequestBody), HttpStatus.CREATED);
    }


    @PutMapping(path = "/id/{id}")
    @JsonView(View.BookSummary.class)
    public ResponseEntity<Void> replace(@RequestBody BookPutRequestBody bookPutRequestBody) {
        service.replace(bookPutRequestBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(path = "/admin/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}