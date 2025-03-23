the horizontal and vertical lazy grid composables and 
demonstrated how they could be used to organize items 
in rows and columns. A limitation of these layouts is 
that the grid cells are the same size. While this may 
be the desired behavior for many grid implementations, 
it presents a problem if you need to display a grid 
containing items of differing sizes. To address this 
limitation, are introduced staggered lazy grid composables.
Horizontal and vertical staggered grid layouts are created
using the LazyHorizontalStaggeredGrid and
LazyVerticalStaggeredGrid composable. The columns parameter 
controls the grid’s appearance, which can be set to either 
adaptive or fixed mode. In adaptive mode, the grid will 
calculate the number of rows and columns that will fit into 
the available space, with even spacing between items and 
subject to a minimum specified cell size. Fixed mode, 
on the other hand, is passed the number of rows to be 
displayed and sizes each row or column equally to fill 
the available space.
