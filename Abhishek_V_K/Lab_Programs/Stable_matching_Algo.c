#include <stdio.h>
#include <stdbool.h>
#include <string.h>

#define N 3

int menPreferences[N][N] = {
    {0, 1, 2}, // Man 0's preferences
    {1, 2, 0}, // Man 1's preferences
    {2, 0, 1}  // Man 2's preferences
};

int womenPreferences[N][N] = {
    {0, 1, 2}, // Woman 0's preferences
    {1, 0, 2}, // Woman 1's preferences
    {2, 1, 0}  // Woman 2's preferences
};

int currentPartner[N];
bool freeMen[N];

bool prefers(int woman, int man1, int man2) {
    for (int i = 0; i < N; i++) {
        if (womenPreferences[woman][i] == man1) return true;
        if (womenPreferences[woman][i] == man2) return false;
    }
    return false;
}

void stableMarriage() {
    memset(currentPartner, -1, sizeof(currentPartner));
    memset(freeMen, true, sizeof(freeMen));
    int freeCount = N;

    while (freeCount > 0) {
        int man;
        for (man = 0; man < N; man++) if (freeMen[man]) break;

        for (int i = 0; i < N && freeMen[man]; i++) {
            int woman = menPreferences[man][i];
            if (currentPartner[woman] == -1) {
                currentPartner[woman] = man;
                freeMen[man] = false;
                freeCount--;
            } else {
                int otherMan = currentPartner[woman];
                if (prefers(woman, man, otherMan)) {
                    currentPartner[woman] = man;
                    freeMen[man] = false;
                    freeMen[otherMan] = true;
                }
            }
        }
    }
}

int main() {
    stableMarriage();
    printf("Woman - Man\n");
    for (int i = 0; i < N; i++) {
        printf("%d       %d\n", i, currentPartner[i]);
    }
    return 0;
}
