import {useEffect, useState} from "react";
import axios from "axios";

function Task() {
    const [tasks, setTasks] = useState([]);

    const fetchTasks = () => {
        axios.get(API)
            .then(res => {
                console.log("Fetched tasks:", res.data);
                setTasks(res.data);
            })
            .catch(err => console.error("Fetch error:", err));
    };

    useEffect(() => {
        fetchTasks();
    }, []);

    const addTask = (title) => {
        console.log("Adding task:", title);
        axios.post(API, { title, completed: false })
            .then(res => {
                console.log("Task added:", res.data);
                fetchTasks();
            })
            .catch(err => console.error("Add task error:", err));
    };

    const deleteTask = (id) => {
        axios.delete(`${API}/${id}`).then(() => fetchTasks());
    };

    const toggleComplete = (id, completed) => {
        const task = tasks.find(t => t.id === id);
        if (!task) return;
        axios.put(`${API}/${id}`, { ...task, completed })
            .then(() => fetchTasks());
    };

    return (
        <div style={{ padding: '20px' }}>
            <h2>📝 To-Do List</h2>
            <AddTask onAdd={addTask} />
            {tasks.length === 0 ? (
                <p>No tasks found.</p>
            ) : (
                <TaskList tasks={tasks} onDelete={deleteTask} onToggle={toggleComplete} />
            )}
        </div>
    );
}

export default Task;