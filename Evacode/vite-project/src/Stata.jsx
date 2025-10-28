import React from 'react'

function State() {
    const[state,setState]=React.useState(0);
    const setCounttoten=()=>{
setState(prevState=> prevState+1);}
  return (
<> 
    <div>
       <h1 className="text-lg text-gray-700">Simple click counte</h1> 
       </div>
       <div> 
<p> current count value </p>
  <span>{state}</span>
       </div>
     
       <button

        onClick={setCounttoten}>Set Count to 10 {state}
       </button>
    
 </> )
}

export default State
