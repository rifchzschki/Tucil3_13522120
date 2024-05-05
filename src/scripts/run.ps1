#!/bin/bash

Clear-Host

function Show-Spinner {
    $spins = "-\|/"
    $i = 0
    $startTime = Get-Date
    $loading = $true
    while ($loading) {
        $char = $spins[$i++ % $spins.Length]
        Write-Host -NoNewline "`r[char] Loading $char"
        Start-Sleep -Milliseconds 100
        $elapsedTime = (Get-Date) - $startTime
        if ($elapsedTime.TotalSeconds -ge 1) {
            $loading = $false
        }
    }
    Write-Host -NoNewline "`r" # Membersihkan baris terakhir
}

Clear-Host
echo "Menjalankan program..."
Show-Spinner

java Art.java
java -classpath ../bin Main
echo "Program selesai dijalankan."
