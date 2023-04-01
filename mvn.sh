#!/usr/bin/env bash

mvn \
  -Dmaven.repo.local=./.repository \
  --settings ./settings.xml \
  "$@"
