import './App.css';
import Login from './Login';
import Register from './Register';
import MyRoutes from './routing/MyRoutes';
import { BrowserRouter } from 'react-router-dom';
import { AuthProvider } from './context/AuthProvider';
import AuthContext from './context/AuthProvider';
import { useContext } from 'react';
import { Route, Routes } from 'react-router-dom';
import Home from './Home';


function App() {
    const { auth } = useContext(AuthContext);
    const role = localStorage.getItem("role") || null;

  

  return (
    <main className='App'>
      
        { (
          <Routes>
           <Route path='/login' element={<Login role={role} roles={["SystemAdministrator","CenterAdministrator", "Donator"]}/>} />
           <Route path='/register' element={<Register role={role} roles={["SystemAdministrator","CenterAdministrator", "Donator"]}/>} />
           <Route path='/' element={<Home role={role} roles={["SystemAdministrator","CenterAdministrator", "Donator"]}/>} />
         </Routes>
        )}
      
    </main>
  );
}

export default App;

