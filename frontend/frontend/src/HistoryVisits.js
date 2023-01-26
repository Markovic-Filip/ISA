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
        if (data.length===0) {
            axios   
                .get(HISTORY_URL)
                .then(res=>{
                    
                    setData(res.data)
                    console.log(data)

                })
                .catch(err=>{
                    console.log(err)
                })
        }
      },[data])    
    
    return (
        <div>
            <NavigationDonator/>
            <div id="tabela">
                
                    <Table columns={columns} data={data} />  
                
            </div>
        </div>
            
    )
}

export default HistoryVisits