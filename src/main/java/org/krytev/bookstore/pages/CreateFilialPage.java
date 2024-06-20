package org.krytev.bookstore.pages;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.RolesAllowed;
import org.krytev.bookstore.components.NavigationBar;
import org.springframework.security.core.context.SecurityContextHolder;

import java.awt.*;

@Route("create-filial")
@RolesAllowed("ROLE_ADMIN")
public class CreateFilialPage extends VerticalLayout {

    CreateFilialPage(){
        add(new NavigationBar(SecurityContextHolder.getContext().getAuthentication()),
                getForm());
    }

    public Component getForm(){
        Div content = new Div();

        TextField city = new TextField();
        TextField address = new TextField();
        TextField time = new TextField();



        return content;
    }
}
