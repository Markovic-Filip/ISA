import { useState, useEffect } from "react";
import NavigationDonator from "./NavigationDonator";
import Select from 'react-select';




const Complaints = ({role,roles})=>{
    
    useEffect(() => {
    if (!(role==roles)) {
            window.location.href = '/';
        }
      },[])   
    const options = [
        { value: 'center', label: 'Center' },
        { value: 'medicalStaff', label: 'Medical staff' }
      ]

    
    return (
        <div>
            <NavigationDonator/>
            <h1>COMPLAINTS</h1>
            <section>
                <Select options={options} />
                <br/>
                    
                <textarea id="freeform" name="freeform" rows="4" cols="50">
                    
                </textarea>
                <button>Sumbit</button>
                 
            </section>
        </div>
            
    )
}

export default Complaints