set datafile separator tab
set object circle at first 88.49895049851321,1018.8165121567256,285.56398022994847 radius char 1  fillcolor rgb 'red' fillstyle solid  border lt 2 lw 2 front
set object circle at first 63.82437822618489,1020.6424213984045,286.1623253931526 radius char 1  fillcolor rgb 'red' fillstyle solid  border lt 2 lw 2 front
set object circle at first 78.36939820742637,1014.1566367904396,292.09357287806944 radius char 1  fillcolor rgb 'red' fillstyle solid  border lt 2 lw 2 front
set object circle at first 32.20143415906128,1019.0867014341591,293.86685759695774 radius char 1  fillcolor rgb 'red' fillstyle solid  border lt 2 lw 2 front
set object circle at first 58.922506095621756,1015.4959185836956,295.2846380427457 radius char 1  fillcolor rgb 'red' fillstyle solid  border lt 2 lw 2 front
splot "c:/Projects/DM/data/weather_data_sandiego_processed.txt" using 3:4:5 with points palette pt 3 title "Weather Data"
add point 88.49895049851321,1018.8165121567256,571.1279604598969add point 63.82437822618489,1020.6424213984045,572.3246507863053add point 78.36939820742637,1014.1566367904396,584.1871457561389add point 32.20143415906128,1019.0867014341591,587.7337151939155add point 58.922506095621756,1015.4959185836956,590.5692760854914