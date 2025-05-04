import {createSlice} from "@reduxjs/toolkit";

export interface LoginDTO {
    username: string,
}

const initState: LoginDTO={
    username:''
}

const loginSlice = createSlice({
    name: 'loginSlice',
    initialState: initState,
    reducers: {
        login: (state,action) => {
            const value = action.payload
            console.log(state)
            return {username: value}
        },
        logout: () => {
            return { username:''}
        }
    }
})

export const {logout,login} = loginSlice.actions

export default loginSlice.reducer