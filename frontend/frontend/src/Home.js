import Navigation from "./Navigation"
import NavigationDonator from "./NavigationDonator"
import { useEffect } from "react"
const Home = ({role,roles})=>{
    
    useEffect(() => {
    if (!(role==roles)) {
            window.location.href = '/';
        }
      },[])   
    
    return (
        <div>
                <NavigationDonator/>
            <section>
                <h1>WELCOME TO DONATOR HOME PAGE</h1>
                
            </section>
        </div>
            
    )
}

export default Home