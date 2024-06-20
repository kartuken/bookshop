package org.krytev.bookstore.pages;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.RolesAllowed;
import org.krytev.bookstore.components.NavigationBar;
import org.krytev.bookstore.domain.CityEntity;
import org.krytev.bookstore.services.CityService;
import org.krytev.bookstore.services.FilialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;


@Route("create-filial")
@RolesAllowed("ROLE_ADMIN")
public class CreateFilialPage extends VerticalLayout {

    private FilialService filialService;

    private CityService cityService;

    @Autowired
    CreateFilialPage(FilialService filialService, CityService cityService){
        this.filialService = filialService;
        this.cityService = cityService;
        add(new NavigationBar(SecurityContextHolder.getContext().getAuthentication()),
                getForm());
    }

    public Component getForm(){
        VerticalLayout content = new VerticalLayout();

        HorizontalLayout cityLayout = new HorizontalLayout();
        ComboBox<CityEntity> city = new ComboBox<CityEntity>("City");
        Button addCityButton = new Button("Add City");
        cityLayout.add(city, addCityButton);
        TextField address = new TextField("Address");
        TextField time = new TextField("Working time");
        Button submit = new Button("Submit");
        //submit.addClickListener(event -> filialService.createFilial());
        content.add(cityLayout, address, time, submit);

        return content;
    }

}
