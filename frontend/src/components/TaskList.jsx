function TaskList({ tasks }) {
  if (!tasks || tasks.length === 0) {
    return <p className="empty-state">No tasks found.</p>;
  }

  return (
    <section className="task-table-panel">
      <div className="table-header">
        <h2>Task Overview</h2>
      </div>

      <div className="table-wrapper">
        <table className="task-table">
          <thead>
            <tr>
              <th>Title</th>
              <th>Description</th>
              <th>Status</th>
              <th>Due Date</th>
              <th>Created By</th>
              <th>Created</th>
            </tr>
          </thead>
          <tbody>
            {tasks.map((task) => (
              <tr key={task.id}>
                <td>{task.title}</td>
                <td>{task.description}</td>
                <td>
                  <span className={`status-badge ${task.status?.toLowerCase().replace(/\s+/g, "-")}`}>
                    {task.status}
                  </span>
                </td>
                <td>{task.dueDate || "-"}</td>
                <td>{task.createdBy || "-"}</td>
                <td>{task.createdAt || "-"}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </section>
  );
}

export default TaskList;
