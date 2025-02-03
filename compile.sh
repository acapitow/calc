#!/bin/bash

SRC_DIR="src/main/java" # à mettre à jour

cd ${SRC_DIR}

pwd

find . -name '*.java' > tempo

clear

# Compilation des fichiers source
while read -r string; do
		string_size=${#string}
		string_without_leading_chars=${string:2:${string_size}}
		set -x
		
		# Attention : la version de Java doit être au moins égale à 21.
		# Pour supporter JavaFX, il est recommandé d'utiliser une version JavaFX SDK de Azul : https://www.azul.com/downloads/
		javac -Xlint:all -Xdiags:verbose ${string_without_leading_chars}
		{ set +x; } &> /dev/null
done < tempo

rm tempo


