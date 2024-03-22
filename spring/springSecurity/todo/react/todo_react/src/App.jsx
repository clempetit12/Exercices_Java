import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
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
          <PrivateRoute>
            <TaskList />
          </PrivateRoute>
        } />

    
        <Route path="/create-task" element={
          <PrivateRoute>
            <CreateTask />
          </PrivateRoute>
        } />
      </Routes>
    </Router>
  );
}
export default App;