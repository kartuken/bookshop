package org.krytev.bookstore.pages;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.upload.UploadI18N;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinService;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.flow.spring.annotation.RouteScopeOwner;
import jakarta.annotation.security.RolesAllowed;
import org.apache.catalina.webresources.FileResource;
import org.krytev.bookstore.domain.BookEntity;
import org.krytev.bookstore.services.BookService;
import org.krytev.bookstore.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;
import com.vaadin.flow.component.html.Image;
@Route("index")
@RolesAllowed("ROLE_USER")
public class IndexBookPage extends VerticalLayout {

    private final BookService bookService;
    private Grid<BookEntity> grid = new Grid<>(BookEntity.class);
    private Button createRedirectButton = new Button();
    @Autowired
    public IndexBookPage(BookService bookService, SecurityContextHolder securityContextHolder, GenreService genreService) {
        this.bookService = bookService;
        System.out.println("testing start");
        System.out.println(bookService.findByTitle("asd"));
        System.out.println(bookService.findByTitleAndGenre("asd", genreService.findByName("Fantastic").get()));
        System.out.println("testing end");
        add(grid);
        grid.setItems(bookService.findAll());
        grid.setColumns("title", "author", "year", "price");
        grid.addColumn(book -> book.getGenre().getName()).setHeader("Genre");
        createRedirectButton.setText("create book");
        createRedirectButton.addClickListener(buttonClickEvent -> UI.getCurrent().navigate("/createBook"));
        List<GrantedAuthority> roles =
                (List<GrantedAuthority>) securityContextHolder.getContext()
                .getAuthentication().getAuthorities();
        if(roles.contains(new SimpleGrantedAuthority("ROLE_ADMIN"))){
            add(createRedirectButton);
        }
    }

}
