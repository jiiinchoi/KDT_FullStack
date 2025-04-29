//프로젝트 할 때 절대 이렇게 하지 마라
//비동기 호출
import {createAsyncThunk, createSlice} from "@reduxjs/toolkit";
import axios from "axios";

export const getProductsList = createAsyncThunk('getProductsListThunk',async()=>{
    const res = await axios.get("http://122.34.51.94:8090/api/products/list")

    return res.data
})

const productsSlice = createSlice({
    name: "productsSlice",
    initialState: {dtoList:[]},
    reducers: {

    },
    extraReducers:(builder) => {
        builder
            .addCase(getProductsList.pending,()=>{
                console.log("pending.....")
            })
            .addCase(getProductsList.fulfilled,()=>{
                console.log("fulfilled.......")
            })
    }
})

export default productsSlice.reducer