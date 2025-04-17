
import AddTask from './AddTask';
import TaskList from './TaskList';
import Task from './Task.jsx'

const API = 'http://localhost:8080/api/tasks';

function App() {
  return (
      <>
        < AddTask />
        < TaskList />
        < Task />
      </>
  );
}

export default App;
