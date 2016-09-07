#!/bin/sh
GITSHA="$(git rev-parse HEAD)"
echo "${GITSHA}"
ARRAY=($(git show --pretty="" --name-only ${GITSHA}))
echo "${ARRAY}"
if echo ${ARRAY[@]} | grep -q -w "pom.xml"; then
    echo "Building Dockerfile...."
else
    echo "No changes..Using the same docker image.."
fi
