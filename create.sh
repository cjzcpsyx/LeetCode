#!/bin/bash
NAME="$(echo "$@" | tr 'A-Z ' 'a-z_' | tr -d "'")"

[ -d "$NAME" ] && {
    exit 1
}
echo "Create $NAME"
mkdir "$NAME"
touch "$NAME/Solution.java"