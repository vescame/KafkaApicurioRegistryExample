#!/bin/sh

[ $# -lt 2 ] && {
  echo "usage: $0 name age"
  exit 1
}


curl -X POST -H 'Content-type: application/json' \
  -d "{\"name\": \"$1\", \"age\": $2}" \
  http://localhost:8081/api/v1/user

