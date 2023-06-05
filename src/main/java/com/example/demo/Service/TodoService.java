package com.example.demo.Service;

import com.example.demo.Model.Todo;
import com.example.demo.Repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;

    public List<Todo> getTodos(Integer id) {
        return todoRepository.findTodosByUserId(id);

    }

    public void addTodo(Integer userId, Todo todo) {
        todo.setUserId(userId);
        todoRepository.save(todo);
    }

    public void updateTodo(Integer userId, Todo todo, Integer idTodo) {
        Todo oldTodo = todoRepository.findTodoById(idTodo);
        if (oldTodo.getUserId() != userId) {
            return;
        }
        oldTodo.setMessage(todo.getMessage());
        todoRepository.save(oldTodo);
    }

    public void deleteTodo(Integer userId, Integer idTodo) {
        Todo todo = todoRepository.findTodoById(idTodo);
        if (todo.getUserId() != userId) {
            return;
        }
        todoRepository.delete(todo);

    }

}
