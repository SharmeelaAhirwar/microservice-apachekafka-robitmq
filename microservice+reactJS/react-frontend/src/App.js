import logo from './logo.svg';
import './App.css';
import {get} from './service/Employee'
import { useEffect, useState } from 'react';

// import 'bootstrap/dist/css/bootstrap.min.css';

function App() {
  const [departmentDto,setDepartmentDto]=useState({});
  const [employeeDto,setEmployeeDto]=useState({});

  const [organizationDto ,setOrganizationDto]=useState({});

  useEffect(()=>{
    get().then((response)=>{
      setDepartmentDto(response.data.departmentDto)
      setEmployeeDto(response.data.employeeDto)
      setOrganizationDto(response.data.organizationDto)
      console.log(response.data.organizationDto);
      console.log(response.data.employeeDto);
      console.log(response.data.departmentDto);
    }).catch(error=>{
      console.log(error);
    })
  },[])

 



  const data=()=>{
    get().then((response)=>{
      console.log("response",response);
    }).catch(error=>{
      console.log(error);
    })
    
   
    
  }
  return (
    <>




{/* <button type="button" class="btn btn-primary" onClick={data}>click</button> */}

<div className='card col-md-6 offset-md-3'>
                    <h3 className='text-center card-header'> View Employee Details</h3>
                    <div className='card-body'>
                        <div className='row'>
                            <p><strong>Employee First Name: </strong> {employeeDto.firstName}</p>
                        </div>
                        <div className='row'>
                            <p><strong>Employee Last Name: </strong> {employeeDto.lastName}</p>
                        </div>
                        <div className='row'>
                            <p><strong>Employee Email: </strong> {employeeDto.email}</p>
                        </div>
                    </div>
                    <h3 className='text-center card-header'> View Department Details</h3>
                    <div className='card-body'>
                        <div className='row'>
                            <p><strong>Department Name: </strong> {departmentDto.departmentName }</p>
                        </div>
                        <div className='row'>
                            <p><strong>Department Description: </strong> {departmentDto.departmentDesc }</p>
                        </div>
                        <div className='row'>
                            <p><strong>Department code: </strong> {departmentDto.departmentCode }</p>
                        </div>
                    </div>
                    <h3 className='text-center card-header'> View Organization Details</h3>
                    <div className='card-body'>
                        <div className='row'>
                            <p><strong> Organization Name: </strong> {organizationDto.name } </p>
                        </div>
                        <div className='row'>
                            <p><strong> Organization Description: </strong> {organizationDto.description } </p>
                        </div>
                        <div className='row'>
                            <p><strong> Organization Code: </strong> {organizationDto.code} </p>
                        </div>
                    </div>
                </div>
    </>
    
  );
}

export default App;
