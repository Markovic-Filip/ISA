import { useState, useEffect } from "react";
import { useTable, useSortBy } from "react-table";
import axios from "./api/axios";
import NavigationDonator from "./NavigationDonator";
import Table from './Table';


const HISTORY_URL = '/donator/History';


const QrCodeApp = ()=>{

    const [table, setTable] = useState(null);
    const [data, setData] = useState([]);

    const columns = [
        {
          Header: 'Start',
          accessor: 'startTime',
        },
        {
          Header: 'Picture',
          accessor: 'qrCodePath',
          Cell: ({ value }) => <img src={`data:image/png;base64,${value}`}  alt="image" width="100px" height="100px" />
        }, 
      ]
    
        
    
    useEffect(() => {
            const token = localStorage.getItem("token");
            const username = localStorage.getItem("username");
            axios   
                .get(`/donator/qrAppointments?username=${username}`, {
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

export default QrCodeApp