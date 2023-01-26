import { useState, useEffect } from "react";
import { useTable, useSortBy } from "react-table";
import axios from "./api/axios";
import NavigationDonator from "./NavigationDonator";
import Table from './Table';


const HISTORY_URL = '/donator/History';


const HistoryVisits = ()=>{

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
      ]
    
        
    
    useEffect(() => {
            const token = localStorage.getItem("token");
            const username = localStorage.getItem("username");
            axios   
                .get(`/donator/History?username=${username}`, {
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
    
    return (
        <div>
            <NavigationDonator/>
            <h1>HISTORY OF VISITS</h1>
            <div id="tabela">
                
                    <Table columns={columns} data={data} />  
                
            </div>
        </div>
            
    )
}

export default HistoryVisits