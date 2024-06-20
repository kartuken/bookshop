package org.krytev.bookstore.components;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.server.VaadinService;
import com.vaadin.flow.server.VaadinSession;
import org.krytev.bookstore.domain.CommentEntity;
import org.krytev.bookstore.domain.RoleEntity;
import org.krytev.bookstore.domain.UserEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.stream.Collectors;

@Tag("div")
@CssImport("./styles/navigation-bar.css")
public class NavigationBar extends VerticalLayout {

    List <GrantedAuthority> roles;

    public NavigationBar(Authentication authentication){
        this.addClassName("navigationbar-container");

        roles = (List<GrantedAuthority>) authentication.getAuthorities();

        Div topContainer = new Div();
        topContainer.addClassName("navigationbar-topcontainer");
        topContainer.add(
                getTitle(),

                // For debugging. Delete after
//                new Text(authentication.getPrincipal().toString()),
//                new Text(roles.stream().map(GrantedAuthority::getAuthority).collect(Collectors.joining(" "))),
//                new Text(String.valueOf(roles.contains(new SimpleGrantedAuthority("ROLE_ANONYMOUS")))),

                roles.contains(new SimpleGrantedAuthority("ROLE_ANONYMOUS"))
                        ? getLogButtons()
                        : getLogedIcons((UserEntity) authentication.getPrincipal())
        );

        HorizontalLayout botContainer = new HorizontalLayout();
        botContainer.addClassName("navigationbar-botcontainer");
        botContainer.add(
                getNavigationComponent("Main", ""),
                getNavigationComponent("Catalog", "catalog"),
                getNavigationComponent("Filials", "filials")
        );

        if (roles.contains(new SimpleGrantedAuthority("ROLE_ADMIN"))){
            botContainer.add(
                    getNavigationComponent("Add Book", "create-book"),
                    getNavigationComponent("Add Filial", "create-filial"),
                    getNavigationComponent("Watch orders", "view-orders")
            );
        }

        add(
                topContainer,
                botContainer
        );

    }

    private Component getTitle(){
        Div result = new Div();
        result.addClassName("navigationbar-title");
        result.setText("The Legendary Book Store");
        result.setWidth("");
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
        result.setWidth("");

        Button signIn = new Button("Sign In");
        signIn.addClassName("navigationbar-sign-in-button");
        signIn.addClickListener(event -> UI.getCurrent().navigate("login"));

        Button signUp = new Button("Sign Up");
        signUp.addClassName("navigationbar-sign-up-button");
        signUp.addClickListener(event -> UI.getCurrent().navigate("registration"));

        result.add(signIn, signUp);
        return result;
    }

    private Component getLogedIcons(UserEntity user){

        Div result = new Div();
        result.addClassName("navigationbar-log-buttons-container");
        result.setWidth("");

        Button liked = new Button("Liked");
        liked.addClassName("navigationbar-sign-up-button");
        liked.addClickListener(event -> UI.getCurrent().navigate("liked"));

        Button cart = new Button("Cart");
        cart.addClassName("navigationbar-sign-up-button");
        cart.addClickListener(event -> UI.getCurrent().navigate("cart"));

        Button orders = new Button("Orders");
        orders.addClassName("navigationbar-sign-up-button");
        orders.addClickListener(event -> UI.getCurrent().navigate("orders"));

        Button logout = new Button("Logout");
        logout.addClassName("navigationbar-sign-up-button");
        logout.addClickListener(event -> VaadinSession.getCurrent().getSession().invalidate());

        result.add(liked, cart, orders, logout);
        return result;
    }

}
