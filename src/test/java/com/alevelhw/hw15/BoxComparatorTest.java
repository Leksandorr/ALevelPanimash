package com.alevelhw.hw15;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class BoxComparatorTest {
    BoxComparator comp;
    Box o1;
    Box o2;

    @Before
    public void setUp() {
        comp = new BoxComparator();
        o1 = Mockito.mock(Box.class);
        o2 = Mockito.mock(Box.class);
    }

    @Test
    public void compare_whenVolumeBox1Zero() {
        Mockito.when(o1.getVolume()).thenReturn(0.0);
        Mockito.when(o2.getVolume()).thenReturn(-1.0);

        assertEquals(-1, comp.compare(o1, o2));
    }

    @Test
    public void compare_whenVolumeBox2Zero() {
        Mockito.when(o1.getVolume()).thenReturn(1.0);
        Mockito.when(o2.getVolume()).thenReturn(0.0);

        assertEquals(1, comp.compare(o1, o2));
    }

    @Test
    public void compare_whenVolumeBox1MoreThanVolumeBox2() {
        Mockito.when(o1.getVolume()).thenReturn(2.0);
        Mockito.when(o2.getVolume()).thenReturn(1.0);

        assertEquals(-1, comp.compare(o1, o2));
    }

    @Test
    public void compare_whenVolumeBox1LessThanVolumeBox2() {
        Mockito.when(o1.getVolume()).thenReturn(1.0);
        Mockito.when(o2.getVolume()).thenReturn(2.0);

        assertEquals(1, comp.compare(o1, o2));
    }
}