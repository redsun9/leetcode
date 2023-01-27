package help_requests.trading_stats;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@SuppressWarnings("DuplicatedCode")
class TradingTest {

    @Test
    void test1() {
        Trading trading = new Trading();
        trading.add(new Listing("AAPL", 300));
        trading.add(new Listing("AAPL", 300));
        trading.add(new Listing("MSFT", 200));
        trading.add(new Listing("META", 100));
        Listing[] expected = {
                new Listing("AAPL", 600),
                new Listing("MSFT", 200),
        };
        assertArrayEquals(expected, trading.getTop(2));
    }

    @Test
    void test2() {
        Trading2 trading2 = new Trading2();
        trading2.add(new Listing("AAPL", 300));
        trading2.add(new Listing("AAPL", 300));
        trading2.add(new Listing("MSFT", 200));
        trading2.add(new Listing("META", 100));
        Listing[] expected = new Listing[]{
                new Listing("AAPL", 600),
                new Listing("MSFT", 200),
        };
        assertArrayEquals(expected, trading2.getTop(2));
    }

    @Test
    void test3() {
        Trading3 trading3 = new Trading3(5);
        trading3.add(new Listing("AAPL", 300));
        trading3.add(new Listing("AAPL", 300));
        trading3.add(new Listing("MSFT", 200));
        trading3.add(new Listing("META", 100));
        Listing[] expected = new Listing[]{
                new Listing("AAPL", 600),
                new Listing("MSFT", 200),
        };
        assertArrayEquals(expected, trading3.getTop(2));
    }

    @Test
    void testRandom12() {
        Trading trading = new Trading();
        Trading2 trading2 = new Trading2();
        Random random = new Random(0L);
        for (int i = 0; i < 1000; i++) {
            Listing listing = new Listing("name" + random.nextInt(20), 1 + random.nextInt(1000));
            trading.add(listing);
            trading2.add(listing);
        }
        Listing[] top = trading.getTop(10);
        Listing[] top2 = trading2.getTop(10);
        assertArrayEquals(top, top2);
    }

    @Test
    void testRandom13() {
        Trading trading = new Trading();
        Trading3 trading3 = new Trading3(3);
        Random random = new Random(0L);
        for (int i = 0; i < 1000; i++) {
            Listing listing = new Listing("name" + random.nextInt(20), 1 + random.nextInt(1000));
            trading.add(listing);
            trading3.add(listing);
        }
        for (int k = 1; k <= 3; k++) {
            Listing[] top = trading.getTop(k);
            Listing[] top2 = trading3.getTop(k);
            assertArrayEquals(top, top2);
        }
    }
}