set datafile separator tab
set object circle at first 16.0,100.0 radius char 1  fillcolor rgb 'red' fillstyle solid  border lt 2 lw 2 front
set object circle at first 23.0,100.0 radius char 1  fillcolor rgb 'red' fillstyle solid  border lt 2 lw 2 front
set object circle at first 8.5,10.0 radius char 1  fillcolor rgb 'red' fillstyle solid  border lt 2 lw 2 front
set object circle at first 60.0,100.0 radius char 1  fillcolor rgb 'red' fillstyle solid  border lt 2 lw 2 front
plot "c:/Projects/DM/data/weightlifting_130k_processed.txt" using 6:7:9 with points palette pt 3 title "Weightlifting Data"
