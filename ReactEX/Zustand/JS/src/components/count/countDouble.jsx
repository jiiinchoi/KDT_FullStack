import React from 'react';
import useCouterStore from "../../stores/useCouterStore.jsx";

function CountDouble() {

    const{makeDouble} =useCouterStore()

    return (
        <div>
            <button onClick={makeDouble}>Double</button>
        </div>
    );
}

export default CountDouble;