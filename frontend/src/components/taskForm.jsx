import { useState } from "react";
import { createTask } from "../services/taskService";

function TaskForm({ onTaskCreated }) {
  const [task, setTask] = useState({
    title: "",
    description: "",
    status: "IN-PROGRESS",
    dueDate: "",
    createdBy: "",
  });

  const handleChange = (event) => {
    const { name, value } = event.target;

    setTask((currentTask) => ({
      ...currentTask,
      [name]: value,
    }));
  };

  const handleSubmit = async (event) => {
    event.preventDefault();

    try {
      const createdTask = await createTask(task);
      onTaskCreated(createdTask);
      setTask({
        title: "",
        description: "",
        status: "IN-PROGRESS",
        dueDate: "",
        createdBy: "",
      });
    } catch (error) {
      console.error(error);
      alert("Failed to create task");
    }
  };

  return (
    <form onSubmit={handleSubmit} className="task-form">
      <h2>Create Task</h2>

      <label className="field-label">
        <span>Task title</span>
        <input
          type="text"
          name="title"
          placeholder="Task title"
          value={task.title}
          onChange={handleChange}
          required
        />
      </label>

      <label className="field-label">
        <span>Task description</span>
        <textarea
          name="description"
          placeholder="Task description"
          value={task.description}
          onChange={handleChange}
          required
        />
      </label>

      <label className="field-label">
        <span>Status</span>
        <select name="status" value={task.status} onChange={handleChange}>
          <option value="IN-PROGRESS">In Progress</option>
          <option value="COMPLETED">Completed</option>
          <option value="TODO">Todo</option>
        </select>
      </label>

      <label className="field-label">
        <span>Due date</span>
        <input type="date" name="dueDate" value={task.dueDate} onChange={handleChange} />
      </label>

      <label className="field-label">
        <span>Created by</span>
        <input
          type="text"
          name="createdBy"
          placeholder="Created by"
          value={task.createdBy}
          onChange={handleChange}
          required
        />
      </label>

      <button type="submit" className="primary-button">
        + Create Task
      </button>
    </form>
  );
}

export default TaskForm;