set datafile separator tab
set object circle at first 368051.2772843445,258191.36773743833 radius char 1  fillcolor rgb 'red' fillstyle solid  border lt 2 lw 2 front
set object circle at first 2029520.5933960192,1500499.8347898216 radius char 1  fillcolor rgb 'red' fillstyle solid  border lt 2 lw 2 front
set object circle at first 3259897.232260726,2521054.560858086 radius char 1  fillcolor rgb 'red' fillstyle solid  border lt 2 lw 2 front
set object circle at first 1074615.3270062103,787671.1631677018 radius char 1  fillcolor rgb 'red' fillstyle solid  border lt 2 lw 2 front
set object circle at first 36176.34227825503,29356.659372108345 radius char 1  fillcolor rgb 'red' fillstyle solid  border lt 2 lw 2 front
plot "c:/Projects/DM/data/income-tax-2_processed.txt" using 2:3:4 with points palette pt 3 title "Income Tax Data"
