* nu reusesc sa dau run aplicatiei din terminal :<
* am folosit o metoda createMatrix pentru a creea matricea tip Latin Square, are complexitate n^2
  * se foloseste de faptul ca fiecare linie incepe cu elementul n-linie+1 (numit pivot in functia mea)
  * adauga elementele pe linie incepand de la pivot, incrementeaza pivotul si adauga pana pivot ajunge la valoarea n, dupa care pivot devine 1 si se completeaza linia cu elementele de la 1 la pivotul initial
* metoda displayMatrix creeaza cate un string pentru fiecare linie/coloana cu elementele de pe linia/coloana respectiva si le afiseaza
* daca n este mai mare de 20000, se afiseaza doar runtime in nanosecunde
