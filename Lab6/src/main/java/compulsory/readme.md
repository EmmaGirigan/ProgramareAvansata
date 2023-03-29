* am folosit java swing pentru proiect
* am creat un mainframe cu JFrame
* am creat cele 3 paneluri cu JPanel
* configuration panel este pus in zona NORTH a frame-ului si are un spinner cu valori int si un combobox cu probabilitatile 0.25, 0.5, 0.75 si 1.0
* drawing panel este pus in zona CENTER a frame-ului si foloseste metodele drawLines si drawVertices sa creeze nodurile si muchiile dupa valorile introduse
  * nu adauga muchiile random, incepe de la un nod si adauga pana cand ajunge la numarul maxim de noduri dupa probabilitatea data
* control panel este pus in zona SOUTH a frame-ului si are cele 4 butoane
  * load afiseaza pe drawing panel un png din resources
  * save salveaza graful actual ca un png in resources
  * reset goleste drawing panel-ul
  * exit foloseste dispose() pentru a inchide aplicatia
