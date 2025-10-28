import React from 'react';

function State() {
    // 1. Initialize State using useState
    // This returns the current value (count) and the function to update it (setCount)
    const [count, setCount] = React.useState(0);
    
    // Function to handle the button click and increment the count
    const incrementCount = () => {
        // 2. FIX: Use the functional update form (prevState => prevState + 1)
        // This safely increments the count by 1 based on its previous value.
        setCount(prevCount => prevCount + 1); 
    };
     const decrementCount = () => {
        // Use the functional update form (prevState => prevState - 1)
        // We also add a check to prevent the count from going below zero, 
        // which is often desirable in simple counters.
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
