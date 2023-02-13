package com.example.coffeeshop.repository;

import com.example.coffeeshop.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;


@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {



    @Query("SELECT o FROM Order o ORDER BY o.price DESC")
    List<Order> findAllByOrderOrderByPriceDesc();
}
