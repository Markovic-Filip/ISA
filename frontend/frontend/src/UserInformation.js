import { useState, useEffect } from "react";
import { useTable, useSortBy } from "react-table";
import axios from "./api/axios";
import NavigationDonator from "./NavigationDonator";


const HISTORY_URL = '/donator/History';


const UserInformation = ({role,roles})=>{
    
    useEffect(() => {
    if (!(role==roles)) {
            window.location.href = '/';
        }
      },[])   

    const [address_id, setAddress] = useState();
    const [username, setUsername] = useState();
    const [email, setEmail] = useState();
    const [name, setName] = useState();
    const [surname, setSurname] = useState();
    const [phoneNumber, setPhoneNumber] = useState();
    const [jmbg, setJmbg] = useState();
    const [gender, setGender] = useState();
    const [proffesion, setProffesion] = useState();
    const [company, setCompany] = useState();

    
    useEffect(() => {
            const token = localStorage.getItem("token");
            const username = localStorage.getItem("username");
            axios   
                .get(`/donator/information?username=${username}`, {
                    headers: {
                        Authorization: "Bearer " + token
                    }
                })
                .then(res=>{
                    
                    setAddress(res.data.address_id);
                    setUsername(res.data.username);
                    setEmail(res.data.email);
                    setName(res.data.name);
                    setSurname(res.data.surnname);
                    setPhoneNumber(res.data.phoneNumber);
                    setJmbg(res.data.jmbg);
                    setGender(res.data.gender);
                    setProffesion(res.data.proffesion);
                    setCompany(res.data.company);
                    

                })
                .catch(err=>{
                    console.log(err)
                })
        
      },[])    
    
    return (
        <div>
            <NavigationDonator/>
            
            <section>
                    <label htmlFor="username">Username:</label>
                    <input 
                        type="text" 
                        id="username"
                        value={username}
                         
                    />
                    <label htmlFor="email">Email:</label>
                    <input  
                        
                        type="text" 
                        id="email"
                        value={email}
                         
                    />
                    <label htmlFor="krk">Name:</label>
                    <input 
                        type="krk" 
                        id="krk"
                        value={name}
                         
                    />
                    <label htmlFor="surname">Surname:</label>
                    <input 
                        type="text" 
                        id="surname"
                        value={surname}
                         
                    />
                    <label htmlFor="phoneNumber">Phone number:</label>
                    <input 
                        type="text" 
                        id="phoneNumber"
                        value={phoneNumber}
                         
                    />
                    <label htmlFor="jmbg">JMBG:</label>
                    <input 
                        type="text" 
                        id="jmbg"
                        value={jmbg}
                         
                    />
                    <label htmlFor="gender">Gender:</label>
                    <input 
                        type="text" 
                        id="gender"
                        value={gender}
                         
                    />
                    <label htmlFor="proffesion">Proffesion:</label>
                    <input 
                        type="text" 
                        id="proffesion"
                        value={proffesion}
                         
                    />
                    <label htmlFor="company">Company:</label>
                    <input 
                        type="text" 
                        id="company"
                        value={company}
                         
                    />
                    <label htmlFor="address">Address:</label>
                    <input 
                        type="text" 
                        id="address"
                        value={address_id}
                         
                    />
                
            </section>
        </div>
            
    )
}

export default UserInformation