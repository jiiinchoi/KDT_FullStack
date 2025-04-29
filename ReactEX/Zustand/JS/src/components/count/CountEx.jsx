import React from 'react';
import useCouterStore from "../../stores/useCouterStore.jsx";
import CountDouble from "./countDouble.jsx";

function CountEx() {
    const {count, inc,dec} = useCouterStore()

    return (
        <div>
            <h1>Count2 Ex</h1>
            <h1>COUNT: {count} </h1>
            <div>
                <button onClick={()=>inc(3)}>PLUS</button>
                <button onClick={()=>dec(2)}>MINUS</button>
            </div>

            <CountDouble/>
        </div>
    );
}

export default CountEx;