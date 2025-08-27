package br.com.fiap.tds.twotdspj.javaadv.taskManager.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tasks")
public class TaskApiController {
    
    
//    private final TaskService taskService;
//
//    public TaskApiController(TaskService taskService) {
//        this.taskService = taskService;
//    }
//
//    private final TaskMapper taskMapper = new TaskMapper();
//
//    @GetMapping
//    public ResponseEntity<List<TaskDTO>> getAllTasks() {
//        List<Task> tasks = taskService.findAll();
//        List<TaskDTO> taskDTOs = tasks.stream()
//                .map(taskMapper::toDTO)
//                .collect(Collectors.toList());
//        return ResponseEntity.ok(taskDTOs);
//    }
//
//    @GetMapping("/old")
//    public ResponseEntity<List<Task>> getAllTasksOld() {
//        List<Task> tasks = taskService.findAll();
//        return ResponseEntity.ok(tasks);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<TaskDTO> getTaskById(@PathVariable Long id) {
//        Task task = taskService.findById(id).get();
//        if (task == null) {
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok(taskMapper.toDTO(task));
//    }
//
//    @PostMapping
//    public ResponseEntity<TaskDTO> createTask(@RequestBody TaskDTO taskDTO) {
//        Task task = taskMapper.toEntity(taskDTO);
//        Task savedTask = taskService.save(task);
//        return ResponseEntity.ok(taskMapper.toDTO(savedTask));
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<TaskDTO> updateTask(@PathVariable Long id, @RequestBody TaskDTO taskDTO) {
//        Task taskToUpdate = taskMapper.toEntity(taskDTO);
//        taskToUpdate.setId(id);
//        Task updatedTask = taskService.save(taskToUpdate);
//        if (updatedTask == null) {
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok(taskMapper.toDTO(updatedTask));
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
//        this.taskService.deleteById(id);
//        return ResponseEntity.noContent().build();
//
//    }
    
}
