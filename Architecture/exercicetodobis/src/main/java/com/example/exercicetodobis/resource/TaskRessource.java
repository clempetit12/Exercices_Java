package com.example.exercicetodobis.resource;

import com.example.exercicetodobis.dto.TaskDto;
import com.example.exercicetodobis.entity.Task;
import com.example.exercicetodobis.service.TaskService;
import com.example.exercicetodobis.utils.Definition;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;

import java.util.List;

@Path("/task")
public class TaskRessource {

    private final TaskService taskService;


    @Inject
    public TaskRessource(TaskService taskService) {
        this.taskService = taskService;
    }
    @POST
    public boolean postTask(TaskDto taskDto) {

        return taskService.create(taskDto);
    }

    @DELETE
    @Path("{id}")
    public boolean delete(@PathParam("id") Long id) {
        return taskService.delete(id);
    }

    @GET
    @Path("/taskList")
    public List<Task> getTasks() {
        return taskService.getAll();
    }

    @PUT
    @Path("{id}/update")
    public Task putTask(@PathParam("id") Long id, @FormParam("status") boolean status) {
        return taskService.update(id, status);
    }

    @GET
    @Path("/showForm")
    public String showForm() {
        return Definition.VIEW_PATH + "task-form.jsp";
    }
}
