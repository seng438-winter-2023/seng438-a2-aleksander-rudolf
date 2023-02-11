package org.jfree.data.test;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.junit.*;
import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import org.jfree.data.KeyedValues;
import org.jmock.Expectations;
import org.jmock.Mockery;

import java.lang.Comparable.*;

import org.jfree.data.DataUtilities;
import org.junit.Test;

public class DataUtilitiesTest extends DataUtilities {
	
	/**
	 * Tests for calculateColumnTotalColumn(Values2D data, int column)
	 */

	@Test
	public void calculateColumnTotalColumnLessThanZero() {
		
		Mockery mockingContext = new Mockery();

		final Values2D mockObject = mockingContext.mock(Values2D.class);
		
		mockingContext.checking(new Expectations() {
			
			{
				one(mockObject).getColumnCount();
				will(returnValue(0));


				one(mockObject).getRowCount();
				will(returnValue(0));
			}
			
		});	
		
		int column = -20;
		
		assertEquals("This test is for checking when column is negative", 0, DataUtilities.calculateColumnTotal(mockObject, column),.000000001d); 
	}
	
	@Test
	public void calculateColumnTotalDataIsNull() {
		
		try {
			int column = 20;
			DataUtilities.calculateRowTotal(null, column);

		} catch (Exception e) {
			assertEquals("The exception thrown is InvalidParameterException", InvalidParameterException.class,
					e.getClass());
		}
	}
	
	@Test
	public void calculateColumnTotalDataPositiveValues() {
		
		Mockery mockingContext = new Mockery();

		final Values2D mockObject = mockingContext.mock(Values2D.class);
		
		mockingContext.checking(new Expectations() {
			
			{
				one(mockObject).getRowCount();
				will(returnValue(5));
				
				one(mockObject).getValue(0, 4);				
				will(returnValue(3.45));
				
				one(mockObject).getValue(1, 4);				
				will(returnValue(300000000.55));
				
				one(mockObject).getValue(2, 4);				
				will(returnValue(0.0000001));
				
				one(mockObject).getValue(3, 4);				
				will(returnValue(3.0));
				
				one(mockObject).getValue(4, 4);				
				will(returnValue(2.0001));

			}
			
		});	
		
		int column = 4;
		
		assertEquals("This test is for checking when data has positive values",300000009.00010014 , DataUtilities.calculateColumnTotal(mockObject, column),.000000001d); 
	}
	
	@Test
	public void calculateColumnTotalDataNegativeValues() {
		
		Mockery mockingContext = new Mockery();

		final Values2D mockObject = mockingContext.mock(Values2D.class);
		
		mockingContext.checking(new Expectations() {
			
			{
				one(mockObject).getRowCount();
				will(returnValue(5));
				
				one(mockObject).getValue(0, 4);
				will(returnValue(-3.65));
				
				one(mockObject).getValue(1, 4);
				will(returnValue(-210000000.55));
				
				one(mockObject).getValue(2, 4);
				will(returnValue(-0.0000007));
				
				one(mockObject).getValue(3, 4);
				will(returnValue(-5.0));
				
				one(mockObject).getValue(4, 4);			
				will(returnValue(-9.0201));

			}
			
		});	
		
		int column = 4;
		
		assertEquals("This test is for checking when data has negative values",-210000018.2201007 , DataUtilities.calculateColumnTotal(mockObject, column),.000000001d); 
	}
	
	@Test
	public void calculateColumnTotalDataMixedValues() {
		
		Mockery mockingContext = new Mockery();

		final Values2D mockObject = mockingContext.mock(Values2D.class);
		
		mockingContext.checking(new Expectations() {
			
			{
				one(mockObject).getRowCount();
				will(returnValue(5));
				
				one(mockObject).getValue(0, 4);
				will(returnValue(13.65));
				
				one(mockObject).getValue(1, 4);
				will(returnValue(-250000000.55));
				
				one(mockObject).getValue(2, 4);
				will(returnValue(300000.0000007));
				
				one(mockObject).getValue(3, 4);
				will(returnValue(5.25));
				
				one(mockObject).getValue(4, 4);
				will(returnValue(-9.4201));

			}
			
		});	
		
		int column = 4;
		
		assertEquals("This test is for checking when data has mixed values",-249699991.07009932 , DataUtilities.calculateColumnTotal(mockObject, column),.0000000001d); 
	}

	@Test
	public void calculateColumnTotalColumnGreaterThanActualColumnsInData() {
		
		Mockery mockingContext = new Mockery();

		final Values2D mockObject = mockingContext.mock(Values2D.class);
		
		mockingContext.checking(new Expectations() {
			
			{

				one(mockObject).getRowCount();
				will(returnValue(3));
				
				one(mockObject).getColumnCount();
				will(returnValue(3));
				
				one(mockObject).getValue(0, 3);
				will(returnValue(null));
				
				one(mockObject).getValue(1, 3);
				will(returnValue(null));
				
				one(mockObject).getValue(2, 3);
				will(returnValue(null));

			}
			
		});	
		
		int column = 3;
		
		assertEquals("This test is for checking when Column > data.getColumnCount()", 0 , DataUtilities.calculateColumnTotal(mockObject, column),.0000000001d); 
		
	}
	
	@Test
	public void calculateColumnTotalWhenDataIsInvalidWithNegativeColumns() {
		
		Mockery mockingContext = new Mockery();

		final Values2D mockObject = mockingContext.mock(Values2D.class);
		
		mockingContext.checking(new Expectations() {
			
			{

				one(mockObject).getRowCount();
				will(returnValue(3));
				
				one(mockObject).getColumnCount();
				will(returnValue(3));
				
				one(mockObject).getValue(0, -3);
				will(returnValue(null));
				
				one(mockObject).getValue(1, -3);
				will(returnValue(null));
				
				one(mockObject).getValue(2, -3);
				will(returnValue(null));

			}
			
		});	
		
		int column = -3;
		
		assertEquals("This test is for checking when data is invalid i.e column is negative inside data", 0 , DataUtilities.calculateColumnTotal(mockObject, column),.0000000001d); 
		
	}
	
	@Test
	public void calculateColumnTotalEmptyData() {
		
		Mockery mockingContext = new Mockery();

		final Values2D mockObject = mockingContext.mock(Values2D.class);
		
		mockingContext.checking(new Expectations() {
			
			{
				one(mockObject).getColumnCount();
				will(returnValue(0));


				one(mockObject).getRowCount();
				will(returnValue(0));
			}
			
		});	
		
		int column = 1;
		
		assertEquals("This test is for checking when data is empty", 0, DataUtilities.calculateColumnTotal(mockObject, column),.000000001d); 
	}
	
	/**
	 * Tests for calculateColumnTotalRow(Values2D data, int row)
	 */
	
	@Test
	public void calculateRowTotalRowLessThanZero() {
		
		Mockery mockingContext = new Mockery();
	
		final Values2D mockObject = mockingContext.mock(Values2D.class);
		
		mockingContext.checking(new Expectations() {
			
			{
				one(mockObject).getColumnCount();
				will(returnValue(0));
	
	
				one(mockObject).getRowCount();
				will(returnValue(0));
			}
			
		});	
		
		int row = -10;
		
		assertEquals("This test is for checking when row is negative", 0, DataUtilities.calculateRowTotal(mockObject, row),.000000001d); 
	}
	
	@Test
	public void calculateRowTotalDataIsNull() {
		
		try {
			int row = 20;
			DataUtilities.calculateRowTotal(null, row);
	
		} catch (Exception e) {
			assertEquals("Test to check when data is null", InvalidParameterException.class,
					e.getClass());
		}
	}
	
	@Test
	public void calculateRowTotalDataPositiveValues() {
		
		Mockery mockingContext = new Mockery();
	
		final Values2D mockObject = mockingContext.mock(Values2D.class);
		
		mockingContext.checking(new Expectations() {
			
			{
				one(mockObject).getColumnCount();
				will(returnValue(5));
				
				one(mockObject).getValue(4, 0);				
				will(returnValue(3.45));
				
				one(mockObject).getValue(4, 1);				
				will(returnValue(300000000.55));
				
				one(mockObject).getValue(4, 2);				
				will(returnValue(0.0000001));
				
				one(mockObject).getValue(4, 3);				
				will(returnValue(3.0));
				
				one(mockObject).getValue(4, 4);				
				will(returnValue(2.0001));
				

			}
			
		});	
		
		int row = 4;
		
		assertEquals("This test is for checking when data has positive values",300000009.00010014 , DataUtilities.calculateRowTotal(mockObject, row),.000000001d); 
	}
	
	@Test
	public void calculateRowTotalDataNegativeValues() {
		
		Mockery mockingContext = new Mockery();
	
		final Values2D mockObject = mockingContext.mock(Values2D.class);
		
		mockingContext.checking(new Expectations() {
			
			{
				one(mockObject).getColumnCount();
				will(returnValue(5));
				
				one(mockObject).getValue(4, 0);
				will(returnValue(-3.65));
				
				one(mockObject).getValue(4, 1);
				will(returnValue(-210000000.55));
				
				one(mockObject).getValue(4, 2);
				will(returnValue(-0.0000007));
				
				one(mockObject).getValue(4, 3);
				will(returnValue(-5.0));
				
				one(mockObject).getValue(4, 4);			
				will(returnValue(-9.0201));
	
			}
			
		});	
		
		int row = 4;
		
		assertEquals("This test is for checking when data has negative values",-210000018.2201007 , DataUtilities.calculateRowTotal(mockObject, row),.000000001d); 
	}
	
	@Test
	public void calculateRowTotalDataMixedValues() {
		
		Mockery mockingContext = new Mockery();
	
		final Values2D mockObject = mockingContext.mock(Values2D.class);
		
		mockingContext.checking(new Expectations() {
			
			{
				one(mockObject).getColumnCount();
				will(returnValue(5));
				
				one(mockObject).getValue(4, 0);
				will(returnValue(13.65));
				
				one(mockObject).getValue(4, 1);
				will(returnValue(-250000000.55));
				
				one(mockObject).getValue(4, 2);
				will(returnValue(300000.0000007));
				
				one(mockObject).getValue(4, 3);
				will(returnValue(5.25));
				
				one(mockObject).getValue(4, 4);
				will(returnValue(-9.4201));
	
			}
			
		});	
		
		int row = 4;
		
		assertEquals("This test is for checking when data has mixed values",-249699991.07009932 , DataUtilities.calculateRowTotal(mockObject, row),.0000000001d); 
	}
	
	@Test
	public void calculateRowTotalRowGreaterThanActualRowsInData() {
		
		Mockery mockingContext = new Mockery();
		
		final Values2D mockObject = mockingContext.mock(Values2D.class);
		
		mockingContext.checking(new Expectations() {
		
		{

			one(mockObject).getRowCount();
			will(returnValue(3));
			
			one(mockObject).getColumnCount();
			will(returnValue(3));
			
			one(mockObject).getValue(3, 0);
			will(returnValue(null));
			
			one(mockObject).getValue(3, 1);
			will(returnValue(null));
			
			one(mockObject).getValue(3, 2);
			will(returnValue(null));

		}
		
	   });	
	
	    int row = 3;
		
		assertEquals("This test is for checking when row > data.getRowCount()",0 , DataUtilities.calculateRowTotal(mockObject, row),.0000000001d); 
		
	}
	
	@Test
	public void calculateRowTotalEmptyData() {
		
		Mockery mockingContext = new Mockery();
	
		final Values2D mockObject = mockingContext.mock(Values2D.class);
		
		mockingContext.checking(new Expectations() {
			
			{
				one(mockObject).getColumnCount();
				will(returnValue(0));
	
	
				one(mockObject).getRowCount();
				will(returnValue(0));
			}
			
		});	
		
		int row = 1;
		
		assertEquals("This test is for checking when data is empty", 0, DataUtilities.calculateRowTotal(mockObject, row),.000000001d); 
	}
	
	@Test
	public void calculateRowTotalWhenDataIsInvalidWithNegativeRows() {
		
		Mockery mockingContext = new Mockery();

		final Values2D mockObject = mockingContext.mock(Values2D.class);
		
		mockingContext.checking(new Expectations() {
			
			{

				one(mockObject).getRowCount();
				will(returnValue(3));
				
				one(mockObject).getColumnCount();
				will(returnValue(3));
				
				one(mockObject).getValue(-3, 0);
				will(returnValue(null));
				
				one(mockObject).getValue(-3, 1);
				will(returnValue(null));
				
				one(mockObject).getValue(-3, 2);
				will(returnValue(null));
			}
		});	
		
		int row = -3;
		
		assertEquals("This test is for checking when data is invalid i.e row is negative inside data", 0 , DataUtilities.calculateRowTotal(mockObject, row),.0000000001d); 
	}
	
	/**
	 * Tests for getCumulativePercentages(KeyedValues data)
	 */
	
	@Test
	public void getCumulativePercentagesSmallPositiveValues() {
		
		Mockery mockingContext1 = new Mockery();
		
		final KeyedValues mockObject = mockingContext1.mock(KeyedValues.class);
		
		mockingContext1.checking(new org.jmock.Expectations() {
			{
				allowing(mockObject).getItemCount();
				will(returnValue(4));
				
				allowing(mockObject).getKey(0);
				will(returnValue("Anshdeep"));
				allowing(mockObject).getKey(1);
				will(returnValue("Aleksander"));
				allowing(mockObject).getKey(2);
				will(returnValue("Jannine"));
				allowing(mockObject).getKey(3);
				will(returnValue("Jaskaran"));
				
				
				allowing(mockObject).getIndex("Anshdeep");
				will(returnValue(0));
				allowing(mockObject).getIndex("Aleksander");
				will(returnValue(1));
				allowing(mockObject).getIndex("Jannine");
				will(returnValue(2));
				allowing(mockObject).getIndex("Jaskaran");
				will(returnValue(3));
				
				
				allowing(mockObject).getValue(0);
				will(returnValue(5));
				allowing(mockObject).getValue(1);
				will(returnValue(10));
				allowing(mockObject).getValue(2);
				will(returnValue(15));
				allowing(mockObject).getValue(3);
				will(returnValue(20));
			}
		});
		
		  KeyedValues actualOutput = DataUtilities.getCumulativePercentages(mockObject);
		  
		  assertEquals(0.1,actualOutput.getValue(0).doubleValue(),  0.001d);
		  assertEquals(0.3,actualOutput.getValue(1).doubleValue(),  0.001d);
		  assertEquals(0.6,actualOutput.getValue(2).doubleValue(),  0.001d);
		  assertEquals(1,actualOutput.getValue(3).doubleValue(),  0.001d);
	}
	
	@Test
	public void getCumulativePercentagesSmallNegativeValues() {
		
		Mockery mockingContext1 = new Mockery();
		
		final KeyedValues mockObject = mockingContext1.mock(KeyedValues.class);
		
		mockingContext1.checking(new org.jmock.Expectations() {
			{
				allowing(mockObject).getItemCount();
				will(returnValue(4));
				
				allowing(mockObject).getKey(0);
				will(returnValue("Anshdeep"));
				allowing(mockObject).getKey(1);
				will(returnValue("Aleksander"));
				allowing(mockObject).getKey(2);
				will(returnValue("Jannine"));
				allowing(mockObject).getKey(3);
				will(returnValue("Jaskaran"));
				
				
				allowing(mockObject).getIndex("Anshdeep");
				will(returnValue(0));
				allowing(mockObject).getIndex("Aleksander");
				will(returnValue(1));
				allowing(mockObject).getIndex("Jannine");
				will(returnValue(2));
				allowing(mockObject).getIndex("Jaskaran");
				will(returnValue(3));
				
				
				allowing(mockObject).getValue(0);
				will(returnValue(-5));
				allowing(mockObject).getValue(1);
				will(returnValue(-10));
				allowing(mockObject).getValue(2);
				will(returnValue(-15));
				allowing(mockObject).getValue(3);
				will(returnValue(-20));
			}
		});
		
			  KeyedValues actualOutput = DataUtilities.getCumulativePercentages(mockObject);
			  
			  assertEquals(0.1,actualOutput.getValue(0).doubleValue(), 0.001d);
			  assertEquals(0.3,actualOutput.getValue(1).doubleValue(), 0.001d);
			  assertEquals(0.6,actualOutput.getValue(2).doubleValue(), 0.001d);	  
			  assertEquals(0.1,actualOutput.getValue(3).doubleValue(), 0.001d);
	}	
	
	@Test
	public void getCumulativePercentagesDataIsNull() {
		
		try {
	
			DataUtilities.getCumulativePercentages(null);
	
		} catch (Exception e) {
			assertEquals("The exception thrown should be InvalidParameterException", InvalidParameterException.class,
					e.getClass());
		}
	}
	
	/**
	 * Tests for createNumberArray()
	 */
	
	@Test
	public void createNumberArrayDataIsNull() {
		 try {
	            DataUtilities.createNumberArray(null);
	
	        } catch (Exception e) {
	            assertEquals("Test to check when data is null", InvalidParameterException.class,
	                    e.getClass());
	        }
	}
	
	@Test
	public void createNumberArrayDataIsEmpty() {
		double[] data = {};
		Number[] expectedArray = {};
		
		assertArrayEquals("This test is for checking when the data is not null but empty", expectedArray, DataUtilities.createNumberArray(data));
	}
	
	@Test
	public void createNumberArrayDataOneValue() {
		double[] data = {1};
		Number[] expectedArray = {1};
		
		assertArrayEquals("This test is for checking when the data is not null with one value", expectedArray, DataUtilities.createNumberArray(data));
	}
	
	@Test
	public void createNumberArrayLength() {
		double[] data = {1.0, 2.0, 3.0};
		Number[] expectedArray = {1.0, 2.0, 3.0};
		
		assertEquals("This test is for checking when the data is not null with one value", expectedArray.length, DataUtilities.createNumberArray(data).length);
	}
	
	@Test
	public void createNumberArrayDataPositiveValues() {
		double[] data = {1.5, 2.5, 3.5};
		Number[] expectedArray = {1.5, 2.5, 3.5};
		
		assertArrayEquals("This test is for checking when the data is not null with positive double values", expectedArray, DataUtilities.createNumberArray(data));
	}
	
	@Test
	public void createNumberArrayDataNegativeValues() {
		double[] data = {-1.5, -2.5, -3.5};
		Number[] expectedArray = {-1.5, -2.5, -3.5};
		
		assertArrayEquals("This test is for checking when the data is not null with positive double values", expectedArray, DataUtilities.createNumberArray(data));
	}
	
	@Test
	public void createNumberArrayDataPositiveNegativeValues() {
		double[] data = {-1.5, 2.5, -3.5};
		Number[] expectedArray = {-1.5, 2.5, -3.5};
		
		assertArrayEquals("This test is for checking when the data is not null with positive and negative double values", expectedArray, DataUtilities.createNumberArray(data));
	}
	
	@Test
	public void createNumberArrayDataLargeValues() {
		double[] data = {Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE};
		Number[] expectedArray = {Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE};
		
		assertArrayEquals("This test is for checking when the data is not null with positive large double values", expectedArray, DataUtilities.createNumberArray(data));
	}
	
	@Test
	public void createNumberArrayDataSmallValues() {
		double[] data = {Double.MIN_VALUE, Double.MIN_VALUE, Double.MIN_VALUE};
		Number[] expectedArray = {Double.MIN_VALUE, Double.MIN_VALUE, Double.MIN_VALUE};
		
		assertArrayEquals("This test is for checking when the data is not null with positive small double values", expectedArray, DataUtilities.createNumberArray(data));
	}
	
	@Test
	public void createNumberArrayDataLargeSmallValues() {
		double[] data = {Double.MIN_VALUE, Double.MAX_VALUE, Double.MIN_VALUE};
		Number[] expectedArray = {Double.MIN_VALUE, Double.MAX_VALUE, Double.MIN_VALUE};
		
		assertArrayEquals("This test is for checking when the data is not null with positive large and small double values", expectedArray, DataUtilities.createNumberArray(data));
	}
	
	/**
	 * Tests for the createNumberArray2D(double[][] data) method
	 */
	
	@Test
	public void createNumberArray2DDataIsNull() {
		 try {
	            DataUtilities.createNumberArray2D(null);
	
	        } catch (Exception e) {
	            assertEquals("Test to check when data is null", InvalidParameterException.class,
	                    e.getClass());
	        }
	}
	
	@Test
	public void createNumberArray2DDataIsEmpty() {
		double[][] data = {};
		Number[][] expectedArray = {};
		
		assertArrayEquals("This test is for checking when the data is not null but empty", expectedArray, DataUtilities.createNumberArray2D(data));
	}
	
	@Test
	public void createNumberArray2DDataOneValue() {
		double[][] data = {{1}};
		Number[][] expectedArray = {{1}};
		
		assertArrayEquals("This test is for checking when the data is not null with one value", expectedArray, DataUtilities.createNumberArray2D(data));
	}
	
	@Test
	public void createNumberArray2DLength() {
		double[][] data = {{1.0, 2.0, 3.0}, {1.0, 2.0, 3.0}};
		Number[][] expectedArray = {{1.0, 2.0, 3.0}, {1.0, 2.0, 3.0}};
		
		assertEquals("This test is for checking when the data is not null with one value", expectedArray.length, DataUtilities.createNumberArray2D(data).length);
	}
	
	@Test
	public void createNumberArray2DDataPositiveValues() {
		double[][] data = {{1.5, 2.5, 3.5}, {1.5, 2.5, 3.5}};
		Number[][] expectedArray = {{1.5, 2.5, 3.5}, {1.5, 2.5, 3.5}};
		
		assertArrayEquals("This test is for checking when the data is not null with positive double values", expectedArray, DataUtilities.createNumberArray2D(data));
	}
	
	@Test
	public void createNumberArray2DDataNegativeValues() {
		double[][] data = {{-1.5, -2.5, -3.5}, {-1.5, -2.5, -3.5}};
		Number[][] expectedArray = {{-1.5, -2.5, -3.5}, {-1.5, -2.5, -3.5}};
		
		assertArrayEquals("This test is for checking when the data is not null with positive double values", expectedArray, DataUtilities.createNumberArray2D(data));
	}
	
	@Test
	public void createNumberArray2DDataPositiveNegativeValues() {
		double[][] data = {{-1.5, 2.5, -3.5}, {-1.5, 2.5, -3.5}};
		Number[][] expectedArray = {{-1.5, 2.5, -3.5}, {-1.5, 2.5, -3.5}};
		
		assertArrayEquals("This test is for checking when the data is not null with positive and negative double values", expectedArray, DataUtilities.createNumberArray2D(data));
	}
	
	@Test
	public void createNumberArray2DDataLargeValues() {
		double[][] data = {{Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE}, {Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE}};
		Number[][] expectedArray = {{Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE}, {Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE}};
		
		assertArrayEquals("This test is for checking when the data is not null with positive large double values", expectedArray, DataUtilities.createNumberArray2D(data));
	}
	
	@Test
	public void createNumberArray2DDataSmallValues() {
		double[][] data = {{Double.MIN_VALUE, Double.MIN_VALUE, Double.MIN_VALUE}, {Double.MIN_VALUE, Double.MIN_VALUE, Double.MIN_VALUE}};
		Number[][] expectedArray = {{Double.MIN_VALUE, Double.MIN_VALUE, Double.MIN_VALUE}, {Double.MIN_VALUE, Double.MIN_VALUE, Double.MIN_VALUE}};
		
		assertArrayEquals("This test is for checking when the data is not null with positive small double values", expectedArray, DataUtilities.createNumberArray2D(data));
	}
	
	@Test
	public void createNumberArray2DDataLargeSmallValues() {
		double[][] data = {{Double.MIN_VALUE, Double.MAX_VALUE, Double.MIN_VALUE}, {Double.MIN_VALUE, Double.MAX_VALUE, Double.MIN_VALUE}};
		Number[][] expectedArray = {{Double.MIN_VALUE, Double.MAX_VALUE, Double.MIN_VALUE}, {Double.MIN_VALUE, Double.MAX_VALUE, Double.MIN_VALUE}};
		
		assertArrayEquals("This test is for checking when the data is not null with positive large and small double values", expectedArray, DataUtilities.createNumberArray2D(data));
	}

}
