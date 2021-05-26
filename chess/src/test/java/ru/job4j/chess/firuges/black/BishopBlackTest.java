package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BishopBlackTest {

    @Test
    public void position() {
        Figure bishopBlack = new BishopBlack(Cell.C8);
        assertThat(bishopBlack.position(), is(Cell.C8));
    }

    @Test
    public void copy() {
        Figure bishopBlack = new BishopBlack(Cell.C8);
        bishopBlack = bishopBlack.copy(Cell.G4);
        assertThat(bishopBlack.position(), is(Cell.G4));
    }

    @Test
    public void way() {
        Figure bishopBlack = new BishopBlack(Cell.C1);
        Cell[] way = bishopBlack.way(Cell.G5);
        Cell[] expected = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(way, is(expected));
    }

    @Test(expected = ImpossibleMoveException.class)
    public void wrongWay() {
        Figure bishopBlack = new BishopBlack(Cell.C1);
        Cell[] way = bishopBlack.way(Cell.D6);
    }
}