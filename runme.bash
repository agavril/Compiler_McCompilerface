#!/bin/bash

java -cp "antlr-4.7.1-complete.jar":classes/ step1 "$1" > "$2"
