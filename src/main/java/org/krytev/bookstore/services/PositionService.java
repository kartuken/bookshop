package org.krytev.bookstore.services;

import lombok.RequiredArgsConstructor;
import org.krytev.bookstore.domain.*;
import org.krytev.bookstore.repositories.PositionRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PositionService {

    private final PositionRepository positionRepository;

    public Optional<PositionEntity> getPositionByBookAndUser(BookEntity book, UserEntity user){
        return positionRepository.findByBookAndUser(book, user);
    }

    public PositionEntity setAmountOfPosition(Integer amount, PositionEntity position){
        position.setAmount(amount);
        return positionRepository.save(position);
    }

    public void addPositionToUserCart(BookEntity book, UserEntity user){
        Optional<PositionEntity> candidate = getPositionByBookAndUser(book, user);
        PositionEntity position;
        if (candidate.isEmpty()){
            position = new PositionEntity();
            position.setBook(book);
            position.setUser(user);
            position.setAmount(1);
        } else {
            position = candidate.get();
            position.setAmount(position.getAmount() + 1);
        }
        positionRepository.save(position);
    }

    public void movePositionFromCartToOrder(UserEntity user, OrderEntity order){
        return;
    }

    public List<PositionEntity> getPositionsOfUser(UserEntity user){
        return positionRepository.findByUser(user);
    }
}
