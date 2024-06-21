package org.krytev.bookstore.components;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.krytev.bookstore.domain.BookEntity;
import org.krytev.bookstore.services.LikeService;

import java.util.List;

@Tag("div")
@CssImport("./styles/components/book-map.css")
public class BookMap extends HorizontalLayout {
    private LikeService likeService;
    public BookMap(List<BookEntity> books, LikeService likeService){
        this.likeService = likeService;
        addClassName("bookmap-card-holder");
        for (BookEntity book : books){
            add(new BookCard(book, likeService));
        }

    }

}
