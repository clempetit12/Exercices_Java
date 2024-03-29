import React, { useState } from 'react';

function UpdateTaskModal({ task, onSave, onCancel }) {
  const [name, setName] = useState(task?.name);
  const [description, setDescription] = useState(task?.description);
  const [endingDate, setEndingDate] = useState(task?.endingDate);
  const [priority, setPriority] = useState(task?.priority);
  const [status, setStatus] = useState(task?.status);

  

  const handleSubmit = (e) => {
    e.preventDefault();
    onSave({id:task.id, name, description, endingDate, priority,status });
  };

  return (
    <div className="modal" style={{ display: 'block', backgroundColor: 'rgba(0,0,0,0.5)' }}>
      <div className="modal-dialog">
        <div className="modal-content">
          <div className="modal-header">
            <h5 className="modal-title">Update Task</h5>
            <button type="button" className="close" onClick={onCancel}>
              <span>&times;</span>
            </button>
          </div>
          <div className="modal-body">
            <form onSubmit={handleSubmit}>
              <div className="form-group">
                <label>Name</label>
                <input type="text" className="form-control" value={name} onChange={(e) => setName(e.target.value)} />
              </div>
              <div className="form-group">
                <label>Description</label>
                <input type="text" className="form-control" value={description} onChange={(e) => setDescription(e.target.value)} />
              </div>
              <div className="form-group">
  <label>Ending Date</label>
  <input type="date" className="form-control" value={endingDate} onChange={(e) => setEndingDate(e.target.value)} />
</div>
<div className="form-group">
  <label>Priority</label>
  <select className="form-control" value={priority} onChange={(e) => setPriority(e.target.value)}>
    <option value="1">1</option>
    <option value="2">2</option>
    <option value="3">3</option>
  </select>
</div>
<div className="form-group">
  <label>Status</label>
  <select className="form-control" value={status} onChange={(e) => setStatus(e.target.value)}>
    <option value="En cours">En cours</option>
    <option value="Terminé">Terminé</option>
  </select>
</div>
              <button type="submit" className="btn btn-primary">Save changes</button>
            </form>
          </div>
        </div>
      </div>
    </div>
  );
}

export default UpdateTaskModal;