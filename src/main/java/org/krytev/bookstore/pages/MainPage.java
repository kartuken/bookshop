package org.krytev.bookstore.pages;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import lombok.RequiredArgsConstructor;
import org.krytev.bookstore.components.BookList;
import org.krytev.bookstore.domain.GenreEntity;
import org.krytev.bookstore.services.BookService;
import org.krytev.bookstore.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;

@Route("")
@PageTitle("The Legendary Book Store")
@AnonymousAllowed
public class MainPage extends VerticalLayout {
    private BookService bookService;
    private GenreService genreService;

    @Autowired
    MainPage(BookService bookService, GenreService genreService){
        this.bookService = bookService;
        this.genreService = genreService;

        add(
                new BookList("Most Liked", bookService.findMostLiked()),
                new BookList("New books on website", bookService.findNewBooks())
        );
        for (GenreEntity genre : genreService.findAll()){
            add(new BookList(genre.getName(), bookService.findByGenre(genre)));
        }

    }

}
