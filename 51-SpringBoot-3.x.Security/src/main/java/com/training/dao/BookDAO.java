package com.training.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.bean.Book;

@Repository
public interface BookDAO extends JpaRepository<Book, Integer>{

}
