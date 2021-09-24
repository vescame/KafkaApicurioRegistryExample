#!/bin/sh

[ $# -ne 1 ] && {
  echo "usage: $0 avroschema"
  exit 1
}

curl -X POST -H "Content-type: application/json; artifactType=AVRO" \
  -H "X-Registry-ArtifactId: User" \
  --data "@$1" http://localhost:8080/apis/registry/v2/groups/com.picpay.apicurio.spike.user/artifacts

