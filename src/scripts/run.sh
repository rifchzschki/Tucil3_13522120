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
    echo -e "\r" # Membersihkan baris terakhir
}

clear
echo "Menjalankan program..."
Show_Spinner

java Art.java
java -classpath ../bin Main
echo "Program selesai dijalankan."
