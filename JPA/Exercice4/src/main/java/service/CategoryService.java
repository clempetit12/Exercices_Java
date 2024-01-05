package service;

import dao.CategoryDao;
import dao.ToDoDao;
import entity.Category;
import entity.Task;
import entity.User;

public class CategoryService {

    private CategoryDao categoryDao;
    public CategoryService(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    public Category createCategory(Category category) {
        if (categoryDao.add(category)  ) {
            System.out.println("Une catégorie a bien été créé   !");
        }
        return category;

    }

    public  boolean deleteCategory(Long id) {

        if (categoryDao.remove(id)) {
            System.out.println("La categorie a bien été supprimée");

        }
        return true;
    }

    public  boolean addTaskToCategory(Long taskId, Long categoryId) {

        if (categoryDao.addaddTaskToCategory(taskId,categoryId)) {
            System.out.println("La tâche a  a bien été ajoutée à la catégorie");

        }
        return true;
    }

    public Category findCategory (Long id) {
        return categoryDao.findCategory(id);

    }

    public  boolean removeTaskCategory(Long taskId, Long categoryId) {

        if (categoryDao.removeTaskFromCategory(taskId,categoryId)) {
            System.out.println("La tâche a  a bien été supprimée de la catégorie");

        }
        return true;
    }
    public void close() {
        categoryDao.close();
    }
}
