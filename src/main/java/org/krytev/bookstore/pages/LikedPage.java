package org.krytev.bookstore.pages;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.PermitAll;
import org.krytev.bookstore.components.BookMap;
import org.krytev.bookstore.components.NavigationBar;
import org.krytev.bookstore.services.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

@Route("liked")
@PermitAll
public class LikedPage extends VerticalLayout {

    private LikeService likeService;
    @Autowired
    LikedPage(LikeService likeService){
        this.likeService = likeService;
        add(new NavigationBar(SecurityContextHolder.getContext().getAuthentication()),
                new BookMap(likeService.getLikedBooks(SecurityContextHolder.getContext().getAuthentication()), likeService));
    }

}
