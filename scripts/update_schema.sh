#!/bin/sh

[ $# -ne 1 ] && {
  echo "usage: $0 avroschema"
  exit 1
}

curl -X PUT -H "Content-type: application/json; artifactType=AVRO" \
  --data "@$1" http://localhost:8080/apis/registry/v2/groups/com.picpay.apicurio.spike.user/artifacts/User
  # -H "X-Registry-Version: $version_number" \ # optionally you can send the version as a header
