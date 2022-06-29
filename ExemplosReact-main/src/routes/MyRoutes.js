import React, { Component }  from 'react';
import  {Routes, Route} from 'react-router-dom'
import SignIn from '../pages/SignIn'
import SignUp from '../pages/SignUp'
import Dashboard from '../pages/Dashboard'
import Profile from '../pages/Profile'
import Costumers from '../pages/Costumers'
import New from '../pages/New';
import Chamados from '../pages/Chamados/listagem/chamados';

 export default function MyRoutes(){
    return(
       <Routes>
          <Route exact path='/' element={<SignIn/>}/>
          <Route exact path='/register' element={<SignUp/>}/>
          <Route exact path='/chamados' element={<Chamados/>}/>
          <Route isPrivate exact path='/dashboard' element={<Dashboard/>}/>
          <Route isPrivate exact path='/profile' element={<Profile/>}/>
          <Route isPrivate exact path='/costumers' element={<Costumers/>}/>
          <Route isPrivate exact path='/new' element={<New/>}/>
       </Routes> 
    );
}