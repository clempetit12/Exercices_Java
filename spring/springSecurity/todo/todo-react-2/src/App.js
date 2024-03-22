import logo from './logo.svg';
import './App.css';
import { Router } from 'express';
import Login from './components/Login';
import Register from './components/Register';
import TaskList from './components/TaskList';
import CreateTask from './components/CreateTask';
import { Route, Routes } from 'react-router';
import Header from './shared/Header';


function App() {
  return (
    <Router>
      <Header />
      <Routes>
        <Route path="/login" element={<Login />} />
        <Route path="/register" element={<Register />} />
        <Route path="/" element={<Login />} />

        <Route path="/tasks" element={
      
            <TaskList />
  
        } />

    
        <Route path="/create-task" element={
        
            <CreateTask />
    
        } />
      </Routes>
    </Router>
  );
}
export default App;