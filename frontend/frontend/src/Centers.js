import { useState, useEffect } from "react";
import { useTable, useSortBy } from "react-table";
import axios from "./api/axios";
import NavigationDonator from "./NavigationDonator";
import Table from './Table';


const CENTER_URL = '/center/all';


const Centers = ()=>{

    const [table, setTable] = useState(null);
    const [data, setData] = useState([]);

    const columns = [
        {
          Header: 'Name',
          accessor: 'name',
        },
        {
          Header: 'Description',
          accessor: 'description',
        },
        {
          Header: 'Average Grade',
          accessor: 'averageGrade',
        },
        {
            Header: 'Address',
            accessor: 'addressDTO',
        },
        {
            Header: 'Button',
            Cell: ({ row }) => <button onClick={() => handleClick(row.original.id)}>
              Appointments</button>,
        },
      ]
    
        
    
    useEffect(() => {
        if (data.length===0) {
            axios   
                .get(CENTER_URL)
                .then(res=>{
                    
                    setData(res.data)
                    console.log(data)

                })
                .catch(err=>{
                    console.log(err)
                })
        }
      },[data])
      
      function handleClick(id) {
        // Find the row in the data array with the matching ID
        const row = data.find(item => item.id === id);
    
        // Access the age from the row
        const age = row.id;
        console.log(age);
        localStorage.setItem("center", age);
        window.location.href = '/available';
      }
    
    return (
        <div>
            <NavigationDonator/>
            <h1>CENTERS</h1>
            <div id="tabela">
                
                    <Table columns={columns} data={data} />  
                
            </div>
        </div>
            
    )

}

export default Centers