package org.krytev.bookstore.pages;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import org.krytev.bookstore.components.NavigationBar;
import org.springframework.security.core.context.SecurityContextHolder;


@Route("catalog")
@AnonymousAllowed
public class CatalogPage extends VerticalLayout {

    CatalogPage(){
        add(new NavigationBar(SecurityContextHolder.getContext().getAuthentication()),
                getContent());
    }

    private Component getContent(){
        HorizontalLayout content = new HorizontalLayout();

        Div filters = new Div();
        return  content;
    }

}
