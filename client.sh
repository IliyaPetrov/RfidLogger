#!/bin/bash

endpoint='http://localhost:8090/api/events'

while true
do
	echo "Enter RFID:"
	read rfid
	time=$(date +%s)
	status=$(curl -w "%{http_code}\n" -o /dev/null -s -H "Content-Type: application/json" -X POST -d '{"date":'$time',"rfid":"'$rfid'"}' $endpoint)
	if [ "${status}" == "201" ];
	  then echo "Successful registration!"
	fi
done

