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
scriptName=$1
collectionName=$2


if [ $# == 0 ] || [ $# == 1 ]; then
echo -e "\n ${yellowColour}[!] Error: \n\t Ussage: ${endColour}${redColour}./createDb.sh ${endColour}${blueColour}<creation_Script.js> <secondScript.js> ${endColour}"

else

	echo -e "\n ${greenColour}[*] Creating DB [${endColour}${redColour}$scriptName${endColour}${greenColour}]...${endColour}"

#sudo service mongod restart
 mongosh -f $scriptName && echo -e "\n${greenColour} [*] DB created with ${endColour}${redColour}2${endColour} ${greenColour}collections${endColour}"
 mongosh -f $collectionName &&  clear
 echo -e "\n ${greenColour}[*] All operations done successfully !!${endColour}"







#"db.createCollection("Partida")"
#"db.createCollection("Pertsona")"

#db.Partida.insert({_id_partida, pertsona: [
#	_id_pertsona,
#	izena: ]})
#sudo service mongod stop
#sudo service mongod start

#mongosh -f $collectionName



fi

