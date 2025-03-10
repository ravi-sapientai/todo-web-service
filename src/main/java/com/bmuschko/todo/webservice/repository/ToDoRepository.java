package com.bmuschko.todo.webservice.repository;

import com.bmuschko.todo.webservice.model.BaseTodoItem;
import com.bmuschko.todo.webservice.model.ToDoItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<BaseTodoItem, Long> {
}
