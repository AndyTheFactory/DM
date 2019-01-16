set datafile separator tab
set object circle at first 21.554721920694718,68.92905816997663 radius char 1  fillcolor rgb 'red' fillstyle solid  border lt 2 lw 2 front
set object circle at first 55.681299311734094,120.11979128196431 radius char 1  fillcolor rgb 'red' fillstyle solid  border lt 2 lw 2 front
set object circle at first 37.70922370186848,83.4097269536492 radius char 1  fillcolor rgb 'red' fillstyle solid  border lt 2 lw 2 front
set object circle at first 22.792598733385883,136.88950178032653 radius char 1  fillcolor rgb 'red' fillstyle solid  border lt 2 lw 2 front
set object circle at first 33.27288685869606,195.26260674241877 radius char 1  fillcolor rgb 'red' fillstyle solid  border lt 2 lw 2 front
plot "c:/Projects/DM/data/weightlifting_130k_processed.txt" using 6:7:9 with points palette pt 3 title "Weightlifting Data"
