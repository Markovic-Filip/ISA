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
import Centers from './Centers';
import HistoryVisits from './HistoryVisits';
import Penaltys from './Penaltys';
import Complaints from './Complaints';
import UserInformation from './UserInformation';
import ScheduledAppointments from './ScheduledAppointments';
import AvailableApp from './AvailableApp';
import QrCodeApp from './QrCodeApp';
import Questionnaire from './Questionnaire';
import HomeUna from './HomeUna';


function App() {
    const { auth } = useContext(AuthContext);
    const role = localStorage.getItem("role") || null;
    const center = localStorage.getItem("center") || null;
   

  

  return (
    <main className='App'>
      
        { (
          <Routes>
           <Route path='/login' element={<Login role={role} roles={["SystemAdministrator","CenterAdministrator", "Donator"]}/>} />
           <Route path='/register' element={<Register role={role} roles={["SystemAdministrator","CenterAdministrator", "Donator"]}/>} />
           <Route path='/home' element={<Home role={role} roles={["Donator"]}/>} />
           <Route path='/centers' element={<Centers role={role} roles={["Donator"]}/>}/>
           <Route path='/history' element={<HistoryVisits role={role} roles={["Donator"]}/>}/>
           <Route path='/penalty' element={<Penaltys role={role} roles={["Donator"]}/>}/>
           <Route path='/complaint' element={<Complaints role={role} roles={["Donator"]}/>}/>
           <Route path='/myinformation' element={<UserInformation role={role} roles={["Donator"]}/>}/>
           <Route path='/scheduled' element={<ScheduledAppointments role={role} roles={["Donator"]}/>}/>
           <Route path='/available' element={<AvailableApp center={center} role={role} roles={["Donator"]}/>}/>
           <Route path='/qrappointment' element={<QrCodeApp role={role} roles={["Donator"]}/>}/>
           <Route path='/questionnaire' element={<Questionnaire role={role} roles={["Donator"]}/>}/>
           <Route path='/' element={<HomeUna role={role} roles={["SystemAdministrator","CenterAdministrator", "Donator"]}/>}/>
           
           
       
         </Routes>
        )}
      
    </main>
  );
}

export default App;

