import './App.css'
import ListEmployeeComponent from './Components/ListEmployeeComponent'
import HeaderComponent from './Components/HeaderComponent'
import FooterComponent from './Components/FooterComponent'
import {BrowserRouter, Routes, Route} from 'react-router-dom'
import EmployeeComponent from './Components/EmployeeComponent'

function App() {
  

  return (
    <>
    <BrowserRouter>
    <HeaderComponent/>
    <Routes>
      {/* // http://localhost:3000  */}
      <Route path='/' element = {<ListEmployeeComponent/>}></Route>
      {/* http:localhost:3000/employees  */}
      <Route path='/employees' element = {<ListEmployeeComponent/>}></Route>
      {/* http:localhost:3000/add-employee */}
      <Route path='/add-employee' element = {<EmployeeComponent/>}></Route>


    
     </Routes>
     <FooterComponent/>

     </BrowserRouter>
    </>
  )
}

export default App
