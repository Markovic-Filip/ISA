import { useState, useEffect } from "react";
import { useTable, useSortBy } from "react-table";
import axios from "./api/axios";
import NavigationDonator from "./NavigationDonator";


const HISTORY_URL = '/donator/History';


const Penaltys = ({role,roles})=>{
    
    useEffect(() => {
    if (!(role==roles)) {
            window.location.href = '/';
        }
      },[])   

    const [data, setData] = useState();

    
    useEffect(() => {
            const token = localStorage.getItem("token");
            const username = localStorage.getItem("username");
            axios   
                .get(`/donator/penalty?username=${username}`, {
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
            
            <section>
                <h1>You have {data} penaltys</h1>
                
            </section>
        </div>
            
    )
}

export default Penaltys