import './App.css';
import Login from './Login';
import Register from './Register';
import MyRoutes from './routing/MyRoutes';
import { BrowserRouter } from 'react-router-dom';


function App() {
  return (
    <main className='App'>
      <BrowserRouter>
        <MyRoutes />
      </BrowserRouter>
    </main>
  );
}

export default App;

