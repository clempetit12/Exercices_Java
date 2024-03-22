import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { taskService } from '../services/taskService';

const CreateTask = () => {
    const [task, setTask] = useState({
        name: '',
        description: '',
        priority: '',
        endingDate: '',
        status:'',

    });
    const navigate = useNavigate();

    const handleChange = (e) => {
        const { name, value } = e.target;
        setProduct(prevState => ({
            ...prevState,
            [name]: value
        }));
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            await taskService.createTask(task);
            console.log('Task created successfully');
            setTask({ name: '',description: '',priority: '',creationDate: '',endingDate: '',status:'', });
            navigate('/tasks'); 
        } catch (error) {
            console.error('Error creating task:', error);
           
        }
    };


    return (
        <div className="container mt-5">
        <h2>Créer une nouvelle tâche</h2>
        <form onSubmit={handleSubmit}>
            <div className="mb-3">
                <label htmlFor="taskName" className="form-label">Nom</label>
                <input 
                    type="text" 
                    className="form-control" 
                    id="taskName" 
                    name="name" 
                    value={task.name} 
                    onChange={handleChange} 
                />
            </div>
            <div className="mb-3">
                <label htmlFor="description" className="form-label">Description</label>
                <input 
                    type="text" 
                    className="form-control" 
                    id="description" 
                    name="description" 
                    value={task.description} 
                    onChange={handleChange} 
                />
            </div>
            <div className="mb-3">
            <label htmlFor="prioritySelect" className="form-label">Priorité</label>
            <Form.Select
                id="prioritySelect"
                value={task.priority}
                onChange={handleChange}
            >
                <option value="">Choisissez une priorité</option>
                <option value="1">Priorité 1</option>
                <option value="2">Priorité 2</option>
                <option value="3">Priorité 3</option>
            </Form.Select>
        </div>
        <div className="mb-3">
            <label htmlFor="endDate" className="form-label">Date de fin</label>
            <DatePicker
                selected={endDate}
                onChange={handleChange}
                id="endDate"
                className="form-control"
                value={task.endingDate}
                dateFormat="dd/MM/yyyy" 
                placeholderText="Sélectionnez une date"
            />
        </div>
        <div className="mb-3">
            <label htmlFor="status" className="form-label">Statut</label>
            <select
                id="status"
                className="form-select"
                value={task.status}
                onChange={handleChange}
            >
                <option value="En cours">En cours</option>
                <option value="Terminé">Terminé</option>
            </select>
        </div>
            <button type="submit" className="btn btn-primary">Créer</button>
        </form>
    </div>
    );
};

export default CreateTask;
