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

@Route("login")
@PageTitle("Login")
@AnonymousAllowed
public class LoginPage extends VerticalLayout implements BeforeEnterObserver {

    private LoginForm login = new LoginForm();
    private Button registration = new Button("registration");
    public LoginPage() {
        addClassName("login-view");
        setSizeFull();

        setJustifyContentMode(JustifyContentMode.CENTER);
        setAlignItems(Alignment.CENTER);

        login.setAction("login");
        login.addLoginListener(buttonClickEvent -> UI.getCurrent().navigate("/index"));
        registration.addClickListener(buttonClickEvent -> UI.getCurrent().navigate("/registration"));
        add(new H1("Test Application"), login, registration);

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
