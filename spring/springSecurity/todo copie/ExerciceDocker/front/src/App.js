import logo from './logo.svg';
import './App.css';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Header from './shared/Header';
import Login from './components/Login';
import Register from './components/Register';
import TaskList from './components/TaskList';
import CreateTask from './components/CreateTask';

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
