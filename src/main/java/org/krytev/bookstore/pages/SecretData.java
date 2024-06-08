package org.krytev.bookstore.pages;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.RolesAllowed;

@Route("secret")
@RolesAllowed("ROLE_USER")
public class SecretData extends VerticalLayout {

    SecretData(){
        add(new Text("SECRET_FLAG{FYM}"));
    }

}
