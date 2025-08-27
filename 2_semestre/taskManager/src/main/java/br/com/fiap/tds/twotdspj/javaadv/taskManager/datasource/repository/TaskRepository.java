package br.com.fiap.tds.twotdspj.javaadv.taskManager.datasource.repository;

import br.com.fiap.tds.twotdspj.javaadv.taskManager.domain.model.Task;
import br.com.fiap.tds.twotdspj.javaadv.taskManager.domain.model.TaskStatus;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TaskRepository  extends JpaRepository<Task, Long>{
    public List<Task> findAllByOrderByDueDateAsc();
    public List<Task> findByStatusOrderByDueDate(TaskStatus status);
    
}
