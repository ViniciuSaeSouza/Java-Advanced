package br.com.fiap.tds.twotdspj.javaadv.taskManager.controllers;

import br.com.fiap.tds.twotdspj.javaadv.taskManager.domainmodel.Task;
import br.com.fiap.tds.twotdspj.javaadv.taskManager.domainmodel.TaskPriority;
import br.com.fiap.tds.twotdspj.javaadv.taskManager.domainmodel.TaskStatus;
import br.com.fiap.tds.twotdspj.javaadv.taskManager.service.TaskService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(TaskController.class)
@Import(TaskManagerControllerTest.McvTestConfig.class)
public class TaskManagerControllerTest {

    @Autowired
    private static MockMvc mockMvc;

    @Autowired
    private TaskService taskService;

    @TestConfiguration
    public static class McvTestConfig {
        @Bean
        @Primary
        TaskService taskService() {
            return Mockito.mock(TaskService.class);
        }

        @Bean
        @Primary
        SpringResourceTemplateResolver thymeleafTemplateResolver() {
            SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
            resolver.setSuffix(".html");
            resolver.setPrefix("classpath:/templates/");
            resolver.setTemplateMode("HTML");
            resolver.setCharacterEncoding("UTF-8");
            resolver.setCacheable(false);
            return resolver;
        }

        @Bean
        @Primary
        SpringTemplateEngine thymeleafTemplateEngine(Set<ITemplateResolver> templateResolvers) {
            SpringTemplateEngine engine = new SpringTemplateEngine();

            engine.setTemplateResolvers(templateResolvers);
            engine.setTemplateResolver(thymeleafTemplateResolver());
            engine.setEnableSpringELCompiler(true);
            return engine;
        }

        @Bean
        @Primary
        ThymeleafViewResolver thymeleafViewResolver(SpringTemplateEngine engine) {
            ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
            viewResolver.setTemplateEngine(engine);
            viewResolver.setCharacterEncoding("UTF-8");
            return viewResolver;
        }

    }

    private Task task(Long id, String title) {
        Task task = new Task();
        task.setId(id);
        task.setTitle(title);
        task.setDescription("DESCRIPTION");
        task.setCreationDate(LocalDate.of(2025, 9, 29));
        task.setDueDate(LocalDate.of(2025, 9, 30));
        task.setStatus(TaskStatus.PENDING);
        task.setPriority(TaskPriority.MEDIUM);
        return task;
    }

    @Nested
    @DisplayName("GET /tasks")
    class ListAllTasks {
        @Test
        @DisplayName("Dado tarefas existentes, quando lista, então 200, redirecionar para view")
        void shouldReturnAllTasks() throws Exception {
            BDDMockito.given(taskService.findAll())
                    .willReturn(List.of(
                                    task(1L, "TASK-1"),
                                    task(2L, "TASK-2"),
                                    task(3L, "TASK-3"),
                                    task(4L, "TASK-4")
                            )
                    );

            mockMvc.perform(get("/tasks"))
                    .andExpect(status().isOk())
                    .andExpect(view().name("tasks/int_list"))
                    .andExpect(model().attributeDoesNotExist("tasks"))
                    .andExpect(model().attribute("tasks", hasSize(4)))
                    .andExpect(model().attribute("tasks", hasItem(task(1L, "TASK-1"))))
                    .andExpect(model().attribute("tasks", hasItem(task(2L, "TASK-2"))))
                    .andExpect(model().attribute("tasks", hasItem(task(3L, "TASK-3"))))
                    .andExpect(model().attribute("tasks", hasItem(task(4L, "TASK-4"))));

        }
    }

    @Nested
    @DisplayName("GET /tasks/new")
    class newForm {
        @Test
        @DisplayName("Dado formulário de nova tarefa, quando requisitar, então 200, redirecionar para view tasks/int_form")
        void shouldReturnNewTaskForm() throws Exception {
            mockMvc.perform(get("/tasks/new"))
                    .andExpect(status().isOk())
                    .andExpect(view().name("tasks/int_form"))
                    .andExpect(model().attributeExists("task"))
                    .andExpect(model().attributeExists("task", "statuses", "priorities"));
        }
    }

    @Nested
    @DisplayName("GET /tasks/new")
    class savetask {
        @Test
        @DisplayName("Quando payload inválido, quando salvar então volta 'tasks/int_form' com erros")
        void should_return_form_on_validation_errors() throws Exception {
            mockMvc.perform(post("/tasks/new")
                            .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                            .param("title", "T")
                            .param("description", "x"))
                    .andExpect(status().isOk())
                    .andExpect(view().name("tasks/int_form"))
                    .andExpect(model().attributeHasFieldErrors("task", "title", "description", "creationDate", "dueDate", "status", "priority"));
        }
    }
}
