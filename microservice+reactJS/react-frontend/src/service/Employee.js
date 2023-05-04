import { myaxios } from "./Helper";

export const get=()=>{
    return myaxios.get('/employee-service/employee/byId/'+10);

}

