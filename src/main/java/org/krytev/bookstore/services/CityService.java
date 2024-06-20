package org.krytev.bookstore.services;

import lombok.RequiredArgsConstructor;
import org.krytev.bookstore.domain.CityEntity;
import org.krytev.bookstore.domain.FilialEntity;
import org.krytev.bookstore.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityService {
    @Autowired
    private final CityRepository cityRepository;

    public void save(CityEntity city){
        cityRepository.save(city);
    }

    public void update(long id, CityEntity cityEntity){
        CityEntity city = cityRepository.findById(id).orElseThrow();
        city = cityEntity;
        city.setId(id);
        cityRepository.save(cityEntity);
    }

    public void delete(CityEntity city){
        cityRepository.delete(city);
    }

    public void deleteById(long id){
        cityRepository.deleteById(id);
    }

    public CityEntity findById(long id){
        return cityRepository.findById(id).orElseThrow();
    }

    public List<CityEntity> findAll(){
        return cityRepository.findAll();
    }
}
