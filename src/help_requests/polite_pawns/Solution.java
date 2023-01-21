package help_requests.polite_pawns;

// на доске 1*N расположились пешки двух цветов (белые и черные).
// белые пешки идут вправо, черные идут влево. все пешки делают ход (если могут) ОДНОВРЕМЕННО.
// каждый ход каждая белая пешка ХОЧЕТ на следующем ходу пойти на одну клетку вправо, а черная - на одну клетку влево, но только если это не выходит за край доски.
// если пешка видит, что поле, на которое она ХОЧЕТ пойти, будет занято на следующем ходу другой фигурой, то эта пешка пропускает этот ход.
// так же пешки очень вежливые: если две пешки разных цветов видят, что они обе хотят пойти на одну и ту же клетку на следующем ходу, то они обе пропускают ход
// две пещки разных цветов могут проходить через друг друга, ели они обе двигаются в этот ход.

// дано поле в виде массива чисел длинной N.
// 0 - свободная клетка, 1 - белая, 2 - черная.

// "12" -> "21" пешки поменялись местами
// "102" -> "102" пешки вежливые и обе пропускают ход
// "110022" -> "011220" все пешки сделали ход
// "1010202" -> "0110220". Центральные пешки стоят на месте, а боковые спокойно сделали свои ход.
// "11102" -> "11102". Самая правая белая пешка уступает черной, из-за чего не двигается. А все остальные белые пешки из-за этого тоже не могут двинуться.
// "112" -> "112"
@SuppressWarnings("DuplicatedCode")
public class Solution {
    // we use extra memory
    public static int[] solveWithExtraMemory(int[] a) {
        int n = a.length;
        boolean[] pass = new boolean[n];

        //process white pawns
        for (int i = n - 1; i >= 0; i--) {
            if (a[i] != 1) continue;
            pass[i] = i + 1 == n || pass[i + 1] || i + 2 < n && a[i + 2] == 2 || i != 0 && a[i - 1] == 1 && a[i + 1] == 2;
        }
        //process black pawns
        for (int i = 0; i < n; i++) {
            if (a[i] != 2) continue;
            pass[i] = i == 0 || pass[i - 1] || i - 2 >= 0 && a[i - 2] == 1 || i + 1 != n && a[i - 1] == 1 && a[i + 1] == 2;
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            if (a[i] == 1) {
                if (pass[i]) ans[i] = 1;
                else ans[i + 1] = 1;
            } else if (a[i] == 2) {
                if (pass[i]) ans[i] = 2;
                else ans[i - 1] = 2;
            }
        }
        return ans;
    }

    public static int[] solveInPlace(int[] a) {
        int n = a.length;

        //change sign to opposite if will stay
        //process white pawns
        for (int i = n - 1; i >= 0; i--) {
            if (a[i] != 1) continue;
            if (i + 1 == n || a[i + 1] < 0 || i + 2 < n && a[i + 2] == 2 || i != 0 && a[i - 1] == 1 && a[i + 1] == 2)
                a[i] = -1;
        }
        //process black pawns
        for (int i = 0; i < n; i++) {
            if (a[i] != 2) continue;
            if (i == 0 || a[i - 1] < 0 || i - 2 >= 0 && a[i - 2] == -1 || i + 1 != n && a[i - 1] == -1 && a[i + 1] == 2)
                a[i] = -2;
        }

        for (int i = 1; i < n; i++) {
            if (a[i] == 2) {
                swap(a, i, i - 1);
                if (a[i] == 1) a[i] = -1; // because we can swap 1
            }
        }

        for (int i = n - 1; i >= 0; i--) if (a[i] == 1) swap(a, i, i + 1);

        for (int i = 0; i < n; i++) if (a[i] < 0) a[i] = -a[i];
        return a;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
