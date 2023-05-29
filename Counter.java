public class Counter {
	private int count = 0;
	private int lastCount = -1;
	private int maximum = -1;
	
	
	@Override
	public String toString() {
		return "Counter's value is: " + count;
	}

	
	
	
	
	
	
	public Counter() {}
	
	public Counter(int maximum) {
		this.maximum = maximum;
	}
	
	public void setMaximumCount(int maximum) {
		this.maximum = maximum;
	}
	
	public int getMaximumCount() {
		return maximum;
	}
	
	public int getCount() {
		return count;
	}
	
	public void incrementCount() {
		count++;
		if (maximum > 0 && count > maximum) {
			count = 0;
		}
	}
	
	public void reset() {
		lastCount = count;
		count = 0;
	}
	
	public void unReset() {
		if (lastCount > -1) {
			if (maximum > 0 && lastCount > maximum) {
				count = 0;
			} else {
				count = lastCount;
			}
		}
	}
}