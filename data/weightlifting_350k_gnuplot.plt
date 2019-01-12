set datafile separator tab
set object circle at first 0.0010824673594457767,119.70605238032421 radius char 1  fillcolor rgb 'red' fillstyle solid  border lt 2 lw 2 front
set object circle at first 0.7421092621194758,66.66334088983834 radius char 1  fillcolor rgb 'red' fillstyle solid  border lt 2 lw 2 front
set object circle at first 24.75524904562807,122.96947850390913 radius char 1  fillcolor rgb 'red' fillstyle solid  border lt 2 lw 2 front
set object circle at first 47.44774911482043,127.09615655032724 radius char 1  fillcolor rgb 'red' fillstyle solid  border lt 2 lw 2 front
set object circle at first 0.10730104049493813,183.6674917393147 radius char 1  fillcolor rgb 'red' fillstyle solid  border lt 2 lw 2 front
plot "c:/Projects/DM/data/weightlifting_350k_processed.txt" using 6:7:9 with points palette pt 3 title "Weightlifting Data"
