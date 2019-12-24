package com.gl.unittesting.unittesting.business;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.ArrayList;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class ListMockTest {
    List<String>  mockList = mock(List.class);

    @Test
    public void testList_basic(){

        when(mockList.size()).thenReturn(5);
        assertEquals(5,mockList.size(),()->"Size of list vary expected:"+5+" and actual:"+mockList.size());

    }

    @Test
    public void returnWithDifferentValue(){

        when(mockList.size()).thenReturn(5).thenReturn(10);
        assertEquals(5,mockList.size(),()->"Size of list vary expected:"+5+" and actual:"+mockList.size());
        assertEquals(10,mockList.size(),()->"Size of list vary expected:"+10+" and actual:"+mockList.size());
    }

    @Test
    public void returnWithParameters(){
        when(mockList.get(0)).thenReturn("in28minutes").thenReturn("javabrains");
        assertEquals("in28minutes",mockList.get(0),()->"Size of list vary expected:in28minutes and actual:"+mockList.size());
        assertEquals("javabrains",mockList.get(0),()->"Size of list vary expected:javabrains and actual:"+mockList.size());
    }

    @Test
    public void returnWithGenericParameters(){
        when(mockList.get(anyInt())).thenReturn("in28minutes").thenReturn("javabrains");
        assertEquals("in28minutes",mockList.get(10),()->"Size of list vary expected:in28minutes and actual:"+mockList.size());
        assertEquals("javabrains",mockList.get(4),()->"Size of list vary expected:javabrains and actual:"+mockList.size());
    }

    @Test
    public void verificationBasics(){
        //SUT:-System Under Test
        String value1 = mockList.get(0);
        String value2 = mockList.get(1);

        //Verify
        verify(mockList).get(0); //this verify the get() method with 0 argument is called or not
        //verify(mockList).get(anyInt()); //this verify the get() method with any integer argument is called or not
        verify(mockList,times(2)).get(anyInt()); //this verify the get() method with any integer argument with one time is called or not
        verify(mockList,atLeast(1)).get(anyInt()); //this verify the get() method with any integer argument with one time is called or not
        verify(mockList,atLeastOnce()).get(anyInt()); //this verify the get() method with any integer argument with at least once is called or not similer to atMost or atMostOnce
        verify(mockList,never()).get(2); //this verify the get() method with argument 2 with is never called or called
    }

    @Test
    public void argumentCapturing(){
        //SUT:-System Under Test
        mockList.add("Some String");

        //Verification
        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);

        verify(mockList).add(argumentCaptor.capture());

        assertEquals("Some String",argumentCaptor.getValue());
    }

    @Test
    public void multipleArgumentCapturing(){
        //SUT:-System Under Test
        mockList.add("Some String1");
        mockList.add("Some String2");
        mockList.add("Some String3");

        //Verification
        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);

        verify(mockList,times(3)).add(argumentCaptor.capture());

        List<String> allValues = argumentCaptor.getAllValues();
        assertEquals("Some String1",allValues.get(0));
        assertEquals("Some String2",allValues.get(1));
        assertEquals("Some String3",allValues.get(2));
    }

    @Test
    public void mocking(){
        ArrayList arrayListMock = mock(ArrayList.class);
        System.out.println(arrayListMock.get(0));   //null
        System.out.println(arrayListMock.size());   //0
        arrayListMock.add("Test");
        arrayListMock.add("Test");
        System.out.println(arrayListMock.size());//0 Note:- A Mock does not retain behaviour(code) of the original class

        when(arrayListMock.size()).thenReturn(5);
        System.out.println(arrayListMock.size());
    }

    @Test
    public void spying(){
        ArrayList arrayListSpy = spy(ArrayList.class);
        arrayListSpy.add("Test-0");
        System.out.println(arrayListSpy.get(0));   //IndexOutOfBoundException if not added element before calling this method
        System.out.println(arrayListSpy.size());   //1
        arrayListSpy.add("Test-1");
        arrayListSpy.add("Test-2");
        System.out.println(arrayListSpy.size());//3 Note:- A spy by default retain behaviour(code) of the original class
        //By using spy() method we can stub(override) and verify specific behaviour(methods)on a spy
        when(arrayListSpy.size()).thenReturn(5);
        System.out.println(arrayListSpy.size());//5
        arrayListSpy.add("Test-2");
        System.out.println(arrayListSpy.size());//5


        verify(arrayListSpy).add("test-4");
    }
}
