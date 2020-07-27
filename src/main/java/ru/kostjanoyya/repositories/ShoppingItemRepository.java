package ru.kostjanoyya.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kostjanoyya.entity.ShoppingItem;
import ru.kostjanoyya.entity.ShoppingItemView;

import java.util.List;

@Repository
public interface ShoppingItemRepository extends JpaRepository<ShoppingItem, Long> {

    List<ShoppingItemView> findByUserUsername(String username);
}
