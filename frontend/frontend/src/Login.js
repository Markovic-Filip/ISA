import {useRef, useState, useEffect,useContext} from 'react'; 
import AuthContext from "./context/AuthProvider";
import axios from './api/axios';
import { Link } from 'react-router-dom';
import Navigation from './Navigation';
const LOGIN_URL = '/auth/login';

const Login = ({role,roles})=>{
    
    useEffect(() => {
    if (!(role==null)) {
            window.location.href = '/home';
        }
      },[])    
    const {setAuth} = useContext(AuthContext);
    const userRef = useRef();
    const errRef= useRef();

    const [user, setUser] = useState('');
    const [pwd, setPwd] = useState('');
    const [errMsg, setErrMsg] = useState('');
    const [success, setSuccess] = useState(false);

    useEffect(() => {
        userRef.current.focus();
    }, [])

    useEffect(() => {
        setErrMsg('');
    }, [user, pwd])

    const handleSumbit = async (e)=>{
        e.preventDefault();
        
        try{
            const response = await axios.post(LOGIN_URL,
                JSON.stringify({username : user,password : pwd}),
                {
                    headers: {'Content-Type':'application/json'},
                    withCredentials:true
                }
            );
            console.log(JSON.stringify(response?.data));
            const accessToken = response?.data?.token.accessToken;
            const role = response?.data?.role;
            localStorage.setItem("role", role);
            localStorage.setItem("token", accessToken);
            localStorage.setItem("username", user);

            setAuth({user,pwd,role,accessToken});
            setUser('');
            setPwd('');
            setSuccess(true);
        }catch(err){
            if (!err?.response) {
                setErrMsg('No Server Response');
            } else if (err.response?.status === 400) {
                setErrMsg('Missing Username or Password');
            } else if (err.response?.status === 401) {
                setErrMsg('Unauthorized');
            } else {
                setErrMsg('Login Failed');
            }
            errRef.current.focus();

        }
        
    }

    

    return (
        <>
            <Navigation/>
            {success ? (
                <section>
                    <h1>You are logged in!</h1>
                    <br />
                    <p>
                        <Link to="/home">Go to Home</Link>
                    </p>
                </section>
            ) : (
        <section>
            <p red={errRef} className={errMsg ? "errmsg" :
             "offscreen"} aria-live="assertive">{errMsg}</p>
             <h1>Sign In</h1>
             <form onSubmit={handleSumbit}>
                    <label htmlFor="username">Username:</label>
                    <input 
                        type="text" 
                        id="username"
                        ref={userRef}
                        autoComplete="off"
                        onChange={(e) => setUser(e.target.value)}
                        value={user}
                        required 
                    />
                    <label htmlFor="password">Password:</label>
                    <input 
                        type="password" 
                        id="password"
                        ref={userRef}
                        onChange={(e) => setPwd(e.target.value)}
                        value={pwd}
                        required 
                    />
                    <button>Sign In</button>
             </form>
             <p>
                 Need an Account?<br />
                <span className="line">
                    {/*put router link here*/}
                    <Link to="/register">Sign up</Link>
                </span>
            </p>
        </section>
            )}
            </>
    )
}

export default Login