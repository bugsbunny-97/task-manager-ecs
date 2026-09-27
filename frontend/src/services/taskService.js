const API_BASE_URL = "/api";

export const getTasks = async () => {
    const response = await fetch(`${API_BASE_URL}/task`);

    if (!response.ok) {
        throw new Error("Failed to fetch tasks");
    }

    return response.json();
};

export const createTask = async (task) => {
    const response = await fetch(`${API_BASE_URL}/task`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(task)
    });

    if (!response.ok) {
        throw new Error("Failed to create task");
    }

    return response.json();
};

export const getTaskById = async (id) => {
    const response = await fetch(`${API_BASE_URL}/task/${id}`);

    if (!response.ok) {
        throw new Error("Task not found");
    }

    return response.json();
};