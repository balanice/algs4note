package com.force;

import com.force.chapter1_3.Parentheses;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Chapter1_3Test {

    @Test
    public void test1_3_4() {
        Parentheses parentheses = new Parentheses();
        Assertions.assertTrue(parentheses.check("{[()]}()"));
        Assertions.assertFalse(parentheses.check("{[(])}()"));
    }
}
