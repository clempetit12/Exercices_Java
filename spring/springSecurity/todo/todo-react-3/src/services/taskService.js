import api from './api';
import { authHeader } from '../helpers/auth-header';

const getAllTasks = () => {
  return api.get('/tasks', { headers: authHeader() });
};


const createTask = (task) => {
  return api.post('/tasks/create', task, { headers: authHeader() });
};


const deleteTask = (taskId) => {
  return api.delete(`/tasks/${taskId}`, { headers: authHeader() });
};

const updateTask = (taskData,id) => {
  console.log(taskData)
  return api.put(`tasks/update/${id}`, taskData, {
    headers: {
      ...authHeader(),
      'Content-Type': 'application/json'
    }
  });
};

const getTasksPerUser = (userId) => {
    return api.get(`tasks/${userId}`,{ headers: authHeader()})
}


export default { getAllTasks, createTask, deleteTask, updateTask, getTasksPerUser };
