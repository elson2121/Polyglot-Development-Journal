import React from 'react';

function State() {

    const [count, setCount] = React.useState(0);
    const [add, setAdd]=React.useState(0);
 
    const incrementCount = () => {

        setCount(prevCount => prevCount + 1); 
        setAdd(prevAdd => prevAdd + 1);
    };
      const incrementCountt = () => {

       
        setAdd(prevAdd => prevAdd + 1);
    };
     const decrementCount = () => {
     
        setCount(prevCount => prevCount > 0 ? prevCount - 1 : 0); 
    };

    return (
        <div>
            <h1>Simple Click Counter (useState)</h1>
            
            <div>
                {/* Displaying the current state */}
                <p>Current Count Value:</p> 
                <span>{count}</span>
            </div>
             <div>
                {/* Displaying the current state */}
                <p>Current Count Value:for day 2</p> 
                <span>{add}</span>
            </div>
              <button
                onClick={incrementCountt}
            >
                Click this 2
            </button>
            
            
            {/* 3. Attach the increment function to the button */}
            <button
                onClick={incrementCount}
            >
                Click to Increase Count
            </button>
            
            <button
                onClick={decrementCount}
            >
                Click to Decrease Count
            </button>
            {/* Optional: A button to reset the count */}
            <button
                onClick={() => setCount(0)}
            >
                Reset
            </button>
        </div>
    );
}

export default State
