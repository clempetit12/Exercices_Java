import { useEffect, useState } from "react";
import UpdateTaskModal from "./UpdateTaskModal";
import taskService from "../services/taskService"


function TaskList({user}) {
    const [tasks, setTasks] = useState([]);
    const [error, setError] = useState('');
  
    useEffect(() => {
      taskService.getAllTasks()
        .then(response => {
          console.log(response)
          setTasks(response.data);
        })
        .catch(error => {
          setError('Erreur lors de la récupération des tâches.');
        });
    }, []);
  
    const loadTasks = () => {
      if(user.role === 'ROLE_ADMIN') {
        taskService.getTasksPerUser(user.id) 
         .then(response => {
          setTasks(response.data);
        })
        .catch(error => {
          setError('Erreur lors de la récupération des tâches.');
        });
      } else {
        taskService.getAllTasks()
        .then(response => {
          setTasks(response.data);
        })
        .catch(error => {
          setError('Erreur lors de la récupération des tâches.');
        });
      }
     
    };
  
    const [selectedTask, setSelectedTask] = useState(null);
  
    const updateTask = (taskData) => {
      console.log("task " + taskData.name)
      taskService.updateTask(taskData)
        .then(() => {
          loadTasks();
          setSelectedTask(null);
        })
        .catch(error => {
          setError('Erreur lors de la mise à jour de la tâche.');
        });
    };
  
  
    const deleteTask = (taskId) => {
      taskService.deleteTask(taskId)
        .then(() => {
          loadTasks();
        })
        .catch(error => {
          setError('Erreur lors de la suppression de la tâche.');
        });
    };
  
  
    return (
      <div className="container mt-5">
      <h2>Task List</h2>
      {error && (
          <div className="alert alert-danger" role="alert">
              {error}
          </div>
      )}
      <div className="row row-cols-1 row-cols-md-3 g-4">
          {tasks.map((task, index) => (
              <div key={task.id} className="col">
                  <div className="card">
                      <div className="card-body">
                          <h5 className="card-title">{task.name}</h5>
                          <p className="card-text">Description: {task.description}</p>
                          <p className="card-text">Ending Date: {task.endingDate}</p>
                          {user.role === 'ROLE-ADMIN' && (
                  <div>
  
                      <button className="btn btn-danger mr-2" onClick={() => deleteTask(task.id)}>Supprimer</button>
                      <button className="btn btn-warning" onClick={() => setSelectedTask(task)}>Modifier</button>
                  </div>
                  )}
                          <button className={`btn ${task.status === 'Terminé' ? 'btn-success' : 'btn-info'}`}/>
                      </div>
                  </div>
              </div>
          ))}
      </div>
      {selectedTask && (
          <UpdateTaskModal
              product={selectedTask}
              onSave={updateTask}
              onCancel={() => setSelectedTask(null)}
          />
      )}
  </div>
  );
  }
   
  
  export default TaskList;
  