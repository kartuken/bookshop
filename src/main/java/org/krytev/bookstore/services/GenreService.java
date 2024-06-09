package org.krytev.bookstore.services;

import lombok.RequiredArgsConstructor;
import org.krytev.bookstore.domain.BookEntity;
import org.krytev.bookstore.domain.GenreEntity;
import org.krytev.bookstore.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class GenreService {

    private final GenreRepository genreRepository;

    public List<GenreEntity> findAll(){
        return genreRepository.findAll();
    }
}
