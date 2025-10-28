import React from 'react'

function State() {
    const[state,setState]=React.useState(0);
    const setCounttoten=()=>{
setState(10); };
  return (
    <div>
       <p className="text-lg text-gray-700">Current Count Value (from useState):</p> 
       <span>{state}</span>
       <button

        onClick={setCounttoten}>Set Count to 10
       </button>
    </div>
  )
}

export default State
