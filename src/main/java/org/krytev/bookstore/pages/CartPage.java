package org.krytev.bookstore.pages;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.PermitAll;
import org.krytev.bookstore.components.BookCard;
import org.krytev.bookstore.components.NavigationBar;
import org.krytev.bookstore.domain.CartEntity;
import org.krytev.bookstore.domain.PositionEntity;
import org.krytev.bookstore.domain.UserEntity;
import org.krytev.bookstore.services.CartService;
import org.krytev.bookstore.services.LikeService;
import org.krytev.bookstore.services.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.List;

@Route("cart")
@PermitAll
public class CartPage extends VerticalLayout {
    private final CartService cartService;
    private final PositionService positionService;
    private final LikeService likeService;
    @Autowired
    CartPage(CartService cartService, PositionService positionService, LikeService likeService){
        this.cartService = cartService;
        this.positionService = positionService;
        this.likeService = likeService;
        add(new NavigationBar(SecurityContextHolder.getContext().getAuthentication()),
                getContent());
    }

    private Component getContent(){
        VerticalLayout verticalLayout = new VerticalLayout();
        UserEntity user = (UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<PositionEntity> positions = positionService.getPositionsOfUser(user);
        for (PositionEntity position : positions){
            verticalLayout.add(new Div(new BookCard(position.getBook(), likeService), new Text(position.getAmount().toString())));
        }
        return verticalLayout;
    }

}
