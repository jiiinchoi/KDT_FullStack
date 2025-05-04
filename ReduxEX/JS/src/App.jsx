import './App.css'
import CountContainer from "./components/count/CountContainer.jsx";
import LoginComponent from "./components/member/LoginComponent.jsx";
import {useSelector} from "react-redux";
import LogoutComponent from "./components/member/LogoutComponent.jsx";

function App() {
    const user = useSelector(state => state.login)
  return (
    <>
      <CountContainer></CountContainer>
        <hr/>
            {!user.uid
                ?
            <LoginComponent></LoginComponent>
                :
            <LogoutComponent></LogoutComponent>
            }
    </>
  )
}

export default App
