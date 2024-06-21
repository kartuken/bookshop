package org.krytev.bookstore.pages;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import lombok.RequiredArgsConstructor;
import org.krytev.bookstore.components.BookList;
import org.krytev.bookstore.components.NavigationBar;
import org.krytev.bookstore.domain.GenreEntity;
import org.krytev.bookstore.domain.UserEntity;
import org.krytev.bookstore.services.BookService;
import org.krytev.bookstore.services.GenreService;
import org.krytev.bookstore.services.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

@Route("")
@PageTitle("The Legendary Book Store")
@AnonymousAllowed
public class MainPage extends VerticalLayout {
    private BookService bookService;
    private GenreService genreService;
    private LikeService likeService;

    @Autowired
    MainPage(BookService bookService, GenreService genreService, LikeService likeService){
        this.bookService = bookService;
        this.genreService = genreService;
        this.likeService = likeService;

        add(
                new NavigationBar(SecurityContextHolder.getContext().getAuthentication()),
                new BookList("Most Liked", bookService.findMostLiked(), likeService),
                new BookList("New books on website", bookService.findNewBooks(), likeService)
        );
        for (GenreEntity genre : genreService.findAll()){
            add(new BookList(genre.getName(), bookService.findByGenre(genre), likeService));
        }

    }

}
