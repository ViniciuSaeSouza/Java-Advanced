package br.com.fiap.tds.twotdspj.javaadv.taskManager.controllers;


import br.com.fiap.tds.twotdspj.javaadv.taskManager.domain.model.Task;
import br.com.fiap.tds.twotdspj.javaadv.taskManager.domain.model.TaskPriority;
import br.com.fiap.tds.twotdspj.javaadv.taskManager.domain.model.TaskStatus;
import br.com.fiap.tds.twotdspj.javaadv.taskManager.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public String listTasks(Model model) {
        model.addAttribute("tasks", this.taskService.findAll());
        return "tasks/list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("task", new Task());
        model.addAttribute("statuses", TaskStatus.values());
        model.addAttribute("priorities", TaskPriority.values());
        return "tasks/form";
    }


    @PostMapping("/save")
    public String saveTask(@Valid @ModelAttribute("task") Task task, Model model, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("statuses", TaskStatus.values());
            model.addAttribute("priorities", TaskPriority.values());
        }
        this.taskService.save(task);
        return "redirect:/tasks";
    }

    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable("id") Long id) {
        this.taskService.deleteById(id);
        return "redirect:/tasks";
    }

    @GetMapping("/view/{id}")
    public String viewTask(@PathVariable("id") Long id, Model model) {
        Task task = this.taskService.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Task not found" + id.toString()));
        model.addAttribute("tasks", task);

        return "tasks/view";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Task newTask = this.taskService.findById(id).orElseThrow(() -> new IllegalArgumentException("Task not found" + id.toString()));
        model.addAttribute("tasks", newTask);
        model.addAttribute("priorities", TaskPriority.values());
        model.addAttribute("statuses", TaskStatus.values());
        return "tasks/form";
    }
}
