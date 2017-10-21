package ru.job4j.VendingMashine;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ChargeMetodTest {
    @Test
    public void charge() throws Exception {
        ChargeMetod chargeMetod = new ChargeMetod();
        int[] result = chargeMetod.charge(10, 78);
        // сдача 68.
        // т.к. десяток в наличии всего 5, добавляем пятерками, остальное есть.
        int[] expected = new int[]{5, 3, 1, 1};

        assertThat(result, is(expected));
    }

}