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
import org.krytev.bookstore.domain.FilialEntity;
import org.krytev.bookstore.services.CityService;
import org.krytev.bookstore.services.FilialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;


@Route("create-filial")
@RolesAllowed("ROLE_ADMIN")
public class CreateFilialPage extends VerticalLayout {

    private FilialService filialService;

    private CityService cityService;

    private boolean addCityRequired = false;
    HorizontalLayout cityLayout = new HorizontalLayout();
    ComboBox<CityEntity> cityComboBox = new ComboBox<CityEntity>("City");
    TextField cityText = new TextField("City");
    Button addCityButton = new Button("Add City");

    @Autowired
    CreateFilialPage(FilialService filialService, CityService cityService){
        this.filialService = filialService;
        this.cityService = cityService;
        add(new NavigationBar(SecurityContextHolder.getContext().getAuthentication()),
                getForm());
    }

    public Component getForm(){
        cityComboBox.setItems(cityService.findAll());
        cityComboBox.setItemLabelGenerator(CityEntity::getName);
        VerticalLayout content = new VerticalLayout();
        addCityButton.addClickListener(event -> changeAddCityRequired());
        cityLayout.add(cityComboBox, addCityButton);
        TextField address = new TextField("Address");
        TextField time = new TextField("Working time");
        Button submit = new Button("Submit");

        submit.addClickListener(event -> {
            FilialEntity filial = new FilialEntity();
            filial.setAddress(address.getValue());
            filial.setTime(time.getValue());
            if (addCityRequired){
                CityEntity city = new CityEntity();
                city.setName(cityText.getValue());
                cityService.save(city);
                filial.setCity(city);
            } else{
                filial.setCity(cityComboBox.getValue());
            }
            filialService.save(filial);
        });

        content.add(cityLayout, address, time, submit);

        return content;
    }

    private void changeAddCityRequired(){
        this.addCityRequired = !this.addCityRequired;
        cityLayout.getElement().setChild(0, addCityRequired ? cityText.getElement() : cityComboBox.getElement());
        addCityButton.setText(addCityRequired ? "Choose City" : "Add City");
    }

}
