package com.br.jalves.biblioteca.paylod.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class BookPostRequestBody {
    private String name;
    private String autor;

}
