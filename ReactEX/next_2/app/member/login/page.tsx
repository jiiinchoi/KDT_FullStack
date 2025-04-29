
"use client"



import {useActionState} from "react";
import {loginServerAction} from "@/app/member/memberActions";
import Link from "next/link";

const initState: MemberInfo = {
    mid:'',
    accessToken:'',
    refreshToken:''
}

async function loginAction(state:MemberInfo, formData:FormData) {

    console.log("login action",state)

    return loginServerAction()


}


function LoginPage() {

    const [state,action, isPending] = useActionState(loginAction, initState);

    return (
        <div>

            {isPending && <div className={'bg-blue-600'}>로그인 중.................</div>}

            {state.accessToken && <div className={'bg-amber-600'}>로그인 완료되었음</div>}

            <div>Login Page</div>
            <form action={action}>
                <button type={"submit"}>Login</button>
            </form>

            <div>

                <Link href={'/member/mypage'}>MyPage</Link>
            </div>

        </div>
    )
}

export default LoginPage;