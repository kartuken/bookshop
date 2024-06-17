package org.krytev.bookstore.components;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.krytev.bookstore.domain.BookEntity;

import java.util.List;

@Tag("div")
@CssImport("./styles/book-list.css")
public class BookList extends HorizontalLayout {

    public BookList(String title, List<BookEntity> books){

        add(getTitleComponent(title), getCardHolder(books));

    }

    private Component getTitleComponent(String title){
        Div result = new Div();
        result.addClassName("booklist-title");
        result.setText(title);
        return result;
    }

    private Component getCardHolder(List <BookEntity> books){
        Div result = new Div();
        result.addClassName("booklist-card-holder");
        for (BookEntity book : books){
            result.add(new BookCard(book));
        }
        return result;
    }

}
