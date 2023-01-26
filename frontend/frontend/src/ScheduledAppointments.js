import { useState, useEffect } from "react";
import { useTable, useSortBy } from "react-table";
import axios from "./api/axios";
import NavigationDonator from "./NavigationDonator";
import Table from './Table';


const CENTER_URL = '/center/all';


const ScheduledAppointments = ({role,roles})=>{
    
    useEffect(() => {
    if (!(role==roles)) {
            window.location.href = '/';
        }
      },[])   

    const [table, setTable] = useState(null);
    const [data, setData] = useState([]);

    const columns = [
        {
            Header: 'Center',
            accessor: 'center',
        },
        {
            Header: 'Doctor',
            accessor: 'medicalStaff',
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
            Header: 'Button',
            Cell: ({ row }) => <button onClick={() => handleClick(row.original.id)}>
                Cancel</button>,
        },
      ]
    
        
    
      useEffect(() => {
        const token = localStorage.getItem("token");
        const username = localStorage.getItem("username");
        axios   
            .get(`/donator/scheduled?username=${username}`, {
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

            const response = axios.post('/donator/cancelAppointment',
                JSON.stringify({appointmentId : age,username : username}),
                {
                    headers: {'Content-Type':'application/json', Authorization: "Bearer " + token},
                    withCredentials:true
                }
            );
            
       

        }
        // Do something with the age, like setting it to a state variable
        // or displaying it in an alert
    


    
    return (
        <div>
            <NavigationDonator/>
            <h1>SCHEDULED APPOINTMENTS</h1>
            <div id="tabela">
                
                    <Table columns={columns} data={data} />  
                
            </div>
        </div>
            
    )
}

export default ScheduledAppointments