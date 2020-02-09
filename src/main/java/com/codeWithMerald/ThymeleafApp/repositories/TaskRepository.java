package com.codeWithMerald.ThymeleafApp.repositories;

import com.codeWithMerald.ThymeleafApp.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

}
