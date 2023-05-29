/**
* Implements a counter that can be incremented, reset, and restored (unreset)
*
* @author Ben Gladstone
* @version 0.0.1
*/
public class Counter {
    // the current count
    private int count = 0;
    
    // the previous saved count, -1 indicates no count has been saved yet
    private int lastCount = -1;
    
    // the maximum allowed count value, -1 indicates no maximum
    private int maximum = -1;
    
    /**
    * Returns the counter's value as a String.
    *
    * @return           counter's current value as String
    */
    @Override
    public String toString() {
        return "Counter's value is: " + count;
    }

    /**
    * Default constructor creates a new Counter object with default settings.
    *
    * @return           new Counter object
    */
    public Counter() {}
    
    /**
    * Counter constructor to create a Counter with a certain maximum allowed value.
    * The counter should roll over to zero when it reaches the maximum.
    *
    * @param maximum    the maximum counter value
    * @return           new Counter object
    */
    public Counter(int maximum) {
        this.maximum = maximum;
    }
    
    /**
    * Sets the maximum allowed value of the counter.
    *
    * @param maximum    the maximum counter value
    */
    public void setMaximumCount(int maximum) {
        this.maximum = maximum;
    }
    
    /**
    * Returns the maximum allowed value of the counter.
    *
    * @return           the maximum counter value
    */
    public int getMaximumCount() {
        return maximum;
    }
    
    /**
    * Returns the current value of the counter.
    *
    * @return           the current value of the counter
    */
    public int getCount() {
        return count;
    }
    
    /**
    * Increments the value of the counter. Also rolls over to zero if counter exceeds maximum.
    */
    public void incrementCount() {
        count++;    // increment count
        if (maximum > 0 && count > maximum) {   // if there is a maximum set and we just exceeded it
            count = 0;                          // then rollover to zero. not reset, so no need to store old value
        }
    }
    
    /**
    * Resets the counter to zero.
    */
    public void reset() {
        lastCount = count;  // on reset, save the value in case we want to restore later
        count = 0;          // reset to zero
    }
    
    /**
    * Restores the counter to the previous value from before it was last reset.
    */
    public void unReset() {
        if (lastCount > -1) {   // if we stored a previous count value before
            if (maximum > 0 && lastCount > maximum) {   // if there is a maximum set and restoring would exceed it
                count = 0;                              // then set count to zero
            } else {                                    // else
                count = lastCount;                      // restore the stored count value
            }
        }
    }
}
