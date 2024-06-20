package org.krytev.bookstore.pages;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import org.krytev.bookstore.components.NavigationBar;
import org.springframework.security.core.context.SecurityContextHolder;

@Route("login")
@PageTitle("Login")
@AnonymousAllowed
public class LoginPage extends VerticalLayout implements BeforeEnterObserver {

    private LoginForm login = new LoginForm();
    public LoginPage() {
        addClassName("login-view");
        setSizeFull();

        VerticalLayout content = new VerticalLayout();

        content.setAlignItems(Alignment.CENTER);
        content.getStyle().setMarginTop("40px");
        content.add(login);

        login.setAction("login");
        login.addLoginListener(buttonClickEvent -> UI.getCurrent().navigate(""));
        add(new NavigationBar(SecurityContextHolder.getContext().getAuthentication()), content);

    }

    @Override
    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
        if(beforeEnterEvent.getLocation()
                .getQueryParameters()
                .getParameters()
                .containsKey("error")) {
            login.setError(true);
        }
    }
}
