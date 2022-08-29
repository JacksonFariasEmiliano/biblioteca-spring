package com.br.jalves.biblioteca.security.service;

import com.br.jalves.biblioteca.exception.BadRequestException;
import com.br.jalves.biblioteca.models.Book;
import com.br.jalves.biblioteca.paylod.request.BookPostRequestBody;
import com.br.jalves.biblioteca.paylod.request.BookPutRequestBody;
import com.br.jalves.biblioteca.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository repository;

    //@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_MOD', 'ROLE_USER')")
    public List<Book> findBookByName(String name){
        return repository.findBookByName(name);
    }

    //@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_MOD', 'ROLE_USER')")
    public Book findByIdOrThrowBadRequestException(long id) {
        return repository.findById(id).orElseThrow(() -> new BadRequestException("Livro não encotrado"));
    }

    //@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_MOD')")
    public Book save(BookPostRequestBody bookPostRequestBody) {
        return repository.save(Book.builder()
                .name(bookPostRequestBody.getName())
                .autor(bookPostRequestBody.getAutor())
                .build());
    }

    //@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_MOD')")
    public void delete(long id) {
        repository.delete(findByIdOrThrowBadRequestException(id));
    }

    //@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_MOD', 'ROLE_USER')")
    public void replace(BookPutRequestBody bookPutRequestBody){
        Book saveBook = findByIdOrThrowBadRequestException(bookPutRequestBody.getId());
        Book book = Book.builder()
                .id(saveBook.getId())
                .name(bookPutRequestBody.getName())
                .autor(bookPutRequestBody.getAutor())
                .build();

        repository.save(book);
    }
}
