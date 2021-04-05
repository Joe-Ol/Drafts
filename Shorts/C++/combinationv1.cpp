#include <iostream>

using namespace std;

int main() {
    int a,b,c,d;
    for (a = 1; a <= 4; a++) {
        for (b = 1; b <= 4; b++) {
            for (c = 1; c <= 4; c++) {
                for (d = 1; d <= 4; d++) {
                    cout << a << b << c << d << "\t";
                }
            }
        }
    }

    return 0;
}
