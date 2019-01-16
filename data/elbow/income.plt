set datafile separator ","
set grid
set title 'Elbow method'

set ylabel "Distortion"

set xrange[1:10]
set xlabel "Nr Clusters"
plot 'c:/Projects/DM/data/elbow/income.txt' using 1:2 w lp t 'Clusters'
