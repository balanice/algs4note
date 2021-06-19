package com.force;

import com.force.chapter1_3.Parentheses;
import com.force.chapter1_3.Practise_1_3_40;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Chapter1_3Test {

    @Test
    public void test1_3_4() {
        Parentheses parentheses = new Parentheses();
        Assertions.assertTrue(parentheses.check("{[()]}()"));
        Assertions.assertFalse(parentheses.check("{[(])}()"));
    }

    @Test
    public void test_1_3_40() {
        String r = new Practise_1_3_40().handle("abca");
        Assertions.assertEquals("acb", r);
        String r1 = new Practise_1_3_40().handle("abcab");
        Assertions.assertEquals("bac", r1);
    }
}
