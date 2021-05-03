#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int r,g,b;
} Color;

struct Figure;
typedef void (* Figure_Print) (struct Figure*);

typedef struct Figure {
    int x, y;
    Color fg, bg;
    void (* print) (struct Figure*);
} Figure;

///////////////////////////////////////////////////////////////////////////////

typedef struct {
    Figure super;
    int w, h;
} Rect;

void rect_print (Rect* this) {
    Figure* sup = (Figure*) this;
    printf("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
           this->w, this->h, sup->x, sup->y);
}

Rect* rect_new (int x, int y, int w, int h) {
    Rect*   this  = malloc(sizeof(Rect));
    Figure* sup = (Figure*) this;
    sup->print = (Figure_Print) rect_print;
    sup->x = x;
    sup->y = y;
    this->w = w;
    this->h = h;
}

///////////////////////////////////////////////////////////////////////////////

typedef struct {
    Figure super;
    int w, h;
} Ellipse;

void Ellipse_print (Ellipse* this) {
    Figure* sup = (Figure*) this;
    printf("Elipse de tamanho (%d,%d) na posicao (%d,%d).\n",
           this->w, this->h, sup->x, sup->y);
}

Ellipse* ellipse_new (int x, int y, int w, int h) {
    Ellipse* this = malloc(sizeof(Ellipse));
    Figure* sup = (Figure*) this;
    sup->print = (Figure_Print) Ellipse_print;
    sup->x = x;
    sup->y = y;
    this->w = w;
    this->h = h;
}

///////////////////////////////////////////////////////////////////////////////


typedef struct {
    Figure super;
    int w, h;
    int anguloInicial, anguloArc;
} Arc;


void arc_print (Arc* this) {
    Figure* sup = (Figure*) this;
    printf("Arco de tamanho (%d,%d) na posicao (%d,%d).\n",
           this->w, this->h, sup->x, sup->y);
}

Arc* arc_new (int x, int y, int w, int h, int anguloInicial, int anguloArc) {
    Arc* this = malloc(sizeof(Arc));
    Figure* sup = (Figure*) this;
    sup->print = (Figure_Print) arc_print;
    sup->x = x;
    sup->y = y;
    this->w = w;
    this->h = h;
    this->anguloInicial = anguloInicial;
    this->anguloArc = anguloArc;
    
}


///////////////////////////////////////////////////////////////////////////////


typedef struct {
    Figure super;
    int w, h;
    int xpoints[3];
    int ypoints[3];
} Trian;

void trian_print (Trian* this) {
    Figure* sup = (Figure*) this;
    printf("Triângulo de tamanho (%d,%d) na posicao (%d,%d).\n",
           this->w, this->h, sup->x, sup->y);
}


Trian* trian_new (int x, int y, int w, int h) {
    Trian* this = malloc(sizeof(Trian));
    Figure* sup = (Figure*) this;
    sup->print = (Figure_Print) trian_print;
    sup->x = x;
    sup->y = y;
    this->w = w;
    this->h = h;
    this->xpoints[0] = x;
    this->xpoints[1] = w/2+x;
    this->xpoints[2] = w+x;
    this->ypoints[0] = y+h;
    this->ypoints[1] = y;
    this->ypoints[2] = y+h;
        
}



///////////////////////////////////////////////////////////////////////////////
void main (void) {
    Figure* figs[6] = {
        (Figure*) rect_new(10,10,100,100),
        (Figure*) ellipse_new(40,10,140,300),
        (Figure*) rect_new(10,10,100,100),
        (Figure*) ellipse_new(210,110,305,130),
        (Figure*) arc_new(200,100,40,30,140,120),
        (Figure*) trian_new(60,100,45,50)
    };

    ///

    for (int i=0; i<6; i++) {
        figs[i]->print(figs[i]);
    }

    ///

    for (int i=0; i<6; i++) {
        free(figs[i]);
    }
}
