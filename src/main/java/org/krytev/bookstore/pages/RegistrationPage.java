package org.krytev.bookstore.pages;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import org.krytev.bookstore.domain.UserEntity;
import org.krytev.bookstore.services.AuthService;
import org.springframework.security.crypto.password.PasswordEncoder;

@Route("registration")
@PageTitle("Registration")
@AnonymousAllowed
public class RegistrationPage extends VerticalLayout {

    private EmailField email = new EmailField();
    private PasswordField password = new PasswordField();
    private TextField fio = new TextField();
    private TextField address = new TextField();

    private Button submitButton = new Button("Registration!");

    AuthService registrationService;
    PasswordEncoder passwordEncoder;

    RegistrationPage(AuthService registrationService, PasswordEncoder passwordEncoder){
        email.setLabel("Email");
        password.setLabel("Password");
        fio.setLabel("Full name");
        address.setLabel("Address");
        this.registrationService = registrationService;
        add(email, password, fio, address, submitButton);
        submitButton.addClickListener(event -> {
            UserEntity user = new UserEntity();
            user.setEmail(email.getValue());
            user.setFio(fio.getValue());
            user.setPassword(password.getValue());
            user.setAddress(address.getValue());
            registrationService.registration(user);
        });
    }


}
