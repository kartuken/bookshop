package org.krytev.bookstore.pages;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import org.krytev.bookstore.components.NavigationBar;
import org.krytev.bookstore.domain.UserEntity;
import org.krytev.bookstore.services.AuthService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Route("registration")
@PageTitle("Registration")
@AnonymousAllowed
public class RegistrationPage extends VerticalLayout {

    private EmailField email = new EmailField();
    private PasswordField password = new PasswordField();
    private TextField firstName = new TextField();
    private TextField lastName= new TextField();
    private TextField address = new TextField();

    private Button submitButton = new Button("Submit!");

    AuthService registrationService;
    PasswordEncoder passwordEncoder;

    RegistrationPage(AuthService registrationService, PasswordEncoder passwordEncoder){

        VerticalLayout content = new VerticalLayout();
        content.setAlignItems(Alignment.CENTER);
        content.getStyle().setMarginTop("40px");

        email.setLabel("Email");
        password.setLabel("Password");
        firstName.setLabel("Firstname");
        lastName.setLabel("Lastname");
        address.setLabel("Address");

        this.registrationService = registrationService;

        content.add(new H1("Registration"), email, password, firstName, lastName, address, submitButton);
        add(new NavigationBar(SecurityContextHolder.getContext().getAuthentication()), content);
        submitButton.addClickListener(event -> {
            UserEntity user = new UserEntity();
            user.setEmail(email.getValue());
            user.setFirstName(firstName.getValue());
            user.setLastName(lastName.getValue());
            user.setPassword(password.getValue());
            user.setAddress(address.getValue());
            registrationService.registration(user);
            UI.getCurrent().navigate("/login");
        });
    }


}
