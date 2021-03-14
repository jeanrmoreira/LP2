#include <stdio.h>

typedef struct {
  int x, y;
  int v;
  float ri;
  int d;
} Esp;

void print (Esp* e) {
  printf("Espiral de (%d) voltas na posicao (%d,%d) com raio interno igual a (%.2f) e divergencia (%d).\n",
    e->v, e->x,e->y, e->ri,e->d);
}

void main (void) {
    Esp e1 = { 20, 20, 30, 0.3, 10};
    print(&e1);
}
