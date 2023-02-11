package org.jfree.data.test;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.jfree.data.DataUtilities;
import org.jfree.data.Range; import org.junit.*;

public class RangeTest {

	/**
	 * Tests for the contains() method
	 */
	
	@Test
    public void containsValueBetweenUpperAndLowerBound() {
		Range range = new Range(-10, 10);
        assertEquals("The range contains 5 should be true", true, range.contains(5));
    }

    @Test 
    public void containsValueForUpperBound() {
    	Range range = new Range(-10, 10);
        assertEquals("The range contains 10 should be true", true, range.contains(10));
    }

    @Test
    public void containsValueForLowerBound() {
    	Range range = new Range(-10, 10);
        assertEquals("The range contains -10 should be true", true, range.contains(-10));
    }

    @Test
    public void containsLessThanLowerBound() {
    	Range range = new Range(-10, 10);
        assertEquals("The range contains -11 should be false", false, range.contains(-11));
    }

    @Test
    public void containsMoreThanLowerBound() {
    	Range range = new Range(-10, 10);
        assertEquals("The range contains 11 should be false", false, range.contains(11));
    }
    
    @Test
    public void containsDecimalInRange() {
    	Range range = new Range(-10, 10);
        assertEquals("The range contains 0.14 should be true", true, range.contains(0.14));
    }
    
    /**
     * Tests for the getLength() method
     */

    @Test
    public void getLengthSameLowerUpperBound() {
    	
    	Range range = new Range(1, 1);
    	
        assertEquals("This test is for checking the length of the range when the lower and upper bounds are the same", 0, range.getLength(), .000000001d);
    }
    
    @Test
    public void getLengthPositiveLowerUpperBound() {
    	
    	Range range = new Range(1, 10);
    	
        assertEquals("This test is for checking the length of the range when the lower and upper bounds are positive but different", 9, range.getLength(), .000000001d);
    }

    @Test
    public void getLengthNegativeLowerUpperBound() {
    	
    	Range range = new Range(-10, -1);
    	
        assertEquals("This test is for checking the length of the range when the lower and upper bounds are negative but different", 9, range.getLength(), .000000001d);
    }
    
    @Test
    public void getLengthNegativeLowerPositiveUpper() {
    	
    	Range range = new Range(-10, 10);
    	
        assertEquals("This test is for checking the length of the range when the lower bound is negative and upper bound is positive", 20, range.getLength(), .000000001d);
    }
    
    @Test
    public void getLengthDecimalRange() {
    	
    	Range range = new Range(-10.32, 10.49);
    	
        assertEquals("This test is for checking the length of the range when the lower and upper bounds are decimals", 20.81, range.getLength(), .000000001d);
    }
    
    @Test
    public void getLengthNullRange() {
    	
		 try {
	            Range range = null;
	            range.getLength();

	        } catch (Exception e) {
	            assertEquals("This test is for checking the length of a null range object", NullPointerException.class,
	                    e.getClass());
	        }
    }
    
    /**
     * Tests for the getLowerBound() method
     */

    @Test
    public void getLowerBoundSameLowerUpperBound() {
    	
    	Range range = new Range(1, 1);
    	
        assertEquals("This test is for checking the lower bound of the range when the lower and upper bounds are the same", 1, range.getLowerBound(), .000000001d);
    }
    
    @Test
    public void getLowerBoundPositiveLowerUpperBound() {
    	
    	Range range = new Range(5, 10);
    	
        assertEquals("This test is for checking the lower bound of the range when the lower and upper bounds are positive but different", 5, range.getLowerBound(), .000000001d);
    }

    @Test
    public void getLowerBoundNegativeLowerUpperBound() {
    	
    	Range range = new Range(-10, -1);
    	
        assertEquals("This test is for checking the lower bound of the range when the lower and upper bounds are negative but different", -10, range.getLowerBound(), .000000001d);
    }
    
    @Test
    public void getLowerBoundNegativeLowerPositiveUpper() {
    	
    	Range range = new Range(-20, 10);
    	
        assertEquals("This test is for checking the lower bound of the range when the lower bound is negative and upper bound is positive", -20, range.getLowerBound(), .000000001d);
    }
    
    @Test
    public void getLowerBoundDecimalRange() {
    	
    	Range range = new Range(-10.32, 10.49);
    	
        assertEquals("This test is for checking the lower bound of the range when the lower and upper bounds are decimals", -10.32, range.getLowerBound(), .000000001d);
    }
    
    @Test
    public void getLowerBoundNullRange() {
    	
		 try {
	            Range range = null;
	            range.getLowerBound();

	        } catch (Exception e) {
	            assertEquals("This test is for checking the lower bound of a null range object", NullPointerException.class,
	                    e.getClass());
	        }
    }
    
    /**
     * Tests for the getUpperBound() method
     */

    @Test
    public void getUpperBoundSameLowerUpperBound() {
    	
    	Range range = new Range(1, 1);
    	
        assertEquals("This test is for checking the upper bound of the range when the lower and upper bounds are the same", 1, range.getUpperBound(), .000000001d);
    }
    
    @Test
    public void getUpperBoundPositiveLowerUpperBound() {
    	
    	Range range = new Range(5, 10);
    	
        assertEquals("This test is for checking the upper bound of the range when the lower and upper bounds are positive but different", 10, range.getUpperBound(), .000000001d);
    }

    @Test
    public void getUpperBoundNegativeLowerUpperBound() {
    	
    	Range range = new Range(-10, -1);
    	
        assertEquals("This test is for checking the upper bound of the range when the lower and upper bounds are negative but different", -1, range.getUpperBound(), .000000001d);
    }
    
    @Test
    public void getUpperBoundNegativeLowerPositiveUpper() {
    	
    	Range range = new Range(-20, 10);
    	
        assertEquals("This test is for checking the upper bound of the range when the lower bound is negative and upper bound is positive", 10, range.getUpperBound(), .000000001d);
    }
    
    @Test
    public void getUpperBoundDecimalRange() {
    	
    	Range range = new Range(-10.32, 10.49);
    	
        assertEquals("This test is for checking the upper bound of the range when the lower and upper bounds are decimals", 10.49, range.getUpperBound(), .000000001d);
    }
    
    @Test
    public void getUpperBoundNullRange() {
    	
		 try {
	            Range range = null;
	            range.getUpperBound();

	        } catch (Exception e) {
	            assertEquals("This test is for checking the upper bound of a null range object", NullPointerException.class,
	                    e.getClass());
	        }
    }
    
    /**
     * Tests for the getCentralValue() method
     */

    @Test
    public void getCentralValueSameLowerUpperBound() {
    	
    	Range range = new Range(1, 1);
    	
        assertEquals("This test is for checking the central value of the range when the lower and upper bounds are the same", 1, range.getCentralValue(), .000000001d);
    }
    
    @Test
    public void getCentralValuePositiveLowerUpperBound() {
    	
    	Range range = new Range(5, 10);
    	
        assertEquals("This test is for checking the central value of the range when the lower and upper bounds are positive but different", 7.5, range.getCentralValue(), .000000001d);
    }

    @Test
    public void getCentralValueNegativeLowerUpperBound() {
    	
    	Range range = new Range(-10, -1);
    	
        assertEquals("This test is for checking the central value of the range when the lower and upper bounds are negative but different", -5.5, range.getCentralValue(), .000000001d);
    }
    
    @Test
    public void getCentralValueNegativeLowerPositiveUpper() {
    	
    	Range range = new Range(-20, 10);
    	
        assertEquals("This test is for checking the central value of the range when the lower bound is negative and upper bound is positive", -5, range.getCentralValue(), .000000001d);
    }
    
    @Test
    public void getCentralValueDecimalRange() {
    	
    	Range range = new Range(-10.32, 10.49);
    	
        assertEquals("This test is for checking the central value of the range when the lower and upper bounds are decimals", 10.40, range.getCentralValue(), .000000001d);
    }
    
    @Test
    public void getCentralValueNullRange() {
    	
		 try {
	            Range range = null;
	            range.getCentralValue();

	        } catch (Exception e) {
	            assertEquals("This test is for checking the central value of a null range object", NullPointerException.class,
	                    e.getClass());
	        }
    }
}
