set datafile separator tab
set object circle at first 21.640065823108383,68.66261407208613 radius char 1  fillcolor rgb 'red' fillstyle solid  border lt 2 lw 2 front
set object circle at first 55.41373650828975,125.99736786469276 radius char 1  fillcolor rgb 'red' fillstyle solid  border lt 2 lw 2 front
set object circle at first 38.58065369155913,80.30172836894452 radius char 1  fillcolor rgb 'red' fillstyle solid  border lt 2 lw 2 front
set object circle at first 32.575197548186985,193.9539557639738 radius char 1  fillcolor rgb 'red' fillstyle solid  border lt 2 lw 2 front
set object circle at first 22.843783311012107,135.17647470412982 radius char 1  fillcolor rgb 'red' fillstyle solid  border lt 2 lw 2 front
plot "c:/Projects/DM/data/weightlifting_130k_processed.txt" using 6:7:9 with points palette pt 3 title "Weightlifting Data"
