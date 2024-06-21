package org.krytev.bookstore.services;

import lombok.RequiredArgsConstructor;
import org.krytev.bookstore.domain.BookEntity;
import org.krytev.bookstore.domain.CityEntity;
import org.krytev.bookstore.domain.FilialEntity;
import org.krytev.bookstore.repositories.FilialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FilialService {
    private final FilialRepository filialRepository;

    public List<FilialEntity> findByCity(CityEntity cityEntity){
        return filialRepository.findByCity(cityEntity);
    }
    public void save(FilialEntity filial){
        filialRepository.save(filial);
    }

    public void update(long id, FilialEntity filialEntity){
        FilialEntity filial = filialRepository.findById(id).orElseThrow();
        filial = filialEntity;
        filial.setId(id);
        filialRepository.save(filial);
    }

    public void delete(FilialEntity filial){
        filialRepository.delete(filial);
    }

    public void deleteById(long id){
        filialRepository.deleteById(id);
    }

    public FilialEntity findById(long id){
        return filialRepository.findById(id).orElseThrow();
    }

    public List<FilialEntity> findAll(){
        return filialRepository.findAll();
    }

}
