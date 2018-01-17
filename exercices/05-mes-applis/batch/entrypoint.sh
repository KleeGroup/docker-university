#!/bin/sh
set -e

if  [ -n "$URL_ELASTICSEARCH" ] && [ "$1" == "elasticsearch" ]; then
	shift
	exec java -jar /opt/monapp/batch-0.0.1.jar "elasticsearch" "$URL_ELASTICSEARCH" "$@"
fi

exec java -jar /opt/monapp/batch-0.0.1.jar "$@"
