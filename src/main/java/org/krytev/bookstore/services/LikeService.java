package org.krytev.bookstore.services;

import com.vaadin.flow.component.notification.Notification;
import lombok.RequiredArgsConstructor;
import org.krytev.bookstore.domain.BookEntity;
import org.krytev.bookstore.domain.LikeEntity;
import org.krytev.bookstore.domain.UserEntity;
import org.krytev.bookstore.repositories.LikeRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LikeService {

    private final LikeRepository likeRepository;

    public void like(Authentication authentication, BookEntity book){
        if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ANONYMOUS"))){
            Notification.show("You have to be authorized to like books");
            return;
        }

        if (isLiked(authentication, book)){
            UserEntity user = (UserEntity) authentication.getPrincipal();
            likeRepository.delete(likeRepository.findByUserAndBook(user, book).get());
            return;
        }

        LikeEntity like = new LikeEntity();
        like.setBook(book);
        like.setUser((UserEntity) authentication.getPrincipal());
        likeRepository.save(like);
    }

    public boolean isLiked(Authentication authentication, BookEntity book){
        if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ANONYMOUS"))){
            return false;
        }
        UserEntity user = (UserEntity) authentication.getPrincipal();
        return likeRepository.findByUserAndBook(user, book).isPresent();
    }

    public Integer getLikeCount(BookEntity book){
        return likeRepository.countByBook(book);
    }

    public List<BookEntity> getLikedBooks(Authentication authentication){
        return likeRepository.findLikedBooks((UserEntity) authentication.getPrincipal());
    }
}
