#!/usr/bin/env bash

# https://stackoverflow.com/questions/6022384/bash-tool-to-get-nth-line-from-a-file

# Solution 1 (Most efficient)
sed '10q;d' file.txt

# Solution 2
tail -n+10 test.txt | head -1

# Solution 3 (Most intuitive, but incorrect when input is less than 10 lines)
head -10 test.txt | tail -1