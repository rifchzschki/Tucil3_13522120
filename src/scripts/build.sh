#!/bin/bash

clear

function Show_Spinner {
    spins='-\/|'
    i=0
    startTime=$(date +%s)
    loading=true
    while $loading; do
        char=${spins:$((i++ % ${#spins})):1}
        echo -ne "\r$char Loading $char"
        sleep 0.1
        elapsedTime=$(($(date +%s) - $startTime))
        if [ $elapsedTime -ge 1 ]; then
            loading=false
        fi
    done
}
echo "Memulai kompilasi..."
Show_Spinner
javac -d ../bin *.java
wait
echo -ne "\r\033[K"  # Hapus baris terakhir
echo "Kompilasi selesai."
