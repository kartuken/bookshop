package org.krytev.bookstore.pages;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import org.krytev.bookstore.components.NavigationBar;
import org.krytev.bookstore.domain.CityEntity;
import org.krytev.bookstore.domain.FilialEntity;
import org.krytev.bookstore.services.CityService;
import org.krytev.bookstore.services.FilialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

@Route("filials")
@AnonymousAllowed
public class FilialsPage extends VerticalLayout {

    private FilialService filialService;

    private CityService cityService;

    @Autowired
    FilialsPage(FilialService filialService, CityService cityService){
        this.filialService = filialService;
        this.cityService = cityService;
        add(new NavigationBar(SecurityContextHolder.getContext().getAuthentication()),
                getContent());
    }

    private Component getContent(){
        VerticalLayout content = new VerticalLayout();

//        for (CityEntity city : cityService.findCities()){
//            Text cityName = new Text(city.getName());
//            cityName.addClassName("city-name");
//            for (FilialEntity filial : filialService.findByCity(city)){
//                Text filialAddress = new Text(filial.getAddress());
//                filialAddress.addClassName("filial-address");
//
//                Text filialTime = new Text(filial.getTime());
//                filialTime.addClassName("filial-time");
//            }
//        }


        return content;
    }

}
