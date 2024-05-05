#!/bin/bash

Clear-Host

function Show-Spinner {
    $spins = "-\|/"
    $i = 0
    $startTime = Get-Date
    $loading = $true
    while ($loading) {
        $char = $spins[$i++ % $spins.Length]
        Write-Host -NoNewline "`r$char Loading $char"
        Start-Sleep -Milliseconds 100
        $elapsedTime = (Get-Date) - $startTime
        if ($elapsedTime.TotalSeconds -ge 1) {
            $loading = $false
        }
    }
}
echo "Memulai kompilasi..."
Show-Spinner
javac -d ../bin *.java
Write-Host -NoNewline "`r" # Membersihkan baris terakhir
echo "Kompilasi selesai."