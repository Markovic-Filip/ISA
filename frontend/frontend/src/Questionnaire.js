import NavigationDonator from "./NavigationDonator"
import { useState } from "react";
import axios from "./api/axios";
import { useEffect } from "react";

const Questionnaire = ({role,roles})=>{
    
    useEffect(() => {
    if (!(role==roles)) {
            window.location.href = '/';
        }
      },[])   

    const [question1, setQuestion1] = useState('');
    const [question2, setQuestion2] = useState('');
    const [question3, setQuestion3] = useState('');
    const [question4, setQuestion4] = useState('');
    const [question5, setQuestion5] = useState('');
    const [question6, setQuestion6] = useState('');
    const [question7, setQuestion7] = useState('');
    const [question8, setQuestion8] = useState('');
    const [question9, setQuestion9] = useState('');
    const [question10, setQuestion10] = useState('');
    const [question11, setQuestion11] = useState('');
    const [question12, setQuestion12] = useState('');


    const handleSubmit = async (e) => {
        e.preventDefault();
        const q1 = question1;
        const q2 = question2;
        const q3 = question3;
        const q4 = question4;
        const q5 = question5;
        const q6 = question6;
        const q7 = question7;
        const q8 = question8;
        const q9 = question9;
        const q10 = question10;
        const q11 = question11;
        const q12 = question12;
        const username = localStorage.getItem("username");
        const token = localStorage.getItem("token");
        
        try {
            const response = await axios.post('/donator/questionnaire',
                JSON.stringify({username,q1,q2,q3,q4,q5,q6,q7,q8,q9,q10,q11,q12 }),
                {
                    headers: { 'Content-Type': 'application/json', Authorization: "Bearer " + token },
                    withCredentials: true
                }
            );
        

            
        } catch (err) {
            
            
        }
    }


    return (
        <div>
            <NavigationDonator/>
            <h1>QUESTIONNAIRE</h1>
            <section>
                
                <form onSubmit={handleSubmit}>
                    <label htmlFor="username" className="tight-spacing">
                                Did you ever donate blood?
                    </label>
                    <div id="surveyForm" className="survey-form">
                        <label htmlFor="yes">Yes</label>
                        <input type="radio" id="q1yes" name="question1" value="true" onChange={e=> setQuestion1("true")}/>
                        <label htmlFor="no">No</label>
                        <input type="radio" id="q1no" name="question1" value="false" onChange={e=> setQuestion1("false")}/>
                    </div>

                    <label htmlFor="username" className="tight-spacing">
                                Did you ever get rejected for donating blood?
                    </label>
                    <div id="surveyForm" className="survey-form">
                        <label htmlFor="yes">Yes</label>
                        <input type="radio" id="q2yes" name="question2" value="true" onChange={e=> setQuestion2("true")}/>
                        <label htmlFor="no">No</label>
                        <input type="radio" id="q2no" name="question2" value="false" onChange={e=> setQuestion2("false")}/>
                    </div>


                    <label htmlFor="username" className="tight-spacing">
                                Do you feel healthy and rested to be donating blood?
                    </label>
                    <div id="surveyForm" className="survey-form">
                        <label htmlFor="yes">Yes</label>
                        <input type="radio" id="q3yes" name="question3" value="true" onChange={e=> setQuestion3("true")}/>
                        <label htmlFor="no">No</label>
                        <input type="radio" id="q3no" name="question3" value="false" onChange={e=> setQuestion3("false")}/>
                    </div>


                    <label htmlFor="username" className="tight-spacing">
                                Did you eat before coming to donate blood?
                    </label>
                    <div id="surveyForm" className="survey-form">
                        <label htmlFor="yes">Yes</label>
                        <input type="radio" id="q4yes" name="question4" value="true" onChange={e=> setQuestion4("true")}/>
                        <label htmlFor="no">No</label>
                        <input type="radio" id="q4no" name="question4" value="false" onChange={e=> setQuestion4("false")}/>
                    </div>


                    <label htmlFor="username" className="tight-spacing">
                                Do you have dangerous job or hobby?
                    </label>
                    <div id="surveyForm" className="survey-form">
                        <label htmlFor="yes">Yes</label>
                        <input type="radio" id="q5yes" name="question5" value="true" onChange={e=> setQuestion5("true")}/>
                        <label htmlFor="no">No</label>
                        <input type="radio" id="q5no" name="question5" value="false" onChange={e=> setQuestion5("false")}/>
                    </div>


                    <label htmlFor="username" className="tight-spacing">
                                Do you use any medication every day?
                    </label>
                    <div id="surveyForm" className="survey-form">
                        <label htmlFor="yes">Yes</label>
                        <input type="radio" id="q6yes" name="question6" value="true" onChange={e=> setQuestion6("true")}/>
                        <label htmlFor="no">No</label>
                        <input type="radio" id="q6no" name="question6" value="false" onChange={e=> setQuestion6("false")}/>
                    </div>


                    <label htmlFor="username" className="tight-spacing">
                                Did you use any medication in last 2-3 days?
                    </label>
                    <div id="surveyForm" className="survey-form">
                        <label htmlFor="yes">Yes</label>
                        <input type="radio" id="q7yes" name="question7" value="true" onChange={e=> setQuestion7("true")}/>
                        <label htmlFor="no">No</label>
                        <input type="radio" id="q7no" name="question7" value="false" onChange={e=> setQuestion7("false")}/>
                    </div>

                    <label htmlFor="username" className="tight-spacing">
                                Do you use Aspirin often? Did you use it in last 5 days?
                    </label>
                    <div id="surveyForm" className="survey-form">
                        <label htmlFor="yes">Yes</label>
                        <input type="radio" id="q8yes" name="question8" value="true" onChange={e=> setQuestion8("true")}/>
                        <label htmlFor="no">No</label>
                        <input type="radio" id="q8no" name="question8" value="false" onChange={e=> setQuestion8("false")}/>
                    </div>


                    <label htmlFor="username" className="tight-spacing">
                                Did you ever get tested or treated in hospital?
                    </label>
                    <div id="surveyForm" className="survey-form">
                        <label htmlFor="yes">Yes</label>
                        <input type="radio" id="q9yes" name="question9" value="true" onChange={e=> setQuestion9("true")}/>
                        <label htmlFor="no">No</label>
                        <input type="radio" id="q9no" name="question9" value="false" onChange={e=> setQuestion9("false")}/>
                    </div>

                    <label htmlFor="username" className="tight-spacing">
                                Did you pull out teeth in last 7 days?
                    </label>
                    <div id="surveyForm" className="survey-form">
                        <label htmlFor="yes">Yes</label>
                        <input type="radio" id="q10yes" name="question10" value="true" onChange={e=> setQuestion10("true")}/>
                        <label htmlFor="no">No</label>
                        <input type="radio" id="q10no" name="question10" value="false" onChange={e=> setQuestion10("false")}/>
                    </div>

                    <label htmlFor="username" className="tight-spacing">
                                Did you have temperature over 38C in last 7-10 days?
                    </label>
                    <div id="surveyForm" className="survey-form">
                        <label htmlFor="yes">Yes</label>
                        <input type="radio" id="q11yes" name="question11" value="true" onChange={e=> setQuestion11("true")}/>
                        <label htmlFor="no">No</label>
                        <input type="radio" id="q11no" name="question11" value="false" onChange={e=> setQuestion11("false")}/>
                    </div>

                    <label htmlFor="username" className="tight-spacing">
                                Did you get vaccinated in last 12 months?
                    </label>
                    <div id="surveyForm" className="survey-form">
                        <label htmlFor="yes">Yes</label>
                        <input type="radio" id="q12yes" name="question12" value="true" onChange={e=> setQuestion12("true")}/>
                        <label htmlFor="no">No</label>
                        <input type="radio" id="q12no" name="question12" value="false" onChange={e=> setQuestion12("false")}/>
                    </div>
                    <button>Sumbit</button>
                </form>
                    
                
            </section>
        </div>
            
    )
}
export default Questionnaire