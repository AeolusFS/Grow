package com.grow.cmputf17team4.grow.Models;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;
/**
 * Created by Infrared on 2017-11-13.
 */

public class HabitTypeUnitTest {
    private HabitType habitType;

    @Test
    public void testCreateHabitType(){
        habitType = new HabitType();
        assertNotNull(habitType);
    }

    @Test
    public void testSetAndGetName(){
        String name = "Fufu";
        habitType = new HabitType();
        habitType.setName(name);
        assertEquals(habitType.getName(),name);
    }
    @Test
    public void testSetAndGetReason(){
        String reason = "cool";
        habitType = new HabitType();
        habitType.setReason(reason);
        assertEquals(habitType.getReason(),reason);

    }
    @Test
    public void testSetAndGetDate(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE,1);
        Date startDate = calendar.getTime();
        habitType = new HabitType();
        habitType.setStartDate(startDate);
        assertEquals(habitType.getStartDate(),startDate);

    }
    @Test
    public void testSetAndGetRepeat(){
        habitType = new HabitType();
        boolean repeat = true;
        int i = 1;
        habitType.setRepeat(i,repeat);
        assertEquals(habitType.getRepeat(i),repeat);

    }

    @Test
    public void testGenerateUid(){
        habitType = new HabitType();
        HabitType habitType2 = new HabitType();
        assertNotEquals(habitType.getUid(),habitType2.getUid());
    }
    @Test
    public void testBuildEvent(){
        habitType = new HabitType();
        String name = "fufu";
        habitType.setName(name);
        assertNotEquals(habitType.buildEvent(),name);
    }
    @Test
    public void testHasEventToday(){
        habitType = new HabitType();
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK)-1;
        boolean repeat = true;
        habitType.setRepeat(day,repeat);
        assertEquals(habitType.hasEventToday(),true);

    }

    @Test
    public void testGetNextEventDay(){
        habitType = new HabitType();
        habitType.setName("Name");
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK)-1;
        calendar.add(Calendar.DATE,1);
        Date startDate = calendar.getTime();
        boolean repeat = true;
        habitType.setStartDate(startDate);
        habitType.setRepeat(day,repeat);
        calendar.add(Calendar.DATE,6);
        Date nextDate = calendar.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        assertEquals(format.format(habitType.getNextEventDay()),format.format(nextDate));

    }
    @Test
    public void testGetRecord(){
        habitType = new HabitType();
        String name = "fufu";
        habitType.setName(name);
        assertNotNull(habitType.getRecord());
    }
    @Test
    public void testCompareTo(){
        habitType = new HabitType();
        HabitType habitType2 = new HabitType();
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK)-1;
        boolean repeat = true;
        habitType.setRepeat(day,repeat);
        habitType2.setRepeat((day+1)%7,repeat);
        assert(habitType.compareTo(habitType2)<0);
    }
    @Test
    public void testAlreadyDone(){
        habitType = new HabitType();
        assertEquals(habitType.alreadyDone(),false);
    }

    @Test
    public void testGetUid(){
        habitType = new HabitType();
        assertNotNull(habitType.getUid());
    }
    @Test
    public void testGetIndex(){
        habitType = new HabitType();
        assertEquals(habitType.getType(),"habitType");
    }



}