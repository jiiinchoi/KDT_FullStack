import React, {createContext, useState} from 'react';
import CountDisplay from "./CountDisplay.jsx";
import CountMenu from "./CountMenu.jsx";
import { useSelector} from "react-redux";

export const CountContext = createContext()

function CountContainer() {

    const [count, setCount] = useState(1)

    const user = useSelector(state => state.login)


    const plus = () => {
        setCount(count + 1)
    }

    const obj = {count: count, plus: plus}

    //비동기 호출 불러오기
    //상품 목록이 페이지 다뉘로 변경되는 경우 쓰지마라
    //SSR이 필요한 경우 쓰지마라
    // const dispath = useDispatch()
    // const productResult = useSelector(state => state.products)
    // const handleClick=()=>{
    //     dispath(getProductsList())
    // }

    return (
        <CountContext.Provider value={obj}>
            <div>

                {/*<button onClick={handleClick}>GET PRODUCTS</button>*/}
                {/*{productResult.dtoList.map(product=><li key={product.}></li>)}*/}


                Count Container <b>{user.uid}</b>

                <CountMenu></CountMenu>
                <CountDisplay></CountDisplay>

            </div>
        </CountContext.Provider>
    );
}

export default CountContainer;