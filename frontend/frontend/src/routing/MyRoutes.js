import { Route, Routes } from "react-router-dom";
import Register from "../Register";
import Login from "../Login";

const MyRoutes = () => {
    return (
        <Routes>
            <Route path="/signin" element={<Login/>} />
            <Route path="/" element={<Register/>} />
        </Routes>
    )
}

export default MyRoutes;