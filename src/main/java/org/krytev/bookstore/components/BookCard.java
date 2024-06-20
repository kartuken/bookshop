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
import org.krytev.bookstore.services.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


@Tag("div")
@CssImport("./styles/book-card.css")
public class BookCard extends VerticalLayout {

    private  LikeService likeService;
    private final BookEntity book;

    public BookCard(BookEntity book, LikeService likeService){
        this.book = book;
        this.likeService = likeService;
        this.addClassName("bookcard-card");
        this.getElement().setProperty("display", "inline-block");
        this.setWidth("");

        this.add(getImageContainer(), getTitleContainer(), getAuthorContainer(), getRatingComponent());
    }

    private Component getImageContainer(){
        Div result = new Div();
        result.addClassName("bookcard-image-container");

        StreamResource imageResource = new StreamResource(book.getImage() + ".png",
                () -> {
                    try {
                        return new FileInputStream("src/main/resources/static/images/" + book.getImage() + ".png");
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                });
        Component image = new Image(imageResource, "404\nNo image");
        image.addClassName("bookcard-image");

        result.add(image);
        return result;
    }

    private Component getTitleContainer(){
        Div result = new Div();
        result.addClassName("bookcard-title");
        result.getElement().setText(book.getTitle());
        return result;
    }

    private Component getAuthorContainer(){
        Div result = new Div();
        result.addClassName("bookcard-author");
        result.getElement().setText(book.getAuthor());
        return result;
    }

    private Component getRatingComponent(){
        Div result = new Div();

        Div likes = new Div();
        likes.addClassName("bookcard-likes");

        Icon heartIcon = VaadinIcon.HEART.create();
        heartIcon.addClassName("heart");
        heartIcon.setSize("15px");

        Component likeCount = new Span(String.valueOf(likeService.getLikeCount(book)));
        likes.add(heartIcon, likeCount);
        likes.addClickListener(event -> {
            likeService.like(SecurityContextHolder.getContext().getAuthentication(), book);
            likeCount.getElement().setText(String.valueOf(likeService.getLikeCount(book)));

        });

        Div price = new Div();
        price.addClassName("bookcard-price");
        price.setText(book.getPrice().toString() + " ₽");


        result.add(likes, price);
        return result;
    }
}
