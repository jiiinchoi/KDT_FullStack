import LoginComponent from "../../components/member/LoginComponent";
import TopMenuComponent from "../../components/menu/topMenuComponent.tsx";

function LoginPage() {
    return (
        <div>
            <TopMenuComponent/>
            <div>Login Page</div>
            <LoginComponent/>
        </div>
    );
}

export default LoginPage;