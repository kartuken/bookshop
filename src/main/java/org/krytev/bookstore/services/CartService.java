package org.krytev.bookstore.services;

import lombok.RequiredArgsConstructor;
import org.krytev.bookstore.domain.CartEntity;
import org.krytev.bookstore.domain.FilialEntity;
import org.krytev.bookstore.domain.PositionEntity;
import org.krytev.bookstore.repositories.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {
    @Autowired
    private final CartRepository cartRepository;

    public void save(CartEntity cart){
        cartRepository.save(cart);
    }

    public void update(long id, CartEntity cartEntity){
        CartEntity cart = cartRepository.findById(id).orElseThrow();
        cart = cartEntity;
        cart.setId(id);
        cartRepository.save(cart);
    }
    public void addPosition(long id, PositionEntity positionEntity){
        CartEntity cart = cartRepository.findById(id).orElseThrow();
        List<PositionEntity> positionEntityList = cart.getPositions();
        positionEntityList.add(positionEntity);
        cart.setPositions(positionEntityList);
        cartRepository.save(cart);
    }

    public void clearPositionList(Long id){
        CartEntity cart = cartRepository.findById(id).orElseThrow();
        cart.getPositions().clear();
        cartRepository.save(cart);
    }
    public void delete(CartEntity cart){
        cartRepository.delete(cart);
    }

    public void deleteById(long id){
        cartRepository.deleteById(id);
    }

    public CartEntity findById(long id){
        return cartRepository.findById(id).orElseThrow();
    }

    public List<CartEntity> findAll(){
        return cartRepository.findAll();
    }

}
