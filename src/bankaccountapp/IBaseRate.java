package bankaccountapp;

public interface IBaseRate {

	// Imagine someone else is setting this, but we're going to do this instead:
	// Write a method that returns the base rate
	default double getBaseRate() {
		return 2.5;
	}
	
}
