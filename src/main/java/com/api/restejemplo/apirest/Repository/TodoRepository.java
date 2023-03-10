package com.api.restejemplo.apirest.Repository;

import com.api.restejemplo.apirest.Model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Task, Long> {


}
