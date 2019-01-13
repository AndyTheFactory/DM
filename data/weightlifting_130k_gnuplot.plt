set datafile separator tab
set object circle at first 26.98467131947236,180.57885774838226 radius char 1  fillcolor rgb 'red' fillstyle solid  border lt 2 lw 2 front
set object circle at first 24.565436639772187,64.16958442097818 radius char 1  fillcolor rgb 'red' fillstyle solid  border lt 2 lw 2 front
set object circle at first 53.48646934460888,90.7608948202959 radius char 1  fillcolor rgb 'red' fillstyle solid  border lt 2 lw 2 front
set object circle at first 22.286478417713646,121.91422751585938 radius char 1  fillcolor rgb 'red' fillstyle solid  border lt 2 lw 2 front
set object circle at first 41.91938350599228,172.0288944749126 radius char 1  fillcolor rgb 'red' fillstyle solid  border lt 2 lw 2 front
plot "d:/Work/Java/DM/data/weightlifting_130k_processed.txt" using 6:7:9 with points palette pt 3 title "Weightlifting Data"
