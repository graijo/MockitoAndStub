import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * unit testing-feature span over different class or methods.Testing class or method for its functionality is called unit testing
 * To isolate probelms faster
 * when we write busniess login in method(or unit)
 * unit can be a method,a class ,set of class or methods
 */
public class listMockTest {
/**
    There are few recommendations regarding test naming:

Test name should express a specific requirement
Test name could include the expected input or state and the expected result for that input or state
Test name should be presented as a statement or fact of life that expresses workflows and outputs
Test name could include the name of the tested method or class
MethodName_StateUnderTest_ExpectedBehavior
example: isAdult_AgeLessThan18_False

MethodName_ExpectedBehavior_StateUnderTest
cons: should be renamed if method change name
example: isAdult_False_AgeLessThan18

testFeatureBeingTested
cons: “test” prefix is redundant
example: testIsNotAnAdultIfAgeLessThan18



Should_ExpectedBehavior_When_StateUnderTest
cons: duplicates `should` and `when`, long name
example: Should_ThrowException_When_AgeLessThan18

When_StateUnderTest_Expect_ExpectedBehavior
cons: duplicates `when` and `expect`
example: When_AgeLessThan18_Expect_isAdultAsFalse

Given_Preconditions_When_StateUnderTest_Then_ExpectedBehavior — Behavior-Driven Development (BDD)
cons: duplicates `given`, `when`, `then`; really long names
example: Given_UserIsAuthenticated_When_InvalidAccountNumberIsUsedToWithdrawMoney_Then_TransactionsWillFail
    */


    /**
     * Tag	Syntax	Description
     * {@docRoot}        {@docRoot}	to depict relative path to root directory of generated document from any page.
     * @author	@author name - text	To add the author of the class.
     * @code	{@code text}	To show the text in code font without interpreting it as html markup or nested javadoc tag.
     * @version	@version version-text	To specify "Version" subheading and version-text when -version option is used.
     * @since	@since release	To add "Since" heading with since text to generated documentation.
     * @param	@param parameter-name description	To add a parameter with given name and description to 'Parameters' section.
     * @return	@return description	Required for every method that returns something (except void)
     */
    @Test
    public void listSize_success(){
        List mockList=mock(List.class);
        when(mockList.size()).thenReturn(2);
        Assert.assertEquals(2,mockList.size());
    }
    @Test
    public void should_Success_When_listSize_triedWithDifferentSize(){
        List mockList=mock(List.class);
        when(mockList.size()).thenReturn(2).thenReturn(3);
        Assert.assertEquals(2,mockList.size());
        Assert.assertEquals(3,mockList.size());
    }
    @Test
    public void should_Success_When_listSize_triedWithEmpty(){
        List mockList=mock(List.class);
        Assert.assertEquals(0,mockList.size());
    }
    /*
    When expectation not set and mock method called ,Then Mockito will return default values like null,empty list etc
     */
    @Test
    public void should_SuccessAndReturnValue_When_Getlist_withPosition(){
        List mockList=mock(List.class);
        when(mockList.get(2)).thenReturn("test data set 1");
        Assert.assertEquals("test data set 1",mockList.get(2));
        Assert.assertEquals(null,mockList.get(0));
    }
    @Test
    public void should_SuccessAndReturnValue_When_Getlist_withArgumentMatcher(){
        List mockList=mock(List.class);
        /*
        Argument matcher
         */

        when(mockList.get(anyInt())).thenReturn("test data set 1");
        Assert.assertEquals("test data set 1",mockList.get(2));
        Assert.assertEquals("test data set 1",mockList.get(345));
    }

    /**
     * Runtime - runtime exceptions are internal to your application but are not typically recoverable.
     * For example, an object that is expected to have a value but is actually null. In this case,
     * a NullPointerException exception would be thrown.
     */
    @Test(expected = RuntimeException.class)
    public void should_ThrowRunTimeErr_When_Getlist_withArgumentMatcher(){
        List mockList=mock(List.class);
        /*
        Argument matcher
         */
        when(mockList.get(anyInt())).thenThrow(new RuntimeException("Invalid Int"));
        mockList.get(999);
    }
}
