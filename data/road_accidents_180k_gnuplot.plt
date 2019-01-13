set datafile separator tab
set object circle at first 22.125324450596988,1341.1828603564961,8.552734037030628 radius char 1  fillcolor rgb 'red' fillstyle solid  border lt 2 lw 2 front
set object circle at first 42.03168548469128,2177.577484487963,7.734436985047299 radius char 1  fillcolor rgb 'red' fillstyle solid  border lt 2 lw 2 front
set object circle at first 70.77260126978449,1852.5930877224312,8.150853974783153 radius char 1  fillcolor rgb 'red' fillstyle solid  border lt 2 lw 2 front
set object circle at first 53.33557604452197,2376.313896503161,7.700445773458482 radius char 1  fillcolor rgb 'red' fillstyle solid  border lt 2 lw 2 front
set object circle at first 31.589313325390993,1905.663126410057,7.89706217839852 radius char 1  fillcolor rgb 'red' fillstyle solid  border lt 2 lw 2 front
splot "d:/Work/Java/DM/data/road_accidents_180k_processed.txt" using 4:5:6:7 with points palette pt 3 title "Road Accidents Data"
add point 22.125324450596988,6.014272916396844,8.552734037030628add point 42.03168548469128,9.764921455102973,7.734436985047299add point 70.77260126978449,8.307592321625252,8.150853974783153add point 53.33557604452197,10.656116127816864,7.700445773458482add point 31.589313325390993,8.545574557892632,7.89706217839852