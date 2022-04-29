package codeforces.contest1672.problemE;

public interface Grader {
    int test(int w);

    int getN();

    void checkAns(int s);
}
