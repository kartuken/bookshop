package org.krytev.bookstore.pages;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import org.krytev.bookstore.components.BookCard;
import org.krytev.bookstore.domain.BookEntity;

import java.util.List;

@Route("list")
@AnonymousAllowed
public class Booklist extends HorizontalLayout {

    List <BookEntity> books = List.of();

    Booklist(){
        this.setAlignItems(Alignment.CENTER);
        setVerticalComponentAlignment(Alignment.CENTER);
        BookEntity book = new BookEntity();
        book.setTitle("Преступление и наказание");
        book.setAuthor("Достоевский Фёдор Михайлович");
        book.setImage("picture1.png");

        add(new BookCard(book));
    }
}
