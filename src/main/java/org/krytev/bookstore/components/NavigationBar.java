package org.krytev.bookstore.components;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.krytev.bookstore.domain.CommentEntity;
import org.krytev.bookstore.domain.RoleEntity;
import org.krytev.bookstore.domain.UserEntity;
import org.springframework.security.core.Authentication;

import java.util.List;

@Tag("div")
public class NavigationBar extends HorizontalLayout {

    NavigationBar(Authentication authentication){
        this.addClassName("navigationbar-container");

        add();

    }

    private Component getTitle(){
        Div result = new Div();
        result.addClassName("navigationbar-title");
        result.setText("The Legendary Book Store");
        return result;
    }

    private Component getNavigationComponent(String name, String url){
        Button result = new Button(name);
        result.addClassName("navigationbar-navigate-button");
        result.addClickListener(event -> {
            UI.getCurrent().navigate(url);
        });
        return result;
    }

    private Component getLogButtons(){
        Div result = new Div();
        result.addClassName("navigationbar-log-buttons-container");

        Button signIn = new Button("Sign In");
        signIn.addClassName("navigationbar-sign-in-button");
        signIn.addClickListener(event -> {UI.getCurrent().navigate("login");});

        Button signUp = new Button("Sign Up");
        signUp.addClassName("navigationbar-sign-up-button");
        signUp.addClickListener(event -> {UI.getCurrent().navigate("registration");});

        result.add(signIn, signUp);
        return result;
    }

    private Component getLogedIcons(UserEntity user){
        return new Div();
    }

}
