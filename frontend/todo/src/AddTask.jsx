import { useState } from 'react';

function AddTask({ onAdd }) {
    const [title, setTitle] = useState('');

    const handleSubmit = (e) => {
        e.preventDefault();
        if (!title.trim()) return;
        onAdd(title);
        setTitle('');
    };

    return (
        <form onSubmit={handleSubmit} style={{ marginBottom: '10px' }}>
            <input
                value={title}
                onChange={(e) => setTitle(e.target.value)}
                placeholder="Add task"
            />
            <button type="submit">Add</button>
        </form>
    );
}

export default AddTask;
