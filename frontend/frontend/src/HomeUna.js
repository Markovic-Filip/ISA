import Navigation from "./Navigation"
import { useEffect } from "react";

const HomeUna = ({role,roles})=>{
    
    useEffect(() => {
    if (!(role==null)) {
            window.location.href = '/home';
        }
      },[])    
    
    return (
        <div>
                <Navigation/>
            <section>
                <h1>WELCOME TO HOME PAGE</h1>
                
            </section>
        </div>
            
    )
}

export default HomeUna