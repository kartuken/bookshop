package org.krytev.bookstore.components;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Svg;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.dom.Style;
import com.vaadin.flow.server.StreamResource;
import com.vaadin.flow.server.VaadinService;
import org.apache.catalina.webresources.FileResource;
import org.krytev.bookstore.domain.BookEntity;

import java.io.File;


@Tag("div")
@CssImport("./styles/book-card.css")
public class BookCard extends VerticalLayout {

    private final BookEntity book;
    public BookCard(BookEntity book){
        this.book = book;
        this.addClassName("card");
        this.getElement().setProperty("display", "inline-block");
        this.setWidth("");

        this.add(getImageContainer(), getTitleContainer(), getAuthorContainer(), getRatingComponent());
    }

    private Component getImageContainer(){
        Div result = new Div();
        result.addClassName("image-container");

        StreamResource imageResource = new StreamResource("picture1.png",
                () -> getClass().getResourceAsStream("/static/picture1.png"));
        Component image = new Image(imageResource, "404\nNo image");
        image.addClassName("image");

        result.add(image);
        return result;
    }

    private Component getTitleContainer(){
        Div result = new Div();
        result.addClassName("title");
        result.getElement().setText(book.getTitle());
        return result;
    }

    private Component getAuthorContainer(){
        Div result = new Div();
        result.addClassName("author");
        result.getElement().setText(book.getAuthor());
        return result;
    }

    private Component getRatingComponent(){
        Div result = new Div();

        Div likes = new Div();
        likes.addClassName("likes");

        Icon heartIcon = VaadinIcon.HEART.create();
        heartIcon.addClassName("heart");
        heartIcon.setSize("15px");

        Component likeCount = new Span("130");
        likes.add(heartIcon, likeCount);

        Div views = new Div();
        views.addClassName("views");

        Icon eyeIcon = VaadinIcon.EYE.create();
        eyeIcon.addClassName("eye");
        eyeIcon.setSize("15px");

        Component viewCount = new Span("130");
        views.add(eyeIcon, viewCount);

        result.add(likes, views);
        return result;
    }

}
