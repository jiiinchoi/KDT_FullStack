import React, {useState} from 'react';
import useLoginStore from "../../stores/useLoginStore.jsx";

function LoginComponent() {

    const [text, setText] = useState()

    const {login} = useLoginStore()

    return (
        <div>
            <hr/>
            <input type={'text'} value={text} onChange={e=>{
                setText(e.target.value)
            }}/>
            <button onClick={()=>{
                login(text)
            }}>LOGIN</button>
        </div>
    );
}

export default LoginComponent;