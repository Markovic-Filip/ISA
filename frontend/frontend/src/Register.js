import { useRef, useState, useEffect } from "react";
import { faCheck, faTimes, faInfoCircle } from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { Link } from "react-router-dom";
import Select from 'react-select';
import axios from './api/axios';

const USER_REGEX = /^[A-z][A-z0-9-_]{3,23}$/;
const PWD_REGEX = /^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%]).{8,24}$/;
const EMAIL_REGEX = /@[a-zA-Z0-9]+/;
const NAME_REGEX = /^[a-zA-Z]+$/;
const PHONE_REGEX = /^[0-9]+$/;
const JMBG_REGEX = /^\d{13}$/;
const GENDER_REGEX = /^(male|female|other)$/i;
const REGISTER_URL = '/auth/signup';
const ADDRESS_URL = '/auth/allAddress';

const Register = () => {
    const userRef = useRef();
    const errRef = useRef();

    const [user, setUser] = useState('');
    const [validName, setValidName] = useState(false);
    const [userFocus, setUserFocus] = useState(false);

    const [email, setEmail] = useState('');
    const [validEmail, setValidEmail] = useState(false);
    const [emailFocus, setEmailFocus] = useState(false);

    const [pwd, setPwd] = useState('');
    const [validPwd, setValidPwd] = useState(false);
    const [pwdFocus, setPwdFocus] = useState(false);

    const [matchPwd, setMatchPwd] = useState('');
    const [validMatch, setValidMatch] = useState(false);
    const [matchFocus, setMatchFocus] = useState(false);

    const [name, setName] = useState('');
    const [validNamee, setValidNamee] = useState(false);
    const [nameFocus, setNameFocus] = useState(false);

    const [surnname, setSurname] = useState('');
    const [validSurname, setValidSurname] = useState(false);
    const [surnameFocus, setSurnameFocus] = useState(false);

    const [phoneNumber, setPhoneNumber] = useState('');
    const [validPhoneNumber, setValidPhoneNumber] = useState(false);
    const [phoneNumberFocus, setPhoneNumberFocus] = useState(false);

    const [jmbg, setJmbg] = useState('');
    const [validJmbg, setValidJmbg] = useState(false);
    const [jmbgFocus, setJmbgFocus] = useState(false);

    const [gender, setGender] = useState('');
    const [validGender, setValidGender] = useState(false);
    const [genderFocus, setGenderFocus] = useState(false);

    const [proffesion, setProffesion] = useState('');
    const [validProffesion, setValidProffesion] = useState(false);
    const [proffesionFocus, setProffesionFocus] = useState(false);

    const [company, setCompany] = useState('');
    const [validCompany, setValidCompany] = useState(false);
    const [companyFocus, setCompanyFocus] = useState(false);

    const [errMsg, setErrMsg] = useState('');
    const [success, setSuccess] = useState(false);

    const [addresses, setAddress] = useState([]);
        const [selectedValue, setSelectedValue] = useState();

    
    
    useEffect(() => {
        axios   
            .get(ADDRESS_URL)
            .then(res=>{
                
                setAddress(res.data)
                console.log(addresses)
            })
            .catch(err=>{
                console.log(err)
            })
      },[])    


    




    

      





    useEffect(() => {
        userRef.current.focus();
    }, [])

    useEffect(() => {
        setValidName(USER_REGEX.test(user));
    }, [user])

    useEffect(() => {
        setValidEmail(EMAIL_REGEX.test(email));
    }, [email])

    useEffect(() => {
        setValidPwd(PWD_REGEX.test(pwd));
        setValidMatch(pwd === matchPwd);
    }, [pwd, matchPwd])

    useEffect(() => {
        setValidNamee(NAME_REGEX.test(name));
    }, [name])

    useEffect(() => {
        setValidSurname(NAME_REGEX.test(surnname));
    }, [surnname])

    useEffect(() => {
        setValidPhoneNumber(PHONE_REGEX.test(phoneNumber));
    }, [phoneNumber])

    useEffect(() => {
        setValidJmbg(JMBG_REGEX.test(jmbg));
    }, [jmbg])

    useEffect(() => {
        setValidGender(GENDER_REGEX.test(gender));
    }, [gender])

    useEffect(() => {
        setValidProffesion(NAME_REGEX.test(proffesion));
    }, [proffesion])

    useEffect(() => {
        setValidCompany(NAME_REGEX.test(company));
    }, [company])



    useEffect(() => {
        setErrMsg('');
    }, [user, email, pwd, matchPwd, name, surnname, phoneNumber, jmbg, gender, proffesion, company, selectedValue])

    const handleSubmit = async (e) => {
        e.preventDefault();
        // if button enabled with JS hack
        /*const v1 = USER_REGEX.test(user);
        const v2 = PWD_REGEX.test(pwd);
        if (!v1 || !v2) {
            setErrMsg("Invalid Entry");
            return;
        }*/
        const id = 1;
        console.log(selectedValue.value);
        const address_id = selectedValue.value;
        try {
            const response = await axios.post(REGISTER_URL,
                JSON.stringify({id, username : user,email,password : pwd, passwordAgain : matchPwd,name, surnname,phoneNumber,jmbg,gender,proffesion,company,address_id }),
                {
                    headers: { 'Content-Type': 'application/json' },
                    withCredentials: true
                }
            );
            //console.log(response?.data);
            //console.log(response?.accessToken);
            //console.log(JSON.stringify(response))
            setSuccess(true);
            //clear state and controlled inputs
            //need value attrib on inputs for this
            setUser('');
            setPwd('');
            setMatchPwd('');
            setCompany('');
            setEmail('');
            setGender('');
            setJmbg('');
            setName('');
            setSurname('');
            setPhoneNumber('');
            setProffesion('');
            
        } catch (err) {
            if (!err?.response) {
                setErrMsg('No Server Response');
            } else if (err.response?.status === 409) {
                setErrMsg('Username Taken');
            } else {
                setErrMsg('Registration Failed')
            }
            errRef.current.focus();
        }
    }

    return (
        <>
            {success ? (
                <section>
                    <h1>Success!</h1>
                    <p>
                        <a href="#">Sign In</a>
                    </p>
                </section>
            ) : (
                <section>
                    <p ref={errRef} className={errMsg ? "errmsg" : "offscreen"} aria-live="assertive">{errMsg}</p>
                    <h1>Register</h1>
                    <form onSubmit={handleSubmit}>
                        <label htmlFor="username">
                            Username:
                            <FontAwesomeIcon icon={faCheck} className={validName ? "valid" : "hide"} />
                            <FontAwesomeIcon icon={faTimes} className={validName || !user ? "hide" : "invalid"} />
                        </label>
                        <input
                            type="text"
                            id="username"
                            ref={userRef}
                            autoComplete="off"
                            onChange={(e) => setUser(e.target.value)}
                            value={user}
                            required
                            aria-invalid={validName ? "false" : "true"}
                            aria-describedby="uidnote"
                            onFocus={() => setUserFocus(true)}
                            onBlur={() => setUserFocus(false)}
                        />
                        <p id="uidnote" className={userFocus && user && !validName ? "instructions" : "offscreen"}>
                            <FontAwesomeIcon icon={faInfoCircle} />
                            4 to 24 characters.<br />
                            Must begin with a letter.<br />
                            Letters, numbers, underscores, hyphens allowed.
                        </p>



                        <label htmlFor="email">
                            Email:
                            <FontAwesomeIcon icon={faCheck} className={validEmail ? "valid" : "hide"} />
                            <FontAwesomeIcon icon={faTimes} className={validEmail || !email ? "hide" : "invalid"} />
                        </label>
                        <input
                            type="text"
                            id="email"
                            autoComplete="off"
                            onChange={(e) => setEmail(e.target.value)}
                            value={email}
                            required
                            aria-invalid={validEmail ? "false" : "true"}
                            aria-describedby="emdnote"
                            onFocus={() => setEmailFocus(true)}
                            onBlur={() => setEmailFocus(false)}
                        />
                        <p id="emdnote" className={emailFocus && email && !validEmail ? "instructions" : "offscreen"}>
                            <FontAwesomeIcon icon={faInfoCircle} />
                            Wrong email, you must have @.
                        </p>


                        <label htmlFor="password">
                            Password:
                            <FontAwesomeIcon icon={faCheck} className={validPwd ? "valid" : "hide"} />
                            <FontAwesomeIcon icon={faTimes} className={validPwd || !pwd ? "hide" : "invalid"} />
                        </label>
                        <input
                            type="password"
                            id="password"
                            onChange={(e) => setPwd(e.target.value)}
                            value={pwd}
                            required
                            aria-invalid={validPwd ? "false" : "true"}
                            aria-describedby="pwdnote"
                            onFocus={() => setPwdFocus(true)}
                            onBlur={() => setPwdFocus(false)}
                        />
                        <p id="pwdnote" className={pwdFocus && !validPwd ? "instructions" : "offscreen"}>
                            <FontAwesomeIcon icon={faInfoCircle} />
                            8 to 24 characters.<br />
                            Must include uppercase and lowercase letters, a number and a special character.<br />
                            Allowed special characters: <span aria-label="exclamation mark">!</span> <span aria-label="at symbol">@</span> <span aria-label="hashtag">#</span> <span aria-label="dollar sign">$</span> <span aria-label="percent">%</span>
                        </p>


                        <label htmlFor="confirm_pwd">
                            Confirm Password:
                            <FontAwesomeIcon icon={faCheck} className={validMatch && matchPwd ? "valid" : "hide"} />
                            <FontAwesomeIcon icon={faTimes} className={validMatch || !matchPwd ? "hide" : "invalid"} />
                        </label>
                        <input
                            type="password"
                            id="confirm_pwd"
                            onChange={(e) => setMatchPwd(e.target.value)}
                            value={matchPwd}
                            required
                            aria-invalid={validMatch ? "false" : "true"}
                            aria-describedby="confirmnote"
                            onFocus={() => setMatchFocus(true)}
                            onBlur={() => setMatchFocus(false)}
                        />
                        <p id="confirmnote" className={matchFocus && !validMatch ? "instructions" : "offscreen"}>
                            <FontAwesomeIcon icon={faInfoCircle} />
                            Must match the first password input field.
                        </p>



                        <label htmlFor="name">
                            Name:
                            <FontAwesomeIcon icon={faCheck} className={validNamee ? "valid" : "hide"} />
                            <FontAwesomeIcon icon={faTimes} className={validNamee || !name ? "hide" : "invalid"} />
                        </label>
                        <input
                            type="text"
                            id="name"
                            autoComplete="off"
                            onChange={(e) => setName(e.target.value)}
                            value={name}
                            required
                            aria-invalid={validNamee ? "false" : "true"}
                            aria-describedby="namnote"
                            onFocus={() => setNameFocus(true)}
                            onBlur={() => setNameFocus(false)}
                        />
                        <p id="namnote" className={nameFocus && name && !validNamee ? "instructions" : "offscreen"}>
                            <FontAwesomeIcon icon={faInfoCircle} />
                            You must only use letters.
                        </p>





                        <label htmlFor="surname">
                            Surname:
                            <FontAwesomeIcon icon={faCheck} className={validSurname ? "valid" : "hide"} />
                            <FontAwesomeIcon icon={faTimes} className={validSurname || !surnname ? "hide" : "invalid"} />
                        </label>
                        <input
                            type="text"
                            id="surname"
                            autoComplete="off"
                            onChange={(e) => setSurname(e.target.value)}
                            value={surnname}
                            required
                            aria-invalid={validSurname ? "false" : "true"}
                            aria-describedby="surnote"
                            onFocus={() => setSurnameFocus(true)}
                            onBlur={() => setSurnameFocus(false)}
                        />
                        <p id="surnote" className={surnameFocus && surnname && !validSurname ? "instructions" : "offscreen"}>
                            <FontAwesomeIcon icon={faInfoCircle} />
                            You must only use letters.
                        </p>


                        <label htmlFor="phoneNumber">
                            Phone number:
                            <FontAwesomeIcon icon={faCheck} className={validPhoneNumber ? "valid" : "hide"} />
                            <FontAwesomeIcon icon={faTimes} className={validPhoneNumber || !phoneNumber ? "hide" : "invalid"} />
                        </label>
                        <input
                            type="text"
                            id="phoneNumber"
                            autoComplete="off"
                            onChange={(e) => setPhoneNumber(e.target.value)}
                            value={phoneNumber}
                            required
                            aria-invalid={validPhoneNumber ? "false" : "true"}
                            aria-describedby="pnnote"
                            onFocus={() => setPhoneNumberFocus(true)}
                            onBlur={() => setPhoneNumberFocus(false)}
                        />
                        <p id="pnnote" className={phoneNumberFocus && phoneNumber && !validPhoneNumber ? "instructions" : "offscreen"}>
                            <FontAwesomeIcon icon={faInfoCircle} />
                            You must only use numbers.
                        </p>


                        <label htmlFor="jmbg">
                            JMBG:
                            <FontAwesomeIcon icon={faCheck} className={validJmbg ? "valid" : "hide"} />
                            <FontAwesomeIcon icon={faTimes} className={validJmbg || !jmbg ? "hide" : "invalid"} />
                        </label>
                        <input
                            type="text"
                            id="jmbg"
                            autoComplete="off"
                            onChange={(e) => setJmbg(e.target.value)}
                            value={jmbg}
                            required
                            aria-invalid={validJmbg ? "false" : "true"}
                            aria-describedby="jmbgnote"
                            onFocus={() => setJmbgFocus(true)}
                            onBlur={() => setJmbgFocus(false)}
                        />
                        <p id="jmbgnote" className={jmbgFocus && jmbg && !validJmbg ? "instructions" : "offscreen"}>
                            <FontAwesomeIcon icon={faInfoCircle} />
                            There has to be 13 numbers.
                        </p>


                        <label htmlFor="gender">
                            Gender:
                            <FontAwesomeIcon icon={faCheck} className={validGender ? "valid" : "hide"} />
                            <FontAwesomeIcon icon={faTimes} className={validGender || !gender ? "hide" : "invalid"} />
                        </label>
                        <input
                            type="text"
                            id="gender"
                            autoComplete="off"
                            onChange={(e) => setGender(e.target.value)}
                            value={gender}
                            required
                            aria-invalid={validGender ? "false" : "true"}
                            aria-describedby="gennote"
                            onFocus={() => setGenderFocus(true)}
                            onBlur={() => setGenderFocus(false)}
                        />
                        <p id="gennote" className={genderFocus && gender && !validGender ? "instructions" : "offscreen"}>
                            <FontAwesomeIcon icon={faInfoCircle} />
                            Type male, female or other.
                        </p>


                        <label htmlFor="proffesion">
                            Proffesion:
                            <FontAwesomeIcon icon={faCheck} className={validProffesion ? "valid" : "hide"} />
                            <FontAwesomeIcon icon={faTimes} className={validProffesion || !proffesion ? "hide" : "invalid"} />
                        </label>
                        <input
                            type="text"
                            id="proffesion"
                            autoComplete="off"
                            onChange={(e) => setProffesion(e.target.value)}
                            value={proffesion}
                            required
                            aria-invalid={validProffesion ? "false" : "true"}
                            aria-describedby="pronote"
                            onFocus={() => setProffesionFocus(true)}
                            onBlur={() => setProffesionFocus(false)}
                        />
                        <p id="pronote" className={proffesionFocus && proffesion && !validProffesion ? "instructions" : "offscreen"}>
                            <FontAwesomeIcon icon={faInfoCircle} />
                            You must only use letters.
                        </p>


                        <label htmlFor="company">
                            Company:
                            <FontAwesomeIcon icon={faCheck} className={validCompany ? "valid" : "hide"} />
                            <FontAwesomeIcon icon={faTimes} className={validCompany || !company ? "hide" : "invalid"} />
                        </label>
                        <input
                            type="text"
                            id="company"
                            autoComplete="off"
                            onChange={(e) => setCompany(e.target.value)}
                            value={company}
                            required
                            aria-invalid={validCompany ? "false" : "true"}
                            aria-describedby="comnote"
                            onFocus={() => setCompanyFocus(true)}
                            onBlur={() => setCompanyFocus(false)}
                        />
                        <p id="comnote" className={companyFocus && company && !validCompany ? "instructions" : "offscreen"}>
                            <FontAwesomeIcon icon={faInfoCircle} />
                            You must only use letters.
                        </p>

                        <label htmlFor="Address">
                            Address:
                        </label>
                        <Select options={addresses.map((ad) => (
                                    { value: ad.id, label: ad.address }
                                ))} 
                            onChange={(e) => setSelectedValue(e)}
                            value={selectedValue}
                        />






                        <button disabled={!validName || !validPwd || !validMatch ? true : false}>Sign Up</button>
                    </form>
                    <p>
                        Already registered?<br />
                        <span className="line">
                            {/*put router link here*/}
                                
                            <Link to="/signin">SingIn</Link>
                        </span>
                    </p>
                </section>
            )}
        </>
    )
}

export default Register