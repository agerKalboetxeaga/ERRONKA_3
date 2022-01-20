#!/bin/bash

#Colours
greenColour="\e[0;32m\033[1m"
endColour="\033[0m\e[0m"
redColour="\e[0;31m\033[1m"
blueColour="\e[0;34m\033[1m"
yellowColour="\e[0;33m\033[1m"
purpleColour="\e[0;35m\033[1m"
turquoiseColour="\e[0;36m\033[1m"
grayColour="\e[0;37m\033[1m"

if [ $# == 0 ] || [ $# -gt 1 ]; then

echo  -e "\n ${redColour}[*] ERROR: \n\n\t Ussage: ${endColour}${blueColour}bash mongolize.sh <JSON_File.js> ${endColour}"

else

file=$1

echo  -e "${greenColour} \n\n[*] Importing data from [${endColour}${yellowColour}$1${endColour}${greenColour}]${endColour}"
mongoimport.exe --uri mongodb://localhost:27017/partidak  --collection puntuazioak --type json --file $1 && echo -e "${greenColour}\n[*] Data successfully updated.${endColour}" &&   mongo.exe 127.0.0.1:27017/partidak partidaCheck.js

fi

