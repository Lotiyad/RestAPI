function TaskItem({ task, onDelete, onToggle }) {
    return (
        <li style={{
            textDecoration: task.completed ? 'line-through' : 'none',
            marginBottom: '5px'
        }}>
            {task.title}
            <button onClick={() => onToggle(task.id, !task.completed)} style={{ marginLeft: '10px' }}>
                {task.completed ? 'Undo' : 'Complete'}
            </button>
            <button onClick={() => onDelete(task.id)} style={{ marginLeft: '5px' }}>❌</button>
        </li>
    );
}

export default TaskItem;
