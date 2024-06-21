package org.krytev.bookstore.pages;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.Page;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.StreamResource;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import lombok.RequiredArgsConstructor;
import org.krytev.bookstore.components.NavigationBar;
import org.krytev.bookstore.domain.BookEntity;
import org.krytev.bookstore.domain.CartEntity;
import org.krytev.bookstore.domain.PositionEntity;
import org.krytev.bookstore.domain.UserEntity;
import org.krytev.bookstore.services.BookService;
import org.krytev.bookstore.services.CartService;
import org.krytev.bookstore.services.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

@Route("books")
@AnonymousAllowed
@CssImport("./styles/pages/book-page.css")
@RequiredArgsConstructor
public class BookPage extends VerticalLayout implements HasUrlParameter<Long> {
    private final BookService bookService;
    private final PositionService positionService;
    private BookEntity book;

    @Override
    public void setParameter(BeforeEvent event, Long parameter) {
        this.book = bookService.findById(parameter);

        add(new NavigationBar(SecurityContextHolder.getContext().getAuthentication()),
                getContent());
    }

    private Component getContent(){
        HorizontalLayout content = new HorizontalLayout();

        VerticalLayout vl = new VerticalLayout();
        HorizontalLayout titleBar = new HorizontalLayout();
        titleBar.addClassName("bookpage-titlebar");
        titleBar.add(
                new Div(getTitle(), getAuthor()),
                new Div(getButtons(), getPrice())
        );

        vl.add(
                titleBar,
                getDescription()
        );

        content.add(getImage(), vl);
        return content;
    }

    private Image getImage(){
        StreamResource imageResource = new StreamResource(book.getImage() + ".png",
                () -> {
                    try {
                        return new FileInputStream("src/main/resources/static/images/" + book.getImage() + ".png");
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                });
        Image image = new Image(imageResource, "404\nNo image");
        image.addClassName("bookpage-image");
        return image;
    }

    private Component getTitle(){
        Div div = new Div();
        div.setText(book.getTitle());
        div.addClassName("bookpage-title");
        return div;
    }

    private Component getAuthor(){
        Div div = new Div();
        div.setText(book.getAuthor());
        div.addClassName("bookpage-author");
        return div;
    }

    private Component getPrice(){
        Div div = new Div();
        div.setText(String.valueOf(book.getPrice()));
        div.addClassName("bookpage-price");
        return div;
    }

    private Component getDescription(){
        Div div = new Div();
        div.setText(String.valueOf(book.getDescription()));
        div.addClassName("bookpage-price");
        return div;
    }

    private Component getButtons(){
        Div div = new Div();
        Button likeButton = new Button("Like");
        likeButton.addClassName("bookpage-button");
        Button addToCartButton = new Button("Buy");
        addToCartButton.addClassName("bookpage-button");
        div.add(likeButton, addToCartButton);
        div.addClassName("bookpage-buttons");

        addToCartButton.addClickListener(event -> {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            if (auth.getPrincipal().equals("anonymousUser")){
                Notification.show("You have to be authenticated to buy books.");
                return;
            }
            UserEntity user = (UserEntity) auth.getPrincipal();
            positionService.addPositionToUserCart(book, user);
            Notification.show("Book added to cart");
        });

        return div;
    }
}
