set datafile separator tab
set object circle at first 30.21343649745235,294.65269752072743 radius char 1  fillcolor rgb 'red' fillstyle solid  border lt 2 lw 2 front
set object circle at first 77.23897124486516,291.1322838801658 radius char 1  fillcolor rgb 'red' fillstyle solid  border lt 2 lw 2 front
set object circle at first 60.04268907563025,296.24433946158075 radius char 1  fillcolor rgb 'red' fillstyle solid  border lt 2 lw 2 front
set object circle at first 89.20826098875993,285.6606918382605 radius char 1  fillcolor rgb 'red' fillstyle solid  border lt 2 lw 2 front
set object circle at first 59.37520506210452,285.8032066970662 radius char 1  fillcolor rgb 'red' fillstyle solid  border lt 2 lw 2 front
plot "c:/Projects/DM/data/weather_data_sandiego_processed.txt" using 3:4:5 with points palette pt 3 title "Weather Data"
