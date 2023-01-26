import { useState, useEffect } from "react";
import { useTable, useSortBy } from "react-table";
import axios from "./api/axios";
import NavigationDonator from "./NavigationDonator";
import Table from './Table';


const CENTER_URL = '/center/all';


const AvailableApp = ({center,role,roles})=>{

    const [table, setTable] = useState(null);
    const [data, setData] = useState([]);

    const columns = [
        {
          Header: 'Center',
          accessor: 'center',
        },
        {
          Header: 'Start',
          accessor: 'startTime',
        },
        {
          Header: 'End',
          accessor: 'endTime',
        },
        {
            Header: 'Doctor',
            accessor: 'medicalStaff',
        },
        {
            Header: 'b',
            Cell: ({ row }) => <button onClick={() => handleClick(row.original.id)}>
              Schedule</button>,
        },
      ]
    
        
    
      useEffect(() => {
        const token = localStorage.getItem("token");
        const username = localStorage.getItem("username");
        console.log(username);
        console.log(center);
        axios   
            .get('/donator/available',{
            params: {centerId : center,username : username}, 
                headers: {
                    Authorization: "Bearer " + token
                }
            })
            .then(res=>{
                
                setData(res.data)
                console.log(data)

            })
            .catch(err=>{
                console.log(err)
            })
    
    },[])       
      
    function handleClick(id) {
        // Find the row in the data array with the matching ID
        const row = data.find(item => item.id === id);
    
        // Access the age from the row
        const age = row.id;
        console.log(age);
        const username = localStorage.getItem("username");
        const token = localStorage.getItem("token");

            const response = axios.post('/donator/scheduleAppointment',
                JSON.stringify({appointmentId : age,username : username}),
                {
                    headers: {'Content-Type':'application/json', Authorization: "Bearer " + token},
                    withCredentials:true
                }
            );
            
       

        }
    
    return (
        <div>
            <NavigationDonator/>
            <h1>APPOINTMENTS</h1>
            <div id="tabela">
                
                    <Table columns={columns} data={data} />  
                
            </div>
        </div>
            
    )

}

export default AvailableApp