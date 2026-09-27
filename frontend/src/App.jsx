import { useEffect, useState } from "react";
import TaskForm from "./components/TaskForm";
import TaskList from "./components/TaskList";
import { getTasks } from "./services/taskService";
import "./App.css";

function App() {
  const [tasks, setTasks] = useState([]);
  const [loading, setLoading] = useState(true);
  const [activeTab, setActiveTab] = useState("create");

  const loadTasks = async () => {
    try {
      const data = await getTasks();
      setTasks(data);
    } catch (error) {
      console.error(error);
    } finally {
      setLoading(false);
    }
  };

  useEffect(() => {
    loadTasks();
  }, []);

  const handleTaskCreated = (task) => {
    setTasks((previousTasks) => [task, ...previousTasks]);
    setActiveTab("tasks");
  };

  return (
    <div className="app-shell">
      <div className="app-card">
        <div className="tab-bar" role="tablist" aria-label="Task views">
          <button
            type="button"
            className={activeTab === "create" ? "tab-button active" : "tab-button"}
            onClick={() => setActiveTab("create")}
          >
            Create Task
          </button>
          <button
            type="button"
            className={activeTab === "tasks" ? "tab-button active" : "tab-button"}
            onClick={() => setActiveTab("tasks")}
          >
            Your tasks
          </button>
        </div>

        <main className="content-panel">
          {activeTab === "create" ? (
            <TaskForm onTaskCreated={handleTaskCreated} />
          ) : (
            <section className="task-section">
              <h3>Your tasks</h3>
              {loading ? (
                <p className="loading-state">Loading tasks...</p>
              ) : (
                <TaskList tasks={tasks} />
              )}
            </section>
          )}
        </main>
      </div>
    </div>
  );
}

export default App;