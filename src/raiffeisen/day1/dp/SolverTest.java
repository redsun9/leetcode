package raiffeisen.day1.dp;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolverTest {

    @Test
    void test1() {
        // когда дистанция обоих игроков от финишкрой клетки меньше или равна 6.
        // вероятность победы начинающего игрока - 6/11
        HashMap<Integer, Double> map = new HashMap<>();
        for (int i = 1; i <= 6; i++) {
            map.put(i, 1.0 / 6);
        }
        Solver solver = new Solver(x -> map);

        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= 6; j++) {
                System.out.println(i + " " + j);
                assertEquals(6.0 / 11, solver.probability(i, j), 1e-6);
            }
        }
    }

    @Test
    void test2() {
        // проверяем результаты детерминированнаого солвера с результатами, полученными
        // методом Монте-Карло.
        HashMap<Integer, Double> map = new HashMap<>();
        double p = (1 - 0.33d) / 5;
        for (int i = 1; i <= 6; i++) {
            map.put(i, p);
        }
        map.put(4, 0.33);
        Solver solver = new Solver(x -> map);

        assertEquals(0.446344172d, solver.probability(12, 8), 1e-4);
        assertEquals(0.619721604d, solver.probability(8, 12), 1e-4);
        assertEquals(0.495882453, solver.probability(22, 20), 1e-4);
    }
}